package ad.mapper;

import ad.bean.AbAdver;
import ad.bean.AbStatisticsHourTemp;
import ad.bean.AbStatisticsHourTempExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AbStatisticsHourTempMapper {
	long countByExample(AbStatisticsHourTempExample example);

	int deleteByExample(AbStatisticsHourTempExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(AbStatisticsHourTemp record);

	int insertSelective(AbStatisticsHourTemp record);

	List<AbStatisticsHourTemp> selectByExampleWithRowbounds(AbStatisticsHourTempExample example, RowBounds rowBounds);

	List<AbStatisticsHourTemp> selectByExample(AbStatisticsHourTempExample example);

	AbStatisticsHourTemp selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") AbStatisticsHourTemp record,
			@Param("example") AbStatisticsHourTempExample example);

	int updateByExample(@Param("record") AbStatisticsHourTemp record,
			@Param("example") AbStatisticsHourTempExample example);

	int updateByPrimaryKeySelective(AbStatisticsHourTemp record);

	int updateByPrimaryKey(AbStatisticsHourTemp record);

	List<AbStatisticsHourTemp> selectByCondition(AbStatisticsHourTemp record);
	//后加
	List<AbStatisticsHourTemp> selectByCondition1(AbStatisticsHourTemp record);
		
	List<AbStatisticsHourTemp> selectByConditionOfAngect(AbStatisticsHourTemp record);
	
	List<AbStatisticsHourTemp> queryByHour(AbStatisticsHourTemp record);
	
	List<AbStatisticsHourTemp> queryByHourOfAgent(@Param("record")AbStatisticsHourTemp record);

	AbStatisticsHourTemp advertisingCostsToday(@Param("ids") List<AbAdver> ids);

	List<AbStatisticsHourTemp> advertisingByHourYesterday(@Param("ids") List<AbAdver> ids);

	List<AbStatisticsHourTemp> queryByAdTitelYesterday(AbStatisticsHourTemp record);
	List<AbStatisticsHourTemp> queryByConditionsUserId(AbStatisticsHourTemp record);
	
	List<String> getDistinctAppName();

}