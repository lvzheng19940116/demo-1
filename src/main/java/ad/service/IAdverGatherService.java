package ad.service;

import ad.bean.AbAdvertiser;
import ad.bean.AbStatisticsHourTemp;

public interface IAdverGatherService {

	String getAdGather(AbAdvertiser record);
	
	String queryByAdTitelYesterDay(AbStatisticsHourTemp been);
}
