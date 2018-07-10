package ad.service.impl;

import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import ad.bean.AbAdver;
import ad.bean.AbAdvertiser;
import ad.bean.AbProxyUser;
import ad.bean.AbStatisticsHourTemp;
import ad.mapper.AbAdvertiserMapper;
import ad.mapper.AbProxyUserMapper;
import ad.mapper.AbReveOrderDetailsMapper;
import ad.mapper.AbStatisticsHourTempMapper;
import ad.service.IAbAdvertiserService;
import ad.service.IHourStatisticsService;
import ad.txcos.TxCosConfig;
import ad.util.DateUtil;
import ad.util.Excel2018;
import ad.util.LineCharts;
import ad.util.MessageUtils;

@Service
public class HourStatisticsServiceImpl implements IHourStatisticsService {
	private final static String CREATETIME = "createTime";
	@Autowired
	private AbStatisticsHourTempMapper abStatisticsHourTempMapper;
	@Autowired
	private AbReveOrderDetailsMapper abReveOrderDetailsMapper;
	@Autowired
	private AbProxyUserMapper abProxyUserMapper;
	@Autowired
	private TxCosConfig txCosConfig;
	@Autowired
	private AbAdvertiserMapper abAdvertiserMapper;
	/**
	 * 广告主服务
	 */
	@Autowired
	private IAbAdvertiserService iAbAdvertiserService;
	/**
	 * 按天统计广告信息
	 */
	@Override
	public List<AbStatisticsHourTemp> queryByConditions(AbStatisticsHourTemp been) {
		List<AbStatisticsHourTemp> list = abStatisticsHourTempMapper.selectByCondition(been);
		return list;
	}

	/**
	 * 分页查询语句
	 */
	@Override
	public List<AbStatisticsHourTemp> selectByConditionOfAngect(AbStatisticsHourTemp been) {
		List<AbStatisticsHourTemp> list = abStatisticsHourTempMapper.selectByConditionOfAngect(been);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (AbStatisticsHourTemp tem : list) {
			String tableName = "ab_reve_order_details_" + (new SimpleDateFormat("yyyyMM")).format(tem.getCreateTime());
			Float earningsAmount = abReveOrderDetailsMapper.selectEarningsAmountByDays(tableName, tem.getProxyId(),
					sdf.format(tem.getCreateTime()));
			tem.setAgencyNameOfAmount(earningsAmount == null ? 0f : earningsAmount);
		}
		return list;
	}

	@Override
	public List<AbStatisticsHourTemp> queryByHour(AbStatisticsHourTemp been) {
		List<AbStatisticsHourTemp> list = abStatisticsHourTempMapper.queryByHour(been);
		return list;
	}

	/**
	 * 分时获取广告数据
	 */
	@Override
	public List<AbStatisticsHourTemp> queryByHourOfAgent(AbStatisticsHourTemp been) {
		List<AbStatisticsHourTemp> list = abStatisticsHourTempMapper.queryByHourOfAgent(been);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
		for (AbStatisticsHourTemp tem : list) {
			String tableName = "ab_reve_order_details_" + (new SimpleDateFormat("yyyyMM")).format(tem.getCreateTime());
			Float earningsAmount = abReveOrderDetailsMapper.selectEarningsAmount(tableName, tem.getProxyId(),
					sdf.format(tem.getCreateTime()));
			tem.setAgencyNameOfAmount(earningsAmount);
		}
		return list;
	}

	/**
	 * 获取代理数据
	 */
	@Override
	public List<AbProxyUser> queryAngeList(AbProxyUser abProxyUser) {
		AbProxyUser ab = abProxyUserMapper.queryAnge(abProxyUser);
		List<AbProxyUser> list = abProxyUserMapper.queryAngeList(ab);
		List<AbProxyUser> reslutlist = new ArrayList<AbProxyUser>();
		for (AbProxyUser ab1 : list) {
			reslutlist.add(ab1);
			List<AbProxyUser> ablist = abProxyUserMapper.queryAngeList(ab1);
			// AbProxyUser ab2 = abProxyUserMapper.selectAnge(ab1);
			reslutlist.addAll(ablist);
		}
		reslutlist.add(ab);
		return reslutlist;
	}

	@Override
	public AbStatisticsHourTemp advertisingCostsToday(List<AbAdver> col) {
		AbStatisticsHourTemp list = abStatisticsHourTempMapper.advertisingCostsToday(col);
		return list;
	}

	/**
	 * 获取按时  广告数据
	 */
	@Override
	public List<AbStatisticsHourTemp> advertisingByHourYesterday(List<AbAdver> list) {
		List<AbStatisticsHourTemp> result = abStatisticsHourTempMapper.advertisingByHourYesterday(list);
		return result;
	}

	/**
	 * 根据广告id获取按时广告数据
	 */
	@Override
	public List<AbStatisticsHourTemp> queryByAdTitel(AbStatisticsHourTemp been) {
		System.out.println(been.getAdverId());
		List<AbStatisticsHourTemp> result = abStatisticsHourTempMapper.queryByAdTitelYesterday(been);
		return result;
	}

	@Override
	public List<AbStatisticsHourTemp> queryByConditionsUserId(AbStatisticsHourTemp been) {
		List<AbStatisticsHourTemp> queryByConditionsUserId = abStatisticsHourTempMapper.queryByConditionsUserId(been);
		return queryByConditionsUserId;
	}

