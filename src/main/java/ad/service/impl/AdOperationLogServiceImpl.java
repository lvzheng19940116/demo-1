package ad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ad.bean.AdOperationLog;
import ad.mapper.AdOperationLogMapper;
import ad.service.IAdOperationLogService;

@Service
public class AdOperationLogServiceImpl implements IAdOperationLogService{

	@Autowired
	AdOperationLogMapper adOperationLogMapper;
	
	@Override
	public int insertSelective(AdOperationLog adlog){
		int type = adOperationLogMapper.insertSelective(adlog);
		return type;
	}
}
