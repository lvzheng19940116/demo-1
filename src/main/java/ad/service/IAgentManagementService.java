package ad.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ad.bean.AS_.AgentBean.AgentsDo;

/**
 * 
 * @author cqp
 *
 */
public interface IAgentManagementService {

	String queryAgents(HttpServletRequest req, HttpServletResponse response, AgentsDo AgentsDo);
	void ExportExcel(HttpServletRequest req, HttpServletResponse response,AgentsDo AgentsDo);
}
