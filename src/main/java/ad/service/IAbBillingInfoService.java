package ad.service;

import java.util.List;

import ad.bean.AbBillingInfo;

public interface IAbBillingInfoService {
	
	public List<AbBillingInfo> select(AbBillingInfo abBillingInfo);
	//结算信息查询接口
	public String queryBillingInformationList(AbBillingInfo abBillingInfo);
	public int updateByPrimaryKeySelective(AbBillingInfo abBillingInfo);
	public Float setCumulativeIncome(int id);
	//结算记录查询所有数据的接口
	public String queryBillingAllInformationList(AbBillingInfo abBillingInfo);
	//结算数据管理转账和完成
	public String transferCompleted(String ids,String flag);
}
