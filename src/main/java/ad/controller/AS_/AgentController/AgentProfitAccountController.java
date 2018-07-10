//package ad.controller.AS_.AgentController;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import ad.bean.AbBankCard;
//import ad.bean.AbBillingInfo;
//import ad.bean.AS_.AccountBean.Account;
//import ad.service.IAbBankCardService;
//import ad.service.IAgentProfitAccountService;
//import ad.service.AS_.DeService.AccountService;
//import ad.service.AS_.DeService.Deservice;
//import ad.util.DateUtil;
//import ad.util.SelectCurrentMonthDay;
//import ad.util.CapcPlusUtil.HttpClientUtil;
//import ad.util.CapcPlusUtil.MD5Util;
//
//import net.sf.json.JSONObject;
//import net.sf.json.JSONSerializer;
//
///**
// * 代理收益账户
// * 
// * @author Administrator
// *
// */
//@RestController
//@RequestMapping("/AgentProfitAccount")
//public class AgentProfitAccountController {
//
//	// 用户服务列表界面上的“业务ID”
//	private final static String ywId = "3bde9a2e-aec4-4682-93ce-4dccdbd66ef2_bankCard4";
//
//	// 用户界面上的“业务密码”
//	private final static String ywPwd = "18131811";
//
//	// 接口地址，参见接口文档
//	public static String url = "https://api.capcplus.com/requestBankCard4Client.do";
//
//	@Autowired
//	private Deservice deservices;
//	@Autowired
//	private AccountService accountservice;
//	@Autowired
//	private IAbBankCardService bankCardService;
//	@Autowired
//	private IAgentProfitAccountService iAgentProfitAccountService;
//
//	/**
//	 * 账户信息接口
//	 * 
//	 * @param req
//	 * @param response
//	 * @return
//	 */
//	@RequestMapping(value = "/RevenueAccount", produces = { "application/json; charset=utf-8" })
//	public String queryIncomeRankings(HttpServletRequest req, HttpServletResponse response, AbBillingInfo abif) {
//		return iAgentProfitAccountService.queryIncomeRankings(req, response, abif);
//	}
//
//	
//
//	/**
//	 * 添加/修改银行卡
//	 * 
//	 * @param req
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping(value = "/ModifyBankCard", produces = { "application/json; charset=utf-8" })
//	public String BankCardAddFunction(HttpServletRequest req, HttpServletResponse response, AbBankCard bankcard)
//			throws Exception {
//		return iAgentProfitAccountService.BankCardAddFunction(req, response, bankcard);
//	}
//
//	@RequestMapping(value = "/SubStringPhone", produces = { "application/json; charset=utf-8" })
//	public String SubStringPhoneFunction(HttpServletRequest req, HttpServletResponse response) {
//		return iAgentProfitAccountService.SubStringPhoneFunction(req, response);
//	}
//
//	/**
//	 * 得到卡片信息
//	 * @param req
//	 * @param response
//	 * @return
//	 */
//	@RequestMapping(value = "/cardstr", produces = { "application/json; charset=utf-8" })
//	public String cardstrFunction(HttpServletRequest req, HttpServletResponse response) {
//		return iAgentProfitAccountService.cardstrFunction(req, response);
//	}
//
//}
