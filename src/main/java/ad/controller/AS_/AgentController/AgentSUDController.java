//package ad.controller.AS_.AgentController;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.actuate.autoconfigure.ActuatorMetricWriter;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.alibaba.fastjson.JSONObject;
//import ad.bean.AbProxyUser;
//import ad.service.IAbProxyUserService;
//import ad.service.IAgentSUDService;
//import ad.service.AS_.DeService.Deservice;
//import ad.util.Constends;
//import ad.util.DateUtil;
//import ad.util.DesCrypt;
//import ad.util.HttpConnection;
//import ad.util.MessageUtils;
//import ad.util.sixNum;
//
//import net.sf.json.JSONSerializer;
//
///**
// * 代理管理
// * 
// * @author AgentAUD
// *
// */
//@RestController
//@RequestMapping("/AgentAUD")
//public class AgentSUDController {
//
//	@Autowired
//	private IAbProxyUserService abProxyUserService;
//
//	@Autowired
//	private Deservice deservices;
//	@Autowired
//	private IAgentSUDService iAgentSUDService;
//
//	/**
//	 * 
//	 * @param req
//	 * @param response
//	 * @return
//	 */
//	@RequestMapping(value = "/abcde", produces = { "application/json; charset=utf-8" })
//	public String queryAgs(HttpServletRequest req, HttpServletResponse response) {
//		//System.out.println(
//			//	"=AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA============================================================");
//		return "";
//		// return JSONSerializer.toJSON(m).toString();
//	}
//
//	/**
//	 * 添加代理用户
//	 * 
//	 * @param abProxyUser
//	 * @param req
//	 * @return
//	 */
//	@RequestMapping(value = "/AgentAdd", produces = { "application/json; charset=utf-8" })
//	@ResponseBody
//	@Transactional
//	public String AddProxyInfo(AbProxyUser abProxyUser, HttpServletRequest req) {
//		return iAgentSUDService.AddProxyInfo(abProxyUser, req);
//	}
//
//	/**
//	 * 修改代理用户
//	 * 
//	 * @param abProxyUser
//	 * @param req
//	 * @return
//	 */
//	@RequestMapping(value = "/UpdateProxyInfo", produces = { "application/json; charset=utf-8" })
//	@ResponseBody
//	public String UpdateProxyInfo(AbProxyUser abProxyUser, HttpServletRequest req) {
//		return iAgentSUDService.UpdateProxyInfo(abProxyUser, req);
//	}
//
//}
