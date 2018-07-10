package ad.service;

import java.util.List;

import ad.bean.AbAdver;
import ad.bean.AbProxyUser;
import ad.bean.AbStatisticsHourTemp;

public interface IAdvertisingManService {

	int saveObject(AbAdver been);

	int deleteByKey(AbAdver been);

	AbAdver queryBykey(Integer id);

	int updateBykey(AbAdver been);
	
	AbAdver checkAdverPrice(Integer id);

	AbAdver selectMaxId();

	List<AbAdver> selectByPage(AbAdver been);
	
	List<AbAdver> selectByPage1(AbAdver been);

	long selectTotal(AbAdver been);

	//查询广告
	List<AbAdver> getAdverIdList();

	List<AbAdver> queryByAdvertiserId(String id);
	
	//modified by caiqp
	List<AbAdver> queryByProxyUserId(List<AbProxyUser> proxyUserId);
	List<AbAdver> queryByUserId(String userId);
	List<AbAdver> selectByProxyUserId(String proxyUserId);

	List<AbAdver> listAbAdver(AbAdver been);

	int selectIsGetAdver(AbAdver been);

	AbAdver getByName(AbAdver been);

	Integer getNameCount(AbAdver been);
	
	//modified by caiqp
	String queryByPage(AbAdver been);
	String addAdverInfo(AbAdver been);
	String queryAbAdverByKey(Integer id);
	String updateAbAdverByKey(AbAdver been);
	String selectByKey(Integer id);
	String deleteAbAdverByKey(AbAdver been);
	String checkStartEndTime(String startEndTime);
	String checkAdUnitPrice(String billingMethodWay, Integer id, Integer flag);
	String checkAdverPrice(String totalAdverPrice,Integer id);
	String checkUpdateAdverTitle(AbAdver been,Integer id);
}
