package ad.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ad.bean.AbProxyUser;
import ad.bean.AS_.AgentBean.AgentsDo;
import ad.mapper.AbProxyUserMapper;
import ad.service.IAbProxyUserService;
import ad.service.IAdminService;

import net.sf.json.JSONSerializer;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAbProxyUserService abProxyUserService;
	@Autowired
	private AbProxyUserMapper abProxyUserMapper;
	
	/**
	 * 获取代理
	 * @param req
	 * @param response
	 * @param AgentsDo
	 */
	@Override
	public String queryAgents(HttpServletRequest req, HttpServletResponse response, AgentsDo AgentsDo) {
		System.out.println("lslslslslslslslslslslslslsls q!");
		List<AbProxyUser> listagent = abProxyUserMapper.selectAgentByCy(1);
		Map m = new HashMap<>();
		m.put("listagent", listagent);
		return JSONSerializer.toJSON(m).toString();
	}
}
