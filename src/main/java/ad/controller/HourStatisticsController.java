package ad.controller;

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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import ad.bean.AbAdvertiser;
import ad.bean.AbProxyUser;
import ad.bean.AbStatisticsHourTemp;
import ad.service.IAbAdvertiserService;
import ad.service.IHourStatisticsService;
import ad.txcos.TxCosConfig;
import ad.util.DateUtil;
import ad.util.Excel2018;
import ad.util.LineCharts;
import ad.util.MessageUtils;

/**
 * 按天，分时统计
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/statistics")
public class HourStatisticsController {
	private final static String CREATETIME = "createTime";
	@Autowired
	private IHourStatisticsService iHourStatisticsService;

	@Autowired
	private TxCosConfig txCosConfig;
	/**
	 * 广告主服务
	 */
	@Autowired
	private IAbAdvertiserService iAbAdvertiserService;

	/**
	 * 广告统计数据来源方法
	 * @param been
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/statisticsDay", produces = { "application/json; charset=utf-8" })
	public String dayStatisticsList(AbStatisticsHourTemp been) {
		return iHourStatisticsService.dayStatisticsList(been);
	}

	/**
	 * 广告统计分时
	 * @param been
	 * @return
	 * @throws ParseException
	 */
	@Transactional
	@RequestMapping(value = "/statisticsHour", produces = { "application/json; charset=utf-8" })
	public String hourStatisticsList(AbStatisticsHourTemp been) throws ParseException {
		return iHourStatisticsService.hourStatisticsList(been);
	}
	/**
	 * 代理广告统计按天
	 * @param been
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/statisticsDayOfAngent", produces = { "application/json; charset=utf-8" })
	public String statisticsDayOfAngent(AbStatisticsHourTemp been) {
		return iHourStatisticsService.statisticsDayOfAngent(been);
	}
	/**
	 * 代理广告统计分时
	 * @param been
	 * @return
	 * @throws ParseException
	 */
	@Transactional
	@RequestMapping(value = "/angetHourStatisticsList", produces = { "application/json; charset=utf-8" })
	public String AngleHourStatisticsList(AbStatisticsHourTemp been) throws ParseException {
		return iHourStatisticsService.AngleHourStatisticsList(been);
	}

	/**
	 * 广告统计导出按天
	 * @param been
	 * @param response
	 */
	@Transactional
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/downLoadStatisticsDay", produces = { "application/json; charset=utf-8" })
	public void exportExcell(AbStatisticsHourTemp been, HttpServletResponse response) {
		iHourStatisticsService.exportExcell(been, response);
	}
	
	/**
	 * 代理广告统计导出按天
	 * @param been
	 * @param response
	 */
	@Transactional
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/downLoadStatisticsDayOfAngent", produces = { "application/json; charset=utf-8" })
	public void downLoadStatisticsDayOfAngent(AbStatisticsHourTemp been, HttpServletResponse response) {
		iHourStatisticsService.downLoadStatisticsDayOfAngent(been, response);
	}

	/**
	 * 代理广告统计分时导出
	 * @param been
	 * @param response
	 */
	@Transactional
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/downLoadAgentStatisticsHour", produces = { "application/json; charset=utf-8" })
	public void downLoadAgentStatisticsHour(AbStatisticsHourTemp been, HttpServletResponse response) {
		iHourStatisticsService.downLoadAgentStatisticsHour(been, response);
	}
	
	/**
	 * 广告统计分时导出
	 * @param been
	 * @param response
	 */
	@Transactional
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/downLoadStatisticsHour", produces = { "application/json; charset=utf-8" })
	public void downLoadStatisticsHour(AbStatisticsHourTemp been, HttpServletResponse response) {
		iHourStatisticsService.downLoadStatisticsHour(been, response);
	}

}
