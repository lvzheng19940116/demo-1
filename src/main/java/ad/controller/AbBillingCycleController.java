package ad.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Repeat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ad.bean.AbBillingCycle;
import ad.service.IAbBillingCycleService;

import net.sf.json.JSONSerializer;

/**
 * 佣金管理类
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/abBillingCycle")
public class AbBillingCycleController {

	@Autowired
	IAbBillingCycleService abBillingCycleService;
	
	/**
	 * 	查询结算管理接口
	 * @param req
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/GetBillingCycle", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String getBillingCycle(HttpServletRequest req,HttpServletResponse response){
		Map<String,Object> m = new HashMap<String,Object>();
		try{
			AbBillingCycle abBillingCycle = abBillingCycleService.select();
			m.put("abBillingCycle", abBillingCycle ==null?new AbBillingCycle():abBillingCycle);
			m.put("message", "ok");
			m.put("code", 200);
			m.put("success", "true");
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
	@RequestMapping(value = "/getAgentNumber", produces = {"application/json; charset=utf-8"})
	public String getAgentNumber(){
		String count=abBillingCycleService.getAgentNumber();
		return count;
	}
	/**
	 * 修改结算日接口
	 * @param req
	 * @param response
	 * @param abBillingCycle
	 * @return
	 */
	@RequestMapping(value = "/UpdateBillingCycle", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String updateBillingCycle(HttpServletRequest req,HttpServletResponse response,AbBillingCycle abBillingCycle){
		Map<String,Object> m = new HashMap<String,Object>();
		try{
			String result = abBillingCycleService.updateBillingCycle(abBillingCycle);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
	/**
	 * 按着主键查询结算管理的接口
	 * @param req
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/GetBillingCycleById", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public AbBillingCycle getBillingCycleById(HttpServletRequest req,HttpServletResponse response,String  id){
		
		AbBillingCycle abBillingCycle = abBillingCycleService.selectByPrimaryKey(Integer.valueOf(id));
		if(abBillingCycle ==null){
			abBillingCycle = new AbBillingCycle();
			return abBillingCycle;
		}
		return abBillingCycle;
	}
	
	
}
