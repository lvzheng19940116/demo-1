package ad.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import ad.bean.AbAdver;
import ad.bean.AbAdvertiser;
import ad.bean.StatusBeen;
import ad.service.IAbAdvertiserService;
import ad.service.IAdvertisingManService;
import ad.util.Constends;
import ad.util.DateUtil;
import ad.util.DesCrypt;
import ad.util.HttpConnection;
import ad.util.IdUtil;
import ad.util.MessageUtils;
import ad.util.sixNum;

/*
 * 广告主管理
 */
@RestController
@RequestMapping("/adver")
public class AbAdvertiserController {

	@Autowired
	private IAbAdvertiserService iAbAdvertiserService;

	@Autowired
	private IAdvertisingManService iAdvertisingManService;

	/**
	 * 添加广告主
	 * 
	 * @param record
	 * @param req
	 * @param map
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/AddAdvertiser", produces = { "application/json; charset=utf-8" }, method = {
			RequestMethod.GET, RequestMethod.POST })
	public String saveObject(AbAdvertiser record, HttpServletRequest req) {
		return iAbAdvertiserService.saveAbAdvertiserObject(record, req);
	}

	/**
	 * 查询分页
	 * 
	 * @param record
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/QueryAdvertiserList", produces = { "application/json; charset=utf-8" })
	public String queryList(AbAdvertiser record) {
		return iAbAdvertiserService.queryAbAdvertiserList(record);
	}

	/**
	 * 修改广告主
	 * 
	 * @param record
	 * @param req
	 * @param map
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/UpdateAdvertiser", produces = { "application/json; charset=utf-8" })
	public String updateObject(AbAdvertiser record, HttpServletRequest req) {
		return iAbAdvertiserService.updateAbAdvertiserObject(record, req);
	}

	/**
	 * 删除广告主
	 * 
	 * @param record
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/DeleteAdvertiser", produces = { "application/json; charset=utf-8" })
	public String deleteObject(AbAdvertiser record) {
		return iAbAdvertiserService.deleteAbAdvertiserObject(record);
	}

	/**
	 * 查询广告主,广告id
	 * 
	 * @param record
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/queryAdvertiserIdList", produces = { "application/json; charset=utf-8" })
	public String queryAdvertiserIdList(AbAdvertiser record) {
		try {
			List<AbAdvertiser> queryAdvertiserIdList = iAbAdvertiserService.queryAdvertiserIdList();
			return MessageUtils.jsonRetrunListMessage(1, "success", queryAdvertiserIdList);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "查询广告主列表失败");
		}
	}

}
