package ad.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ad.bean.AS_.AgentBean.BTListAgent;
import ad.bean.AS_.AgentBean.BTListIncome;
import ad.bean.AS_.AgentBean.DayProxyAll;
import ad.mapper.AbProxyUserMapper;
import ad.mapper.AbReveOrderMapper;
import ad.mapper.AblcyProxyUserMapper;
import ad.mapper.AS_.SubAgentsProxyMapper;
import ad.service.IAbBillingCycleService;
import ad.service.IAbReveOrderService;
import ad.service.IIncomeProfileService;
import ad.service.LCYIAbProxyUserService;
import ad.service.AS_.DeService.Deservice;
import ad.service.AS_.DeService.SubAgentProxyService;
import ad.util.DateUtil;
import ad.util.DateWeekOfMonth;

import net.sf.json.JSONSerializer;

@Service
public class IncomeProfileServiceImpl implements IIncomeProfileService {

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
	private AbProxyUserMapper abProxyUserMapper;
	@Autowired
	private IAbBillingCycleService iAbBillingCycleService;
	@Autowired
	private AblcyProxyUserMapper proxyusermapperlcy;
	@Autowired
	private AbReveOrderMapper abReveOrderMapper;
	@Autowired
	private SubAgentsProxyMapper subagentmapper ;

