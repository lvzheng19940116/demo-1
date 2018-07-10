package ad.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import ad.bean.AbAdvertiser;
import ad.bean.AbStatisticsHourTemp;
import ad.service.AdStatisticsDayService;
import ad.service.IHourStatisticsService;
import ad.util.DateUtil;
import ad.util.MessageUtils;

/**
 * 按天统计
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/outStatistics")
public class AdStatisticsDayController {

	// private final static String CREATETIME = "createTime";
	@Autowired
	private AdStatisticsDayService adStatisticsDayService;

	@RequestMapping(value = "/outStatisticsByDay", produces = { "application/json; charset=utf-8"},method = {
			RequestMethod.GET, RequestMethod.POST })
	public String dayStatisticsList(AbStatisticsHourTemp been) {

		try {
			if (been.getTime() != null) {
				List<AbStatisticsHourTemp> list2 = adStatisticsDayService.queryByConditions1(been);
				Integer showNumber = 0;
				Integer equipmentId = 0;
				Integer clickNumber = 0;
				String adTitle = null;
				String Name = null;
				String adverPosition = null;
				String adverAgent = null;
				String adverDisplay = "";
				DecimalFormat df = new DecimalFormat("0.00");
				BigDecimal earningsAmount = new BigDecimal("0");
				for (AbStatisticsHourTemp a : list2) {
					showNumber += a.getShowNum();
					equipmentId += Integer.valueOf(a.getEquipmentId());
					clickNumber += a.getClickNum();
					earningsAmount = earningsAmount.add(a.getEarningsAmount());
					adTitle = a.getAdTitle();
					Name = a.getName();
					adverAgent = a.getAgencyName();
					adverPosition = a.getAdverPosition().toString();

				}
				AbStatisticsHourTemp tmp = new AbStatisticsHourTemp();
				// 广告主
				tmp.setAdverMain(Name);
				// 展示次数
				tmp.setAdverDisplayNum(Long.valueOf(showNumber));
				// 展示设备次数
				tmp.setEquipmentId(equipmentId + "");
				// 点击次数
				tmp.setAdverClick(Long.valueOf(clickNumber));
				// 广告费用
				tmp.setAdvertisingExpenses(earningsAmount.longValue());
				// 广告标题
				tmp.setAdverTitle(adTitle);
				// 代理
				tmp.setAdverAgent(adverAgent);
				// 广告位
				tmp.setAdverPosition1(adverPosition);
				// 点击率
				if (showNumber > 0 && clickNumber > 0) {
					// 点击率=点击次数/展示次数
					adverDisplay = df.format(clickNumber / showNumber);
				}
				tmp.setAdverDisplay(adverDisplay);

				return MessageUtils.jsonRetrunListMessage(1, "success", tmp);
			} else {

				return MessageUtils.commonReturnMessage(0, "请输入查询时间");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return MessageUtils.commonReturnMessage(0, "fail");
		}
	}

}
