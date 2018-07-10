package ad.service.AS_.DeService;

import java.util.List;

import ad.bean.AbBankCard;
import ad.bean.AbBillingInfo;

public interface AccountService {

	 AbBankCard selectByProxyId(Integer userId);
	
	 List<AbBillingInfo>  selectbyuserid(AbBillingInfo abBillingInfo,int userid);
}
