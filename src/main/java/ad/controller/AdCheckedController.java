package ad.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ad.bean.AbAdver;
import ad.service.IAdCheckedService;
import ad.service.IAdvertisingManService;
import ad.util.MessageUtils;

/**
 * 广告审核
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("check")
public class AdCheckedController {
	@Autowired
	private IAdvertisingManService iAdvertisingManService;
	
	@Autowired
	private IAdCheckedService iAdCheckedService;

	/**
	 * 审核不通过
	 * 
	 * @param been
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/UpdateAdverStatusNO", produces = { "application/json; charset=utf-8" })
	public String updateByIdOfStatus(AbAdver been) {
		// status
		return iAdCheckedService.updateByIdOfStatus(been);
	}

	/**
	 * 审核通过
	 * 
	 * @param been
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/UpdateAdverStatusYes", produces = { "application/json; charset=utf-8" })
	public String updateByIdOfStatusYes(AbAdver been) {
		return iAdCheckedService.updateByIdOfStatusYes(been);
	}

}
