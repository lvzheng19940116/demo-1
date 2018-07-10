package ad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ad.bean.AS_.AgentBean.AgentsDo;
import ad.mapper.AblcyProxyUserMapper;
import ad.service.LCYIAbProxyUserService;



@Service
public class LCYAbProxyUserServiceImpl implements LCYIAbProxyUserService{
	
	@Autowired
	private AblcyProxyUserMapper proxyusermapperlcy;
	
	
	@Override
	public List<AgentsDo> queryProxyList(AgentsDo AgentsDo) {
		List<AgentsDo> list = proxyusermapperlcy.queryProxyList(AgentsDo);
		return list;
	}
	
	@Override
	public List<AgentsDo> exportExcelQueryProxyList(AgentsDo AgentsDo) {
		List<AgentsDo> list = proxyusermapperlcy.exportExcelQueryProxyList(AgentsDo);
		return list;
	}

	/**
	 * 根据父级id得到user个数
	 */
	@Override
	public Integer selectuserCountsByfatherid(Integer fatherid) {
		Integer i =proxyusermapperlcy.selectuserCount(fatherid);
		return i;
	}


	@Override
	public List<AgentsDo> subAgentList(Integer fatherid) {
		List<AgentsDo> list =proxyusermapperlcy.selectSubAgentByFatherid(fatherid);
		return list;
	}


	@Override
	public Integer thisAgentCy(Integer id) {
		Integer i =proxyusermapperlcy.selectAgentCy(id);
		return i;
	}

	
	
	
	
}
