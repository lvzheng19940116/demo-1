package ad.service;

import java.util.Map;

import ad.bean.AbAdvertiser;
import ad.bean.AbStatisticsHourTemp;

public interface IAngeAdCountedAllService {

	String getTopMessage(String userId);
	
	//modified by caiqp 
	String queryAngeAdCountAll(AbAdvertiser record);
	String angeAdCountedAllByTitel(AbStatisticsHourTemp been);
	String queryAngeAdCountAllProxy(AbAdvertiser record);
	String angeAdCountedAllByTitelProxy(AbStatisticsHourTemp been);
}
