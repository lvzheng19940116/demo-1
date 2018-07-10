package ad.mapper;

import ad.bean.TempMenu;
import ad.bean.TempMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TempMenuMapper {
	long countByExample(TempMenuExample example);

	int deleteByExample(TempMenuExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(TempMenu record);

	int insertSelective(TempMenu record);

	List<TempMenu> selectByExampleWithRowbounds(TempMenuExample example, RowBounds rowBounds);

	List<TempMenu> selectByExample(TempMenuExample example);

	TempMenu selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") TempMenu record, @Param("example") TempMenuExample example);

	int updateByExample(@Param("record") TempMenu record, @Param("example") TempMenuExample example);

	int updateByPrimaryKeySelective(TempMenu record);

	int updateByPrimaryKey(TempMenu record);

	List<TempMenu> queryByCondtion();

	List<TempMenu> selectByCondition(TempMenu record);
}