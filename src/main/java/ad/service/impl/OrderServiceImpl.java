package ad.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import ad.bean.AbAdvertOrder;
import ad.bean.StatusBeen;
import ad.mapper.AbAdvertOrderMapper;
import ad.service.IOrderService;
import ad.util.IdUtil;
import ad.util.MessageUtils;
@Service
public class OrderServiceImpl implements IOrderService{
	@Autowired
	private AbAdvertOrderMapper abAdvertOrderMapper;
	
	/**
	 * 新增广告订单
	 */
	@Override
	public int saveObject(AbAdvertOrder been) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String[] startEndTime = been.getStartEndTime();
		try {
			Date start = sdf.parse(startEndTime[0]);
			Date end = sdf.parse(startEndTime[1]);
			been.setStartTime(start);
			been.setEndTime(end);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int insertSelective = abAdvertOrderMapper.insertSelective(been);
		return insertSelective;
	}

	/**
	 * 修改广告订单
	 */
	@Override
	public int updateByKey(AbAdvertOrder been) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String[] startEndTime = been.getStartEndTime();
		try {
			Date start = sdf.parse(startEndTime[0]);
			Date end = sdf.parse(startEndTime[1]);
			been.setStartTime(start);
			been.setEndTime(end);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int code = abAdvertOrderMapper.updateByPrimaryKeySelective(been);
		return code;
	}

	@Override
	public int deleteByKey(AbAdvertOrder been) {
		been.setDeleteFlag(StatusBeen.DELETE);
		int code = abAdvertOrderMapper.updateByPrimaryKeySelective(been);
		return code;
	}

	@Override
	public List<AbAdvertOrder> queryByPage(AbAdvertOrder been) {
		List<AbAdvertOrder> list = abAdvertOrderMapper.selectByPage(been);
		return list;
	}

	@Override
	public AbAdvertOrder selectMaxId() {
		AbAdvertOrder selectMaxId = abAdvertOrderMapper.selectMaxId();
		return selectMaxId;
	}

	@Override
	public long selecTotal() {
		long total = abAdvertOrderMapper.selecTotal();
		return total;
	}

	/**
	 * 根据主键查询广告订单
	 * @param record
	 * @return
	 */
	@Override
	public AbAdvertOrder querybykey(Integer id) {
		AbAdvertOrder been = abAdvertOrderMapper.selectByPrimaryKey(id);
		return been;
	}
	/**
	 * 根据名称获取广告订单
	 */
	@Override
	public Integer getByName(AbAdvertOrder record) {
		Integer count = abAdvertOrderMapper.getByName(record);
		return count;
	}
	
	/**
	 * 查询订单
	 */
	@Override
	public AbAdvertOrder getByUpdateName(AbAdvertOrder record) {
		AbAdvertOrder newRecord = abAdvertOrderMapper.getByUpdateName(record);
		return newRecord;
	}
	
	//modified by caiqp
	/**
	 * 查询订单数据
	 * @param record
	 * @return
	 */
	@Override
	public String queryAllByPage(AbAdvertOrder record) {
		try {
			record.setPage((record.getPage() - 1) * 10);
			//查询数据
			List<AbAdvertOrder> list = this.queryByPage(record);
			//查询总数
			long total = this.selecTotal();
			return MessageUtils.jsonRetrunListTotalMessage(1, "success", list, total);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "fail");
		}
	}
	
	/**
	 * 新增广告订单
	 * @param record
	 * @return
	 */
	@Override
	public String save(AbAdvertOrder record) {
		try {
			Integer byName = this.getByName(record);
			if (byName != 0) {
				return MessageUtils.commonReturnMessage(2, "订单名称重复，请重新填写。");
			}
			AbAdvertOrder maxId = this.selectMaxId();
			if (maxId == null) {
				String setIdNf = IdUtil.setIdNf("DD", 0);
				record.setOrderId(setIdNf);
			}else{
				String setIdNf = IdUtil.setIdNf("DD", maxId.getId());
				record.setOrderId(setIdNf);
			}
			record.setCreateTime(new Date());
			record.setDeleteFlag(StatusBeen.NORMAL);
			int saveObject = this.saveObject(record);
			return MessageUtils.commonReturnMessage(1, "添加成功");
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "添加失败");
		}
	}
	
	@Override
	public String queryOrderByKey(Integer id) {
		try {
			AbAdvertOrder been = this.querybykey(id);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String[] startEndTime = new String[2];
			startEndTime[0] = sdf.format(been.getStartTime());
			startEndTime[1] = sdf.format(been.getEndTime());
			been.setStartEndTime(startEndTime);
			return MessageUtils.jsonRetrunListMessage(1, "success", been);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "fail");
		}
	}
	
	/**
	 * 删除广告订单
	 * @param record
	 * @return
	 */
	@Override
	public String deleteOrderByKey(AbAdvertOrder record) {
		try {
			int updateByKey = this.deleteByKey(record);
			return MessageUtils.commonReturnMessage(updateByKey, "修改成功");
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "fial");
		}
	}
	
	@Override
	public String updateByAbAdverKey(AbAdvertOrder record) {
		try {
			//根据主键查询广告订单
			AbAdvertOrder querybykey = this.querybykey(record.getId());
			if (record.getOrderName().equals(querybykey.getOrderName())) {
				int updateByKey = this.updateByKey(record);
				return MessageUtils.commonReturnMessage(updateByKey, "修改成功");
			}else{
				//根据名称获取广告订单
				Integer byName = this.getByName(record);
				if (byName != 0) {
					return MessageUtils.commonReturnMessage(2, "订单名称重复，请重新填写。");
				}
				int updateByKey = this.updateByKey(record);
				return MessageUtils.commonReturnMessage(updateByKey, "修改成功");
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "fail");
		}
	}

}