	/**
	 * 代理收益 今日收益；累计收益；代理数； id
	 * 
	 * @param req
	 * @param response
	 * @return
	 */
	@Override
	public String queryIncomeProfile(HttpServletRequest req, HttpServletResponse response) {
		// 获取当前代理--统一用户中心的用户编号
		String ussn = req.getParameter("proxy_id");
		// 获取当前代理ID 根据根据统一用户中心的用户编号
		Integer id = deservices.selectidBytyid(ussn);
		if (id == null || "".equals(id)) {
			return "";
		} else {
			System.out.println("当前的代理ID是：===============" + id);
		}
		Float YesterdayProfit = 0F, Cumulative = 0F;
		String starttime = "", endtime = "";
		Integer SubAgentCount = 0; // 拥有代理数
		// 累计收益
		Cumulative = abReveOrderMapper.selectByFatheridOrAndTimes(starttime, endtime, id);
		// 总饼图显示列表
		List<BTListAgent> listAllLeft = new ArrayList<BTListAgent>();
		List<BTListAgent> listAllRight = new ArrayList<BTListAgent>();
		Float OwnProAll = 0f;// 自己的收益
		Float SubagentProAll = 0f;// 自己旗下所有代理的收益前十名总和
		Float OwnAndSubagentProAll = 0f;// 自己和代理的总收益
		Float QiTaProAll = 0f; // OwnAndSubagentPro - OwnPro - SubagentPro;其他的收益

//		List<BTListAgent> AgentProlistAll = abReveOrderService.selectAgentAllByProidOrAndTimes(starttime, endtime, id);
		List<BTListAgent> AgentProlistAll = abReveOrderMapper.selectAgentAllNoTop10ByProidOrAndTimes(starttime, endtime, id);
		System.out.println(AgentProlistAll.size());

		OwnProAll = abReveOrderMapper.selectOwnProByProidOrAndTimes(starttime, endtime, id);
		BTListAgent BTListAgentOwn = new BTListAgent("自己", OwnProAll, "#B5B5B5"); // 创建返回list的自己收益对象
		// 饼图内 加入自己的 其他的
		AgentProlistAll.add(AgentProlistAll.size(), BTListAgentOwn);
		for (int i = 0; i < AgentProlistAll.size(); i++) {
			SubagentProAll = SubagentProAll + AgentProlistAll.get(i).getValue();
		}
		OwnAndSubagentProAll = abReveOrderMapper.selectOwnAndSubAgentProByProidOrAndTimes(starttime, endtime, id);
		QiTaProAll = OwnAndSubagentProAll - OwnProAll - SubagentProAll;
		BTListAgent BTListAgentQT=null;
		if(AgentProlistAll.size()>10){
			BTListAgentQT = new BTListAgent("其他", QiTaProAll, "#808080"); // 创建返回list的其他收益对象
			AgentProlistAll.add(AgentProlistAll.size(), BTListAgentQT);
		}

		

		// 给前端传输的颜色组
		ArrayList<Object> colArr = new ArrayList<Object>();
		// 给前十位渲染颜色
		String[] colors = { "#E68191", "#DD9D85", "#8BCDA9", "#8B9ECD", "#E78080", "#84CEC6", "#E6B981", "#85B4CA",
				"#A98BCD", "#AECD8B" };
		//说明只有自己
		if(AgentProlistAll.size()==1){
			colArr.add(AgentProlistAll.size() - 1, "#B5B5B5");
		}
		if(AgentProlistAll.size()>=2 && AgentProlistAll.size()<11){
			for (int i = 0; i < AgentProlistAll.size() - 1; i++) {
				AgentProlistAll.get(i).setCol(colors[i]);
				colArr.add(i, colors[i]);
			}
			colArr.add(AgentProlistAll.size() - 1, "#B5B5B5");
		}
		if(AgentProlistAll.size()>=11){
			for (int i = 0; i < AgentProlistAll.size() - 2; i++) {
				AgentProlistAll.get(i).setCol(colors[i]);
				colArr.add(i, colors[i]);
			}
			colArr.add(AgentProlistAll.size() - 2, "#B5B5B5");
			colArr.add(AgentProlistAll.size() - 1, "#808080");
		}
		

		for (int i = 0; i < colArr.size(); i++) {
			System.out.println(colArr.get(i) + "     CCCCCCCCCCCCC6666666666666666666666");
			System.out.println(AgentProlistAll.get(i).getCol() + "     MMMMMMMMMMMMMMMM9999999999" + "/ln");
		}
		for (int i = 0; i < AgentProlistAll.size(); i++) {
			if (AgentProlistAll.get(i).getName() != null) {
				System.out.println(AgentProlistAll.get(i).getName());
				AgentProlistAll.get(i).setDetailName(AgentProlistAll.get(i).getName());
				if (AgentProlistAll.get(i).getName().length() > 7) {
					AgentProlistAll.get(i).setName(AgentProlistAll.get(i).getName().substring(0, 6) + "..");
				}
			}
			if (i >= 0 && i < 6) {
				listAllLeft.add(i, AgentProlistAll.get(i));
			}
			if (i > 5 && i < AgentProlistAll.size()) {
				listAllRight.add(i - 6, AgentProlistAll.get(i));
			}
		}
		// 获取时间方法
		String format = "yyyy-MM-dd";// 格式
		endtime = DateUtil.getCurrentDateTime(format);// 当天时间
		starttime = DateUtil.getCurrentDatePreDays(endtime, format, 1);
		// 昨日收益
		YesterdayProfit = abReveOrderMapper.selectByFatheridOrAndTimes(starttime, endtime, id);
		// 代理数
		SubAgentCount = proxyusermapperlcy.selectuserCount(id);
		System.out.println("昨日的收益是 ：" + YesterdayProfit + " 累计的收益是： " + Cumulative + "代理数是:" + SubAgentCount);
		Map<String, Object> mapsy = new HashMap<>();
		mapsy.put("message", "ok");
		mapsy.put("code", 200);
		mapsy.put("success", "true");
		mapsy.put("todayEarning", YesterdayProfit);
		mapsy.put("cumulativeRevenue", Cumulative);
		mapsy.put("numberAgent", SubAgentCount);
		mapsy.put("guanggaoMXjosnt", AgentProlistAll);
		mapsy.put("topleftgg", listAllLeft);
		mapsy.put("toprightgg", listAllRight);
		mapsy.put("OwnAndSubagentProAll", OwnAndSubagentProAll);
		mapsy.put("TopcolArr", colArr);
		return JSONSerializer.toJSON(mapsy).toString();
	}

