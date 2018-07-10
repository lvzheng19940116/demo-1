package ad.mapper;

import ad.bean.AdUser;
import ad.bean.AdUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AdUserMapper {
    long countByExample(AdUserExample example);

    int deleteByExample(AdUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdUser record);

    int insertSelective(AdUser record);

    List<AdUser> selectByExampleWithRowbounds(AdUserExample example, RowBounds rowBounds);

    List<AdUser> selectByExample(AdUserExample example);

    AdUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdUser record, @Param("example") AdUserExample example);

    int updateByExample(@Param("record") AdUser record, @Param("example") AdUserExample example);

    int updateByPrimaryKeySelective(AdUser record);

    int updateByPrimaryKey(AdUser record);
}