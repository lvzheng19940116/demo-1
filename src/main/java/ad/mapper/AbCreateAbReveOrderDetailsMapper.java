package ad.mapper;

import org.apache.ibatis.annotations.Param;

public interface AbCreateAbReveOrderDetailsMapper {

	void createAbReveOrderDetails(@Param("timeTable")String timeTable);
}
