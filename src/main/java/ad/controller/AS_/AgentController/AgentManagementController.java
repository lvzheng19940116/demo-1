package ad.controller.AS_.AgentController;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ad.bean.AS_.AgentBean.AgentsDo;
import ad.service.IAgentManagementService;
import ad.service.LCYIAbProxyUserService;
import ad.service.AS_.DeService.Deservice;
import ad.util.Excel2018;
import ad.util.MD5;

import net.sf.json.JSONSerializer;

/**
 * 代理管理
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/AgentManagements")
public class AgentManagementController {

	@Autowired
	private Deservice deservices;

	@Autowired
	private LCYIAbProxyUserService abProxyUserServiceLCY;
	@Autowired
	private IAgentManagementService iAgentManagementService;

	/**
	 * 代理详情
	 * 
	 * @param req
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/QueryProxyList", produces = { "application/json; charset=utf-8" })
	public String queryAgents(HttpServletRequest req, HttpServletResponse response, AgentsDo AgentsDo) {
		return iAgentManagementService.queryAgents(req, response, AgentsDo);
	}

	/**
	 * 代理导出
	 * 
	 * @param req
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ExportExcel", produces = { "application/json; charset=utf-8" })
	public void ExportExcel(HttpServletRequest req, HttpServletResponse response,AgentsDo AgentsDo) {
		iAgentManagementService.ExportExcel(req, response, AgentsDo);
	}
}
