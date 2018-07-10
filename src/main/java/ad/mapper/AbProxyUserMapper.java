package ad.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import ad.bean.AbProxyUser;
import ad.bean.AbProxyUserExample;

public interface AbProxyUserMapper {
	long countByExample(AbProxyUserExample example);

	int deleteByExample(AbProxyUserExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(AbProxyUser record);

	int insertSelective(AbProxyUser record);

	List<AbProxyUser> selectByExampleWithRowbounds(AbProxyUserExample example, RowBounds rowBounds);

	List<AbProxyUser> selectByExample(AbProxyUserExample example);

	//查询一共多少条数据的方法
	AbProxyUser selectNum();

	//按着主键查询
	AbProxyUser selectByPrimaryKey(Integer id);

	AbProxyUser queryByProxyName(@Param("proxyName") String proxyName);

	// 按着手机号码查询
	AbProxyUser queryByProxyPhone(@Param("proxyPhone") String proxyPhone);

	//按着邮箱查询
	AbProxyUser queryByProxyEmail(@Param("proxyEmail") String proxyEmail);

	// 初始加载代理用户全部数据
	List<AbProxyUser> select(@Param("abProxyUser") AbProxyUser abProxyUser);

	//条件查询
	List<AbProxyUser> queryProxyList(@Param("abProxyUser") AbProxyUser abProxyUser);
	//按着条件查询
	List<AbProxyUser> exportQueryProxyList(@Param("abProxyUser") AbProxyUser abProxyUser);

	List<AbProxyUser> queryRevenueChartsList(@Param("time0") String time0, @Param("time1") String time1);

	Integer getNewAddProxy(@Param("yesterday") String yesterday);
	
	Integer selectMax();

	//获取下线列表
	List<AbProxyUser> queryDownProxyList(@Param("abProxyUser") AbProxyUser abProxyUser);

	List<AbProxyUser> queryUpperList(@Param("agencyLevel") int agencyLevel);

	int updateByExampleSelective(@Param("record") AbProxyUser record, @Param("example") AbProxyUserExample example);

	int updateByExample(@Param("record") AbProxyUser record, @Param("example") AbProxyUserExample example);

	//代理修改
	int updateByPrimaryKeySelective(AbProxyUser record);
	
	//修改下线人数信息增加
	int updateByPrimaryId(AbProxyUser record);

	//删除代理方法
	int deleteByPrimaryId(@Param("id") String id);

	//修改下线人数信息减少
	int updateByPrimaryID(AbProxyUser record);

	int updateByPrimaryKey(AbProxyUser record);

	List<AbProxyUser> selectFirstlevel(AbProxyUser abProxyUser);

	long queryTotal();

	List<AbProxyUser> selectAgentLevelFirst();

	List<AbProxyUser> selectAgentLevelTwo();

	List<AbProxyUser> selectAgentLevelThree();

	List<AbProxyUser> selectByInId(@Param("ids") String id);

	List<AbProxyUser> queryAllProxyUser();

	Integer selectAbProxyUserByProxyName(@Param("proxyname") String proxyname);

	List<AbProxyUser> selectMenu();
	
	List<AbProxyUser>  selectAgentByCy(@Param("cy") Integer cy);
	
	AbProxyUser queryAnge(@Param("abProxyUser")AbProxyUser aProxyUser);
	
	List<AbProxyUser> queryAngeList(@Param("abProxyUser")AbProxyUser abProxyUser);
	
	AbProxyUser selectAnge(@Param("abProxyUser")AbProxyUser aProxyUser);
	
	List<AbProxyUser> selectProxyUser();

	/**
	 * 根据userid得到代理级别
	 * @param userId
	 * @author caiqp
	 * @return
	 */
	String compareAgentLevel(@Param("userId")String userId);

}