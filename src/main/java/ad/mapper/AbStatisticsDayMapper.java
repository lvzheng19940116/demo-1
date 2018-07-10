package ad.mapper;

import ad.bean.AbStatisticsDay;
import ad.bean.AbStatisticsDayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AbStatisticsDayMapper {
    int countByExample(AbStatisticsDayExample example);

    int deleteByExample(AbStatisticsDayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AbStatisticsDay record);

    int insertSelective(AbStatisticsDay record);

    List<AbStatisticsDay> selectByExample(AbStatisticsDayExample example);

    AbStatisticsDay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AbStatisticsDay record, @Param("example") AbStatisticsDayExample example);

    int updateByExample(@Param("record") AbStatisticsDay record, @Param("example") AbStatisticsDayExample example);

    int updateByPrimaryKeySelective(AbStatisticsDay record);

    int updateByPrimaryKey(AbStatisticsDay record);
}