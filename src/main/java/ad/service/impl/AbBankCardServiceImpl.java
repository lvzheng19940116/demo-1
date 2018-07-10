package ad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ad.bean.AbBankCard;
import ad.mapper.AbBankCardMapper;
import ad.service.IAbBankCardService;
@Service
public class AbBankCardServiceImpl implements IAbBankCardService {

	@Autowired
	AbBankCardMapper abBankCardMapper;
	
	/**
	 * 根据代理ID查询出银行卡信息
	 */
	@Override
	public AbBankCard queryById(int id){
		//根据代理ID查询出银行卡信息
		AbBankCard abBankCard = abBankCardMapper.selectByProxyId(id);
		return abBankCard;
	}


	@Override
	public Integer ResultIntinsertSelective(AbBankCard bankcard) {
		Integer i =abBankCardMapper.insertSelective(bankcard);
		return i;
	}


	@Override
	public Integer ResultupdateByPrimaryByProxyId(AbBankCard bankcard) {
		Integer result = abBankCardMapper.updateByPrimaryByProxyId(bankcard);
		return result;
	}
}
