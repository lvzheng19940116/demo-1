package ad.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ISubAgentService {

	String AgentProxyDetails(HttpServletRequest req, HttpServletResponse response);
}
