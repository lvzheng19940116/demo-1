package ad.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author cqp
 *
 */
public interface IIncomeProfileService {

	String queryIncomeProfile(HttpServletRequest req, HttpServletResponse response);
	Integer SerchAgentNum(HttpServletRequest req, HttpServletResponse response);
	String queryIncomeLineDiagrams(HttpServletRequest req, HttpServletResponse response);
	/**
	 * 根据登录人判断当前代理级别和佣金管理中的代理级别是否相同
	 * @param userId
	 * @return
	 */
	String compareAgentLevel(String userId);
}
