package ad.mapper;

import ad.bean.AbAdvertAreaAssociation;
import ad.bean.AbAdvertAreaAssociationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AbAdvertAreaAssociationMapper {
    int countByExample(AbAdvertAreaAssociationExample example);

    int deleteByExample(AbAdvertAreaAssociationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AbAdvertAreaAssociation record);

    int insertSelective(AbAdvertAreaAssociation record);

    List<AbAdvertAreaAssociation> selectByExample(AbAdvertAreaAssociationExample example);

    AbAdvertAreaAssociation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AbAdvertAreaAssociation record, @Param("example") AbAdvertAreaAssociationExample example);

    int updateByExample(@Param("record") AbAdvertAreaAssociation record, @Param("example") AbAdvertAreaAssociationExample example);

    int updateByPrimaryKeySelective(AbAdvertAreaAssociation record);

    int updateByPrimaryKey(AbAdvertAreaAssociation record);
}