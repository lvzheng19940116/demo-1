package ad.mapper;

import ad.bean.AbStatisticsHour;
import ad.bean.AbStatisticsHourExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AbStatisticsHourMapper {
    int countByExample(AbStatisticsHourExample example);

    int deleteByExample(AbStatisticsHourExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AbStatisticsHour record);

    int insertSelective(AbStatisticsHour record);

    List<AbStatisticsHour> selectByExample(AbStatisticsHourExample example);

    AbStatisticsHour selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AbStatisticsHour record, @Param("example") AbStatisticsHourExample example);

    int updateByExample(@Param("record") AbStatisticsHour record, @Param("example") AbStatisticsHourExample example);

    int updateByPrimaryKeySelective(AbStatisticsHour record);

    int updateByPrimaryKey(AbStatisticsHour record);
}