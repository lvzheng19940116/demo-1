package ad.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ad.bean.AbBankCard;
import ad.service.IAbBankCardService;

import net.sf.json.JSONSerializer;

/**
 * 查询银行卡类
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/abBankCard")
public class AbBankCardController {
	
	@Autowired
	IAbBankCardService abBankCardService;
	
	/**
	 * 查询代理用户的银行卡
	 * @param req
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/GetProxyBank", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String queryById(HttpServletRequest req,HttpServletResponse response,int id){
		Map<String,Object> m = new HashMap<String,Object>();
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		try{
			//根据代理ID查询出银行卡信息
			AbBankCard abBankCard = abBankCardService.queryById(id);
			if(abBankCard !=null && abBankCard.getCreateTime() !=null){
				abBankCard.setDate(time.format(abBankCard.getCreateTime()));
			}
			m.put("abBankCard", abBankCard);
			m.put("code", 200);
			m.put("message", "ok");
			m.put("success", "true");
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
}
