package ad.mapper;

import ad.bean.AbBillingInfo;
import ad.bean.AbBillingInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AbBillingInfoMapper {
    int countByExample(AbBillingInfoExample example);

    int deleteByExample(AbBillingInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AbBillingInfo record);

    int insertSelective(AbBillingInfo record);

    List<AbBillingInfo> selectByExample(AbBillingInfoExample example);

    AbBillingInfo selectByPrimaryKey(Integer id);
    
    Float setCumulativeIncome(@Param("id")Integer id);
    
    //结算记录查询
    List<AbBillingInfo> select(@Param("abBillingInfo") AbBillingInfo abBillingInfo);
    
    List<AbBillingInfo> queryBillingInformationList(@Param("abBillingInfo") AbBillingInfo abBillingInfo);

    int updateByExampleSelective(@Param("record") AbBillingInfo record, @Param("example") AbBillingInfoExample example);

    int updateByExample(@Param("record") AbBillingInfo record, @Param("example") AbBillingInfoExample example);

    int updateByPrimaryKeySelective(AbBillingInfo record);

    int updateByPrimaryKey(AbBillingInfo record);
    
    List<AbBillingInfo> selectByAgentId(@Param("abBillingInfo") AbBillingInfo abBillingInfo,@Param("userid")Integer id);
}