package ad.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Repeat;
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
import ad.bean.AbProxyUser;
import ad.bean.AbStatisticsHourTemp;
import ad.service.IAdvertisingManService;
import ad.service.IAngeAdCountedAllService;
import ad.service.IHourStatisticsService;
import ad.util.DateUtil;
import ad.util.MessageUtils;

@RestController
@RequestMapping("/angeAdCountedAll")
public class AngeAdCountedAllController {
	
	private static final String CREATETIME = "createTime";
	
	@Autowired
	private IAdvertisingManService iAdvertisingManService;
	@Autowired
	private IHourStatisticsService iHourStatisticsService;
	@Autowired
	private IAngeAdCountedAllService iAngeAdCountedAllService;

	
	/**
	 * 得到广告信息
	 * @param record
	 * @return
	 */
	@Transactional
	@RequestMapping("/queryAngeAdCountAll")
	public String queryAngeAdCountAll(AbAdvertiser record){
		return iAngeAdCountedAllService.queryAngeAdCountAll(record);
	}
	
	/**
	 * 根据广告标题得到广告信息
	 * @param been
	 * @return
	 */
	@Transactional
	@RequestMapping("/angeAdCountedAllByTitel")
	public String angeAdCountedAllByTitel(AbStatisticsHourTemp been){
		return iAngeAdCountedAllService.angeAdCountedAllByTitel(been);
	}
	
	/**
	 * 获取代理数据
	 * @param record
	 * @return
	 */
	@Transactional
	@RequestMapping("/queryAngeAdCountAllProxy")
	public String queryAngeAdCountAllProxy(AbAdvertiser record){
		return iAngeAdCountedAllService.queryAngeAdCountAllProxy(record);
	}
	
	/**
	 * 根据代理名称获得相应代理数据
	 * @param been
	 * @return
	 */
	@Transactional
	@RequestMapping("/angeAdCountedAllByTitelProxy")
	public String angeAdCountedAllByTitelProxy(AbStatisticsHourTemp been){
		return iAngeAdCountedAllService.angeAdCountedAllByTitelProxy(been);
	}
	
	/**
	 * 获得广告汇总头部显示信息
	 * @param record
	 * @return
	 */
	@RequestMapping("/getTopMessage")
	@Transactional
	public String getTopMessage(AbAdvertiser record){
		return iAngeAdCountedAllService.getTopMessage(record.getUserid());
	}
}
