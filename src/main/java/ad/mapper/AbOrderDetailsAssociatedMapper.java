package ad.mapper;

import ad.bean.AbOrderDetailsAssociated;
import ad.bean.AbOrderDetailsAssociatedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AbOrderDetailsAssociatedMapper {
    int countByExample(AbOrderDetailsAssociatedExample example);

    int deleteByExample(AbOrderDetailsAssociatedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AbOrderDetailsAssociated record);

    int insertSelective(AbOrderDetailsAssociated record);

    List<AbOrderDetailsAssociated> selectByExampleWithBLOBs(AbOrderDetailsAssociatedExample example);

    List<AbOrderDetailsAssociated> selectByExample(AbOrderDetailsAssociatedExample example);

    AbOrderDetailsAssociated selectByPrimaryKey(Integer id);
    
    AbOrderDetailsAssociated selectByorderId(@Param("record") AbOrderDetailsAssociated record);

    int updateByExampleSelective(@Param("record") AbOrderDetailsAssociated record, @Param("example") AbOrderDetailsAssociatedExample example);

    int updateByExampleWithBLOBs(@Param("record") AbOrderDetailsAssociated record, @Param("example") AbOrderDetailsAssociatedExample example);

    int updateByExample(@Param("record") AbOrderDetailsAssociated record, @Param("example") AbOrderDetailsAssociatedExample example);

    int updateByPrimaryKeySelective(AbOrderDetailsAssociated record);

    int updateByPrimaryKeyWithBLOBs(AbOrderDetailsAssociated record);

    int updateByPrimaryKey(AbOrderDetailsAssociated record);
}