package ad.service;

import javax.servlet.http.HttpServletRequest;

import ad.bean.AbProxyUser;

/**
 * 
 * @author cqp
 *
 */
public interface IAgentSUDService {

	String AddProxyInfo(AbProxyUser abProxyUser, HttpServletRequest req);
	String UpdateProxyInfo(AbProxyUser abProxyUser, HttpServletRequest req);
}
