package ad.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ad.service.IAbCreateAbReveOrderDetailsService;
import ad.util.DateUtil;

import net.sf.json.JSONSerializer;

/**
 * 创建明细表
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/abCreateAbReveOrderDetails")
public class AbCreateAbReveOrderDetailsController {

	@Autowired
	IAbCreateAbReveOrderDetailsService abCreateAbReveOrderDetailsService;
	
	@RequestMapping(value = "/createAbReveOrderDetails", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String createAbReveOrderDetails(HttpServletRequest req,HttpServletResponse response){
		Map<String,Object> m = new HashMap<String,Object>();
		String tableTime = DateUtil.nextMonthFirstDate("yyyyMM");
		try{
			abCreateAbReveOrderDetailsService.createAbReveOrderDetails("ab_reve_order_details_"+tableTime);
			m.put("code", 1);
			m.put("message", "success");
			m.put("success", "true");
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
	
	
}
