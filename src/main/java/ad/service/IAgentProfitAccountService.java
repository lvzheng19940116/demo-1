package ad.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ad.bean.AbBankCard;
import ad.bean.AbBillingInfo;

/**
 * 
 * @author cqp
 *
 */
public interface IAgentProfitAccountService {

	String queryIncomeRankings(HttpServletRequest req, HttpServletResponse response, AbBillingInfo abif);
	String cardstrFunction(HttpServletRequest req, HttpServletResponse response);
	String BankCardAddFunction(HttpServletRequest req, HttpServletResponse response, AbBankCard bankcard);
	String SubStringPhoneFunction(HttpServletRequest req, HttpServletResponse response);
}
