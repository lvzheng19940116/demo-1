package ad.service;

import ad.bean.AbBillingCycle;

public interface IAbBillingCycleService {
	
	public AbBillingCycle select();
	public AbBillingCycle selectByPrimaryKey(int id);
	public int insertSelective(AbBillingCycle abBillingCycle); 
	public int updateByPrimaryKeySelective(AbBillingCycle abBillingCycle);
	public String updateBillingCycle(AbBillingCycle abBillingCycle);
	
	//返回代理级别  modified by caiqp
	public String getAgentNumber();
}
