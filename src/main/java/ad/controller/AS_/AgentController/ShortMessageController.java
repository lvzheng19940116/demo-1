package ad.controller.AS_.AgentController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ad.bean.AbBillingInfo;

/**
 * 代理收益账户
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/ShortMessage")
public class ShortMessageController {

	
	/**
	 * 账户信息接口
	 * @param req
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ResultShortMessage", produces = { "application/json; charset=utf-8" })
	public Integer ResultShortMessage(HttpServletRequest req,HttpServletResponse response) {
		//字符串的手机号
		String usphone = req.getParameter("usphone");
		//查询需要转换integer类型
		//Integer IntPhone = 
		System.out.println("短信发出接口");
		return 666666;
	}
	
	
}