	/**
	 * 查看当前代理有多少下级代理
	 * @param req
	 * @param response
	 */
	@Override
	public Integer SerchAgentNum(HttpServletRequest req, HttpServletResponse response) {
		// 获取当前代理--统一用户中心的用户编号
		String ussn = req.getParameter("proxy_id");
		// 获取当前代理ID 根据根据统一用户中心的用户编号
		Integer id = deservices.selectidBytyid(ussn);
		if (id == null || "".equals(id)) {
			System.out.println("id空了！！！！！！！！！！！！" + ussn);
			return 0;
		} else {
			System.out.println("当前的代理ID是：===============" + id);
		}
		//根据父级id得到user个数
		Integer num = proxyusermapperlcy.selectuserCount(id);
		return num;
	}
	
	/**
	 * 筛选条件折线图/饼图 默认昨日 返回数组日期 数组金额 字符串lab
	 * @param req
	 * @param response
	 */
	@Override
	public String queryIncomeLineDiagrams(HttpServletRequest req, HttpServletResponse response) {
		Map<String,Object> mapsy = new HashMap<>();
		String sitype = req.getParameter("isjudgeRZY"); // 获取日周月的判断格式
		Integer cd = Integer.valueOf(sitype);
		String parmtype = req.getParameter("restype");// 获取折线图分段方式
		String proxy_id = req.getParameter("proxy_id");// 获取当前代理--统一用户中心的用户编号
		Integer id = deservices.selectidBytyid(proxy_id);// 获取当前代理ID
		if (id == null || "".equals(id)) {
			return "";
		} else {
			System.out.println("当前的代理ID是：===============" + id);
		}
		// 定义一个时间段空值 待用
		String Start_date = "";
		String End_date = "";
		String format = "yyyy-MM-dd";// 格式
		String dateStr = req.getParameter("dateStr");// 获取时间 如果为空返回昨日
		if (cd == 1 || cd == 7 || cd == 30) {
			System.out.println("返回");
			End_date = DateUtil.getCurrentDateTime(format);// 当天时间
			Start_date = DateUtil.getCurrentDatePreDays(End_date, format, cd); // 昨天
																				// 7天前
																				// 或者30天前的时间
		}
		if (cd == 50) {
			System.out.println("返回自定义时间");
			if (sitype == null || sitype == "" || dateStr.length() > 0) {
				String[] timearr = dateStr.split(",");
				// 防止错误发生 例如用户撤销了时间搜索
				if (timearr.length == 2) {
					Start_date = timearr[0];
					End_date = timearr[1];
					if(Start_date.equals(End_date)){
						Integer apend = Integer.valueOf(End_date.substring(8))+1;
						End_date =End_date.substring(0, 8)+apend.toString();
						System.out.println(End_date);
					}
				} else {
					End_date = DateUtil.getCurrentDateTime(format);// 当天时间
					Start_date = DateUtil.getCurrentDatePreDays(End_date, format, 1);
				}
			}
		}
		// 区间查询 + id
		// 代理饼图显示：==========================================================
		List<BTListAgent> SubAgentListAll = abReveOrderMapper.selectAgentAllTop10ByProidOrAndTimes(Start_date, End_date,
				id);
		List<BTListAgent> SubAgentListLeft = new ArrayList<BTListAgent>(); // 代理饼图左列表
		List<BTListAgent> SubAgentListRight = new ArrayList<BTListAgent>();// 代理饼图右列表
		// 下级代理饼图显示列表
		Float OwnProAll = 0f;// 自己的收益
		Float SubagentProAll = 0f;// 自己旗下所有代理的收益前十名总和
		Float OwnAndSubagentProAll = 0f;// 自己和代理的总收益
		Float QiTaProAll = 0f; // OwnAndSubagentPro - OwnPro - SubagentPro;其他的收益
		OwnProAll = abReveOrderMapper.selectOwnProByProidOrAndTimes(Start_date, End_date, id);
		BTListAgent BTListAgentOwn = new BTListAgent("自己", OwnProAll, "#B5B5B5"); // 创建返回list的自己收益对象
		for (int i = 0; i < SubAgentListAll.size(); i++) {
			SubagentProAll = SubagentProAll + SubAgentListAll.get(i).getValue();
		}
		OwnAndSubagentProAll = abReveOrderMapper.selectOwnAndSubAgentProByProidOrAndTimes(Start_date, End_date, id);
		QiTaProAll = OwnAndSubagentProAll - OwnProAll - SubagentProAll;
		BTListAgent BTListAgentQT = new BTListAgent("其他", QiTaProAll, "#808080"); // 创建返回list的其他收益对象
		SubAgentListAll.add(SubAgentListAll.size(), BTListAgentOwn);
		SubAgentListAll.add(SubAgentListAll.size(), BTListAgentQT);
		System.out.println("自己和代理的收益" + OwnAndSubagentProAll + "前十和自己的收益" + SubagentProAll + "  " + OwnProAll + "其他的收益"
				+ QiTaProAll);
		// 给前端传输的颜色组
		ArrayList<Object> colArr = new ArrayList<>();
		// 给前十位渲染颜色
		String[] colors = { "#E68191", "#DD9D85", "#8BCDA9", "#8B9ECD", "#E78080", "#84CEC6", "#E6B981", "#85B4CA",
				"#A98BCD", "#AECD8B" };
		for (int i = 0; i < SubAgentListAll.size() - 2; i++) {
			SubAgentListAll.get(i).setCol(colors[i]);
			colArr.add(i, colors[i]);
		}
		colArr.add(SubAgentListAll.size() - 2, "#B5B5B5");
		colArr.add(SubAgentListAll.size() - 1, "#808080");
		for (int i = 0; i < colArr.size(); i++) {
			System.out.println(colArr.get(i) + "CCCCCCCCCCCCC6666666666666666666666");
		}
		for (int i = 0; i < SubAgentListAll.size(); i++) {
			if(SubAgentListAll.get(i).getName() != null){
				SubAgentListAll.get(i).setDetailName(SubAgentListAll.get(i).getName());
				if(SubAgentListAll.get(i).getName().length() > 7){
					SubAgentListAll.get(i).setName(SubAgentListAll.get(i).getName().substring(0, 6)+"..");
				}
			}
			if (i >= 0 && i < 6) {
				SubAgentListLeft.add(i, SubAgentListAll.get(i));
			}
			if (i > 5 && i < SubAgentListAll.size()) {
				SubAgentListRight.add(i - 6, SubAgentListAll.get(i));
			}
		}
		// 区间查询 + id
		// 广告饼图显示：==========================================================
		List<BTListIncome> IncomeProListAll = subagentmapper.selectIncomeProAllByIdAndTimes(Start_date, End_date, id);
		List<BTListIncome> IncomeProListLeft = new ArrayList<BTListIncome>();
		List<BTListIncome> IncomeProListRight = new ArrayList<BTListIncome>();
		Float IncometimesProAll = 0f; // 时间段内所有广告的收益
		Float IncometimesProOorT = 0f; // 10个广告的收益和
		Float QTIncomePro = 0f; // 其他广告收益
		IncometimesProAll = subagentmapper.selectTimesAllProIncomeByIdAndTimes(Start_date, End_date, id);
		System.out.println(IncomeProListAll.size() + "广告的集合长度&&&&&&&&&&&&&&&&" + IncometimesProAll + "  时间段内所有广告的收益");
		for (int j = 0; j < IncomeProListAll.size(); j++) {
			IncometimesProOorT = IncometimesProOorT + IncomeProListAll.get(j).getValue();
		}
		QTIncomePro = IncometimesProAll - IncometimesProOorT;
		BTListIncome QTIncomeProObjct = new BTListIncome("其他", QTIncomePro, "#808080");
		IncomeProListAll.add(IncomeProListAll.size(), QTIncomeProObjct);
		// 广告颜色组
		ArrayList<Object> IncomeColArr = new ArrayList<>();
		// 渲染颜色数组
		String[] IncomeColors = { "#E68191", "#DD9D85", "#8BCDA9", "#8B9ECD", "#E78080", "#84CEC6", "#E6B981",
				"#85B4CA", "#A98BCD", "#AECD8B" };
		for (int k = 0; k < IncomeProListAll.size() - 1; k++) {
			IncomeProListAll.get(k).setCol(IncomeColors[k]);
			IncomeColArr.add(k, IncomeColors[k]);
		}
		IncomeColArr.add(IncomeProListAll.size() - 1, "#808080");
		// 拆分两个列表
		for (int i = 0; i < IncomeProListAll.size(); i++) {
			
			if( IncomeProListAll.get(i).getName() != null){
				IncomeProListAll.get(i).setDetailName(IncomeProListAll.get(i).getName());
				if(IncomeProListAll.get(i).getName().length() > 6){
					IncomeProListAll.get(i).setName(IncomeProListAll.get(i).getName().substring(0, 6)+"..");
				}
			}
			if (i >= 0 && i < 6) {
				IncomeProListLeft.add(i, IncomeProListAll.get(i));
			}
			if (i > 5 && i < IncomeProListAll.size()) {
				IncomeProListRight.add(i - 6, IncomeProListAll.get(i));
			}
		}
		// 区间查询 折线图显示
		// ***********************************************************************************
		List<DayProxyAll> DayProList = new ArrayList<DayProxyAll>();
		ArrayList<Object> manyArr = new ArrayList<>();// 创建金额数据
		ArrayList<Object> dateArr = new ArrayList<>();// 时间数据
		// 最后返回的集合
		List<DayProxyAll> resultlist = new ArrayList<>();
		String resType = "";
		if ("2".equals(parmtype)) {
			resType = "%Y%u";

		} else if ("3".equals(parmtype)) {
			resType = "%Y%m";

		} else {
			resType = "%Y%m%d";
		}
		// resType = "%Y-%m-%d";
		//按日查询
		if("1".equals(parmtype)){
			DayProList = abReveOrderMapper.selectDayProxyByTimesAndId(Start_date, End_date, id, resType);
			// 格式化方法
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// 时间格式的集合
			List<Date> listdate = null;
			try {
				listdate = DateUtil.findDates(sdf.parse(Start_date), sdf.parse(End_date));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < listdate.size(); i++) {
				DayProxyAll dayro = new DayProxyAll();
				dayro.setOrderDate(sdf.format(listdate.get(i)));
				dayro.setEarningsAmount(0f);
				resultlist.add(dayro);
			}	
			if(cd == 50){
				for (int i = 0; i < resultlist.size(); i++) {
					for (int j = 0; j < DayProList.size(); j++) {
						System.out.println(DayProList.get(j).getOrderDate());
						if (resultlist.get(i).getOrderDate().equals(DayProList.get(j).getOrderDate())) {
							System.out.println(DayProList.get(j).getOrderDate());
							resultlist.get(i).setEarningsAmount(DayProList.get(j).getEarningsAmount());
						}
					}
				}
				for (int i = 0; i < resultlist.size(); i++) {
					manyArr.add(resultlist.get(i).getEarningsAmount());
					dateArr.add(resultlist.get(i).getOrderDate());
				}
			}else{
				for (int i = 0; i < resultlist.size()-1; i++) {
					for (int j = 0; j < DayProList.size(); j++) {
						System.out.println(DayProList.get(j).getOrderDate());
						if (resultlist.get(i).getOrderDate().equals(DayProList.get(j).getOrderDate())) {
							System.out.println(DayProList.get(j).getOrderDate());
							resultlist.get(i).setEarningsAmount(DayProList.get(j).getEarningsAmount());
						}
					}
				}
				for (int i = 0; i < resultlist.size()-1; i++) {
					manyArr.add(resultlist.get(i).getEarningsAmount());
					dateArr.add(resultlist.get(i).getOrderDate());
				}
			}
		}else{
			//按周查询
			if("2".equals(parmtype)){
				//返回符合标准周的时间段
				List<String> list = DateWeekOfMonth.getDateOfWeek(Start_date, End_date);
				if(list.size() !=0){
					for(int i=0;i<list.size();i++){
						List<DayProxyAll> NewDayProList = new ArrayList<DayProxyAll>();
						DayProxyAll da = new DayProxyAll();
						//根据一周的时间段查出一周的数
						NewDayProList = abReveOrderMapper.selectDayProxyByTimesAndId(list.get(i).split("~")[0], list.get(i).split("~")[1], id, resType);
						//把一周的数据全部合成一条数据作为前台输出
						float earningsAmount =0f;
						for(int m=0;m<NewDayProList.size();m++){
							earningsAmount +=NewDayProList.get(m).getEarningsAmount();
						}
						da.setOrderDate(list.get(i));
						da.setEarningsAmount(earningsAmount);
						DayProList.add(da);
					}
				}
			}else{
				//返回符合标准月的时间段[2018-09,2018-10]
				List<String> list = null;
				try {
					list = DateWeekOfMonth.getMonthBetween(Start_date, End_date);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(list.size() !=0){
					for(int i=0;i<list.size();i++){
						List<DayProxyAll> NewDayProList = new ArrayList<DayProxyAll>();
						DayProxyAll da = new DayProxyAll();
						//查分月
						String startTime = list.get(i)+"-01";
						String endTime = list.get(i)+"-"+DateWeekOfMonth.getLastDayOfMonth(list.get(i)+"-01");
						//根据月的时间段查出一个月的所有的数据
						NewDayProList = abReveOrderMapper.selectDayProxyByTimesAndId(startTime, endTime, id, resType);
						//把一周的数据全部合成一条数据作为前台输出
						float earningsAmount =0f;
						for(int m=0;m<NewDayProList.size();m++){
							earningsAmount +=NewDayProList.get(i).getEarningsAmount();
						}
						da.setOrderDate(startTime+"~"+endTime);
						da.setEarningsAmount(earningsAmount);
						DayProList.add(da);
					}
				}
			}
			for(int i=0;i<DayProList.size();i++){
				manyArr.add(DayProList.get(i).getEarningsAmount());
				dateArr.add(DayProList.get(i).getOrderDate());
			}
		}
		System.out.println("折线图的节点list长度是====" + DayProList.size());
		for(int i=0; i<DayProList.size();i++){
			System.out.println(DayProList.get(i).getOrderDate());
			System.out.println(DayProList.get(i).getEarningsAmount());
		}
		System.out.println(manyArr);
		System.out.println(dateArr);
		mapsy.put("manyArr", manyArr);
		mapsy.put("dateArr", dateArr);
		mapsy.put("message", "ok");
		mapsy.put("code", 200);
		mapsy.put("success", "true");
		mapsy.put("RguanggaoMXjosnt", SubAgentListAll);
		mapsy.put("rightggo", SubAgentListLeft);
		mapsy.put("rightggt", SubAgentListRight);
		mapsy.put("OwnAndSubagentProAllRi", OwnAndSubagentProAll);
		mapsy.put("colArr", colArr);
		mapsy.put("IncomeProListAll", IncomeProListAll);
		mapsy.put("IncomeProListLeft", IncomeProListLeft);
		mapsy.put("IncomeProListRight", IncomeProListRight);
		mapsy.put("OwnAndSubagentProAllLe", IncometimesProAll);
		mapsy.put("IncomeColArr", IncomeColArr);
		return JSONSerializer.toJSON(mapsy).toString();
	}
	
	/**
	 * 根据登录人判断当前代理级别和佣金管理中的代理级别是否相同
	 * @param userId
	 * @return
	 */
	@Override
	public String compareAgentLevel(String userId) {
		String puserAgentLevel=abProxyUserMapper.compareAgentLevel(userId);
		String abBillAgentLevel=iAbBillingCycleService.getAgentNumber();
		System.out.println(puserAgentLevel+"-------"+abBillAgentLevel+"-------"+puserAgentLevel.equals(abBillAgentLevel));
		//判断是否相同
		if(puserAgentLevel.equals(abBillAgentLevel)){
			return "0";
		}else{
			return "1";
		}
	}
}
