package ad.service.AS_.DeService;

import java.util.List;

import ad.bean.AS_.AgentBean.BTListIncome;
import ad.bean.AS_.AgentBean.SubAgentProxyDe;
import ad.util.Page;

public interface SubAgentProxyService {
	
	public Page selectsubagentprode(int pageSize, int page ,Integer id , String starttime , String endtime);
	
	/**
	 * 广告饼图
	 * @param Start_date
	 * @param End_date
	 * @param id
	 * @return
	 */
	public List<BTListIncome> selectIncomeBT(String Start_date ,String End_date ,Integer id);
	
	/**
	 * 查询时间段内广告收益
	 * @param Start_date
	 * @param End_date
	 * @param id
	 * @return
	 */
	Float selectAllProIncomeByIdAndTimes(String Start_date ,String End_date ,Integer id);
	
}
