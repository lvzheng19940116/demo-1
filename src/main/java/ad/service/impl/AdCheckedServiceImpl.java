package ad.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import ad.bean.AbAdver;
import ad.mapper.AbAdverMapper;
import ad.service.IAdCheckedService;
import ad.service.IAdvertisingManService;
import ad.util.MessageUtils;

@Service
public class AdCheckedServiceImpl implements IAdCheckedService {
	
	@Autowired
	private AbAdverMapper abAdverMapper;
	@Autowired
	private IAdvertisingManService iAdvertisingManService;

	/**
	 * 审核通过处理
	 */
	@Override
	public String updateByIdOfStatusYes(AbAdver been) {
		try {
			Calendar instance = Calendar.getInstance();
			instance.set(Calendar.HOUR_OF_DAY, 0);
			instance.set(Calendar.MINUTE, 0);
			instance.set(Calendar.SECOND, 0);
			long currentTime = instance.getTime().getTime();

			// 判断审核通过，是待上线，还是上线
			AbAdver beenResult = abAdverMapper.selectByPrimaryKey(been.getId());
			Date startTime = beenResult.getStartTime();
			long startDateLongValue = startTime.getTime();

			if (currentTime >= startDateLongValue) {
				been.setStatus(1);
			} else if (currentTime < startDateLongValue) {
				been.setStatus(3);
			}
			int code = abAdverMapper.updateByPrimaryKeySelective(been);
			return MessageUtils.commonReturnMessage(code, "success");
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "fail");
		}
	}
	
	/**
	 * 审核不通过
	 */
	@Override
	public String updateByIdOfStatus(AbAdver been) {
		try {
			int code = abAdverMapper.updateByPrimaryKeySelective(been);
			return MessageUtils.commonReturnMessage(code, "success");
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "fail");
		}
	}
}
