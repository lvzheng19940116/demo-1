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
import ad.bean.AbProxyUser;
import ad.bean.AbStatisticsHourTemp;
import ad.mapper.AbAdverMapper;
import ad.mapper.AbStatisticsHourTempMapper;
import ad.service.IAdvertisingManService;
import ad.service.IAngeAdCountedAllService;
import ad.service.IHourStatisticsService;
import ad.util.DateUtil;
import ad.util.MessageUtils;

@Service
public class AngeAdCountedAllServiceImpl implements IAngeAdCountedAllService{

	private static final String CREATETIME = "createTime";
	@Autowired
	private AbAdverMapper abAdverMapper;
	@Autowired
	private IHourStatisticsService iHourStatisticsService;
	@Autowired
	private IAdvertisingManService iAdvertisingManService;
	@Autowired
	private AbStatisticsHourTempMapper abStatisticsHourTempMapper;
	
	/**
	 * 获得广告汇总头部显示信息
	 * @param record
	 * @return
	 */
	@Override
	public String getTopMessage(String userId) {
		JSONObject json=new JSONObject();
		try{
			//得到登录人id
			String id=abAdverMapper.getId(userId);
			//得到广告id集合
			List<AbAdver> adverIds=abAdverMapper.getAdverCount(id);
			String adverIdStr="";
			for (AbAdver abAdver : adverIds) {
				adverIdStr+=abAdver.getId()+",";
			}
			List<AbStatisticsHourTemp> list=null;
			if(adverIdStr.length()>0){
				adverIdStr=adverIdStr.substring(0, adverIdStr.length()-1);
				String[] arr=adverIdStr.split(",");
				//根据登录人id和广告id获得广告收益和代理广告收益
				list=abAdverMapper.getAdverMoney(arr, id);
			}
			json.put("code", "1");
			json.put("message", "success");
			json.put("count", adverIds.size());
			json.put("money", list);
			return MessageUtils.jsonRetrunListMessage(1,"success",json,"");
		}catch(Exception e){
			e.printStackTrace();
			json.put("code", "0");
			json.put("message", "fail:"+e);
			return MessageUtils.commonReturnMessage(0, "fail");
		}
	}
	
	//modified by caiqp
	/**
	 * 得到广告信息
	 */
	@Override
	public String queryAngeAdCountAll(AbAdvertiser record) {
		try {
			SimpleDateFormat sdff = new SimpleDateFormat("yyyy年MM月dd日 HH时");
			//获得代理名称 
			AbProxyUser abProxyUser = new AbProxyUser();
			abProxyUser.setUserid(record.getUserid());
			List<AbProxyUser> abProxyUserList = iHourStatisticsService.queryAngeList(abProxyUser);
			//获得user4下的相关用户的广告id
			List<AbAdver> queryByProxyUserId=null;
			if(abProxyUserList.get(0)!=null){
				queryByProxyUserId= abAdverMapper.queryByProxyUserId(abProxyUserList);
			}
			// 返回广告主下的所有广告;
			// 查询这个广告主下昨日所有的广告 分时查询
			Calendar instance = Calendar.getInstance();
			instance.set(Calendar.HOUR_OF_DAY, 0);
			Date end = instance.getTime();
			instance.add(Calendar.DAY_OF_MONTH, -1);
			instance.set(Calendar.HOUR_OF_DAY, 0);
			Date start = instance.getTime();
			List<Date> findDatesHH = null;
			findDatesHH = DateUtil.findDatesHH(start, end);
			List<String> keys = JSON.parseObject(JSON.toJSONStringWithDateFormat(findDatesHH, "yyyy年MM月dd日 HH时"),
					new TypeReference<List<String>>() {
					});
			// 创建临时集合存放结果集
			JSONArray temp = new JSONArray();
			JSONArray details = new JSONArray();
			List<AbStatisticsHourTemp> advertisingCostsToday1 = null;
			JSONArray result = null;
			if (queryByProxyUserId!=null && queryByProxyUserId.size()>0) {
				// 获得具体数据
				advertisingCostsToday1 = abStatisticsHourTempMapper.advertisingByHourYesterday(queryByProxyUserId);
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
			JSONObject json = new JSONObject();
			json.put("list", queryByProxyUserId);
			json.put("temp", temp);
			json.put("details", details);
			return MessageUtils.jsonRetrunListMessage(1, "success", json, "");
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "fail");
		}
	}
	
