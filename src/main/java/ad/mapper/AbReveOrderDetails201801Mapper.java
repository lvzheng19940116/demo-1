package ad.mapper;

import ad.bean.AbReveOrderDetails201801;
import ad.bean.AbReveOrderDetails201801Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AbReveOrderDetails201801Mapper {
    int countByExample(AbReveOrderDetails201801Example example);

    int deleteByExample(AbReveOrderDetails201801Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(AbReveOrderDetails201801 record);

    int insertSelective(AbReveOrderDetails201801 record);

    List<AbReveOrderDetails201801> selectByExample(AbReveOrderDetails201801Example example);

    AbReveOrderDetails201801 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AbReveOrderDetails201801 record, @Param("example") AbReveOrderDetails201801Example example);

    int updateByExample(@Param("record") AbReveOrderDetails201801 record, @Param("example") AbReveOrderDetails201801Example example);

    int updateByPrimaryKeySelective(AbReveOrderDetails201801 record);

    int updateByPrimaryKey(AbReveOrderDetails201801 record);
}