	/**
	 * 广告统计数据来源方法
	 * @param been
	 * @return
	 */
	@Override
	public String dayStatisticsList(AbStatisticsHourTemp been) {
		// 查询广告主表是否存在
		Integer page = been.getPage();
		been.setPageSize((page - 1) * 10);
		AbAdvertiser adver = new AbAdvertiser();
		adver.setUserid(been.getUserid());
		AbAdvertiser advertiserBeen = abAdvertiserMapper.queryByUserId(adver);
		// 广告主如果不存在，是管理员操作，存在是广告主操作
		if (advertiserBeen == null) {
			// 管理员操作用户userid清空,查询所有
			been.setUserid(null);
		}
		String[] startEndTime = been.getStartEndTime();
		Calendar instance = Calendar.getInstance();
		Date end = instance.getTime();
		instance.add(Calendar.DATE, -30);
		Date start = instance.getTime();
		try {
			// String[] startEndTime = been.getStartEndTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd");
			// Date start = sdf.parse("2018-03-01");
			// Date end = sdf.parse("2018-03-31");
			// 计算起止日期每天的日期字符串
			List<Date> findDates = null;
			if (startEndTime != null && startEndTime.length == 2) {
				Date parse = sdf.parse(startEndTime[0]);
				Date parse2 = sdf.parse(startEndTime[1]);
				been.setStartDate(parse);
				been.setEndDate(parse2);
				findDates = DateUtil.findDates(parse, parse2);
			} else {
				been.setStartDate(start);
				been.setEndDate(end);
				findDates = DateUtil.findDates(start, end);
			}
			// List<Date> findDates = DateUtil.findDates(start, end);
			List<String> strDate = JSON.parseObject(JSON.toJSONStringWithDateFormat(findDates, "yyyy-MM-dd"),
					new TypeReference<List<String>>() {
					});
			// 创建临时集合;存结果集
			JSONArray temp = new JSONArray();
			List<AbStatisticsHourTemp> list = new ArrayList<>();
			// 分页的语句
			been.setFlag(1);
			List<AbStatisticsHourTemp> list1 = this.queryByConditions(been);
			// 为分页语句
			been.setFlag(2);
			List<AbStatisticsHourTemp> list2 = this.queryByConditions(been);
			//获得appname
			List<String> appnameList=abStatisticsHourTempMapper.getDistinctAppName();
			//初始化参数
			Integer showNumber = 0;
			Integer equipmentId = 0;
			Integer clickNumber = 0;
			float clickingRatenew = 0f;
			BigDecimal earningsAmount = new BigDecimal("0");
			for (AbStatisticsHourTemp a : list2) {
				showNumber += a.getShowNum();
				equipmentId += Integer.valueOf(a.getEquipmentId());
				clickNumber += a.getClickNum();
				earningsAmount = earningsAmount.add(a.getEarningsAmount());
			}
			AbStatisticsHourTemp tmp = new AbStatisticsHourTemp();
			tmp.setShowNum(showNumber);
			tmp.setEquipmentId(equipmentId + "");
			tmp.setClickNum(clickNumber);
			tmp.setEarningsAmount(earningsAmount);
			tmp.setAdTitle("-");
			tmp.setName("-");
			tmp.setAgencyName("-");
			JSONArray parseObject = JSONArray.parseArray(JSON.toJSONStringWithDateFormat(list2, "yyyy-MM-dd"));
			// 展示次数
			Integer showNum = 0;
			// 点击次数
			Integer clickNum = 0;
			// 点击率
			String clickRate = "";
			DecimalFormat df = new DecimalFormat("0.00");
			// 广告费用
			Integer adCost = 0;
			for (String key : strDate) {
				boolean flag = false;
				for (int i = 0; i < parseObject.size(); i++) {
					JSONObject object = parseObject.getJSONObject(i);
					if (key.equals(object.getString(CREATETIME))) {
						// clickingRate 点击率 = 点击次数/展示次数。
						Double click = object.getDouble("showNum");
						Double show = object.getDouble("clickNum");
						String clickingRate = "";
						// 点击率
						if (show != null && show > 0 && click != null) {
							clickingRate = df.format(show / click);
							clickRate += clickingRate;
							object.put("clickingRate", clickingRate);
						}
						// 展示次数
						if (object.getInteger("showNum") != null) {
							showNum += object.getInteger("showNum");
						}
						// 点击次数
						if (object.getInteger("clickNum") != null) {
							clickNum += object.getInteger("clickNum");
						}
						// 广告费用
						if (object.getInteger("earningsAmount") != null) {
							adCost += object.getInteger("earningsAmount");
						}
						temp.add(object);
						flag = true;
						break;
					}
				}
				if (!flag) {
					// 不存在数据的格式如下
					AbStatisticsHourTemp aht = new AbStatisticsHourTemp();
					aht.setAdTitle("-");
					aht.setAgencyName("-");
					aht.setAgencyAmount(new BigDecimal(0));
					aht.setClickNum(0);
					aht.setName("-");
					aht.setEarningsAmount(new BigDecimal(0));
					aht.setEquipmentId("0");
					aht.setShowNum(0);
					aht.setClickingRate(0);
					aht.setCreateTime(sdff.parse(key));
					temp.add(JSON.parseObject(JSON.toJSONStringWithDateFormat(aht, "yyyy-MM-dd")));
				}
			}
			for (int i = 0; i < parseObject.size(); i++) {
				JSONObject object = parseObject.getJSONObject(i);
				clickingRatenew += object.getDouble("clickingRate");
			}
			tmp.setClickingRate(clickingRatenew);
			list.add(tmp);
			for (AbStatisticsHourTemp t : list1) {
				list.add(t);
			}
			JSONArray parseObjectList = JSONArray.parseArray(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd"));
			for (int i = 0; i < parseObject.size(); i++) {
				JSONObject object = parseObject.getJSONObject(i);
				clickingRatenew += object.getDouble("clickingRate");
				for (int m = 0; m < parseObjectList.size(); m++) {
					JSONObject objectList = parseObjectList.getJSONObject(m);
					if (object.getString("createTime").equals(objectList.getString("createTime"))) {
						objectList.put("clickingRate", object.getDouble("clickingRate"));
						break;
					} else {
						continue;
					}
				}
			}
			JSONObject jsonCount = new JSONObject();
			jsonCount.put("showNumTemp", showNum);
			jsonCount.put("clickNumTemp", clickNum);
			jsonCount.put("clickRateTemp", clickRate);
			jsonCount.put("adCostTemp", adCost);
			jsonCount.put("appnameList", appnameList);
			return MessageUtils.jsonRetrunListMessage1(1, list2.size(), "success", temp, parseObjectList, jsonCount);
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "success");
		}
	}

