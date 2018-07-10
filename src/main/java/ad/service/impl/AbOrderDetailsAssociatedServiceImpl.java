package ad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ad.bean.AbAdvertProxyAssociation;
import ad.mapper.AbAdvertProxyAssociationMapper;
import ad.service.IAbOrderDetailsAssociatedService;

@Service
public class AbOrderDetailsAssociatedServiceImpl implements IAbOrderDetailsAssociatedService{

	@Autowired
	AbAdvertProxyAssociationMapper abAdvertProxyAssociationMapper;
	
	@Override
	public AbAdvertProxyAssociation selectAbAdvertProxy(AbAdvertProxyAssociation abAdvertProxyAssociation){
		AbAdvertProxyAssociation abAdvertProxy=abAdvertProxyAssociationMapper.selectAbAdvertProxy(abAdvertProxyAssociation);
		return abAdvertProxy;
	}
}
