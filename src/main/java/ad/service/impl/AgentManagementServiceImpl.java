package ad.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ad.bean.AS_.AgentBean.AgentsDo;
import ad.mapper.AblcyProxyUserMapper;
import ad.service.IAgentManagementService;
import ad.service.LCYIAbProxyUserService;
import ad.service.AS_.DeService.Deservice;
import ad.util.Excel2018;

import net.sf.json.JSONSerializer;

@Service
public class AgentManagementServiceImpl implements IAgentManagementService {

	@Autowired
	private Deservice deservices;
	@Autowired
	private LCYIAbProxyUserService abProxyUserServiceLCY;
	@Autowired
	private AblcyProxyUserMapper proxyusermapperlcy;

	/**
	 * 代理详情
	 * 
	 * @param req
	 * @param response
	 * @return
	 */
	@Override
	public String queryAgents(HttpServletRequest req, HttpServletResponse response, AgentsDo AgentsDo) {
		// 获取当前代理--统一用户中心的用户编号
		String ussn = req.getParameter("proxy_id");
		// 获取当前代理ID 根据根据统一用户中心的用户编号
		Integer id = deservices.selectidBytyid(ussn);
		if (id == null || "".equals(id)) {
			return "";
		} else {
			// System.out.println("当前的代理ID是：===============" + id);
		}
		Map m = new HashMap();
		List<AgentsDo> prolist = new ArrayList<AgentsDo>();
		int page = AgentsDo.getPage();
		AgentsDo.setPage((page - 1) * 10);
		AgentsDo.setFatherId(id);
		prolist = proxyusermapperlcy.queryProxyList(AgentsDo);
		try {
			m.put("totalNumber", prolist == null ? 0 : prolist.get(0));
			m.put("prolist", prolist);
		} catch (Exception e) {
			m.put("totalNumber", 0);
			m.put("prolist", 0);
		}
		return JSONSerializer.toJSON(m).toString();
	}

	/**
	 * 代理导出
	 * 
	 * @param req
	 * @param response
	 * @return
	 */
	@Override
	public void ExportExcel(HttpServletRequest req, HttpServletResponse response, AgentsDo AgentsDo) {
		System.out.println("进入下载");
		// 获取当前代理--统一用户中心的用户编号
		String ussn = req.getParameter("proxy_id");
		// 获取当前代理ID 根据根据统一用户中心的用户编号
		Integer id = deservices.selectidBytyid(ussn);
		if (id == null || "".equals(id)) {
			// System.out.println("无");
		} else {
			// System.out.println("当前的代理ID是：===============" + id);
		}
		// 通过ID 所有下级代理
		// List<AgentsDo> SubAgents = abProxyUserServiceLCY.subAgentList(id);
		List<AgentsDo> SubAgents = new ArrayList<AgentsDo>();
		int page = AgentsDo.getPage();
		AgentsDo.setPage((page - 1) * 10);
		AgentsDo.setFatherId(id);
		SubAgents = proxyusermapperlcy.exportExcelQueryProxyList(AgentsDo);
		Map<String, Object> maps = new HashMap<>();
		String title = "代理管理导出明细";
		List<String> titleList = new ArrayList();
		List<String> columnList = new ArrayList();
		List<Map> dataList = new ArrayList();
		titleList.add("ID");
		titleList.add("用户名称");
		titleList.add("联系人姓名");
		titleList.add("联系人电话");
		titleList.add("拥有代理数");
		titleList.add("分佣比例");
		titleList.add("累计收益金额");
		columnList.add("id");
		columnList.add("proxyName");
		columnList.add("proxyUserName");
		columnList.add("proxyPhone");
		columnList.add("offlineNumber");
		columnList.add("distributionRatio");
		columnList.add("earningsAmount");
		for (int i = 0; i < SubAgents.size(); i++) {
			Map m = new HashMap();
			m.put("id", SubAgents.get(i).getId());
			m.put("proxyName", SubAgents.get(i).getProxyName());
			m.put("proxyUserName", SubAgents.get(i).getProxyUserName());
			m.put("proxyPhone", SubAgents.get(i).getProxyPhone());
			m.put("offlineNumber", SubAgents.get(i).getOfflineNumber());
			m.put("distributionRatio", SubAgents.get(i).getDistributionRatio());
			m.put("earningsAmount", SubAgents.get(i).getEarningsAmount());
			dataList.add(m);
		}
		Excel2018 excel = new Excel2018();
		try {
			excel.openWorkbook(title, titleList.size() - 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		excel.addTable(titleList, columnList, dataList);
		excel.lineNum += 2;
		// 文件下载
		excel.downLoad(response, "代理管理");
	}
}
