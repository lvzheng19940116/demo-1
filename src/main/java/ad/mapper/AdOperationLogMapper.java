package ad.mapper;

import ad.bean.AdOperationLog;
import ad.bean.AdOperationLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AdOperationLogMapper {
    long countByExample(AdOperationLogExample example);

    int deleteByExample(AdOperationLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdOperationLog record);

    int insertSelective(AdOperationLog record);

    List<AdOperationLog> selectByExampleWithBLOBsWithRowbounds(AdOperationLogExample example, RowBounds rowBounds);

    List<AdOperationLog> selectByExampleWithBLOBs(AdOperationLogExample example);

    List<AdOperationLog> selectByExampleWithRowbounds(AdOperationLogExample example, RowBounds rowBounds);

    List<AdOperationLog> selectByExample(AdOperationLogExample example);

    AdOperationLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdOperationLog record, @Param("example") AdOperationLogExample example);

    int updateByExampleWithBLOBs(@Param("record") AdOperationLog record, @Param("example") AdOperationLogExample example);

    int updateByExample(@Param("record") AdOperationLog record, @Param("example") AdOperationLogExample example);

    int updateByPrimaryKeySelective(AdOperationLog record);

    int updateByPrimaryKeyWithBLOBs(AdOperationLog record);

    int updateByPrimaryKey(AdOperationLog record);
}