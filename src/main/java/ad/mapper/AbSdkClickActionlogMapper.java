package ad.mapper;

import ad.bean.AbSdkClickActionlog;
import ad.bean.AbSdkClickActionlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AbSdkClickActionlogMapper {
    long countByExample(AbSdkClickActionlogExample example);

    Integer selectMaxId();

    int deleteByExample(AbSdkClickActionlogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AbSdkClickActionlog record);

    int insertSelective(AbSdkClickActionlog record);

    List<AbSdkClickActionlog> selectByExampleWithRowbounds(AbSdkClickActionlogExample example, RowBounds rowBounds);

    List<AbSdkClickActionlog> selectByExample(AbSdkClickActionlogExample example);

    AbSdkClickActionlog selectByPrimaryKey(Integer id);
    

    int updateByExampleSelective(@Param("record") AbSdkClickActionlog record, @Param("example") AbSdkClickActionlogExample example);

    int updateByExample(@Param("record") AbSdkClickActionlog record, @Param("example") AbSdkClickActionlogExample example);

    int updateByPrimaryKeySelective(AbSdkClickActionlog record);

    int updateByPrimaryKey(AbSdkClickActionlog record);
}