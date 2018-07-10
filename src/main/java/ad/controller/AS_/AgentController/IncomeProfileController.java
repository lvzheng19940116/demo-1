package ad.controller.AS_.AgentController;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ad.bean.AS_.AgentBean.BTListAgent;
import ad.bean.AS_.AgentBean.BTListIncome;
import ad.bean.AS_.AgentBean.DayProxyAll;
import ad.service.IAbReveOrderService;
import ad.service.IIncomeProfileService;
import ad.service.LCYIAbProxyUserService;
import ad.service.AS_.DeService.Deservice;
import ad.service.AS_.DeService.SubAgentProxyService;
import ad.util.DateUtil;
import ad.util.DateWeekOfMonth;

import net.sf.json.JSONSerializer;

/**
 * 收益概况
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/IncomeProfile")
public class IncomeProfileController {

	@Autowired
	private IAbReveOrderService abreorderservic;

	@Autowired
	private Deservice deservices;

	@Autowired
	private LCYIAbProxyUserService lcyprouserservice;

	@Autowired
	private IAbReveOrderService abReveOrderService;

	@Autowired
	private SubAgentProxyService subAgentProxyService;
	
	@Autowired
	private IIncomeProfileService iIncomeProfileService;

	/**
	 * 查看当前代理有多少下级代理
	 * 
	 * @param req
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/OffNumber", produces = { "application/json; charset=utf-8" })
	public Integer SerchAgentNum(HttpServletRequest req, HttpServletResponse response) {
		return iIncomeProfileService.SerchAgentNum(req, response);
	}

	/**
	 * 代理收益 今日收益；累计收益；代理数； id
	 * 
	 * @param req
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/qryIncomeProfile", produces = { "application/json; charset=utf-8" })
	public String queryIncomeProfile(HttpServletRequest req, HttpServletResponse response) {
		return iIncomeProfileService.queryIncomeProfile(req, response);
	}

	/**
	 * 筛选条件折线图/饼图 默认昨日 返回数组日期 数组金额 字符串lab
	 * 
	 * @param req
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/IncomeSituation", produces = { "application/json; charset=utf-8" })
	public String queryIncomeLineDiagrams(HttpServletRequest req, HttpServletResponse response) throws Exception {
		return iIncomeProfileService.queryIncomeLineDiagrams(req, response);
	}
	
	/**
	 * 根据登录人判断当前代理级别和佣金管理中的代理级别是否相同
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/compareAgentLevel",produces = { "application/json; charset=utf-8" })
	public String compareAgentLevel(@Param("userId")String userId){
		return iIncomeProfileService.compareAgentLevel(userId);
	}

	/**
	 * 筛选条件折线图 默认昨日 返回数组日期 数组金额 字符串lab
	 * 
	 * @param req
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/qryIncomeLineDiagram")
	public static String queryIncomeLineDiagram(HttpServletRequest req, HttpServletResponse response) {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("开始跨域3");
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", req.getHeader("Methods"));
		response.setHeader("Access-Control-Allow-Origin", req.getHeader("Origin"));
		response.setHeader("Access-Control-Request-Headers", req.getHeader("Headers"));
		response.setHeader("Access-Control-Request-Method", req.getHeader("Method"));

		String sitype = req.getParameter("isjudgeRZY");
		Integer cd = Integer.valueOf(sitype);
		System.out.println(sitype);

		String format = "yyyy-MM-dd";
		String curDate = DateUtil.getCurrentDateTime(format);// 当天
		String startDate = DateUtil.getCurrentDatePreDays(curDate, format, 1); // 昨天
		String endDate = DateUtil.getCurrentDatePreDays(curDate, format, cd); // 7天前

		System.out.println("此处开始查询，开始日期--" + startDate + "--结束日期--" + endDate);

		String titelStr = ""; // 标头声明
		int[] manyArr = {}; // 金额数据
		String[] dateArr = {};// 时间数据

		if (cd == 1) {
			System.out.println("返回昨日");
			titelStr = "昨日收入统计";
			manyArr = new int[] { 10000 };
			dateArr = new String[] { "1" };
		}
		if (cd == 7) {
			System.out.println("返回一周");
			titelStr = "近一周收入统计";
			manyArr = new int[] { 23456, 14432, 20245, 35298, 43456, 34432, 50245 };
			dateArr = new String[] { "1", "2", "3", "4", "5", "6", "7" };
		}
		if (cd == 30) {
			System.out.println("返回一月");
			titelStr = "近一月收入统计";
			manyArr = new int[] { 10000, 20000, 15000, 10000, 20000, 15000, 10000, 20000, 15000, 10000, 20000, 15000,
					10000, 20000, 15000, 10000, 20000, 15000, 10000, 20000, 15000, 10000, 20000, 15000, 10000, 20000,
					15000, 10000, 20000 };
			dateArr = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
					"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" };
		}

		Map<String,Object> mapsy = new HashMap<>();

		mapsy.put("dateArr", dateArr);
		mapsy.put("manyArr", manyArr);

		return JSONSerializer.toJSON(mapsy).toString();
	}

}
