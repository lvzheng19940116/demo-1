package ad.mapper;

import ad.bean.AbBankCard;
import ad.bean.AbBankCardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AbBankCardMapper {
    int countByExample(AbBankCardExample example);

    int deleteByExample(AbBankCardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AbBankCard record);

    int insertSelective(AbBankCard record);

    List<AbBankCard> selectByExample(AbBankCardExample example);

    AbBankCard selectByPrimaryKey(Integer id);
    
    //根据代理ID查询出银行卡信息
    AbBankCard selectByProxyId(Integer id);
    
    AbBankCard selectBankNumber(Integer proxyId);

    int updateByExampleSelective(@Param("record") AbBankCard record, @Param("example") AbBankCardExample example);

    int updateByExample(@Param("record") AbBankCard record, @Param("example") AbBankCardExample example);

    int updateByPrimaryKeySelective(AbBankCard record);

    int updateByPrimaryKey(AbBankCard record);
    
    Integer updateByPrimaryByProxyId (AbBankCard record);
}