	/**
	 * 广告统计导出按天
	 * @param been
	 * @param response
	 */
	@Override
	public void exportExcell(AbStatisticsHourTemp been, HttpServletResponse response) {
		// 查询广告主表是否存在
		AbAdvertiser adver = new AbAdvertiser();
		adver.setUserid(been.getUserid());
		AbAdvertiser advertiserBeen = abAdvertiserMapper.queryByUserId(adver);
		// 广告主如果不存在，是管理员操作，存在是广告主操作
		if (advertiserBeen == null) {
			// 管理员操作用户userid清空,查询所有
			been.setUserid(null);
		}
		String[] startEndTime = been.getStartEndTime();
		Calendar instance = Calendar.getInstance();
		Date end = instance.getTime();
		instance.add(Calendar.DATE, -30);
		Date start = instance.getTime();
		try {
			// String[] startEndTime = been.getStartEndTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdff = new SimpleDateFormat("yyyy年MM月dd日");
			// Date start = sdf.parse("2018-03-01");
			// Date end = sdf.parse("2018-03-31");
			// 计算起止日期每天的日期字符串
			List<Date> findDates = null;
			if (startEndTime != null && startEndTime.length == 2) {
				Date parse = sdf.parse(startEndTime[0]);
				Date parse2 = sdf.parse(startEndTime[1]);
				been.setStartDate(parse);
				been.setEndDate(parse2);
				findDates = DateUtil.findDates(parse, parse2);
			} else {
				been.setStartDate(start);
				been.setEndDate(end);
				findDates = DateUtil.findDates(start, end);
			}
			// List<Date> findDates = DateUtil.findDates(start, end);
			List<String> strDate = JSON.parseObject(JSON.toJSONStringWithDateFormat(findDates, "yyyy年MM月dd日"),
					new TypeReference<List<String>>() {
					});
			// 创建临时集合;存结果集
			JSONArray temp = new JSONArray();
			List<AbStatisticsHourTemp> list = this.queryByConditions(been);
			JSONArray parseObject = JSONArray.parseArray(JSON.toJSONStringWithDateFormat(list, "yyyy年MM月dd日"));
			for (String key : strDate) {
				boolean flag = false;
				for (int i = 0; i < parseObject.size(); i++) {
					JSONObject object = parseObject.getJSONObject(i);
					if (key.equals(object.getString(CREATETIME))) {
						temp.add(object);
						flag = true;
						break;
					}
				}
				if (!flag) {
					AbStatisticsHourTemp aht = new AbStatisticsHourTemp();
					aht.setAdTitle("-");
					aht.setAgencyName("-");
					aht.setAgencyAmount(new BigDecimal(0));
					aht.setClickNum(0);
					aht.setName("-");
					aht.setEarningsAmount(new BigDecimal(0));
					aht.setEquipmentId("0");
					aht.setShowNum(0);
					aht.setCreateTime(sdff.parse(key));
					temp.add(JSON.parseObject(JSON.toJSONStringWithDateFormat(aht, "yyyy年MM月dd日")));
				}
			}
			Date date = findDates.get(0);
			Date date2 = findDates.get(findDates.size() - 1);
			String format = sdf.format(date);
			String format1 = sdf.format(date2);
			String onlyKey = DateUtil.createKey();
			String strt = "广告统计" + format + "至" + format1;
			// 生成展示次数图片
			CategoryDataset dataset = LineCharts.createDataset(temp, "showNum", "展示次数", "d");
			// 步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置
			JFreeChart freeChart = LineCharts.createChart(dataset, strt, "数量");
			// 步骤3：将JFreeChart对象输出到文件，Servlet输出流等
			LineCharts.saveAsFile(freeChart, txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "line.jpg", 1600,
					500);
			// ************************************************************************************************
			// 生成点击次数图片
			CategoryDataset dataset1 = LineCharts.createDataset(temp, "clickNum", "点击次数", "d");
			// 步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置

			JFreeChart freeChart1 = LineCharts.createChart(dataset1, strt, "数量");
			// 步骤3：将JFreeChart对象输出到文件，Servlet输出流等
			LineCharts.saveAsFile(freeChart1, txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineclick.jpg",
					1600, 500);
			// ***************************************************************************************************
			// 广告收益图片
			CategoryDataset dataset2 = LineCharts.createDataset(temp, "earningsAmount", "广告收益", "d");
			// 步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置

			JFreeChart freeChart2 = LineCharts.createChart(dataset2, strt, "元");
			// 步骤3：将JFreeChart对象输出到文件，Servlet输出流等
			LineCharts.saveAsFile(freeChart2,
					txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineearningsAmount.jpg", 1600, 500);
			// **********************************************
			// 代理收益
			CategoryDataset dataset3 = LineCharts.createDataset(temp, "agencyAmount", "代理广告收益", "d");
			// 步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置
			JFreeChart freeChart3 = LineCharts.createChart(dataset3, strt, "元");
			// 步骤3：将JFreeChart对象输出到文件，Servlet输出流等
			LineCharts.saveAsFile(freeChart3,
					txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineagencyAmount.jpg", 1600, 500);
			System.out.println("完成");
			String title = strt;
			List titleList = new ArrayList();
			List columnList = new ArrayList();
			List dataList = new ArrayList();
			titleList.add("日期");
			titleList.add("广告标题");
			titleList.add("代理");
			titleList.add("展示次数");
			titleList.add("展示设备数");
			titleList.add("点击次数");
			titleList.add("广告收益（元）");
			titleList.add("代理广告收益（元）");
			columnList.add("createTime");
			columnList.add("adTitle");
			columnList.add("agencyName");
			columnList.add("showNum");
			columnList.add("equipmentId");
			columnList.add("clickNum");
			columnList.add("earningsAmount");
			columnList.add("agencyAmount");
			for (int i = 0; i < temp.size(); i++) {
				Map m = new HashMap();
				JSONObject jsonObject = temp.getJSONObject(i);
				m.put("createTime", jsonObject.getString("createTime"));
				m.put("adTitle", jsonObject.getString("adTitle"));
				m.put("agencyName", jsonObject.getString("agencyName"));
				m.put("showNum", jsonObject.getString("showNum"));
				m.put("equipmentId", jsonObject.getString("equipmentId"));
				m.put("clickNum", jsonObject.getString("clickNum"));
				m.put("earningsAmount", jsonObject.getString("earningsAmount"));
				m.put("agencyAmount", jsonObject.getString("agencyAmount"));
				dataList.add(m);
			}
			Excel2018 excel = new Excel2018();
			excel.openWorkbook(title, titleList.size() - 1);
			excel.addTable(titleList, columnList, dataList);
			excel.lineNum += 2;
			excel.addImg(txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "line.jpg", 0, 8, excel.lineNum,
					excel.lineNum + 20);
			excel.lineNum += 22;
			excel.addImg(txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineclick.jpg", 0, 8, excel.lineNum,
					excel.lineNum + 20);
			excel.lineNum += 22;
			excel.addImg(txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineearningsAmount.jpg", 0, 8,
					excel.lineNum, excel.lineNum + 20);
			excel.lineNum += 22;
			excel.addImg(txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineagencyAmount.jpg", 0, 8,
					excel.lineNum, excel.lineNum + 20);
			excel.lineNum += 22;
			excel.downLoad(response, "广告按天统计");
			String[] deleteUrl = { txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "line.jpg",
					txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineclick.jpg",
					txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineearningsAmount.jpg",
					txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineagencyAmount.jpg" };
			for (String key : deleteUrl) {
				File f = new File(key);
				if (f.exists()) {
					f.delete();
				}
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return;
		}
	}

	/**
	 * 广告统计分时
	 * @param been
	 * @return
	 * @throws ParseException
	 */
	@Override
	public String hourStatisticsList(AbStatisticsHourTemp been) {
		// 查询广告主表是否存在
		AbAdvertiser adver = new AbAdvertiser();
		adver.setUserid(been.getUserid());
		AbAdvertiser advertiserBeen = abAdvertiserMapper.queryByUserId(adver);
		// 广告主如果不存在，是管理员操作，存在是广告主操作
		if (advertiserBeen == null) {
			// 管理员操作用户userid清空,查询所有
			been.setUserid(null);
		}
		String[] startEndTime = been.getStartEndTime();
		// Calendar instance = Calendar.getInstance();
		// Date end = instance.getTime();
		// instance.add(Calendar.DAY_OF_MONTH, -2);
		// Date start = instance.getTime();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdff = new SimpleDateFormat("yyyy年MM月dd日 HH时");
			// 计算开始时间和结束时间
			Calendar instance = Calendar.getInstance();
			instance.setTime(sdf.parse(startEndTime[0]));
			Date start = instance.getTime();
			instance.add(Calendar.DAY_OF_MONTH, 1);
			Date end = instance.getTime();
			// 格式化时间
			// Date time = sdf.parse(startTempTime);
			// 创建List集合装在1-24小时
			// String start = "2017-09-01";
			// String end = "2017-09-02";
			// Date parse = null;
			// Date parse2 = null;
			List<Date> findDatesHH = null;
			// if (startEndTime != null && startEndTime.length == 2) {
			// Date parse = sdf.parse(startEndTime[0]);
			// Date parse2 = sdf.parse(startEndTime[1]);
			// been.setStartDate(parse);
			// been.setEndDate(parse2);
			// findDatesHH = DateUtil.findDatesHH(parse, parse2);
			// } else {
			been.setStartDate(start);
			been.setEndDate(end);
			findDatesHH = DateUtil.findDatesHH(start, end);
			// }
			List<String> keys = JSON.parseObject(JSON.toJSONStringWithDateFormat(findDatesHH, "yyyy年MM月dd日 HH时"),
					new TypeReference<List<String>>() {
					});
			// 创建临时集合存放结果集
			JSONArray temp = new JSONArray();
			// 数据库获取数据源
			List<AbStatisticsHourTemp> queryByHour = this.queryByHour(been);
			JSONArray result = JSONArray.parseArray(JSON.toJSONStringWithDateFormat(queryByHour, "yyyy年MM月dd日 HH时"));
			// 展示次数
			Integer showNum = 0;
			// 点击次数
			Integer clickNum = 0;
			// 点击率
			Integer clickRate = 0;
			// 广告费用
			Integer adCost = 0;

			// 判断日期是否相等
			for (String key : keys) {
				boolean flag = false;
				for (int i = 0; i < result.size(); i++) {
					JSONObject jsonObject = result.getJSONObject(i);
					if (key.equals(jsonObject.getString(CREATETIME))) {
						Integer click = jsonObject.getInteger("showNum");
						Integer show = jsonObject.getInteger("clickNum");
						Integer clickingRate = null;
						if (show != null && show > 0 && click != null) {
							clickingRate = click / show;
							clickRate += clickingRate;
							jsonObject.put("clickingRate", clickingRate);
						}
						// 展示次数
						if (jsonObject.getInteger("showNum") != null) {
							showNum += jsonObject.getInteger("showNum");
						}
						// 点击次数
						if (jsonObject.getInteger("clickNum") != null) {
							clickNum += jsonObject.getInteger("clickNum");
						}
						// 广告费用
						if (jsonObject.getInteger("earningsAmount") != null) {
							adCost += jsonObject.getInteger("earningsAmount");
						}
						temp.add(jsonObject);
						flag = true;
					}
				}
				if (!flag) {
					AbStatisticsHourTemp aht = new AbStatisticsHourTemp();
					aht.setAdTitle("-");
					aht.setAgencyName("-");
					aht.setAgencyAmount(new BigDecimal(0));
					aht.setClickNum(0);
					aht.setName("-");
					aht.setCreateTime(sdff.parse(key));
					aht.setEarningsAmount(new BigDecimal(0));
					aht.setEquipmentId("0");
					aht.setClickingRate(0);
					aht.setShowNum(0);
					temp.add(JSON.parseObject(JSON.toJSONStringWithDateFormat(aht, "yyyy年MM月dd日 HH时")));
				}
			}
			//获得appname
			List<String> appnameList=abStatisticsHourTempMapper.getDistinctAppName();
			// 把最后一个时间改为24小时。
			// 统计数据
			JSONObject jsonCount = new JSONObject();
			jsonCount.put("showNumTemp", showNum);
			jsonCount.put("clickNumTemp", clickNum);
			jsonCount.put("clickRateTemp", clickRate);
			jsonCount.put("adCostTemp", adCost);
			jsonCount.put("appnameList",appnameList);
			JSONArray temp1 = new JSONArray();
			Integer showNumber = 0;
			Integer clickNumber = 0;
			Integer equipmentId = 0;
			Integer clickingRate = 0;
			Float earningsAmount = 0f;
			Float agencyNameOfAmount = 0f;
			for (int i = 0; i < temp.size(); i++) {
				JSONObject ob = temp.getJSONObject(i);// 得到json对象
				showNumber += ob.getInteger("showNum");
				clickNumber += ob.getInteger("clickNum");
				equipmentId += ob.getInteger("equipmentId");
				clickingRate += ob.getInteger("clickingRate");
				earningsAmount += ob.getFloatValue("earningsAmount");
				agencyNameOfAmount += ob.getFloatValue("agencyNameOfAmount");
			}
			AbStatisticsHourTemp aht = new AbStatisticsHourTemp();
			aht.setAdTitle("-");
			aht.setAgencyName("-");
			aht.setAgencyAmount(new BigDecimal(0.01));
			aht.setClickNum(clickNumber);
			aht.setName("-");
			aht.setCreateTime(null);
			aht.setEarningsAmount(new BigDecimal(earningsAmount));
			aht.setAgencyNameOfAmount(agencyNameOfAmount);
			aht.setEquipmentId(equipmentId + "");
			aht.setClickingRate(clickingRate);
			aht.setShowNum(showNumber);
			temp1.add(JSON.parseObject(JSON.toJSONStringWithDateFormat(aht, "yyyy年MM月dd日 HH时")));
			for (int i = 0; i < temp.size() - 1; i++) {
				JSONObject jsonObject = temp.getJSONObject(i);
				AbStatisticsHourTemp aht1 = new AbStatisticsHourTemp();
				aht1.setAdTitle(jsonObject.getString("adTitle"));
				aht1.setAgencyName(jsonObject.getString("agencyName"));
				aht1.setAgencyAmount(new BigDecimal(jsonObject.getFloat("agencyAmount")));
				aht1.setClickNum(jsonObject.getInteger("clickNum"));
				aht1.setName(jsonObject.getString("name"));
				aht1.setCreateTime(sdff.parse(jsonObject.getString("createTime")));
				aht1.setEarningsAmount(new BigDecimal(jsonObject.getFloat("earningsAmount")));
				aht1.setAgencyNameOfAmount(jsonObject.getFloat("agencyNameOfAmount"));
				aht1.setEquipmentId(jsonObject.getString("equipmentId"));
				aht1.setClickingRate(jsonObject.getFloatValue("clickingRate"));
				aht1.setShowNum(jsonObject.getInteger("showNum"));
				temp1.add(JSON.parseObject(JSON.toJSONStringWithDateFormat(aht1, "yyyy年MM月dd日 HH时")));
			}
			return MessageUtils.jsonRetrunListMessage2(1, "success", temp, temp1, jsonCount);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "fail");
		}
	}

	/**
	 * 广告统计分时导出
	 * @param been
	 * @param response
	 */
	@Override
	public void downLoadStatisticsHour(AbStatisticsHourTemp been, HttpServletResponse response) {
		// 查询广告主表是否存在
		AbAdvertiser adver = new AbAdvertiser();
		adver.setUserid(been.getUserid());
		AbAdvertiser advertiserBeen = abAdvertiserMapper.queryByUserId(adver);
		// 广告主如果不存在，是管理员操作，存在是广告主操作
		if (advertiserBeen == null) {
			// 管理员操作用户userid清空,查询所有
			been.setUserid(null);
		}
		String[] startEndTime = been.getStartEndTime();
		//
		// Calendar instance = Calendar.getInstance();
		// Date end = instance.getTime();
		// instance.add(Calendar.DAY_OF_MONTH, -2);
		// Date start = instance.getTime();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdff = new SimpleDateFormat("yyyy年MM月dd日 HH时");
			// 计算开始时间和结束时间
			Calendar instance = Calendar.getInstance();
			instance.setTime(sdf.parse(startEndTime[0]));
			Date start = instance.getTime();
			instance.add(Calendar.DAY_OF_MONTH, 1);
			Date end = instance.getTime();
			// 格式化时间
			// Date time = sdf.parse(startTempTime);
			// 创建List集合装在1-24小时
			// String start = "2017-09-01";
			// String end = "2017-09-02";
			// Date parse = null;
			// Date parse2 = null;
			List<Date> findDatesHH = null;
			// if (startEndTime != null && startEndTime.length == 2) {
			// Date parse = sdf.parse(startEndTime[0]);
			// Date parse2 = sdf.parse(startEndTime[1]);
			// been.setStartDate(parse);
			// been.setEndDate(parse2);
			// findDatesHH = DateUtil.findDatesHH(parse, parse2);
			// } else {
			been.setStartDate(start);
			been.setEndDate(end);
			findDatesHH = DateUtil.findDatesHH(start, end);
			// }
			List<String> keys = JSON.parseObject(JSON.toJSONStringWithDateFormat(findDatesHH, "yyyy年MM月dd日 HH时"),
					new TypeReference<List<String>>() {
					});
			// 创建临时集合存放结果集
			JSONArray temp = new JSONArray();
			// 数据库获取数据源
			List<AbStatisticsHourTemp> queryByHour = this.queryByHour(been);
			JSONArray result = JSONArray.parseArray(JSON.toJSONStringWithDateFormat(queryByHour, "yyyy年MM月dd日 HH时"));
			// 判断日期是否相等
			for (String key : keys) {
				boolean flag = false;
				for (int i = 0; i < result.size(); i++) {
					JSONObject jsonObject = result.getJSONObject(i);
					if (key.equals(jsonObject.getString(CREATETIME))) {
						temp.add(jsonObject);
						flag = true;
					}
				}
				if (!flag) {
					AbStatisticsHourTemp aht = new AbStatisticsHourTemp();
					aht.setAdTitle("-");
					aht.setAgencyName("-");
					aht.setAgencyAmount(new BigDecimal(0));
					aht.setClickNum(0);
					aht.setName("-");
					aht.setCreateTime(sdff.parse(key));
					aht.setEarningsAmount(new BigDecimal(0));
					aht.setEquipmentId("0");
					aht.setShowNum(0);
					temp.add(JSON.parseObject(JSON.toJSONStringWithDateFormat(aht, "yyyy年MM月dd日 HH时")));
				}
			}
			// findDatesHH
			Date date = findDatesHH.get(0);
			Date date2 = findDatesHH.get(findDatesHH.size() - 1);
			String format = sdff.format(date);
			String format1 = sdff.format(date2);
			String onlyKey = DateUtil.createKey();
			String strt = "广告统计" + format + "至" + format1;
			// 生成图片
			// 生成展示次数图片
			CategoryDataset dataset = LineCharts.createDataset(temp, "showNum", "展示次数", "h");
			// 步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置
			JFreeChart freeChart = LineCharts.createChart(dataset, strt, "数量");
			// 步骤3：将JFreeChart对象输出到文件，Servlet输出流等
			LineCharts.saveAsFile(freeChart, txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "line.jpg", 1600,
					500);
			// ************************************************************************************************
			// 生成点击次数图片
			CategoryDataset dataset1 = LineCharts.createDataset(temp, "clickNum", "点击次数", "h");
			// 步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置
			JFreeChart freeChart1 = LineCharts.createChart(dataset1, strt, "数量");
			// 步骤3：将JFreeChart对象输出到文件，Servlet输出流等
			LineCharts.saveAsFile(freeChart1, txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineclick.jpg",
					1600, 500);
			// ***************************************************************************************************
			// 广告收益图片
			CategoryDataset dataset2 = LineCharts.createDataset(temp, "earningsAmount", "广告收益", "h");
			// 步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置
			JFreeChart freeChart2 = LineCharts.createChart(dataset2, strt, "元");
			// 步骤3：将JFreeChart对象输出到文件，Servlet输出流等
			LineCharts.saveAsFile(freeChart2,
					txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineearningsAmount.jpg", 1600, 500);
			// **********************************************
			// 代理收益
			CategoryDataset dataset3 = LineCharts.createDataset(temp, "agencyAmount", "代理广告收益", "h");
			// 步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置
			JFreeChart freeChart3 = LineCharts.createChart(dataset3, strt, "元");
			// 步骤3：将JFreeChart对象输出到文件，Servlet输出流等
			LineCharts.saveAsFile(freeChart3,
					txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineagencyAmount.jpg", 1600, 500);
			System.out.println("完成");
			String title = strt;
			List titleList = new ArrayList();
			List columnList = new ArrayList();
			List dataList = new ArrayList();
			titleList.add("日期");
			titleList.add("广告标题");
			titleList.add("代理");
			titleList.add("展示次数");
			titleList.add("展示设备数");
			titleList.add("点击次数");
			titleList.add("广告收益（元）");
			titleList.add("代理广告收益（元）");
			columnList.add("createTime");
			columnList.add("adTitle");
			columnList.add("agencyName");
			columnList.add("showNum");
			columnList.add("equipmentId");
			columnList.add("clickNum");
			columnList.add("earningsAmount");
			columnList.add("agencyAmount");
			for (int i = 0; i < temp.size(); i++) {
				Map m = new HashMap();
				JSONObject jsonObject = temp.getJSONObject(i);
				m.put("createTime", jsonObject.getString("createTime"));
				m.put("adTitle", jsonObject.getString("adTitle"));
				m.put("agencyName", jsonObject.getString("agencyName"));
				m.put("showNum", jsonObject.getString("showNum"));
				m.put("equipmentId", jsonObject.getString("equipmentId"));
				m.put("clickNum", jsonObject.getString("clickNum"));
				m.put("earningsAmount", jsonObject.getString("earningsAmount"));
				m.put("agencyAmount", jsonObject.getString("agencyAmount"));
				dataList.add(m);
			}

			Excel2018 excel = new Excel2018();
			excel.openWorkbook(title, titleList.size() - 1);
			excel.addTable(titleList, columnList, dataList);
			excel.lineNum += 2;
			excel.addImg(txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "line.jpg", 0, 8, excel.lineNum,
					excel.lineNum + 20);
			excel.lineNum += 22;
			excel.addImg(txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineclick.jpg", 0, 8, excel.lineNum,
					excel.lineNum + 20);
			excel.lineNum += 22;
			excel.addImg(txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineearningsAmount.jpg", 0, 8,
					excel.lineNum, excel.lineNum + 20);
			excel.lineNum += 22;
			excel.addImg(txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineagencyAmount.jpg", 0, 8,
					excel.lineNum, excel.lineNum + 20);
			excel.lineNum += 22;
			excel.downLoad(response, "广告按时统计");
			String[] deleteUrl = { txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "line.jpg",
					txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineclick.jpg",
					txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineearningsAmount.jpg",
					txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineagencyAmount.jpg" };
			for (String key : deleteUrl) {
				File f = new File(key);
				if (f.exists()) {
					f.delete();
				}
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return;
		}
	}
	
	/**
	 * 代理广告统计分时
	 * @param been
	 * @return
	 * @throws ParseException
	 */
	@Override
	public String AngleHourStatisticsList(AbStatisticsHourTemp been) {
		//获取代理数据
		AbProxyUser abProxyUser = new AbProxyUser();
		abProxyUser.setUserid(been.getUserid());
		List<AbProxyUser> abProxyUserList = this.queryAngeList(abProxyUser);
		been.setAbProxyUserList(abProxyUserList);
		been.setUserid(null);
		String[] startEndTime = been.getStartEndTime();
		// Calendar instance = Calendar.getInstance();
		// Date end = instance.getTime();
		// instance.add(Calendar.DAY_OF_MONTH, -2);
		// Date start = instance.getTime();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdff = new SimpleDateFormat("yyyy年MM月dd日 HH时");
			// 计算开始时间和结束时间
			Calendar instance = Calendar.getInstance();
			instance.setTime(sdf.parse(startEndTime[0]));
			Date start = instance.getTime();
			instance.add(Calendar.DAY_OF_MONTH, 1);
			Date end = instance.getTime();
			// 格式化时间
			// Date time = sdf.parse(startTempTime);
			// 创建List集合装在1-24小时
			// String start = "2017-09-01";
			// String end = "2017-09-02";
			// Date parse = null;
			// Date parse2 = null;
			List<Date> findDatesHH = null;
			// if (startEndTime != null && startEndTime.length == 2) {
			// Date parse = sdf.parse(startEndTime[0]);
			// Date parse2 = sdf.parse(startEndTime[1]);
			// been.setStartDate(parse);
			// been.setEndDate(parse2);
			// findDatesHH = DateUtil.findDatesHH(parse, parse2);
			// } else {
			been.setStartDate(start);
			been.setEndDate(end);
			findDatesHH = DateUtil.findDatesHH(start, end);
			// }
			List<String> keys = JSON.parseObject(JSON.toJSONStringWithDateFormat(findDatesHH, "yyyy年MM月dd日 HH时"),
					new TypeReference<List<String>>() {
					});
			// 创建临时集合存放结果集
			JSONArray temp = new JSONArray();
			// 数据库获取数据源
			List<AbStatisticsHourTemp> queryByHour = this.queryByHourOfAgent(been);
			JSONArray result = JSONArray.parseArray(JSON.toJSONStringWithDateFormat(queryByHour, "yyyy年MM月dd日 HH时"));
			// 展示次数
			Integer showNum = 0;
			// 点击次数
			Integer clickNum = 0;
			// 点击率
			Integer clickRate = 0;
			// 广告费用
			Integer adCost = 0;
			// 判断日期是否相等
			for (String key : keys) {
				boolean flag = false;
				for (int i = 0; i < result.size(); i++) {
					JSONObject jsonObject = result.getJSONObject(i);
					if (key.equals(jsonObject.getString(CREATETIME))) {
						Integer click = jsonObject.getInteger("showNum");
						Integer show = jsonObject.getInteger("clickNum");
						Integer clickingRate = null;
						if (show != null && show > 0 && click != null) {
							clickingRate = click / show;
							clickRate += clickingRate;
							jsonObject.put("clickingRate", clickingRate);
						}
						// 展示次数
						if (jsonObject.getInteger("showNum") != null) {
							showNum += jsonObject.getInteger("showNum");
						}
						// 点击次数
						if (jsonObject.getInteger("clickNum") != null) {
							clickNum += jsonObject.getInteger("clickNum");
						}
						// 广告费用
						if (jsonObject.getInteger("earningsAmount") != null) {
							adCost += jsonObject.getInteger("earningsAmount");
						}
						temp.add(jsonObject);
						flag = true;
					}
				}
				if (!flag) {
					AbStatisticsHourTemp aht = new AbStatisticsHourTemp();
					aht.setAdTitle("-");
					aht.setAgencyName("-");
					aht.setAgencyAmount(new BigDecimal(0));
					aht.setClickNum(0);
					aht.setName("-");
					aht.setCreateTime(sdff.parse(key));
					aht.setEarningsAmount(new BigDecimal(0));
					aht.setAgencyNameOfAmount(0f);
					aht.setEquipmentId("0");
					aht.setClickingRate(0);
					aht.setShowNum(0);
					temp.add(JSON.parseObject(JSON.toJSONStringWithDateFormat(aht, "yyyy年MM月dd日 HH时")));
				}
			}
			// 把最后一个时间改为24小时。
			// 统计数据
			JSONObject jsonCount = new JSONObject();
			jsonCount.put("showNumTemp", showNum);
			jsonCount.put("clickNumTemp", clickNum);
			jsonCount.put("clickRateTemp", clickRate);
			jsonCount.put("adCostTemp", adCost);
			JSONArray temp1 = new JSONArray();
			Integer showNumber =0;
			Integer clickNumber =0;
			Integer equipmentId = 0;
			Integer clickingRate = 0;
			Float earningsAmount = 0f;
			Float agencyNameOfAmount =0f;
			for(int i=0;i<temp.size();i++){
				JSONObject ob  = temp.getJSONObject(i);//得到json对象
				showNumber+=ob.getInteger("showNum");
				clickNumber+=ob.getInteger("clickNum");
				equipmentId+=ob.getInteger("equipmentId");
				clickingRate+=ob.getInteger("clickingRate");
				earningsAmount+=ob.getFloatValue("earningsAmount");
				agencyNameOfAmount+=ob.getFloatValue("agencyNameOfAmount");
			}
			AbStatisticsHourTemp aht = new AbStatisticsHourTemp();
			aht.setAdTitle("-");
			aht.setAgencyName("-");
			aht.setAgencyAmount(new BigDecimal(0.01));
			aht.setClickNum(clickNumber);
			aht.setName("-");
			aht.setCreateTime(null);
			aht.setEarningsAmount(new BigDecimal(earningsAmount));
			aht.setAgencyNameOfAmount(agencyNameOfAmount);
			aht.setEquipmentId(equipmentId+"");
			aht.setClickingRate(clickingRate);
			aht.setShowNum(showNumber);
			temp1.add(JSON.parseObject(JSON.toJSONStringWithDateFormat(aht, "yyyy年MM月dd日 HH时")));
			for(int i=0;i<temp.size()-1;i++){
				JSONObject jsonObject = temp.getJSONObject(i);
				AbStatisticsHourTemp aht1 = new AbStatisticsHourTemp();
				aht1.setAdTitle(jsonObject.getString("adTitle"));
				aht1.setAgencyName(jsonObject.getString("agencyName"));
				aht1.setAgencyAmount(new BigDecimal(jsonObject.getFloat("agencyAmount")));
				aht1.setClickNum(jsonObject.getInteger("clickNum"));
				aht1.setName(jsonObject.getString("name"));
				aht1.setCreateTime(sdff.parse(jsonObject.getString("createTime")));
				aht1.setEarningsAmount(new BigDecimal(jsonObject.getFloat("earningsAmount")));
				aht1.setAgencyNameOfAmount(jsonObject.getFloat("agencyNameOfAmount"));
				aht1.setEquipmentId(jsonObject.getString("equipmentId"));
				aht1.setClickingRate(jsonObject.getFloatValue("clickingRate"));
				aht1.setShowNum(jsonObject.getInteger("showNum"));
				temp1.add(JSON.parseObject(JSON.toJSONStringWithDateFormat(aht1, "yyyy年MM月dd日 HH时")));
			}
			return MessageUtils.jsonRetrunListMessage2(1, "success",temp, temp1, jsonCount);
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "fail");
		}
	}
	
	/**
	 * 代理广告统计分时导出
	 * @param been
	 * @param response
	 */
	@Override
	public void downLoadAgentStatisticsHour(AbStatisticsHourTemp been, HttpServletResponse response) {
		//获取代理数据
		AbProxyUser abProxyUser = new AbProxyUser();
		abProxyUser.setUserid(been.getUserid());
		List<AbProxyUser> abProxyUserList = this.queryAngeList(abProxyUser);
		been.setAbProxyUserList(abProxyUserList);
		been.setUserid(null);
		String[] startEndTime = been.getStartEndTime();
		//
		// Calendar instance = Calendar.getInstance();
		// Date end = instance.getTime();
		// instance.add(Calendar.DAY_OF_MONTH, -2);
		// Date start = instance.getTime();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdff = new SimpleDateFormat("yyyy年MM月dd日 HH时");

			// 计算开始时间和结束时间
			Calendar instance = Calendar.getInstance();
			instance.setTime(sdf.parse(startEndTime[0]));
			Date start = instance.getTime();
			instance.add(Calendar.DAY_OF_MONTH, 1);
			Date end = instance.getTime();
			// 格式化时间
			// Date time = sdf.parse(startTempTime);
			// 创建List集合装在1-24小时
			// String start = "2017-09-01";
			// String end = "2017-09-02";
			// Date parse = null;
			// Date parse2 = null;
			List<Date> findDatesHH = null;
			// if (startEndTime != null && startEndTime.length == 2) {
			// Date parse = sdf.parse(startEndTime[0]);
			// Date parse2 = sdf.parse(startEndTime[1]);
			// been.setStartDate(parse);
			// been.setEndDate(parse2);
			// findDatesHH = DateUtil.findDatesHH(parse, parse2);
			// } else {
			been.setStartDate(start);
			been.setEndDate(end);
			findDatesHH = DateUtil.findDatesHH(start, end);
			// }
			List<String> keys = JSON.parseObject(JSON.toJSONStringWithDateFormat(findDatesHH, "yyyy年MM月dd日 HH时"),
					new TypeReference<List<String>>() {
					});
			// 创建临时集合存放结果集
			JSONArray temp = new JSONArray();
			// 数据库获取数据源
			List<AbStatisticsHourTemp> queryByHour = this.queryByHourOfAgent(been);
			JSONArray result = JSONArray.parseArray(JSON.toJSONStringWithDateFormat(queryByHour, "yyyy年MM月dd日 HH时"));
			// 判断日期是否相等
			for (String key : keys) {
				boolean flag = false;
				for (int i = 0; i < result.size(); i++) {
					JSONObject jsonObject = result.getJSONObject(i);
					if (key.equals(jsonObject.getString(CREATETIME))) {
						temp.add(jsonObject);
						flag = true;
					}
				}
				if (!flag) {
					AbStatisticsHourTemp aht = new AbStatisticsHourTemp();
					aht.setAdTitle("-");
					aht.setAgencyName("-");
					aht.setAgencyAmount(new BigDecimal(0));
					aht.setClickNum(0);
					aht.setName("-");
					aht.setCreateTime(sdff.parse(key));
					aht.setEarningsAmount(new BigDecimal(0));
					aht.setEquipmentId("0");
					aht.setShowNum(0);
					temp.add(JSON.parseObject(JSON.toJSONStringWithDateFormat(aht, "yyyy年MM月dd日 HH时")));
				}
			}
			// findDatesHH
			Date date = findDatesHH.get(0);
			Date date2 = findDatesHH.get(findDatesHH.size() - 1);
			String format = sdff.format(date);
			String format1 = sdff.format(date2);
			String onlyKey = DateUtil.createKey();
			String strt = "广告统计" + format + "至" + format1;
			// 生成图片
			// 生成展示次数图片
			CategoryDataset dataset = LineCharts.createDataset(temp, "showNum", "展示次数", "h");
			// 步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置
			JFreeChart freeChart = LineCharts.createChart(dataset, strt, "数量");
			// 步骤3：将JFreeChart对象输出到文件，Servlet输出流等
			LineCharts.saveAsFile(freeChart, txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "line.jpg", 1600,
					500);
			// ************************************************************************************************
			// 生成点击次数图片
			CategoryDataset dataset1 = LineCharts.createDataset(temp, "clickNum", "点击次数", "h");
			// 步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置
			JFreeChart freeChart1 = LineCharts.createChart(dataset1, strt, "数量");
			// 步骤3：将JFreeChart对象输出到文件，Servlet输出流等
			LineCharts.saveAsFile(freeChart1, txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineclick.jpg",
					1600, 500);
			// ***************************************************************************************************
			// 广告收益图片
			CategoryDataset dataset2 = LineCharts.createDataset(temp, "earningsAmount", "广告收益", "h");
			// 步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置
			JFreeChart freeChart2 = LineCharts.createChart(dataset2, strt, "元");
			// 步骤3：将JFreeChart对象输出到文件，Servlet输出流等
			LineCharts.saveAsFile(freeChart2,
					txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineearningsAmount.jpg", 1600, 500);
			// **********************************************
			// 代理收益
			CategoryDataset dataset3 = LineCharts.createDataset(temp, "agencyAmount", "代理广告收益", "h");
			// 步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置
			JFreeChart freeChart3 = LineCharts.createChart(dataset3, strt, "元");
			// 步骤3：将JFreeChart对象输出到文件，Servlet输出流等
			LineCharts.saveAsFile(freeChart3,
					txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineagencyAmount.jpg", 1600, 500);
			System.out.println("完成");
			//添加标题
			String title = strt;
			List titleList = new ArrayList();
			List columnList = new ArrayList();
			List dataList = new ArrayList();
			titleList.add("日期");
			titleList.add("广告标题");
			titleList.add("代理");
			titleList.add("展示次数");
			titleList.add("展示设备数");
			titleList.add("点击次数");
			titleList.add("点击率");
			titleList.add("广告收益（元）");
			titleList.add("代理广告收益（元）");
			columnList.add("createTime");
			columnList.add("adTitle");
			columnList.add("agencyName");
			columnList.add("showNum");
			columnList.add("equipmentId");
			columnList.add("clickNum");
			columnList.add("clickingRate");
			columnList.add("earningsAmount");
			columnList.add("agencyAmount");
			for (int i = 0; i < temp.size(); i++) {
				Map m = new HashMap();
				JSONObject jsonObject = temp.getJSONObject(i);
				m.put("createTime", jsonObject.getString("createTime"));
				m.put("adTitle", jsonObject.getString("adTitle"));
				m.put("agencyName", jsonObject.getString("agencyName"));
				m.put("showNum", jsonObject.getString("showNum"));
				m.put("equipmentId", jsonObject.getString("equipmentId"));
				m.put("clickNum", jsonObject.getString("clickNum"));
				m.put("clickingRate", jsonObject.getString("clickingRate"));
				m.put("earningsAmount", jsonObject.getString("earningsAmount"));
				m.put("agencyAmount", jsonObject.getString("agencyAmount"));
				dataList.add(m);
			}
			Excel2018 excel = new Excel2018();
			excel.openWorkbook(title, titleList.size() - 1);
			excel.addTable(titleList, columnList, dataList);
			excel.lineNum += 2;
			excel.addImg(txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "line.jpg", 0, 8, excel.lineNum,
					excel.lineNum + 20);
			excel.lineNum += 22;
			excel.addImg(txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineclick.jpg", 0, 8, excel.lineNum,
					excel.lineNum + 20);
			excel.lineNum += 22;
			excel.addImg(txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineearningsAmount.jpg", 0, 8,
					excel.lineNum, excel.lineNum + 20);
			excel.lineNum += 22;
			excel.addImg(txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineagencyAmount.jpg", 0, 8,
					excel.lineNum, excel.lineNum + 20);
			excel.lineNum += 22;
			excel.downLoad(response, "广告按时统计");
			String[] deleteUrl = { txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "line.jpg",
					txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineclick.jpg",
					txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineearningsAmount.jpg",
					txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineagencyAmount.jpg" };
			for (String key : deleteUrl) {
				File f = new File(key);
				if (f.exists()) {
					f.delete();
				}
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return;
		}
	}
	
	/**
	 * 代理广告统计按天
	 * @param been
	 * @return
	 */
	@Override
	public String statisticsDayOfAngent(AbStatisticsHourTemp been) {
		//设置分页
		Integer page =been.getPage();
		been.setPageSize((page-1)*10);
		//获取代理信息
		AbProxyUser abProxyUser = new AbProxyUser();
		abProxyUser.setUserid(been.getUserid());
		List<AbProxyUser> abProxyUserList = this.queryAngeList(abProxyUser);
		been.setAbProxyUserList(abProxyUserList);
		been.setUserid(null);
		String[] startEndTime = been.getStartEndTime();
		Calendar instance = Calendar.getInstance();
		Date end = instance.getTime();
		instance.add(Calendar.DATE, -30);
		Date start = instance.getTime();
		try {
			// String[] startEndTime = been.getStartEndTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd");
			// Date start = sdf.parse("2018-03-01");
			// Date end = sdf.parse("2018-03-31");
			// 计算起止日期每天的日期字符串
			List<Date> findDates = null;
			if (startEndTime != null && startEndTime.length == 2) {
				Date parse = sdf.parse(startEndTime[0]);
				Date parse2 = sdf.parse(startEndTime[1]);
				been.setStartDate(parse);
				been.setEndDate(parse2);
				findDates = DateUtil.findDates(parse, parse2);
			} else {
				been.setStartDate(start);
				been.setEndDate(end);
				findDates = DateUtil.findDates(start, end);
			}
			// List<Date> findDates = DateUtil.findDates(start, end);
			List<String> strDate = JSON.parseObject(JSON.toJSONStringWithDateFormat(findDates, "yyyy-MM-dd"),
					new TypeReference<List<String>>() {
					});
			// 创建临时集合;存结果集
			JSONArray temp = new JSONArray();
			List<AbStatisticsHourTemp> list = new ArrayList<>();
			//分页的语句
			been.setFlag(1);
			List<AbStatisticsHourTemp> list1 = this.selectByConditionOfAngect(been);
			//未分页语句
			been.setFlag(2);
			List<AbStatisticsHourTemp> list2 = this.selectByConditionOfAngect(been);
			Integer showNumber=0;
			Integer equipmentId=0;
			Integer clickNumber=0;
			float clickingRatenew =0f;
			float agencyNameOfAmount = 0f;
			BigDecimal earningsAmount = new BigDecimal("0");
			for(AbStatisticsHourTemp a:list2){
				showNumber+=a.getShowNum();
				equipmentId+=Integer.valueOf(a.getEquipmentId());
				clickNumber+=a.getClickNum();
				agencyNameOfAmount +=a.getAgencyNameOfAmount();
				earningsAmount=earningsAmount.add(a.getEarningsAmount());
			}
			AbStatisticsHourTemp tmp= new AbStatisticsHourTemp();
			tmp.setShowNum(showNumber);
			tmp.setEquipmentId(equipmentId+"");
			tmp.setClickNum(clickNumber);
			tmp.setEarningsAmount(earningsAmount);
			tmp.setAgencyNameOfAmount(agencyNameOfAmount);
			tmp.setAdTitle("-");
			tmp.setName("-");
			tmp.setAgencyName("-");
			JSONArray parseObject = JSONArray.parseArray(JSON.toJSONStringWithDateFormat(list2, "yyyy-MM-dd"));
			// 展示次数
			Integer showNum = 0;
			// 点击次数
			Integer clickNum = 0;
			// 点击率
			String clickRate = "";
			DecimalFormat df = new DecimalFormat("0.00");
			// 广告费用
			Integer adCost = 0;
			for (String key : strDate) {
				boolean flag = false;
				for (int i = 0; i < parseObject.size(); i++) {
					JSONObject object = parseObject.getJSONObject(i);
					if (key.equals(object.getString(CREATETIME))) {
						// clickingRate 点击率 = 点击次数/展示次数。
						Double click = object.getDouble("showNum");
						Double show = object.getDouble("clickNum");
						String clickingRate = "";
						// 点击率
						if (show != null && show > 0 && click != null) {
							clickingRate = df.format(show / click);
							clickRate += clickingRate;
							object.put("clickingRate", clickingRate);
						}
						// 展示次数
						if (object.getInteger("showNum") != null) {
							showNum += object.getInteger("showNum");
						}
						// 点击次数
						if (object.getInteger("clickNum") != null) {
							clickNum += object.getInteger("clickNum");
						}
						// 广告费用
						if (object.getInteger("earningsAmount") != null) {
							adCost += object.getInteger("earningsAmount");
						}
						temp.add(object);
						flag = true;
						break;
					}
				}
				if (!flag) {
					// 不存在数据的格式如下
					AbStatisticsHourTemp aht = new AbStatisticsHourTemp();
					aht.setAdTitle("-");
					aht.setAgencyName("-");
					aht.setAgencyAmount(new BigDecimal(0));
					aht.setAgencyNameOfAmount(0f);
					aht.setClickNum(0);
					aht.setName("-");
					aht.setEarningsAmount(new BigDecimal(0));
					aht.setEquipmentId("0");
					aht.setShowNum(0);
					aht.setClickingRate(0);
					aht.setCreateTime(sdff.parse(key));
					temp.add(JSON.parseObject(JSON.toJSONStringWithDateFormat(aht, "yyyy-MM-dd")));
				}
			}
			for (int i = 0; i < parseObject.size(); i++) {
				JSONObject object = parseObject.getJSONObject(i);
				clickingRatenew+=object.getDouble("clickingRate");
			}
			tmp.setClickingRate(clickingRatenew);
			list.add(tmp);
			for(AbStatisticsHourTemp t:list1){
				list.add(t);
			}
			JSONArray parseObjectList = JSONArray.parseArray(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd"));
			for (int i = 0; i < parseObject.size(); i++) {
				JSONObject object = parseObject.getJSONObject(i);
				clickingRatenew+=object.getDouble("clickingRate");
				for(int m=0;m<parseObjectList.size();m++){
					JSONObject objectList = parseObjectList.getJSONObject(m);
					System.out.println(object.getString("createTime"));
					System.out.println(objectList.getString("createTime"));
					if(object.getString("createTime").equals(objectList.getString("createTime"))){
						objectList.put("clickingRate", object.getDouble("clickingRate"));
						break;
					}else{
						continue;
					}
					
				}
			}
			JSONObject jsonCount = new JSONObject();
			jsonCount.put("showNumTemp", showNum);
			jsonCount.put("clickNumTemp", clickNum);
			jsonCount.put("clickRateTemp", clickRate);
			jsonCount.put("adCostTemp", adCost);
			return MessageUtils.jsonRetrunListMessage1(1,list2.size(), "success", temp,parseObjectList, jsonCount);
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "success");
		}
	}
	
	/**
	 * 代理广告统计导出按天
	 * @param been
	 * @param response
	 */
	@Override
	public void downLoadStatisticsDayOfAngent(AbStatisticsHourTemp been, HttpServletResponse response) {
		//获取代理数据
		AbProxyUser abProxyUser = new AbProxyUser();
		abProxyUser.setUserid(been.getUserid());
		List<AbProxyUser> abProxyUserList = this.queryAngeList(abProxyUser);
		been.setAbProxyUserList(abProxyUserList);
		been.setUserid(null);
		String[] startEndTime = been.getStartEndTime();
		//获取当前时间
		Calendar instance = Calendar.getInstance();
		Date end = instance.getTime();
		instance.add(Calendar.DATE, -30);
		Date start = instance.getTime();
		try {
			// String[] startEndTime = been.getStartEndTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdff = new SimpleDateFormat("yyyy年MM月dd日");
			// Date start = sdf.parse("2018-03-01");
			// Date end = sdf.parse("2018-03-31");
			// 计算起止日期每天的日期字符串
			List<Date> findDates = null;
			if (startEndTime != null && startEndTime.length == 2) {
				Date parse = sdf.parse(startEndTime[0]);
				Date parse2 = sdf.parse(startEndTime[1]);
				been.setStartDate(parse);
				been.setEndDate(parse2);
				findDates = DateUtil.findDates(parse, parse2);
			} else {
				been.setStartDate(start);
				been.setEndDate(end);
				findDates = DateUtil.findDates(start, end);
			}
			// List<Date> findDates = DateUtil.findDates(start, end);
			List<String> strDate = JSON.parseObject(JSON.toJSONStringWithDateFormat(findDates, "yyyy年MM月dd日"),
					new TypeReference<List<String>>() {
					});
			// 创建临时集合;存结果集
			JSONArray temp = new JSONArray();
			//未分页语句
			been.setFlag(2);
			List<AbStatisticsHourTemp> list = this.selectByConditionOfAngect(been);
			JSONArray parseObject = JSONArray.parseArray(JSON.toJSONStringWithDateFormat(list, "yyyy年MM月dd日"));
			// 展示次数
			Integer showNum = 0;
			// 点击次数
			Integer clickNum = 0;
			// 点击率
//			float clickRate = 0;
			// 广告费用
			Integer adCost = 0;
			for (String key : strDate) {
				boolean flag = false;
				for (int i = 0; i < parseObject.size(); i++) {
					JSONObject object = parseObject.getJSONObject(i);
					if (key.equals(object.getString(CREATETIME))) {
						// clickingRate 点击率 = 点击次数/展示次数。
						Integer click = object.getInteger("showNum");
						Integer show = object.getInteger("clickNum");
						float clickingRate = 0f;
						// 点击率
						if (show != null && show > 0 && click != null) {
							clickingRate = click / show;
//							clickRate += clickingRate;
							object.put("clickingRate", clickingRate*100);
						}
						// 展示次数
						if (object.getInteger("showNum") != null) {
							showNum += object.getInteger("showNum");
						}
						// 点击次数
						if (object.getInteger("clickNum") != null) {
							clickNum += object.getInteger("clickNum");
						}
						// 广告费用
						if (object.getInteger("earningsAmount") != null) {
							adCost += object.getInteger("earningsAmount");
						}
						temp.add(object);
						flag = true;
						break;
					}
				}
				if (!flag) {
					// 不存在数据的格式如下
					AbStatisticsHourTemp aht = new AbStatisticsHourTemp();
					aht.setAdTitle("-");
					aht.setAgencyName("-");
					aht.setAgencyAmount(new BigDecimal(0));
					aht.setAgencyNameOfAmount(0f);
					aht.setClickNum(0);
					aht.setName("-");
					aht.setEarningsAmount(new BigDecimal(0));
					aht.setEquipmentId("0");
					aht.setShowNum(0);
					aht.setClickingRate(0);
					aht.setCreateTime(sdff.parse(key));
					temp.add(JSON.parseObject(JSON.toJSONStringWithDateFormat(aht, "yyyy年MM月dd日")));
				}
//				for (int i = 0; i < parseObject.size(); i++) {
//					JSONObject object = parseObject.getJSONObject(i);
//					if (key.equals(object.getString(CREATETIME))) {
//						temp.add(object);
//						flag = true;
//						break;
//					}
//				}
//				if (!flag) {
//					AbStatisticsHourTemp aht = new AbStatisticsHourTemp();
//					aht.setAdTitle("-");
//					aht.setAgencyName("-");
//					aht.setAgencyAmount(new BigDecimal(0));
//					aht.setClickNum(0);
//					aht.setName("-");
//					aht.setEarningsAmount(new BigDecimal(0));
//					aht.setEquipmentId("0");
//					aht.setShowNum(0);
//					aht.setCreateTime(sdff.parse(key));
//					temp.add(JSON.parseObject(JSON.toJSONStringWithDateFormat(aht, "yyyy年MM月dd日")));
//				}
			}
			Date date = findDates.get(0);
			Date date2 = findDates.get(findDates.size() - 1);
			String format = sdf.format(date);
			String format1 = sdf.format(date2);
			String onlyKey = DateUtil.createKey();
			String strt = "广告统计" + format + "至" + format1;
			// 生成展示次数图片
			CategoryDataset dataset = LineCharts.createDataset(temp, "showNum", "展示次数", "d");
			// 步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置
			JFreeChart freeChart = LineCharts.createChart(dataset, strt, "数量");
			// 步骤3：将JFreeChart对象输出到文件，Servlet输出流等
			LineCharts.saveAsFile(freeChart, txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "line.jpg", 1600,
					500);
			// ************************************************************************************************
			// 生成点击次数图片
			CategoryDataset dataset1 = LineCharts.createDataset(temp, "clickNum", "点击次数", "d");
			// 步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置

			JFreeChart freeChart1 = LineCharts.createChart(dataset1, strt, "数量");
			// 步骤3：将JFreeChart对象输出到文件，Servlet输出流等
			LineCharts.saveAsFile(freeChart1, txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineclick.jpg",
					1600, 500);

			// ***************************************************************************************************
			// 广告收益图片
			CategoryDataset dataset2 = LineCharts.createDataset(temp, "earningsAmount", "广告收益", "d");
			// 步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置

			JFreeChart freeChart2 = LineCharts.createChart(dataset2, strt, "元");
			// 步骤3：将JFreeChart对象输出到文件，Servlet输出流等
			LineCharts.saveAsFile(freeChart2,
					txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineearningsAmount.jpg", 1600, 500);
			// **********************************************
			// 代理收益
			CategoryDataset dataset3 = LineCharts.createDataset(temp, "agencyAmount", "代理广告收益", "d");
			// 步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置
			JFreeChart freeChart3 = LineCharts.createChart(dataset3, strt, "元");
			// 步骤3：将JFreeChart对象输出到文件，Servlet输出流等
			LineCharts.saveAsFile(freeChart3,
					txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineagencyAmount.jpg", 1600, 500);
			// ************************************************************************************************
			// 生成展示设备图片
			CategoryDataset dataset4 = LineCharts.createDataset(temp, "equipmentId", "展示设备", "d");
			// 步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置
			JFreeChart freeChart4 = LineCharts.createChart(dataset4, strt, "数量");
			// 步骤3：将JFreeChart对象输出到文件，Servlet输出流等
			LineCharts.saveAsFile(freeChart4, txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "equipmentId.jpg", 1600,
					500);
			// ************************************************************************************************
			// 生成展示设备图片
			CategoryDataset dataset5 = LineCharts.createDataset(temp, "clickingRate", "点击率", "d");
			// 步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置
			JFreeChart freeChart5 = LineCharts.createChart(dataset5, strt, "%");
			// 步骤3：将JFreeChart对象输出到文件，Servlet输出流等
			LineCharts.saveAsFile(freeChart5, txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "clickingRate.jpg", 1600,
					500);
			System.out.println("完成");
			String title = strt;
			List titleList = new ArrayList();
			List columnList = new ArrayList();
			List dataList = new ArrayList();
			titleList.add("日期");
			titleList.add("广告标题");
			titleList.add("代理");
			titleList.add("展示次数");
			titleList.add("展示设备数");
			titleList.add("点击次数");
			titleList.add("点击率");
			titleList.add("广告收益（元）");
			titleList.add("代理广告收益（元）");
			columnList.add("createTime");
			columnList.add("adTitle");
			columnList.add("agencyName");
			columnList.add("showNum");
			columnList.add("equipmentId");
			columnList.add("clickNum");
			columnList.add("clickingRate");
			columnList.add("earningsAmount");
			columnList.add("agencyAmount");
			for (int i = 0; i < temp.size(); i++) {
				Map m = new HashMap();
				JSONObject jsonObject = temp.getJSONObject(i);
				m.put("createTime", jsonObject.getString("createTime"));
				m.put("adTitle", jsonObject.getString("adTitle"));
				m.put("agencyName", jsonObject.getString("agencyName"));
				m.put("showNum", jsonObject.getString("showNum"));
				m.put("equipmentId", jsonObject.getString("equipmentId"));
				m.put("clickNum", jsonObject.getString("clickNum"));
				m.put("clickingRate", jsonObject.getString("clickingRate"));
				m.put("earningsAmount", jsonObject.getString("earningsAmount"));
				m.put("agencyAmount", jsonObject.getString("agencyAmount"));
				dataList.add(m);
			}

			Excel2018 excel = new Excel2018();
			excel.openWorkbook(title, titleList.size() - 1);
			excel.addTable(titleList, columnList, dataList);
			excel.lineNum += 2;
			excel.addImg(txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "line.jpg", 0, 8, excel.lineNum,
					excel.lineNum + 20);
			excel.lineNum += 22;
			excel.addImg(txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineclick.jpg", 0, 8, excel.lineNum,
					excel.lineNum + 20);
			excel.lineNum += 22;
			excel.addImg(txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineearningsAmount.jpg", 0, 8,
					excel.lineNum, excel.lineNum + 20);
			excel.lineNum += 22;
			excel.addImg(txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineagencyAmount.jpg", 0, 8,
					excel.lineNum, excel.lineNum + 20);
			excel.lineNum += 22;
			excel.addImg(txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "equipmentId.jpg", 0, 8,
					excel.lineNum, excel.lineNum + 20);
			excel.lineNum += 22;
			excel.addImg(txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "clickingRate.jpg", 0, 8,
					excel.lineNum, excel.lineNum + 20);
			excel.lineNum += 22;
			excel.downLoad(response, "广告按天统计");
			String[] deleteUrl = { txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "line.jpg",
					txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineclick.jpg",
					txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineearningsAmount.jpg",
					txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "lineagencyAmount.jpg",
					txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "equipmentId.jpg",
					txCosConfig.getLocalDir() + "upload/excel/" + onlyKey + "clickingRate.jpg"};
			for (String key : deleteUrl) {
				File f = new File(key);
				if (f.exists()) {
					f.delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return;
		}
	}
}
