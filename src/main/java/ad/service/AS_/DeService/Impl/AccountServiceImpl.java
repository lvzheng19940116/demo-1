package ad.service.AS_.DeService.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ad.bean.AbBankCard;
import ad.bean.AbBillingInfo;
import ad.mapper.AbBankCardMapper;
import ad.mapper.AbBillingInfoMapper;
import ad.service.AS_.DeService.AccountService;
@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AbBankCardMapper bankmapper;
	@Autowired
	private AbBillingInfoMapper billinginfomapper;

	@Override
	public AbBankCard selectByProxyId(Integer userId) {
		AbBankCard bcd = bankmapper.selectByProxyId(userId);
		return bcd;
	}

	@Override
	public List<AbBillingInfo> selectbyuserid(AbBillingInfo abBillingInfo ,int userid) {
		List<AbBillingInfo>  abif = billinginfomapper.selectByAgentId(abBillingInfo,userid);
		return abif;
	}


}
