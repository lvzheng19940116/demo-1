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

import ad.bean.AS_.pageBean;
import ad.bean.AS_.AgentBean.BTListAgent;
import ad.bean.AS_.AgentBean.BTListIncome;
import ad.bean.AS_.AgentBean.DayProxyAll;
import ad.bean.AS_.AgentBean.SubAgentProxyDe;
import ad.mapper.AbReveOrderMapper;
import ad.mapper.AS_.SubAgentsProxyMapper;
import ad.service.IAbReveOrderService;
import ad.service.ISubAgentService;
import ad.service.AS_.DeService.SubAgentProxyService;
import ad.util.DateUtil;
import ad.util.DateWeekOfMonth;
import ad.util.Page;

import net.sf.json.JSONSerializer;

@Service
public class SubAgentServiceImpl implements ISubAgentService {
	
	@Autowired
	private SubAgentProxyService subagentpros;

	@Autowired
	private IAbReveOrderService abReveOrderService;

	@Autowired
	private SubAgentProxyService subAgentProxyService;
	@Autowired
	AbReveOrderMapper abReveOrderMapper;
	@Autowired
	private SubAgentsProxyMapper subagentmapper ;

	/**
	 * 下线代理收益明细
	 * @param req
	 * @param response
	 * @param abif
	 * @return
	 * @throws Exception 
	 */
	@Override
	public String AgentProxyDetails(HttpServletRequest req, HttpServletResponse response) {
		Map mapsy = new HashMap();
		String dateStr = req.getParameter("dateStr");
		String crtpg = req.getParameter("page");
		Integer id = Integer.valueOf(req.getParameter("proxy_id"));
		String parmtype = req.getParameter("restype");// 获取折线图分段方式
		if (id == null || "".equals(id)) {
			return "";
		} else {
			System.out.println("当前的代理ID是：===============" + id);
		}
		String sitype = req.getParameter("isjudgeRZY");
		Integer cd = Integer.valueOf(sitype);
		Integer Limit = Integer.valueOf(req.getParameter("Limit"));
		Integer currentPage = Integer.valueOf(crtpg);
		System.out.println(dateStr);
		System.out.println(sitype);
		System.out.println(id);
		System.out.println(Limit + "-----" + crtpg);
		if (currentPage == null) {
			currentPage = 1;
		}
		List<SubAgentProxyDe> subagentprodelist = new ArrayList<>();
		pageBean Inpb = new pageBean();
		// 获取时间方法
		String format = "yyyy-MM-dd";
		String curDate = DateUtil.getCurrentDateTime(format);// 当天
		String End_date = "";
		String Start_date = "";
		// 判断时间是否为快捷查询1 7 30 如果都不是 那么拆分时间
		if (sitype != null && sitype.length() > 0) {
			End_date = DateUtil.getCurrentDateTime(format);// 当天时间
			Start_date = DateUtil.getCurrentDatePreDays(End_date, format, cd); // 昨天
																				// 7天前
																				// 或者30天前的时间
		}
		if (sitype == null || sitype == "" || dateStr.length() > 0) {
			String[] timearr = dateStr.split(",");
			// 防止错误发生 例如用户撤销了时间搜索
			if (timearr.length == 2) {
				Start_date = timearr[0];
				End_date = timearr[1];
				if (Start_date.equals(End_date)) {
					Integer apend = Integer.valueOf(End_date.substring(8)) + 1;
					End_date = End_date.substring(0, 8) + apend.toString();
					System.out.println(End_date);
				}
			} else {
				End_date = DateUtil.getCurrentDateTime(format);// 当天时间
				Start_date = DateUtil.getCurrentDatePreDays(End_date, format, 1);
			}
		}
		System.out.println("此处开始查询，开始日期--" + Start_date + "--结束日期--" + End_date);
		/**
		 * 折线图展示
		 */
		List<DayProxyAll> DayProList = new ArrayList<DayProxyAll>();
		ArrayList manyArr = new ArrayList();// 创建金额数据
		ArrayList dateArr = new ArrayList();// 时间数据
		// 最后返回的集合
		List<DayProxyAll> resultlist = new ArrayList();
		// 按日查询
		if ("1".equals(parmtype)) {
			DayProList = abReveOrderMapper.selectDayProxyByTimesAndId(Start_date, End_date, id, "");
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
			if (cd == 50) {
				for (int i = 0; i < resultlist.size(); i++) {
					for (int j = 0; j < DayProList.size(); j++) {

						System.out.println(DayProList.get(j).getOrderDate());
						if (resultlist.get(i).getOrderDate().equals(DayProList.get(j).getOrderDate())) {
							System.out.println(DayProList.get(j).getOrderDate());
							System.out.println("----------------------");

							resultlist.get(i).setEarningsAmount(DayProList.get(j).getEarningsAmount());
						}
					}
				}
				for (int i = 0; i < resultlist.size(); i++) {
					manyArr.add(resultlist.get(i).getEarningsAmount());
					dateArr.add(resultlist.get(i).getOrderDate());
				}
			} else {
				for (int i = 0; i < resultlist.size() - 1; i++) {
					for (int j = 0; j < DayProList.size(); j++) {
						System.out.println(DayProList.get(j).getOrderDate());
						if (resultlist.get(i).getOrderDate().equals(DayProList.get(j).getOrderDate())) {
							System.out.println(DayProList.get(j).getOrderDate());
							System.out.println("----------------------");
							resultlist.get(i).setEarningsAmount(DayProList.get(j).getEarningsAmount());
						}
					}
				}
				for (int i = 0; i < resultlist.size() - 1; i++) {
					manyArr.add(resultlist.get(i).getEarningsAmount());
					dateArr.add(resultlist.get(i).getOrderDate());
				}
			}
		} else {
			// 按周查询
			if ("2".equals(parmtype)) {
				// 返回符合标准周的时间段
				List<String> list = DateWeekOfMonth.getDateOfWeek(Start_date, End_date);
				if (list.size() != 0) {
					for (int i = 0; i < list.size(); i++) {
						List<DayProxyAll> NewDayProList = new ArrayList<DayProxyAll>();
						DayProxyAll da = new DayProxyAll();
						// 根据一周的时间段查出一周的数
						NewDayProList = abReveOrderMapper.selectDayProxyByTimesAndId(list.get(i).split("~")[0],
								list.get(i).split("~")[1], id, "");
						// 把一周的数据全部合成一条数据作为前台输出
						float earningsAmount = 0f;
						for (int m = 0; m < NewDayProList.size(); m++) {
							earningsAmount += NewDayProList.get(m).getEarningsAmount();
						}
						da.setOrderDate(list.get(i));
						da.setEarningsAmount(earningsAmount);
						DayProList.add(da);
					}
				}
			} else {
				// 返回符合标准月的时间段[2018-09,2018-10]
				List<String> list = null;
				try {
					list = DateWeekOfMonth.getMonthBetween(Start_date, End_date);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (list.size() != 0) {
					for (int i = 0; i < list.size(); i++) {
						List<DayProxyAll> NewDayProList = new ArrayList<DayProxyAll>();
						DayProxyAll da = new DayProxyAll();
						// 查分月
						String startTime = list.get(i) + "-01";
						String endTime = list.get(i) + "-" + DateWeekOfMonth.getLastDayOfMonth(list.get(i) + "-01");
						// 根据月的时间段查出一个月的所有的数据
						NewDayProList = abReveOrderMapper.selectDayProxyByTimesAndId(startTime, endTime, id, "");
						// 把一周的数据全部合成一条数据作为前台输出
						float earningsAmount = 0f;
						for (int m = 0; m < NewDayProList.size(); m++) {
							earningsAmount += NewDayProList.get(i).getEarningsAmount();
						}
						da.setOrderDate(startTime + "~" + endTime);
						da.setEarningsAmount(earningsAmount);
						DayProList.add(da);
					}
				}
			}
			for (int i = 0; i < DayProList.size(); i++) {
				manyArr.add(DayProList.get(i).getEarningsAmount());
				dateArr.add(DayProList.get(i).getOrderDate());
			}
		}
		System.out.println("折线图的节点list长度是====" + DayProList.size());
		System.out.println("--------------------------------------");
		System.out.println(manyArr);
		System.out.println(dateArr);
		mapsy.put("manyArr", manyArr);
		mapsy.put("dateArr", dateArr);
		/**
		 * 饼图展示 -- 广告收益构成
		 */
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
		ArrayList IncomeColArr = new ArrayList();
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
			if (IncomeProListAll.get(i).getName() != null) {
				IncomeProListAll.get(i).setDetailName(IncomeProListAll.get(i).getName());
				if (IncomeProListAll.get(i).getName().length() > 7) {
					IncomeProListAll.get(i).setName(IncomeProListAll.get(i).getName().substring(0, 6) + "..");
				}
			}
			if (i >= 0 && i < 6) {
				IncomeProListLeft.add(i, IncomeProListAll.get(i));
			}
			if (i > 5 && i < IncomeProListAll.size()) {
				IncomeProListRight.add(i - 6, IncomeProListAll.get(i));
			}
		}
		/**
		 * 饼图展示 -- 收益渠道构成
		 */
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
		// 给前端传输的颜色组
		ArrayList colArr = new ArrayList();
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
			System.out.println(colArr.get(i) + "pppppppppppppppppppppppppppppppppppppppppp");
		}
		for (int i = 0; i < SubAgentListAll.size(); i++) {
			if (SubAgentListAll.get(i).getName() != null) {
				SubAgentListAll.get(i).setDetailName(SubAgentListAll.get(i).getName());
				if (SubAgentListAll.get(i).getName().length() > 7) {
					SubAgentListAll.get(i).setName(SubAgentListAll.get(i).getName().substring(0, 6) + "..");
				}
			}
			if (i >= 0 && i < 6) {
				SubAgentListLeft.add(i, SubAgentListAll.get(i));
			}
			if (i > 5 && i < SubAgentListAll.size()) {
				SubAgentListRight.add(i - 6, SubAgentListAll.get(i));
			}
		}

		System.out.println("日期时间段是：" + Start_date + "   &&&&&&&&&&" + "  ----------------  ：" + End_date
				+ "   &&&&&&&&&" + OwnAndSubagentProAll + "自己和代理的总收益饼图");

		/**
		 * 下线代理收益集合
		 */
		Page p = subagentpros.selectsubagentprode(Limit, currentPage, id, Start_date, End_date);
		Inpb.setAllRow(p.getAllRow());
		Inpb.setCurrentPage(p.getCurrentPage());
		Inpb.setPagesizi(p.getPageSize());
		Inpb.setTotalPage(p.getTotalPage());
		subagentprodelist = p.getList();

		System.out.println(subagentprodelist.size() + "   99999999999999999999999");
		for (int i = 0; i < subagentprodelist.size(); i++) {
			subagentprodelist.get(i).setCreatTime(
					new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(subagentprodelist.get(i).getCreateTime()));
		}

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

		mapsy.put("subagentprodelist", subagentprodelist); // 下线代理收益集合
		mapsy.put("pagesbe", Inpb);

		return JSONSerializer.toJSON(mapsy).toString();
	}
}
