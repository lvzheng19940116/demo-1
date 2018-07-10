package ad.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import ad.bean.AbAdvertProxyAssociation;
import ad.bean.AbAdvertProxyAssociationExample;
import ad.bean.AbProxyUser;

public interface AbAdvertProxyAssociationMapper {
	long countByExample(AbAdvertProxyAssociationExample example);

	int deleteByExample(AbAdvertProxyAssociationExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(AbAdvertProxyAssociation record);

	int insertSelective(AbAdvertProxyAssociation record);

	List<AbAdvertProxyAssociation> selectByExampleWithRowbounds(AbAdvertProxyAssociationExample example,
			RowBounds rowBounds);

	List<AbAdvertProxyAssociation> selectByExample(AbAdvertProxyAssociationExample example);

	AbAdvertProxyAssociation selectByPrimaryKey(Integer id);

	AbAdvertProxyAssociation selectAbAdvertProxy(@Param("record") AbAdvertProxyAssociation record);

	int updateByExampleSelective(@Param("record") AbAdvertProxyAssociation record,
			@Param("example") AbAdvertProxyAssociationExample example);

	int updateByExample(@Param("record") AbAdvertProxyAssociation record,
			@Param("example") AbAdvertProxyAssociationExample example);

	int updateByPrimaryKeySelective(AbAdvertProxyAssociation record);

	int updateByPrimaryKey(Integer id);

	int updateByProxyId(AbAdvertProxyAssociation record);
	
	int updateByKey(AbProxyUser record);

	List<AbAdvertProxyAssociation> selectByAdverId(@Param("adverId")Integer id);
	List<AbAdvertProxyAssociation> queryByPage(AbAdvertProxyAssociation record);

	long selectTotal();
	
	int deleteByAdverId(Integer id);
}