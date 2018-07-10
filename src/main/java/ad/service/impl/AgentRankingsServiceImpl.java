package ad.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ad.bean.AS_.AgentBean.AgentRankings;
import ad.service.IAgentRankingsService;
import ad.service.AS_.DeService.Deservice;
import ad.util.DateUtil;

import net.sf.json.JSONSerializer;

@Service
public class AgentRankingsServiceImpl implements IAgentRankingsService {

	@Autowired
	private Deservice deservices;

	/**
	 * 代理收益top10 数据来源
	 * @param req
	 * @param response
	 * @return
	 */
	@Override
	public String queryIncomeRankings(HttpServletRequest req, HttpServletResponse response) {
		// 判断是显示多少天的 默认为昨天1
		String sitype = req.getParameter("isjudgeRZY");
		// System.out.println(sitype);
		// 如果是自定义时间段查询 获取参数
		String times = req.getParameter("dateStr");
		// 获取当前代理--统一用户中心的用户编号
		String ussn = req.getParameter("usID");
		// 获取当前代理ID 根据根据统一用户中心的用户编号
		Integer id = deservices.selectidBytyid(ussn);
		if (id == null || "".equals(id)) {
			return "";
		} else {
			// System.out.println("当前的代理ID是：===============" + id);
		}
		// 前十名的集合
		List<AgentRankings> topstenlist = new ArrayList<AgentRankings>();
		// 第一名至第三名的名字空间
		AgentRankings Agenttop1obj = new AgentRankings();
		AgentRankings Agenttop2obj = new AgentRankings();
		AgentRankings Agenttop3obj = new AgentRankings();

		// 获取时间方法
		String format = "yyyy-MM-dd";// 格式
		String End_date = "";
		String Start_date = "";
		// 判断时间是否为快捷查询1 7 30 如果都不是 那么拆分时间
		if (sitype != null && sitype.length() > 0) {
			Integer cd = Integer.valueOf(sitype);
			End_date = DateUtil.getCurrentDateTime(format);// 当天时间
			Start_date = DateUtil.getCurrentDatePreDays(End_date, format, cd); // 昨天
																				// 7天前
																				// 或者30天前的时间
		}

		if (sitype == null || sitype == "" || times.length() > 0) {
			String[] timearr = times.split(",");
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

		// System.out.println(
		// "日期时间段是：" + Start_date + " &&&&&&&&&&" + " ---------------- ：" +
		// End_date + " &&&&&&&&&");

		// 结果集
		Map remap = new HashMap();

		topstenlist = deservices.selectAgentTop10(Start_date, End_date, id);

		if (topstenlist.size() > 0) {
			Agenttop1obj = topstenlist.get(0);
		}
		if (topstenlist.size() > 1) {
			Agenttop2obj = topstenlist.get(1);
		}
		if (topstenlist.size() > 2) {
			Agenttop3obj = topstenlist.get(2);
		}

		remap.put("list", topstenlist);
		remap.put("top1", Agenttop1obj);
		remap.put("top2", Agenttop2obj);
		remap.put("top3", Agenttop3obj);

		remap.put("message", "ok");
		remap.put("code", "200");
		remap.put("success", "true");

		return JSONSerializer.toJSON(remap).toString();
	}
}
