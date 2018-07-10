package ad.mapper;

import ad.bean.AdAreaCode;
import ad.bean.AdAreaCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdAreaCodeMapper {
    int countByExample(AdAreaCodeExample example);

    int deleteByExample(AdAreaCodeExample example);

    int insert(AdAreaCode record);

    int insertSelective(AdAreaCode record);

    List<AdAreaCode> selectByExample(AdAreaCodeExample example);

    int updateByExampleSelective(@Param("record") AdAreaCode record, @Param("example") AdAreaCodeExample example);

    int updateByExample(@Param("record") AdAreaCode record, @Param("example") AdAreaCodeExample example);
}