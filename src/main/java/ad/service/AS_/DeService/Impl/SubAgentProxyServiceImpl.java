package ad.service.AS_.DeService.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ad.bean.AS_.AgentBean.BTListIncome;
import ad.bean.AS_.AgentBean.SubAgentProxyDe;
import ad.mapper.AS_.SubAgentsProxyMapper;
import ad.service.AS_.DeService.SubAgentProxyService;
import ad.util.Page;


@Service
public class SubAgentProxyServiceImpl implements SubAgentProxyService{

	@Autowired
	private SubAgentsProxyMapper subagentmapper ;

	@Override
	public Page selectsubagentprode(int pageSize, int page, Integer id, String starttime, String endtime) {
		Integer allRow =subagentmapper.selectSubAgentProxyDeCountByIdAndTime(id, starttime, endtime);
		System.out.println("广告的总记录数是："+allRow);
		int totalPage = Page.countTatalPage(pageSize,Integer.parseInt(allRow+"")); // 总页数
		final int offset = Page.countOffset(pageSize, page); // 当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = Page.countCurrentPage(page); // 当前页
		
		List<SubAgentProxyDe> list = subagentmapper.selectSubAgentProxyDeByIdAndTime(offset, length,id, starttime, endtime);		
		System.out.println(list.size()+"wwwwwwwwwwwwwwwwwwwwww");
		Page pm = new Page();
		pm.setPageSize(pageSize);
		pm.setCurrentPage(currentPage);
		pm.setAllRow(Integer.parseInt(allRow+""));
		pm.setTotalPage(totalPage);
		pm.setList(list);
		//pm.init();
		return pm;
	}

	@Override
	public List<BTListIncome> selectIncomeBT(String Start_date, String End_date, Integer id) {
		List<BTListIncome> list = subagentmapper.selectIncomeProAllByIdAndTimes(Start_date, End_date, id);
		return list;
	}

	@Override
	public Float selectAllProIncomeByIdAndTimes(String Start_date, String End_date, Integer id) {
		Float flt = subagentmapper.selectTimesAllProIncomeByIdAndTimes(Start_date, End_date, id);
		return flt;
	}

	


	

	
	
	
}
