package ad.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import ad.bean.AbAdver;
import ad.bean.AbAdvertProxyAssociation;
import ad.bean.AbAdvertiser;
import ad.bean.AbProxyUser;
import ad.bean.StatusBeen;
import ad.service.IAbAdvertProxyAssociationService;
import ad.service.IAbAdvertiserService;
import ad.service.IAbProxyUserService;
import ad.service.IAdvertisingManService;
import ad.util.DateUtil;
import ad.util.IdUtil;
import ad.util.MessageUtils;

import net.sf.json.JSONSerializer;

//import scala.reflect.macros.internal.macroImpl;

/**
 * 广告管理
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("adverman")
public class AdvertisingManController {
	@Autowired
	private IAdvertisingManService iAdvertisingManService;

	@Autowired
	private IAbProxyUserService iiAbProxyUserService;
	@Autowired
	private IAbAdvertProxyAssociationService iiAbAdvertProxyAssociationService;

	@Autowired
	private IAbAdvertiserService iAbAdvertiserService;

	
	private final static int STATUS = 4;

	@RequestMapping(value = "/Get_Adver_5day_ForSDK", produces = { "application/json; charset=utf-8" })
	public String listAbAdver(Integer proxyId) {
		AbAdver been = new AbAdver();
		been.setProxyId(proxyId);
		try {
			List<AbAdver> listAbAdver = iAdvertisingManService.listAbAdver(been);

			String jsonString = JSON.toJSONString(listAbAdver);
			JSONArray parseArray = JSONArray.parseArray(jsonString);

			for (int i = 0; i < parseArray.size(); i++) {
				JSONObject jsonObject = parseArray.getJSONObject(i);
				JSONArray adverFile1Url = jsonObject.getJSONArray("adverFile1Url");
				jsonObject.put("adverFile1Url", adverFile1Url);
				JSONArray imgResolution1 = jsonObject.getJSONArray("imgResolution1");
				jsonObject.put("imgResolution1", imgResolution1);
			}
			// 格式化图片 分辨率 视频
			JSONObject jsonResult = new JSONObject();
			jsonResult.put("List", parseArray);
			jsonResult.put("message", "返回列表信息");
			jsonResult.put("success", "success");
			jsonResult.put("code", 1);
			return jsonResult.toJSONString();
		} catch (Exception e) {
			return MessageUtils.commonReturnMessage(0, "fail");
		}

	}

	/**
	 * 查询是否有相同的广告名称
	 * @param been
	 * @return
	 */
	@RequestMapping(value = "/CheckAdverTitle", produces = { "application/json; charset=utf-8" })
	public String checkAdverTitle(AbAdver been) {
		Integer count = iAdvertisingManService.getNameCount(been);
		if (count != 0) {
			return MessageUtils.commonReturnMessage(1, "提示广告名称已存在，并保存失败");
		}else{
			return MessageUtils.commonReturnMessage(2, "提示广告名称新建成功");
		}
	}
	
	/**
	 * 校验广告名称
	 * @param been
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/CheckUpdateAdverTitle", produces = { "application/json; charset=utf-8" })
	public String checkUpdateAdverTitle(AbAdver been,Integer id) {
		return iAdvertisingManService.checkUpdateAdverTitle(been, id);
	}
	
	/**
	 * 添加广告
	 * @param been
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/AddAdverInfo", produces = { "application/json; charset=utf-8" })
	public String saveObject(AbAdver been) {
		return iAdvertisingManService.addAdverInfo(been);
	}

	// 广告主查询列表
	@Deprecated
	@RequestMapping(value = "/QueryAdverListAccountName", produces = { "application/json; charset=utf-8" })
	public String queryaAccountName(AbAdver been, String userAccount) {
		// if (userAccount == null && "".equals(userAccount)) {
		// return MessageUtils.commonReturnMessage(0, "查询失败");
		// }
		// // 去广告主表查询是否存在广告主信息，存在是广告主，不存在是管理员
		// AbAdvertiser ab = new AbAdvertiser();
		// ab.setAdvertiserName(userAccount);
		// AbAdvertiser accountName =
		// iAbAdvertiserService.queryByuserAccount(ab);
		// // 获取广告主Id
		// if (accountName != null && accountName.getAdvertiserId() != null) {
		// String advertiserId = accountName.getAdvertiserId();
		// // 通过广告主编号查询 绑定的广告主的广告
		// been.setAdvertiserId(advertiserId);
		// Integer page = been.getPage();
		// Integer pageTemp = (page - 1) * PAGESIZE;
		// been.setPage(pageTemp);
		// Calendar instance = Calendar.getInstance();
		// instance.set(Calendar.HOUR_OF_DAY, 0);
		// instance.set(Calendar.MINUTE, 0);
		// instance.set(Calendar.SECOND, 0);
		// long currentTime = instance.getTime().getTime();
		// List<AbAdver> list = iAdvertisingManService.selectByPage(been);
		// long total = iAdvertisingManService.selectTotal(been);
		// for (int i = 0; i < list.size(); i++) {
		// AbAdver abAdver = list.get(i);
		// Integer status2 = abAdver.getStatus();
		// Date startTime = abAdver.getStartTime();
		// long startDateLongValue = startTime.getTime();
		// Date endTime = abAdver.getEndTime();
		// long endDateLongValue = endTime.getTime();
		// // 状态等于4或5, 不改变状态，
		// if (status2 != 4 && status2 != 5) {
		// // 当前时间大于截止时间修改状态为下线
		// if (currentTime >= endDateLongValue) {
		// // 已下线状态
		// // if (status2 != 2) {
		// // AbAdver beenStatusById = new AbAdver();
		// // beenStatusById.setId(been.getId());
		// been.setStatus(2);
		// // int updateBykey =
		// // iAdvertisingManService.updateBykey(beenStatusById);
		// // }
		// }
		// }
		// }
		//
		// String strResult = JSON.toJSONStringWithDateFormat(list,
		// "yyyy-MM-dd");
		// JSONArray result = JSONArray.parseArray(strResult);
		// return MessageUtils.jsonRetrunListTotalMessage(1, "success", result,
		// total);
		// } else {
		// return MessageUtils.jsonRetrunListTotalMessage(1, "success", null,
		// 0);
		// }

		return "";
	}

	/**
	 * 管理员查询列表
	 * 
	 * @param been
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/QueryAdverList", produces = { "application/json; charset=utf-8" })
	public String queryByPage(AbAdver been) {
		return iAdvertisingManService.queryByPage(been);
	}

	/**
	 * 修改广告
	 * @param been
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/UpdateAdverInfo", produces = { "application/json; charset=utf-8" })
	public String updateByKey(AbAdver been) {
		return iAdvertisingManService.updateAbAdverByKey(been);	
	}

	@Transactional
	@RequestMapping(value = "/UpdateAdverStatus", produces = { "application/json; charset=utf-8" })
	public String updateByIdOfStatus(AbAdver been) {
		// status

		try {
			AbAdver result = iAdvertisingManService.queryBykey(been.getId());
			Date dateTemp = new Date();
			// long longTemp = dateTemp.getTime();
			// long startLong = result.getStartTime().getTime();

			// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// String dateTemp = sdf.format(date);
			// if(longTemp < startLong){
			int code = iAdvertisingManService.updateBykey(been);

			return MessageUtils.commonReturnMessage(code, "success");
			// }
			// return MessageUtils.commonReturnMessage(0, "fail");
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "fail");
		}
		
	}
	
	/**
	 * 校验广告单价
	 * @param billingMethodWay
	 * @param id
	 * @param flag
	 * @return
	 */
	@RequestMapping(value = "/checkAdUnitPrice", produces = { "application/json; charset=utf-8" })
	public String checkAdUnitPrice(String billingMethodWay, Integer id, Integer flag) {
		return iAdvertisingManService.checkAdUnitPrice(billingMethodWay, id, flag);
	}
	
	/**
	 * 校验广告金额
	 * @param totalAdverPrice
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/checkAdverPrice", produces = { "application/json; charset=utf-8" })
	public String checkAdverPrice(String totalAdverPrice,Integer id) {
		return iAdvertisingManService.checkAdverPrice(totalAdverPrice, id);
	}
	
	/**
	 * 判断时间格式
	 * @param startEndTime
	 * @return
	 */
	@RequestMapping(value = "/checkStartEndTime", produces = { "application/json; charset=utf-8" })
	public String checkStartEndTime(String startEndTime) {
		return iAdvertisingManService.checkStartEndTime(startEndTime);
	}
	
	/**
	 * 根据主键查询广告信息
	 * @param id
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/queryByKey", produces = { "application/json; charset=utf-8" })
	public String queryByKey(Integer id) {
		return iAdvertisingManService.queryAbAdverByKey(id);
	}

	/**
	 * 删除广告
	 * @param been
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/DeleteAdvertInfo", produces = { "application/json; charset=utf-8" })
	public String deleteByKey(AbAdver been) {
		return iAdvertisingManService.deleteAbAdverByKey(been);
	}

	/**
	 * 查询代理
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/selectAgent", produces = { "application/json; charset=utf-8" })
	public String selectAgent() {
		try {
			List<AbProxyUser> firstList = iiAbProxyUserService.selectAgentLevelFirst();
			List<AbProxyUser> twoList = iiAbProxyUserService.selectAgentLevelTwo();
			List<AbProxyUser> threeList = iiAbProxyUserService.selectAgentLevelThree();
			JSONObject agent = new JSONObject();
			agent.put("firstList", firstList);
			agent.put("twoList", twoList);
			agent.put("threeList", threeList);
			agent.put("code", 1);
			agent.put("message", "success");
			return agent.toJSONString();
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "fail");
		}
	}

	/**
	 * 获取广告明细
	 * @param id
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/GetAdverInfo", produces = { "application/json; charset=utf-8" })
	public String selectByKey(Integer id) {
		return iAdvertisingManService.selectByKey(id);
	}

	/**
	 * 查询代理
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/GetProxyName", produces = { "application/json; charset=utf-8" })
	public String getTempMenu() {

		try {
			List<AbProxyUser> menu = iiAbProxyUserService.getMenu();
			return MessageUtils.jsonRetrunListMessage(1, "success", menu);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "fail");
		}

	}

}
