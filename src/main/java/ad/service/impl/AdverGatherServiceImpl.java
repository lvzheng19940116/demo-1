package ad.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import ad.bean.AbAdver;
import ad.bean.AbAdvertiser;
import ad.bean.AbStatisticsHourTemp;
import ad.mapper.AbAdverMapper;
import ad.mapper.AbStatisticsHourTempMapper;
import ad.service.IAdverGatherService;
import ad.service.IAdvertisingManService;
import ad.service.IHourStatisticsService;
import ad.util.DateUtil;
import ad.util.MessageUtils;

@Service
public class AdverGatherServiceImpl implements IAdverGatherService {
	
	private static final String CREATETIME = "createTime";
	@Autowired
	private IHourStatisticsService iHourStatisticsService;
	@Autowired
	private IAdvertisingManService iAdvertisingManService;
	@Autowired
	private AbStatisticsHourTempMapper abStatisticsHourTempMapper;
	@Autowired
	private AbAdverMapper abAdverMapper;

	/**
	 * 按时(分类)    得到昨天上线广告信息
	 */
	@Override
	public String getAdGather(AbAdvertiser record) {
		// record.setUserid("9e0ac526bf46bf642e10354a86332c29");
		try {
			// AbAdvertiser been = iAbAdvertiserService.queryByUserId(record);
			// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//格式化时间
			SimpleDateFormat sdff = new SimpleDateFormat("yyyy年MM月dd日 HH时");
			// if (been != null) {
			// 通过广告主id 查询广告主下的所有广告，广告表
			// been.getAdvertiserId();
			// iAbAdvertiserService.queryBy 获取广告主下所有的广告
			// List<AbAdver> queryByAdvertiserId =
			// iAdvertisingManService.queryByAdvertiserId(record.getUserid());
			// List<AbAdver> queryByAdvertiserId = iAdvertisingManService
			// .queryByAdvertiserId("9e0ac526bf46bf642e10354a86332c29");
			//根据userid得到广告信息
			List<AbAdver> queryByAdvertiserId = abAdverMapper.queryByAdvertiserId(record.getUserid());
			// 返回广告主下的所有广告;
			// 查询这个广告主下昨日所有的广告 分时查询
			Calendar instance = Calendar.getInstance();
			instance.set(Calendar.HOUR_OF_DAY, 0);
			Date end = instance.getTime();
			instance.add(Calendar.DAY_OF_MONTH, -1);
			instance.set(Calendar.HOUR_OF_DAY, 0);
			Date start = instance.getTime();
			// 格式化时间
			// Date time = sdf.parse(startTempTime);
			// 创建List集合装在1-24小时
			// String start = "2017-09-01";
			// String end = "2017-09-02";
			// Date parse = null;
			// Date parse2 = null;
			List<Date> findDatesHH = null;
			findDatesHH = DateUtil.findDatesHH(start, end);
			List<String> keys = JSON.parseObject(JSON.toJSONStringWithDateFormat(findDatesHH, "yyyy年MM月dd日 HH时"),
					new TypeReference<List<String>>() {
					});
			// 创建临时集合存放结果集
			JSONArray temp = new JSONArray();
			JSONArray details = new JSONArray();
			// 数据库获取数据源
			// 替换查询语句
			// List<AbStatisticsHourTemp> queryByHour =
			// iHourStatisticsService.queryByHour(been);
			// if (queryByAdvertiserId.isEmpty()) {
			// AbStatisticsHourTemp aht = new AbStatisticsHourTemp();
			// aht.setAdTitle("暂无数据");
			// aht.setAgencyName("暂无数据");
			// aht.setAgencyAmount(new BigDecimal(0));
			// aht.setClickNum(0);
			// aht.setCreateTime(start);
			// aht.setEarningsAmount(new BigDecimal(0));
			// aht.setEquipmentId("暂无数据");
			// aht.setShowNum(0);
			// List<AbStatisticsHourTemp> list = new
			// ArrayList<AbStatisticsHourTemp>();
			// JSONArray resultNo =
			// JSONArray.parseArray(JSON.toJSONStringWithDateFormat(list,
			// "yyyy年MM月dd日 HH时"));
			// JSONObject json = new JSONObject();
			// json.put("earnings_amount", 0);
			// json.put("surplusAdverPrice", 0);
			// json.put("list", queryByAdvertiserId);
			// json.put("AdvertQuantity", 0);
			// json.put("temp", new ArrayList<AbStatisticsHourTemp>());
			// json.put("details", resultNo);
			// JSONObject jsonCount = new JSONObject();
			// jsonCount.put("showNumTemp", 0);
			// jsonCount.put("clickNumTemp", 0);
			// jsonCount.put("clickRateTemp", 0);
			// jsonCount.put("adCostTemp", 0);
			// return MessageUtils.jsonRetrunListMessage(1, "success", json,
			// jsonCount);
			// }
			List<AbStatisticsHourTemp> advertisingCostsToday1 = null;
			JSONArray result = null;
			if (!queryByAdvertiserId.isEmpty()) {
				advertisingCostsToday1 = abStatisticsHourTempMapper.advertisingByHourYesterday(queryByAdvertiserId);
			}
			if (advertisingCostsToday1 == null) {
				result = JSONArray.parseArray(
						JSON.toJSONStringWithDateFormat(new ArrayList<AbStatisticsHourTemp>(), "yyyy年MM月dd日 HH时"));
			} else {
				result = JSONArray
						.parseArray(JSON.toJSONStringWithDateFormat(advertisingCostsToday1, "yyyy年MM月dd日 HH时"));
			}
			if (result == null) {
				result = new JSONArray();
			}
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
				// if (result != null) {
				for (int i = 0; i < result.size(); i++) {
					JSONObject jsonObject = result.getJSONObject(i);
					if (key.equals(jsonObject.getString(CREATETIME))) {
						Integer click = jsonObject.getInteger("showNum");
						Integer show = jsonObject.getInteger("clickNum");
						Integer clickingRate = 0;
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
						details.add(jsonObject);
						flag = true;
					}
				}
				// }
				if (!flag) {
					AbStatisticsHourTemp aht = new AbStatisticsHourTemp();
					aht.setAdTitle("无");
					aht.setAgencyName("无");
					aht.setAgencyAmount(new BigDecimal(0));
					aht.setClickNum(0);
					aht.setCreateTime(sdff.parse(key));
					aht.setEarningsAmount(new BigDecimal(0));
					aht.setEquipmentId("0");
					aht.setShowNum(0);
					temp.add(JSON.parseObject(JSON.toJSONStringWithDateFormat(aht, "yyyy年MM月dd日 HH时")));
				}
			}
			// 今日广告费用 广告id
			BigDecimal earningsAmount = new BigDecimal(0);
			if (queryByAdvertiserId != null && queryByAdvertiserId.size() > 0) {
				AbStatisticsHourTemp advertisingCostsToday = abStatisticsHourTempMapper
						.advertisingCostsToday(queryByAdvertiserId);
				if (advertisingCostsToday != null) {
					earningsAmount = advertisingCostsToday.getEarningsAmount();
				}
			}
			// 得出今日广告费用
			// 广告余额
			// 广告剩余金额
			Float ab = 0f;
			for (AbAdver item : queryByAdvertiserId) {
				if (item.getSurplusAdverPrice() != null) {
					ab += item.getSurplusAdverPrice();
				}
				// ab.add(surplusAdverPrice);
				// hh += item.getSurplusAdverPrice();
			}
			JSONObject json = new JSONObject();
			json.put("earnings_amount", earningsAmount);
			json.put("surplusAdverPrice", ab == 0 ? "0" : ab);
			json.put("list", queryByAdvertiserId);
			json.put("AdvertQuantity", queryByAdvertiserId.size());
			json.put("temp", temp);
			json.put("details", details);
			// 统计点击数、展示数、点击率、广告费用
			JSONObject jsonCount = new JSONObject();
			jsonCount.put("showNumTemp", showNum);
			jsonCount.put("clickNumTemp", clickNum);
			jsonCount.put("clickRateTemp", clickRate);
			jsonCount.put("adCostTemp", adCost);
			return MessageUtils.jsonRetrunListMessage(1, "success", json, jsonCount);
			// } else {
			// AbStatisticsHourTemp aht = new AbStatisticsHourTemp();
			// aht.setAdTitle("无");
			// aht.setAgencyName("无");
			// aht.setAgencyAmount(new BigDecimal(0));
			// aht.setClickNum(0);
			// aht.setCreateTime(new Date());
			// aht.setEarningsAmount(new BigDecimal(0));
			// aht.setEquipmentId("0");
			// aht.setShowNum(0);
			//// List<AbStatisticsHourTemp> list = new
			// ArrayList<AbStatisticsHourTemp>();
			// return MessageUtils.jsonRetrunListMessage(1, "success", null);
			// }
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "fail");
		}
	}
	
	/**
	 * 得到昨天上线的广告标题
	 * @param been
	 * @return
	 */
	@Override
	public String queryByAdTitelYesterDay(AbStatisticsHourTemp been) {
		Calendar instance = Calendar.getInstance();
		instance.set(Calendar.HOUR_OF_DAY, 0);
		Date end = instance.getTime();
		instance.add(Calendar.DAY_OF_MONTH, -1);
		instance.set(Calendar.HOUR_OF_DAY, 0);
		Date start = instance.getTime();
		try {
			// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdff = new SimpleDateFormat("yyyy年MM月dd日 HH时");
			// 格式化时间
			// Date time = sdf.parse(startTempTime);
			// 创建List集合装在1-24小时
			// String start = "2017-09-01";
			// String end = "2017-09-02";
			// Date parse = null;
			// Date parse2 = null;
			List<Date> findDatesHH = DateUtil.findDatesHH(start, end);
			List<String> keys = JSON.parseObject(JSON.toJSONStringWithDateFormat(findDatesHH, "yyyy年MM月dd日 HH时"),
					new TypeReference<List<String>>() {
					});
			// 创建临时集合存放结果集
			JSONArray temp = new JSONArray();
			JSONArray details = new JSONArray();
			// 数据库获取数据源
			List<AbStatisticsHourTemp> queryByHour = abStatisticsHourTempMapper.queryByAdTitelYesterday(been);
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
						details.add(jsonObject);
						flag = true;
					}
				}
				if (!flag) {
					AbStatisticsHourTemp aht = new AbStatisticsHourTemp();
					aht.setAdTitle("无");
					aht.setAgencyName("无");
					aht.setAgencyAmount(new BigDecimal(0));
					aht.setClickNum(0);
					aht.setCreateTime(sdff.parse(key));
					aht.setEarningsAmount(new BigDecimal(0));
					aht.setEquipmentId("0");
					aht.setShowNum(0);
					temp.add(JSON.parseObject(JSON.toJSONStringWithDateFormat(aht, "yyyy年MM月dd日 HH时")));
				}
			}
			JSONObject json = new JSONObject();
			json.put("temp", temp);
			json.put("details", details);

			// 统计点击数、展示数、点击率、广告费用
			JSONObject jsonCount = new JSONObject();
			jsonCount.put("showNumTemp", showNum);
			jsonCount.put("clickNumTemp", clickNum);
			jsonCount.put("clickRateTemp", clickRate);
			jsonCount.put("adCostTemp", adCost);
			return MessageUtils.jsonRetrunListMessage(1, "success", json, jsonCount);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "fail");
		}
	}
}
