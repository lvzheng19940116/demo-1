//package ad.service.impl;
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
//import org.springframework.stereotype.Service;
//
//import ad.bean.AbBankCard;
//import ad.bean.AbBillingInfo;
//import ad.bean.AS_.AccountBean.Account;
//import ad.mapper.AbBankCardMapper;
//import ad.mapper.AbBillingInfoMapper;
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
//@Service
//public class AgentProfitAccountServiceImpl implements IAgentProfitAccountService {
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
//	private AbBankCardMapper bankmapper;
//	@Autowired
//	private AbBillingInfoMapper billinginfomapper;
//
//	/**
//	 * 账户信息接口
//	 * 
//	 * @param req
//	 * @param response
//	 * @return
//	 */
//	@Override
//	public String queryIncomeRankings(HttpServletRequest req, HttpServletResponse response, AbBillingInfo abif) {
//		Account account = new Account();
//		AbBankCard bankcard = new AbBankCard();
//		List<AbBillingInfo> List = new ArrayList<AbBillingInfo>();
//		Map remap = new HashMap<>();
//		// 获取当前代理--统一用户中心的用户编号
//		String ussn = req.getParameter("proxy_id");
//		// 获取当前代理ID 根据根据统一用户中心的用户编号
//		Integer id = deservices.selectidBytyid(ussn);
//		if (id == null || "".equals(id)) {
//			return "";
//		} else {
//			// System.out.println("当前的代理ID是：===============" + id);
//		}
//		// DateUtil dtu = new DateUtil();
//		// SelectCurrentMonthDay Scm = new SelectCurrentMonthDay();
//		// 时间定位=========================================================
//		String format = "/yyyy-MM-dd";
//		// 当天
//		String curDate = DateUtil.getCurrentDateTime(format);
//		// String startDate = dtu.getCurrentDatePreDays(curDate,format,1); //昨天
//		// String endDate = dtu.getCurrentDatePreDays(curDate,format,7); //7天前
//		String startDateLast = ""; // 上月收益开始日期
//		String endDateLast = ""; // 上月收益结束日期
//		String startDatethis = ""; // 本月收益开始日期
//		String endDatethis = ""; // 结束日期为当前日期curDate
//		String thisProDate = "";// 本次结算日期
//		// System.out.println("今天：" + curDate);
//		// 假如结算日为每月15号 那么 就需要判断 当前日期是在本月的15号前 还是在本月的15号后
//		// 如果在15号前或15号 那么就截取上个月1号至月末的日期 如果是15号以后 就截取本月1号至当前时间的交易
//		// 15号前截取时间为 2018-1-1 00:00:00 -- 2018-1-31（28/29/30） 00:00:00
//		String k = curDate; // 假设当日时间
//		String s = k.substring(9); // 截取到日
//		Integer i = Integer.valueOf(s);
//		String lastmds = "";// 上个月的天数
//		// System.out.println(i);
//		Float lastpromny = 0f; // 上个月的收益金额
//		Float thispromny = 0f; // 本月 的收益金额
//		// 上月收益
//		startDateLast = DateUtil.getCurrentDatePreDays(k, format, 18); // 上个月的日期
//		// System.out.println("获取上个月的一个日期判断上月多少天" + startDateLast);
//		Integer newstartYE = Integer.valueOf(startDateLast.substring(1,5));// 获取上个月的年份
//		Integer newstartMD = Integer.valueOf(startDateLast.substring(6,8));// 获取上个月的月份
//		lastmds = String.valueOf(SelectCurrentMonthDay.getDaysByYearMonth(newstartYE, newstartMD));
//		// System.out.println("上个月的天数是" + lastmds);
//		startDateLast = (startDateLast.substring(0, 8) + "01");// 拼组上个月收益开始日期
//		endDateLast = (startDateLast.substring(0, 8) + lastmds);// 拼组上个月收益结束日期
//		// 获取上个月的收益
//		lastpromny = deservices.selectEarnings(startDateLast, endDateLast, id);
//		if (lastpromny == null || "".equals(lastpromny)) {
//			lastpromny = 0f;
//		}
//		// System.out.println(startDateLast + ":上月收益开始日期" + " " + endDateLast +
//		// "：上月收益结束日期" + "上月的收益是：" + lastpromny);
//		// 本月收益
//		thisProDate = DateUtil.getCurrentDatePreDays(k, format, -20); // 获取下个月的日期
//		startDatethis = (k.substring(0, 8) + "01");
//		endDatethis = k;
//		// 获取本月收益
//		thispromny = deservices.selectEarnings(startDatethis, endDatethis, id);
//		if (thispromny == null || "".equals(thispromny)) {
//			thispromny = 0f;
//		}
//		// System.out.println(startDatethis + ":本月收益开始日期" + " " + endDatethis +
//		// "：本月收益结束日期" + "本月的收益是" + thispromny);
//		if (i <= 15) {
//			// System.out.println("结果-------------------------小于等于15号");
//			thisProDate = (k.substring(1, 8) + "-15"); // 结算日期(上个月的收益本月15号结算)
//			account.setCurrentEarnings(lastpromny + thispromny);
//			account.setSettlementRevenue(lastpromny);
//			account.setDatetime(thisProDate);
//			// System.out.println("上月开始日期---" + startDateLast + "上月结束日期---" +
//			// endDateLast + "外加---本月开始日期---"
//			// + startDatethis + "本月结束日期---" + endDatethis + "结算日期为本月15号" +
//			// thisProDate);
//		}
//		if (i > 15) {
//			// System.out.println("结果-------------------------大于15号");
//			thisProDate = (thisProDate.substring(1, 8) + "-15");
//			account.setCurrentEarnings(thispromny);
//			account.setSettlementRevenue(thispromny);
//			account.setDatetime(thisProDate);
//			// System.out.println("本月开始日期---" + startDatethis + "本月结束日期---" +
//			// endDatethis + "结算日期为下月15号" + thisProDate);
//		}
//		// 银行卡信息
//		bankcard = bankmapper.selectByProxyId(id);
//		// 转账记录
//		int page = abif.getPage();
//		abif.setPage((page - 1) * 5);
//		List = billinginfomapper.selectByAgentId(abif, id);
//		// 转化时间格式
//		for (int j = 0; j < List.size(); j++) {
//			List.get(j).setCreatTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(List.get(j).getCreateTime()));
//		}
//		remap.put("message", "ok");
//		remap.put("code", "200");
//		remap.put("success", "true");
//		remap.put("Account", account);
//		remap.put("Bankcard", bankcard);
//		remap.put("AccountsRecordTable", List);
//		try {
//			remap.put("totalNumber", List == null ? 0 : List.get(0));
//		} catch (Exception e) {
//			remap.put("totalNumber", 0);
//		}
//
//		return JSONSerializer.toJSON(remap).toString();
//	}
//	
//	/**
//	 * 得到卡片信息
//	 * @param req
//	 * @param response
//	 * @return
//	 */
//	@Override
//	public String cardstrFunction(HttpServletRequest req, HttpServletResponse response) {
//		String cardstr = req.getParameter("cardstr");
//		String subQStr = cardstr.substring(0, 4);
//		String subHStr = cardstr.substring(15, cardstr.length());
//		cardstr = subQStr + " XXXX XXXX " + subHStr;
//		return cardstr;
//	}
//	
//	/**
//	 * 添加/修改银行卡
//	 * 
//	 * @param req
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	@Override
//	public String BankCardAddFunction(HttpServletRequest req, HttpServletResponse response, AbBankCard bankcard) {
//		Map<String, Object> maps = new HashMap<String, Object>();
//		// 获取当前代理--统一用户中心的用户编号
//		String ussn = req.getParameter("proxy_id");
//		// 获取当前代理ID 根据根据统一用户中心的用户编号
//		Integer id = deservices.selectidBytyid(ussn);
//		if (id == null || "".equals(id)) {
//			return "";
//		} else {
//			//System.out.println("当前的代理ID是：===============" + id);
//		}
//
//		bankcard.setProxyId(id);
//		bankcard.setCreateTime(new Date());
//
//		Integer Type = Integer.valueOf(req.getParameter("Type")); // 1添加 2修改
//		bankcard.setBankCardNumber(bankcard.getBankCardNumber().replace(" ", ""));
//		bankcard.setBankAccountName(bankcard.getBankAccountName().replace(" ", ""));
//		bankcard.setBankName(bankcard.getBankName().replace(" ", ""));
//		bankcard.setBankBranchesName(bankcard.getBankBranchesName().replace(" ", ""));
//		bankcard.setProxyUserId(bankcard.getProxyUserId().replace(" ", ""));
//		bankcard.setProxyUserContacts(bankcard.getProxyUserContacts().replace(" ", ""));
//
//		Boolean BooleanResult = false;
//		String StrResult = "";
//		try {
//			StrResult = authMotorVehicleInfo(bankcard.getBankCardNumber(), // 卡号
//					bankcard.getProxyUserId(), // "身份证"
//					bankcard.getBankReservePhone(), // "手机",
//					bankcard.getProxyUserContacts()// "姓名"
//			);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		// String StrResult
//		// ="{\"result\":1,\"msg\":\"查询成功,认证不一致\",\"serialno\":\"f71e018b62b94961847fbed5809accae\"}";
//		JSONObject jsonObject = JSONObject.fromObject(StrResult);
//
//		String SnStr = jsonObject.get("result").toString();
//		String ValueStr = jsonObject.get("msg").toString();
//		if ("0".equals(SnStr) && "查询成功,认证一致".equals(ValueStr)) {
//			BooleanResult = true;
//		} else {
//			if(ValueStr.length() > 24){
//				String[] b = ValueStr.split(",");				
//				String[] c = ValueStr.split(":");				
//				 ValueStr = b[0].toString() +","+ c[1].toString();				
//			}
//			maps.put("message", ValueStr);
//			maps.put("code", "150");
//			maps.put("success", "false");
//		}
//
//		//System.out.println(SnStr);
//		//System.out.println(ValueStr);
//		//System.out.println(jsonObject.get("serialno"));
//
//		if (BooleanResult == true) {
//			int Addresult = 0; // 结果
//			if (Type == 1) {
//				Addresult = bankCardService.ResultIntinsertSelective(bankcard);
//				if (Addresult == 1) {
//					maps.put("message", "ok");
//					maps.put("code", "200");
//					maps.put("success", "true");
//				} else {
//					maps.put("message", "数据添加异常");
//					maps.put("code", "");
//					maps.put("success", "false");
//				}
//
//			}
//
//			if (Type == 2) {
//				Addresult = bankCardService.ResultupdateByPrimaryByProxyId(bankcard);
//				if (Addresult == 1) {
//					maps.put("message", "ok");
//					maps.put("code", "200");
//					maps.put("success", "true");
//				} else {
//					maps.put("message", "数据修改异常");
//					maps.put("code", "");
//					maps.put("success", "false");
//				}
//
//			}
//		}
//
//		return JSONSerializer.toJSON(maps).toString();
//	}
//	
//	/**
//	 * 验证银行卡四要素一致接口
//	 * 
//	 * @param idcard
//	 * @param name
//	 * @throws Exception
//	 */
//	public static String authMotorVehicleInfo(String bankCard, String cardNo, String mobile, String name)
//			throws Exception {
//		Map<String, String> param = new HashMap<String, String>();
//		// 所需入参，请参照不同接口文档根据入参不同编写
//		param.put("bankCard", bankCard);// 银行卡号;纯数字
//		param.put("cardNo", cardNo);// 身份证件编号;数字英文
//		param.put("mobile", mobile);// 手机号码；11位纯数字
//		param.put("name", name);// 中文使用UTF-8字符集
//		param.put("ywId", ywId);// 由大象提供
//		// 生成鉴权码，其中涉及到MD5加密，请见源码
//		param.put("authz", MD5Util.md5(bankCard + "|" + cardNo + "|" + mobile + "|" + name + "|" + ywId + "|" + ywPwd));
//		// https的post请求
//		String result = HttpClientUtil.doPostSSL(url, param, "utf-8");
//		// 打印返回结果
//		//System.out.println(result);
//		return result;
//	}
//	
//	@Override
//	public String SubStringPhoneFunction(HttpServletRequest req, HttpServletResponse response) {
//		String usphone = req.getParameter("usphone");
//		String subQStr = usphone.substring(0, 3);
//		String subHStr = usphone.substring(7, 11);
//		String usphone1 = subQStr + "xxxx" + subHStr;
//		usphone = usphone1;
//		return usphone;
//	}
//}
