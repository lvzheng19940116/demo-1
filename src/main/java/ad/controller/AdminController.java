package ad.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ad.bean.AbProxyUser;
import ad.bean.AS_.AgentBean.AgentsDo;
import ad.service.IAbProxyUserService;
import ad.service.IAdminService;

import net.sf.json.JSONSerializer;

@RestController
@RequestMapping("/adminIn")
public class AdminController {

	@Autowired
	private IAdminService iAdminService;

	/**
	 * 获取代理
	 * @param req
	 * @param response
	 * @param AgentsDo
	 * @return
	 */
	@RequestMapping(value = "/adminControllering", produces = { "application/json; charset=utf-8" })
	public String queryAgents(HttpServletRequest req, HttpServletResponse response, AgentsDo AgentsDo) {
		return iAdminService.queryAgents(req, response, AgentsDo);
	}

}
