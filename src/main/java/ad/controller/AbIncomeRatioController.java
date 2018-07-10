package ad.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ad.bean.AbReveOrder;
import ad.service.IAbIncomeRatioService;
import ad.service.IAbProxyUserService;
import ad.service.IAbReveOrderService;
import ad.service.IAdvertisingManService;

import net.sf.json.JSONSerializer;


/**
 * 收益比例类
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/abIncomeRatio")
public class AbIncomeRatioController {
	
	@Autowired
	IAbReveOrderService abReveOrderService;
	@Autowired
	IAbProxyUserService abProxyUserService;
	@Autowired
	IAdvertisingManService advertisingManService;
	@Autowired
	IAbIncomeRatioService abIncomeRatioService;

	
	/**
	 * 收益比例查询类
	 * @param req
	 * @param response
	 * @param abReveOrder
	 * @return
	 */
	@RequestMapping(value = "/RevenueRatio", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String revenueRatio(HttpServletRequest req,HttpServletResponse response,AbReveOrder abReveOrder){
		Map<String,Object> m = new HashMap<String,Object>();
		try{
			String result = abIncomeRatioService.revenueRatio(abReveOrder);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
}
