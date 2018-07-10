package ad.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ad.bean.AdUser;
import ad.mapper.AdUserMapper;
import ad.service.IAdUserSevice;
@Service
public class AdUserSeviceImpl implements IAdUserSevice {
	@Autowired
	private AdUserMapper  adUserMapper;


	@Override
	public AdUser queryById(int id) {
		AdUser selectByPrimaryKey = adUserMapper.selectByPrimaryKey(id);

		return selectByPrimaryKey;
	}
	

	

}
