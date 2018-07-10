package ad.service;

import ad.bean.AbBankCard;

public interface IAbBankCardService {
	
	//根据代理ID查询出银行卡信息
	public AbBankCard queryById(int id);
	
	public Integer ResultIntinsertSelective (AbBankCard bankcard);
	
	public Integer ResultupdateByPrimaryByProxyId(AbBankCard bankcard);

}
