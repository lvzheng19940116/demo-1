package ad.controller.AS_.AgentController;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ad.bean.AS_.pageBean;
import ad.bean.AS_.AgentBean.BTListAgent;
import ad.bean.AS_.AgentBean.BTListIncome;
import ad.bean.AS_.AgentBean.DayProxyAll;
import ad.bean.AS_.AgentBean.SubAgentProxyDe;
import ad.service.IAbReveOrderService;
import ad.service.ISubAgentService;
import ad.service.AS_.DeService.SubAgentProxyService;
import ad.util.DateUtil;
import ad.util.DateWeekOfMonth;
import ad.util.Page;

import net.sf.json.JSONSerializer;

/**
 * 下线代理详情页
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/subAgents")
public class SubAgentController {

	@Autowired
	private ISubAgentService iSubAgentService;

	/**
	 * 下线代理收益明细
	 * 
	 * @param req
	 * @param response
	 * @param abif
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/AgentProxyDetails", produces = { "application/json; charset=utf-8" })
	public String AgentProxyDetails(HttpServletRequest req, HttpServletResponse response) throws Exception {
		return iSubAgentService.AgentProxyDetails(req, response);
	}

}
