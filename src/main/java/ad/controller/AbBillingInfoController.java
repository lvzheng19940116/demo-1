package ad.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ad.bean.AbBillingInfo;
import ad.service.IAbBillingInfoService;
import ad.service.IAbProxyUserService;

import net.sf.json.JSONSerializer;

/**
 * 结算数据类
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/abBillingInfo")
public class AbBillingInfoController {
	
	@Autowired
	IAbBillingInfoService abBillingInfoService;
	@Autowired
	IAbProxyUserService abProxyUserService;
	
	/**
	 * 结算记录查询所有数据的接口
	 * @param req
	 * @param response
	 */
	@RequestMapping(value = "/QueryBillingAllInformationList", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String QueryBillingAllInformationList(HttpServletRequest req,HttpServletResponse response,AbBillingInfo abBillingInfo){
		Map<String,Object> m = new HashMap<String,Object>();
		try{
			String result = abBillingInfoService.queryBillingAllInformationList(abBillingInfo);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
	
	/**
	 *结算信息查询接口
	 *查询条件：结算用户ID（手机号、用户名、银行卡号）、金额范围、时间范围、结算状态（需要点击转账的、需要点击完成的）
	 * @param req
	 * @param response
	 * @param abBillingInfo
	 * @return
	 */
	@RequestMapping(value = "/QueryBillingInformationList", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String queryBillingInformationList (HttpServletRequest req,HttpServletResponse response,AbBillingInfo abBillingInfo){
		Map<String,Object> m = new HashMap<String,Object>();
		try{
			String result = abBillingInfoService.queryBillingInformationList(abBillingInfo);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
	
	/**
	 * 结算数据管理转账和完成
	 * @param req
	 * @param response
	 * @param ids(主键)
	 * @param flag(标记)
	 * @return
	 */
	@RequestMapping(value = "/TransferCompleted", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String transferCompleted (HttpServletRequest req,HttpServletResponse response,String ids,String flag){
		Map<String,Object> m = new HashMap<String,Object>();
		try{
			String result = abBillingInfoService.transferCompleted(ids,flag);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
}
