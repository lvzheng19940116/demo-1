package ad.service;

import java.util.List;

import ad.bean.AbOrderDetailsAssociated;
import ad.bean.AbReveOrderDetails;

public interface IAbReveOrderDetailsService {

	public AbReveOrderDetails selectByPrimaryKey(AbReveOrderDetails abReveOrderDetail);
	public AbOrderDetailsAssociated selectByorderId(AbOrderDetailsAssociated abOrderDetailsAssociated);
	public List<AbReveOrderDetails> selectAbReveOrderDetailsList(AbReveOrderDetails abReveOrderDetails);
	//查询详细的条数
	public String queryRevenueOrdersDetails(AbReveOrderDetails abReveOrderDetails);
	
}
