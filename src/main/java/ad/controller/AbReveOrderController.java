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
import ad.service.IAbProxyUserService;
import ad.service.IAbReveOrderService;

import net.sf.json.JSONSerializer;

/**
 * 收益订单管理
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/abReveOrder")
public class AbReveOrderController {

	@Autowired
	IAbReveOrderService abReveOrderService;
	@Autowired
	IAbProxyUserService abProxyUserService;
	
	/**
	 * 收益订单查询(所有数据)
	 * @param req
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/QueryRevenueOrdersAllList", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String QueryRevenueOrdersAllList(HttpServletRequest req,HttpServletResponse response,AbReveOrder abReveOrder){
		Map<String,Object> m = new HashMap<String,Object>();
		try{
			String result = abReveOrderService.queryRevenueOrdersAllList(abReveOrder);
			return result;
		}catch(Exception e){
			m.put("code", 0);
			m.put("message", "fail");
			e.printStackTrace();
		}
		return JSONSerializer.toJSON(m).toString();
	}
	/**
	 * 收益订单查询
	 * @param req
	 * @param response
	 * @param abReveOrder
	 * @return
	 */
	@RequestMapping(value = "/QueryRevenueOrdersList", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String queryRevenueOrdersList(HttpServletRequest req,HttpServletResponse response,AbReveOrder abReveOrder){
		Map<String,Object> m = new HashMap<String,Object>();
		try{
			String result = abReveOrderService.queryRevenueOrdersList(abReveOrder);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
}
