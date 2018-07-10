package ad.mapper;

import ad.bean.AbReveOrder;
import ad.bean.AbReveOrderExample;
import ad.bean.AS_.AgentBean.AgentRankings;
import ad.bean.AS_.AgentBean.BTListAgent;
import ad.bean.AS_.AgentBean.DayProxyAll;
import ad.bean.AS_.DE.DeAllasTitle;
import ad.bean.AS_.IncomeBean.IncomeRankings;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AbReveOrderMapper {
    int countByExample(AbReveOrderExample example);

    int deleteByExample(AbReveOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AbReveOrder record);

    int insertSelective(AbReveOrder record);

    List<AbReveOrder> selectByExample(AbReveOrderExample example);
    
    List<AbReveOrder> select(@Param("abReveOrder")AbReveOrder abReveOrder);
    
    AbReveOrder selectNum();
    
    List<AbReveOrder> queryRevenueOrdersList(@Param("abReveOrder") AbReveOrder abReveOrder);
    
    List<AbReveOrder> selectCurrentList(@Param("time1") String time1,@Param("time2") String time2);

    List<AbReveOrder> getProxyIdList();
    
    List<AbReveOrder> reportStatistics(@Param("adverId") Integer adverId,@Param("proxyId") Integer proxyId,@Param("appName") String appName,
    		@Param("startTime") String startTime,@Param("endTime") String endTime);
    
    List<AbReveOrder> reportStatisticsList(@Param("adverId") Integer adverId,@Param("proxyId") Integer proxyId,@Param("appName") String appName,
    		@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("page")Integer page);
    
    List<AbReveOrder> downloadReportStatistics(@Param("adverId") Integer adverId,@Param("proxyId") Integer proxyId,@Param("appName") String appName,
    		@Param("startTime") String startTime,@Param("endTime") String endTime);
    
    List<AbReveOrder> sortByProxyId(@Param("startTime") String startTime,@Param("endTime") String endTime);
    
    List<AbReveOrder> sortByAdverId(@Param("startTime") String startTime,@Param("endTime") String endTime);
    
    List<AbReveOrder> sortByAppName(@Param("startTime") String startTime,@Param("endTime") String endTime);
    
    List<AbReveOrder> getAppNameList();
    
    AbReveOrder selectByPrimaryKey(Integer id);
    //查询当前收益
    Float selectCurrentIncome(@Param("abReveOrder")AbReveOrder abReveOrder);
    
    Float getNewAddIncome(@Param("yesterday")String yesterday,@Param("adverId")Integer adverId,@Param("proxyId")Integer proxyId,@Param("appName")String appName);
    
    Float getAllIncome(@Param("adverId")Integer adverId,@Param("proxyId")Integer proxyId,@Param("appName")String appName);

    int updateByExampleSelective(@Param("record") AbReveOrder record, @Param("example") AbReveOrderExample example);

    int updateByExample(@Param("record") AbReveOrder record, @Param("example") AbReveOrderExample example);

    int updateByPrimaryKeySelective(AbReveOrder record);

    int updateByPrimaryKey(AbReveOrder record);
    
    List<AbReveOrder> SelectDeAllByTypes(Integer types);
    
    List<DeAllasTitle> selectBytime(@Param("param1") String cretime,@Param("param2") String endtime);
  //无时间查询带分页 -- 收益明细
    List<DeAllasTitle> selectIncomeAllDe(@Param("param1") Integer offset ,@Param("param2") Integer length,@Param("userid") Integer userid);
    List<DeAllasTitle> selectAgentAllDe(@Param("param1") Integer offset ,@Param("param2") Integer length,@Param("userid") Integer userid);
    
    Integer selectuseridBytyid(@Param("userid") String userid );
    Integer selectCyLevel(@Param("id") Integer id);
    
    long getIncomeAllRowCount(@Param("userid") Integer usid );
    long getAgentAllRowCount(@Param("userid") Integer usid );
    
    //时间查询带分页 -- 收益明细
    long getIncomeAllRowCountOnTime(@Param("createtime") String createtime ,@Param("endetime") String endetime,@Param("userid") Integer usid );
    long getAgentAllRowCountOnTime(@Param("createtime") String createtime ,@Param("endetime") String endetime,@Param("userid") Integer usid );
    
    List<DeAllasTitle> selectIncomeAllDeOnTheTime(@Param("param1") Integer offset ,@Param("param2") Integer length,
    								@Param("createtime") String createtime ,@Param("endetime") String endetime,
    								@Param("userid") Integer usid );
    List<DeAllasTitle> selectAgentAllDeOnTheTime(@Param("param1") Integer offset ,@Param("param2") Integer length,
    								@Param("createtime") String createtime ,@Param("endetime") String endetime,
    								@Param("userid") Integer usid );
    
   // 广告排行榜 top10
    List<IncomeRankings> selectIncomeTop10(@Param("createtime") String createtime ,@Param("endetime") String endetime,@Param("userid") Integer usid );
    
    //代理排行榜 top10
    List<AgentRankings> selectAgentTop10(@Param("createtime") String createtime ,@Param("endetime") String endetime,@Param("userid") Integer usid );
    
    //获取金额  -银行账户
    Float selectEarnings(@Param("createtime") String createtime ,@Param("endetime") String endetime,@Param("userid") Integer usid );
    
    //昨日收益 累计收益
    Float selectByFatheridOrAndTimes(@Param("createtime") String createtime ,@Param("endetime") String endetime,@Param("fatherid") Integer fatherid );
   
    //自己旗下代理收益的集合 top 10 带区间
    List<BTListAgent> selectAgentAllTop10ByProidOrAndTimes
    (@Param("createtime") String createtime ,@Param("endetime") String endetime,@Param("fatherid") Integer fatherid );
    
    List<BTListAgent> selectAgentAllNoTop10ByProidOrAndTimes
    (@Param("createtime") String createtime ,@Param("endetime") String endetime,@Param("fatherid") Integer fatherid );
    
    //自己的收益 带区间
    Float selectOwnProByProidOrAndTimes
    (@Param("createtime") String createtime ,@Param("endetime") String endetime,@Param("fatherid") Integer fatherid );
    
    //自己和代理的总收益 带区间
    Float selectOwnAndSubAgentProByProidOrAndTimes
    (@Param("createtime") String createtime ,@Param("endetime") String endetime,@Param("fatherid") Integer fatherid );
    
    //每日的收益情况 折线图
    List<DayProxyAll> selectDayProxyByTimesAndId
    (@Param("createtime") String createtime ,@Param("endetime") String endetime,@Param("id") Integer id ,@Param("restype") String type );
    //导出广告收益
	List<DeAllasTitle> selectIncomeAllDeById(@Param("userID") Integer userID);
	//导出代理收益
	List<DeAllasTitle> selectAgentAllDeById(@Param("userID") Integer userID);
    
}