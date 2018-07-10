package ad.mapper.AS_;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ad.bean.AS_.AgentBean.BTListIncome;
import ad.bean.AS_.AgentBean.SubAgentProxyDe;

public interface SubAgentsProxyMapper {

	//下级代理收益明细
	List<SubAgentProxyDe> selectSubAgentProxyDeByIdAndTime
	(@Param("param1") int offset ,@Param("param2") int length ,@Param("id")Integer id ,@Param("startdate")String Startdate ,@Param("enddate")String Enddate );
	
	Integer selectSubAgentProxyDeCountByIdAndTime
	(@Param("id")Integer id ,@Param("startdate")String Startdate ,@Param("enddate")String Enddate );
	
	/**
	 * 广告饼图
	 * @param createtime
	 * @param endetime
	 * @param id
	 * @return
	 */
	List<BTListIncome> selectIncomeProAllByIdAndTimes
	(@Param("createtime")String createtime ,@Param("endetime")String endetime ,@Param("id")Integer id);
	
	/**
	 * 时间段内广告所有收益
	 * @param createtime
	 * @param endetime
	 * @param id
	 * @return
	 */
	Float selectTimesAllProIncomeByIdAndTimes
	(@Param("createtime")String createtime ,@Param("endetime")String endetime ,@Param("id")Integer id);
}
