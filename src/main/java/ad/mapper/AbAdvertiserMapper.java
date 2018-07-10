package ad.mapper;

import ad.bean.AbAdvertiser;
import ad.bean.AbAdvertiserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AbAdvertiserMapper {
	long countByExample(AbAdvertiserExample example);

	int deleteByExample(AbAdvertiserExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(AbAdvertiser record);

	int insertSelective(AbAdvertiser record);

	AbAdvertiser selectMaxId();

	AbAdvertiser selectByAdvertiserId(@Param("advertiserId") String advertiserId);

	List<AbAdvertiser> selectByCondtionAll(AbAdvertiser abAdvertiser);

	List<AbAdvertiser> selectByExampleWithRowbounds(AbAdvertiserExample example, RowBounds rowBounds);

	List<AbAdvertiser> selectAdvertiserIdList();

	long selecTotal();

	List<AbAdvertiser> selectByExample(AbAdvertiserExample example);

	AbAdvertiser selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") AbAdvertiser record, @Param("example") AbAdvertiserExample example);

	int updateByExample(@Param("record") AbAdvertiser record, @Param("example") AbAdvertiserExample example);

	/**
	 * 删除广告
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(AbAdvertiser record);

	int updateByPrimaryKey(AbAdvertiser record);

	AbAdvertiser queryByUserId(AbAdvertiser record);

	AbAdvertiser queryByuserAccount(AbAdvertiser record);

	AbAdvertiser queryByuserAccountId(AbAdvertiser record);

	Integer getByName(AbAdvertiser record);
}