	/**
	 * 根据广告标题得到广告信息
	 * @param been
	 * @return
	 */
	@Override
	public String angeAdCountedAllByTitel(AbStatisticsHourTemp been) {
		//获取当前日期
		Calendar instance = Calendar.getInstance();
		instance.set(Calendar.HOUR_OF_DAY, 0);
		Date end = instance.getTime();
		instance.add(Calendar.DAY_OF_MONTH, -1);
		instance.set(Calendar.HOUR_OF_DAY, 0);
		Date start = instance.getTime();
		try {
			SimpleDateFormat sdff = new SimpleDateFormat("yyyy年MM月dd日 HH时");
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
			return MessageUtils.jsonRetrunListMessage(1, "success", json, "");
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "fail");
		}
	}
	
	/**
	 * 获取代理数据
	 * @param record
	 * @return
	 */
	@Override
	public String queryAngeAdCountAllProxy(AbAdvertiser record) {
		try {
			SimpleDateFormat sdff = new SimpleDateFormat("yyyy年MM月dd日 HH时");
			//获得代理名称 
			AbProxyUser abProxyUser = new AbProxyUser();
			abProxyUser.setUserid(record.getUserid());
			List<AbProxyUser> abProxyUserList = iHourStatisticsService.queryAngeList(abProxyUser);
			//获得user4下的用户的广告id
			List<AbAdver> queryByProxyUserId = abAdverMapper.queryByProxyUserId(abProxyUserList);
			// 返回广告主下的所有广告;
			// 查询这个广告主下昨日所有的广告 分时查询
			Calendar instance = Calendar.getInstance();
			instance.set(Calendar.HOUR_OF_DAY, 0);
			Date end = instance.getTime();
			instance.add(Calendar.DAY_OF_MONTH, -1);
			instance.set(Calendar.HOUR_OF_DAY, 0);
			Date start = instance.getTime();
			List<Date> findDatesHH = null;
			findDatesHH = DateUtil.findDatesHH(start, end);
			List<String> keys = JSON.parseObject(JSON.toJSONStringWithDateFormat(findDatesHH, "yyyy年MM月dd日 HH时"),
					new TypeReference<List<String>>() {
					});
			// 创建临时集合存放结果集
			JSONArray temp = new JSONArray();
			JSONArray details = new JSONArray();
			List<AbStatisticsHourTemp> advertisingCostsToday1 = null;
			JSONArray result = null;
			//获取代理数据
			if (!queryByProxyUserId.isEmpty()) {
				advertisingCostsToday1 = abStatisticsHourTempMapper.advertisingByHourYesterday(queryByProxyUserId);
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
			//装载信息
			JSONObject json = new JSONObject();
			json.put("list", queryByProxyUserId);
			json.put("temp", temp);
			json.put("details", details);
			json.put("proxyUser",abProxyUserList);
			return MessageUtils.jsonRetrunListMessage(1, "success", json, "");
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "fail");
		}
	}
	
	/**
	 * 根据代理名称获得相应代理数据
	 * @param been
	 * @return
	 */
	@Override
	public String angeAdCountedAllByTitelProxy(AbStatisticsHourTemp been) {
		Calendar instance = Calendar.getInstance();
		instance.set(Calendar.HOUR_OF_DAY, 0);
		Date end = instance.getTime();
		instance.add(Calendar.DAY_OF_MONTH, -1);
		instance.set(Calendar.HOUR_OF_DAY, 0);
		Date start = instance.getTime();
		try {
			SimpleDateFormat sdff = new SimpleDateFormat("yyyy年MM月dd日 HH时");
			List<Date> findDatesHH = DateUtil.findDatesHH(start, end);
			List<String> keys = JSON.parseObject(JSON.toJSONStringWithDateFormat(findDatesHH, "yyyy年MM月dd日 HH时"),
					new TypeReference<List<String>>() {
					});
			// 创建临时集合存放结果集
			JSONArray temp = new JSONArray();
			JSONArray details = new JSONArray();
			//具体哪个代理下的广告id
			List<AbAdver> selectByProxyUserId = abAdverMapper.selectByProxyUserId(been.getProxyId().toString());
			System.out.println(been.getProxyId());
			// 数据库获取数据源
			if(selectByProxyUserId.size()==0){
				selectByProxyUserId=null;
			}
			List<AbStatisticsHourTemp> queryByHour = abStatisticsHourTempMapper.advertisingByHourYesterday(selectByProxyUserId);
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
			return MessageUtils.jsonRetrunListMessage(1, "success", json, "");
		} catch (Exception e) {
			e.printStackTrace(); 
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "fail");
		}
	}
}
