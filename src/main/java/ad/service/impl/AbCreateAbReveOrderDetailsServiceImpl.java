package ad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ad.mapper.AbCreateAbReveOrderDetailsMapper;
import ad.service.IAbCreateAbReveOrderDetailsService;


@Service
public class AbCreateAbReveOrderDetailsServiceImpl implements IAbCreateAbReveOrderDetailsService{

	@Autowired
	AbCreateAbReveOrderDetailsMapper abCreateAbReveOrderDetailsMapper;
	@Override
	public void createAbReveOrderDetails(String tableTime){
		abCreateAbReveOrderDetailsMapper.createAbReveOrderDetails(tableTime);
	}
}
