package ad.controller.AS_.AgentController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ad.bean.AbProxyUser;
import ad.service.IAbProxyUserService;

import net.sf.json.JSONSerializer;

@Controller
@ResponseBody
@RequestMapping("/angeAdCounted")
public class AngeAdCountedController {
	@Autowired
	private IAbProxyUserService abProxyUserService;
	
	/**
	 * 查询代理
	 * @param aProxyUser
	 * @return
	 */
	@RequestMapping(value = "/queryAngeList", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String queryAngeList (AbProxyUser aProxyUser){
		Map<String,Object> result = new HashMap<String,Object>();
		try{
			List<AbProxyUser> aProxyUserList = abProxyUserService.queryAngeList(aProxyUser);
			result.put("code", 1);
			result.put("message", "fail");
			result.put("list", aProxyUserList);
		}catch(Exception e){
			e.printStackTrace();
			result.put("code", 0);
			result.put("message", "fail");
		}
		return JSONSerializer.toJSON(result).toString();
	}

}
