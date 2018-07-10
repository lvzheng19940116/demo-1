package ad.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ad.bean.AS_.AgentBean.AgentsDo;

public interface IAdminService {

	String queryAgents(HttpServletRequest req, HttpServletResponse response, AgentsDo AgentsDo);
}
