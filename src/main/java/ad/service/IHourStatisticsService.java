package ad.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import ad.bean.AbAdver;
import ad.bean.AbProxyUser;
import ad.bean.AbStatisticsHourTemp;

public interface IHourStatisticsService {

	List<AbStatisticsHourTemp> queryByConditions(AbStatisticsHourTemp been);

	List<AbStatisticsHourTemp> queryByHour(AbStatisticsHourTemp been);
	
	List<AbStatisticsHourTemp> queryByHourOfAgent(AbStatisticsHourTemp been);
	
	List<AbStatisticsHourTemp> selectByConditionOfAngect(AbStatisticsHourTemp been);
	
	List<AbProxyUser> queryAngeList(AbProxyUser abProxyUser);

	AbStatisticsHourTemp advertisingCostsToday(List<AbAdver> queryByAdvertiserId);

	List<AbStatisticsHourTemp> advertisingByHourYesterday(List<AbAdver> queryByAdvertiserId);

	List<AbStatisticsHourTemp> queryByAdTitel(AbStatisticsHourTemp been);

	List<AbStatisticsHourTemp> queryByConditionsUserId(AbStatisticsHourTemp been);
	
	//modified by caiqp
	String dayStatisticsList(AbStatisticsHourTemp been);
	void exportExcell(AbStatisticsHourTemp been, HttpServletResponse response);
	String hourStatisticsList(AbStatisticsHourTemp been);
	void downLoadStatisticsHour(AbStatisticsHourTemp been, HttpServletResponse response);
	String AngleHourStatisticsList(AbStatisticsHourTemp been);
	void downLoadAgentStatisticsHour(AbStatisticsHourTemp been, HttpServletResponse response);
	String statisticsDayOfAngent(AbStatisticsHourTemp been);
	void downLoadStatisticsDayOfAngent(AbStatisticsHourTemp been, HttpServletResponse response);
}
