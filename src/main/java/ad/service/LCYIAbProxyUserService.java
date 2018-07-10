package ad.service;

import java.util.List;

import ad.bean.AS_.AgentBean.AgentsDo;


public interface LCYIAbProxyUserService {
	

	public List<AgentsDo> queryProxyList(AgentsDo AgentsDo);
	
	public List<AgentsDo> exportExcelQueryProxyList(AgentsDo AgentsDo);
	
	//查询代理数
	public Integer selectuserCountsByfatherid(Integer fatherid);
	
	//导出所有代理列表
	public List<AgentsDo> subAgentList(Integer fatherid);

	public Integer thisAgentCy(Integer id);
	
}
