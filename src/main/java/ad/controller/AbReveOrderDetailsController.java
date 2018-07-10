package ad.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ad.bean.AbReveOrderDetails;
import ad.service.IAbOrderDetailsAssociatedService;
import ad.service.IAbReveOrderDetailsService;

import net.sf.json.JSONSerializer;

/**
 * 收益订单管理详情
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/abReveOrderDetails")
public class AbReveOrderDetailsController {

	@Autowired
	IAbReveOrderDetailsService abReveOrderDetailsService;
	
	@Autowired
	IAbOrderDetailsAssociatedService abOrderDetailsAssociatedService;
	
	@RequestMapping(value = "/QueryRevenueOrdersDetailsAllList", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	@Deprecated
	public AbReveOrderDetails queryRevenueOrdersDetailsAllList(HttpServletRequest req,HttpServletResponse response,AbReveOrderDetails abReveOrderDetail){
		String table="ab_reve_order_details_";
		SimpleDateFormat time=new SimpleDateFormat("yyyyMM"); 
		String tableTime = time.format(new Date()) ;
		abReveOrderDetail.setTableName(table+tableTime);
		AbReveOrderDetails abReveOrderDetails = abReveOrderDetailsService.selectByPrimaryKey(abReveOrderDetail);
		return abReveOrderDetails;
	}
	/**
	 * 查询详细的条数
	 * @param req
	 * @param response
	 * @param abOrderDetailsAssociated
	 * @return
	 */
	@RequestMapping(value = "/QueryRevenueOrdersDetailsList", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String queryRevenueOrdersDetails (HttpServletRequest req,HttpServletResponse response,AbReveOrderDetails abReveOrderDetails){
		Map<String,Object> m = new HashMap<String,Object>();
		try{
			String result = abReveOrderDetailsService.queryRevenueOrdersDetails(abReveOrderDetails);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
}
