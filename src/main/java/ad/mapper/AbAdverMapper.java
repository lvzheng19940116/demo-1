package ad.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import ad.bean.AbAdver;
import ad.bean.AbAdverExample;
import ad.bean.AbProxyUser;
import ad.bean.AbStatisticsHourTemp;

public interface AbAdverMapper {
	long countByExample(AbAdverExample example);

	int deleteByExample(AbAdverExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(AbAdver record);

	int insertSelective(AbAdver record);

	List<AbAdver> selectByExampleWithRowbounds(AbAdverExample example, RowBounds rowBounds);

	List<AbAdver> selectByExample(AbAdverExample example);

	AbAdver selectByPrimaryKey(Integer id);

	AbAdver selectBykey(Integer id);

	int updateByExampleSelective(@Param("record") AbAdver record, @Param("example") AbAdverExample example);

	int updateByExample(@Param("record") AbAdver record, @Param("example") AbAdverExample example);

	int updateByPrimaryKeySelective(AbAdver record);

	int updateByPrimaryKey(AbAdver record);

	AbAdver selectMaxId();

	List<AbAdver> selectByPage(AbAdver record);
	//后加
	List<AbAdver> selectByPage1(AbAdver record);


	long selecTotal(AbAdver record);

	List<AbAdver> getAdverIdList();

	List<AbAdver> queryByAdvertiserId(@Param("strAdver") String str);

	List<AbAdver> listAbAdver(AbAdver record);

	int selectIsGetAdver(AbAdver been);

	AbAdver getByName(AbAdver been);

	Integer getByNameCount(AbAdver been);
	
	//modified by caiqp   user4广告汇总
	List<AbAdver> queryByProxyUserId(@Param("ids")List<AbProxyUser> proxyUserId);
	List<AbAdver> queryByUserId(@Param("userId")String userId);
	List<AbAdver> selectByProxyUserId(@Param("proxyId") String proxyUserId);
	//得到abproxyuser中的id
	String getId(@Param("userId")String userId);
	List<AbAdver> getAdverCount(@Param("userId")String userId);
	List<AbStatisticsHourTemp> getAdverMoney(@Param("ids")String[] ids,@Param("userId")String userId);
	
}