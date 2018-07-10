package ad.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import ad.bean.AbAdvertAroxyAssociation;
import ad.bean.AbAdvertAroxyAssociationExample;
import ad.bean.AbSdkClickActionlog;

public interface AbAdvertAroxyAssociationMapper {
	int countByExample(AbAdvertAroxyAssociationExample example);

	int deleteByExample(AbAdvertAroxyAssociationExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(AbAdvertAroxyAssociation record);

	int insertSelective(AbAdvertAroxyAssociation record);

	List<AbAdvertAroxyAssociation> selectByExample(AbAdvertAroxyAssociationExample example);

	AbAdvertAroxyAssociation selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") AbAdvertAroxyAssociation record,
			@Param("example") AbAdvertAroxyAssociationExample example);

	int updateByExample(@Param("record") AbAdvertAroxyAssociation record,
			@Param("example") AbAdvertAroxyAssociationExample example);

	int updateByPrimaryKeySelective(AbAdvertAroxyAssociation record);

	int updateByPrimaryKey(AbAdvertAroxyAssociation record);

	
    
    AbAdvertAroxyAssociation selectDistributionRatio(@Param("record")AbSdkClickActionlog ab);
}