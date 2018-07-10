package ad.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import ad.bean.AbProxyUser;
import ad.bean.AbProxyUserExample;
import ad.bean.AbReveOrder;
import ad.bean.AS_.AgentBean.AgentsDo;

public interface AblcyProxyUserMapper {
	
    List<AgentsDo> queryProxyList(@Param("agentsDo")AgentsDo AgentsDo);
	List<AgentsDo> exportExcelQueryProxyList(@Param("agentsDo")AgentsDo AgentsDo);
    List<AgentsDo> selectSubAgentByFatherid(@Param("fatherid")Integer fatherid);
    
    Integer selectuserCount(@Param("fatherid") Integer fatherid);
    
    Integer selectAgentCy(@Param("id") Integer id);
    
}