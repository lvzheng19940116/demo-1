package ad.service;

import java.util.List;

import ad.bean.AbAdvertOrder;

public interface IOrderService {
	int saveObject(AbAdvertOrder been);
	int updateByKey(AbAdvertOrder been);
	int deleteByKey(AbAdvertOrder been);
	List<AbAdvertOrder> queryByPage(AbAdvertOrder been);
	AbAdvertOrder querybykey(Integer id);
	long selecTotal();
	AbAdvertOrder selectMaxId();
	Integer getByName(AbAdvertOrder record);
	AbAdvertOrder getByUpdateName(AbAdvertOrder record);
	
	//modified by caiqp
	String queryAllByPage(AbAdvertOrder record);
	String save(AbAdvertOrder record);
	String queryOrderByKey(Integer id);
	String deleteOrderByKey(AbAdvertOrder record);
	String updateByAbAdverKey(AbAdvertOrder record);
}
