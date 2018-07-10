package ad.mapper;

import ad.bean.AbReveOrderDetails;
import ad.bean.AbReveOrderDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AbReveOrderDetailsMapper {
    long countByExample(AbReveOrderDetailsExample example);

    int deleteByExample(AbReveOrderDetailsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AbReveOrderDetails record);

    int insertSelective(AbReveOrderDetails record);
    
    AbReveOrderDetails selectAbReveOrderDetails(@Param("record")AbReveOrderDetails record);
    
    List<AbReveOrderDetails> sortByProxyIdOfToday(@Param("today")String today,@Param("tableName")String tableName);
    
    List<AbReveOrderDetails> sortByAdverIdOfToday(@Param("today")String today,@Param("tableName")String tableName);
    
    List<AbReveOrderDetails> sortByAppNameOfToday(@Param("today")String today,@Param("tableName")String tableName);

    List<AbReveOrderDetails> selectByExampleWithRowbounds(AbReveOrderDetailsExample example, RowBounds rowBounds);

    List<AbReveOrderDetails> selectByExample(AbReveOrderDetailsExample example);

    AbReveOrderDetails selectByPrimaryKey(Integer id);
    
    AbReveOrderDetails select(@Param("record") AbReveOrderDetails record);
    
    List<AbReveOrderDetails> selectAbReveOrderDetailsList(@Param("record") AbReveOrderDetails record);

    int updateByExampleSelective(@Param("record") AbReveOrderDetails record, @Param("example") AbReveOrderDetailsExample example);

    int updateByExample(@Param("record") AbReveOrderDetails record, @Param("example") AbReveOrderDetailsExample example);

    int updateByPrimaryKeySelective(AbReveOrderDetails record);

    int updateByPrimaryKey(AbReveOrderDetails record);
    
    Float getNewAddIncome(@Param("tableName")String tableName,@Param("yesterday")String yesterday,@Param("adverId")Integer adverId,@Param("proxyId")Integer proxyId,@Param("appName")String appName);
    
    Float selectEarningsAmount(@Param("tableName")String tableName,@Param("proxyId")Integer proxyId,@Param("createTime")String createTime);
    
    Float selectEarningsAmountByDays(@Param("tableName")String tableName,@Param("proxyId")Integer proxyId,@Param("createTime")String createTime);
}