package ad.mapper;

import ad.bean.AbAdvertOrder;
import ad.bean.AbAdvertOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AbAdvertOrderMapper {
    long countByExample(AbAdvertOrderExample example);

    int deleteByExample(AbAdvertOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AbAdvertOrder record);

    int insertSelective(AbAdvertOrder record);

    List<AbAdvertOrder> selectByExampleWithRowbounds(AbAdvertOrderExample example, RowBounds rowBounds);

    List<AbAdvertOrder> selectByExample(AbAdvertOrderExample example);

    AbAdvertOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AbAdvertOrder record, @Param("example") AbAdvertOrderExample example);

    int updateByExample(@Param("record") AbAdvertOrder record, @Param("example") AbAdvertOrderExample example);

    int updateByPrimaryKeySelective(AbAdvertOrder record);

    int updateByPrimaryKey(AbAdvertOrder record);
    AbAdvertOrder selectMaxId();
    List<AbAdvertOrder> selectByPage(AbAdvertOrder record);
    long selecTotal();

	Integer getByName(AbAdvertOrder record);
	
	AbAdvertOrder getByUpdateName(AbAdvertOrder record);
	
	
	
	
	
}