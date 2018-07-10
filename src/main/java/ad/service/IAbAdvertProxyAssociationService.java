package ad.service;

import java.util.List;

import ad.bean.AbAdvertProxyAssociation;
import ad.bean.AbProxyUser;

public interface IAbAdvertProxyAssociationService {

	int saveObject(AbAdvertProxyAssociation been);

	List<AbAdvertProxyAssociation> queryByAdverId(Integer id);

	int updateByProxyId(AbAdvertProxyAssociation been);

	List<AbAdvertProxyAssociation> queryByPage(AbAdvertProxyAssociation been);

	long selectTotal();

	int updateByKey(AbProxyUser been);
	
	int deleteByAdverId(Integer id);
}
