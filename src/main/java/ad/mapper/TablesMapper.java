package ad.mapper;

import org.apache.ibatis.annotations.Param;

import ad.bean.Tables;

public interface TablesMapper {
	
	Tables selectTableName(@Param("tableName")String tableName);
	Integer selectMaxId();
	Integer selectMaxIdByAbAdver();
}