package ad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ad.bean.AbStatisticsHourTemp;
import ad.mapper.AbStatisticsHourTempMapper;
import ad.service.AdStatisticsDayService;

@Service
public class AdStatisticsDayServiceImpl implements AdStatisticsDayService {

	@Autowired
	private AbStatisticsHourTempMapper abStatisticsHourTempMapper;

	@Override
	public List<AbStatisticsHourTemp> queryByConditions1(AbStatisticsHourTemp been) {
		List<AbStatisticsHourTemp> list = abStatisticsHourTempMapper.selectByCondition1(been);
		return list;
	}

}
