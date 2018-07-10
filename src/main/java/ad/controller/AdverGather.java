package ad.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import ad.bean.AbAdver;
import ad.bean.AbAdvertiser;
import ad.bean.AbStatisticsHourTemp;
import ad.service.IAbAdvertiserService;
import ad.service.IAdverGatherService;
import ad.service.IAdvertisingManService;
import ad.service.IHourStatisticsService;
import ad.util.DateUtil;
import ad.util.MessageUtils;

@RestController
@RequestMapping("/gather")
public class AdverGather {
	private static final String CREATETIME = "createTime";
	@Autowired
	private IAbAdvertiserService iAbAdvertiserService;

	@Autowired
	private IAdvertisingManService iAdvertisingManService;

	@Autowired
	private IHourStatisticsService iHourStatisticsService;
	
	@Autowired
	private IAdverGatherService iAdverGatherService;

	/**
	 * 得到昨天上线的广告
	 * @param record
	 * @return
	 */
	@Transactional
	@RequestMapping("/getAdGather")
	public String getAdGather(AbAdvertiser record) {
		return iAdverGatherService.getAdGather(record);
	}

	/**
	 * 得到昨天上线的广告标题
	 * @param been
	 * @return
	 */
	@Transactional
	@RequestMapping("/gatherByTitel")
	public String queryByAdTitelYesterDay(AbStatisticsHourTemp been) {
		return iAdverGatherService.queryByAdTitelYesterDay(been);
	}

	@Transactional
	@RequestMapping(value = "/adGather", produces = { "application/json; charset=utf-8" })
	public String queryByUserId(AbAdvertiser record) {
		// 查询广告主表 的id
		try {

			AbAdvertiser been = iAbAdvertiserService.queryByUserId(record);
			if (been != null) {
				// 通过广告主id 查询广告主下的所有广告，广告表
				been.getAdvertiserId();
				// iAbAdvertiserService.queryBy
				List<AbAdver> queryByAdvertiserId = iAdvertisingManService.queryByAdvertiserId(been.getAdvertiserId());
				// 返回广告主下的所有广告;
				// 今日广告费用 广告id
				BigDecimal earningsAmount = null;
				if (queryByAdvertiserId != null && queryByAdvertiserId.size() > 0) {
					AbStatisticsHourTemp advertisingCostsToday = iHourStatisticsService
							.advertisingCostsToday(queryByAdvertiserId);
					earningsAmount = advertisingCostsToday.getEarningsAmount();
				}
				//
				// 得出今日广告费用
				// 广告余额
				// 广告剩余金额
				Float ab = 0f;
				for (AbAdver item : queryByAdvertiserId) {
					ab += item.getSurplusAdverPrice();
					// ab.add(surplusAdverPrice);
					// hh += item.getSurplusAdverPrice();
				}
				JSONObject json = new JSONObject();
				json.put("earnings_amount", earningsAmount);
				json.put("surplusAdverPrice", ab == 0 ? "" : ab);
				json.put("list", queryByAdvertiserId);
				json.put("AdvertQuantity", queryByAdvertiserId);
				return MessageUtils.jsonRetrunListMessage(1, "success", json);
			} else {
				return MessageUtils.jsonRetrunListMessage(1, "success", null);
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "fail");
		}
	}

}
