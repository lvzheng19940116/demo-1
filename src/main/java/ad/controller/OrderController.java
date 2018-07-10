package ad.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ad.bean.AbAdvertOrder;
import ad.bean.StatusBeen;
import ad.service.IOrderService;
import ad.util.IdUtil;
import ad.util.MessageUtils;

/**
 * 广告订单管理
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("order")
public class OrderController {
	@Autowired
	private IOrderService iOrderService;

	@RequestMapping(value = "/CheckOrderName", produces = { "application/json; charset=utf-8" })
	public String checkOrderName(AbAdvertOrder record) {
		Integer byName = iOrderService.getByName(record);
		if (byName != 0) {
			return MessageUtils.commonReturnMessage(1, "订单名称重复，请重新填写。");
		}else{
			return MessageUtils.commonReturnMessage(2, "订单名称可以使用。");
		}
	}
	
	/**
	 * 判断订单名称是否重复
	 * @param record
	 * @param oldOrderName
	 * @return
	 */
	@RequestMapping(value = "/UpdateCheckOrderName", produces = { "application/json; charset=utf-8" })
	public String UpdateCheckOrderName(AbAdvertOrder record,String oldOrderName) {
		//查询订单
		AbAdvertOrder newRecord = iOrderService.getByUpdateName(record);
		if (newRecord != null && !newRecord.getOrderId().endsWith(oldOrderName)) {
			return MessageUtils.commonReturnMessage(1, "订单名称重复，请重新填写。");
		}else{
			return MessageUtils.commonReturnMessage(2, "订单名称可以使用。");
		}
	}
	
	/**
	 * 新增广告订单
	 * @param record
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/AddAdverOrder", produces = { "application/json; charset=utf-8" })
	public String save(AbAdvertOrder record) {
		return iOrderService.save(record);
	}

	/**
	 * 查询订单数据
	 * @param record
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/QueryAdverOrderList", produces = { "application/json; charset=utf-8" })
	public String queryAllByPage(AbAdvertOrder record) {
		return iOrderService.queryAllByPage(record);
	}

	/**
	 * 根据主键查询广告订单
	 * @param record
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/UpdateAdverOrder", produces = { "application/json; charset=utf-8" })
	public String updateByKey(AbAdvertOrder record) {
		return iOrderService.updateByAbAdverKey(record);
	}

	/**
	 * 删除广告订单
	 * @param record
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/DeleteAdvertOrder", produces = { "application/json; charset=utf-8" })
	public String deleteByKey(AbAdvertOrder record) {
		return iOrderService.deleteOrderByKey(record);
	}

	@Transactional
	@RequestMapping(value = "/queryByKey", produces = { "application/json; charset=utf-8" })
	public String queryByKey(Integer id) {
		return iOrderService.queryOrderByKey(id);
	}
}
