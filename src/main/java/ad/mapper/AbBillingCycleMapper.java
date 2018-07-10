package ad.mapper;

import ad.bean.AbBillingCycle;
import ad.bean.AbBillingCycleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AbBillingCycleMapper {
    int countByExample(AbBillingCycleExample example);

    int deleteByExample(AbBillingCycleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AbBillingCycle record);

    int insertSelective(AbBillingCycle record);

    List<AbBillingCycle> selectByExample(AbBillingCycleExample example);

    AbBillingCycle selectByPrimaryKey(Integer id);
    
    // 查询计算周期
    AbBillingCycle select();

    int updateByExampleSelective(@Param("record") AbBillingCycle record, @Param("example") AbBillingCycleExample example);

    int updateByExample(@Param("record") AbBillingCycle record, @Param("example") AbBillingCycleExample example);

    int updateByPrimaryKeySelective(AbBillingCycle record);

    int updateByPrimaryKey(AbBillingCycle record);
    //返回代理级别  modified by caiqp
    String getAgentNumber();
}