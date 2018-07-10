package ad.service.AS_.DeService.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ad.bean.AbReveOrder;
import ad.bean.AbReveOrderExample;
import ad.bean.AS_.AgentBean.AgentRankings;
import ad.bean.AS_.DE.DeAllasTitle;
import ad.bean.AS_.IncomeBean.IncomeRankings;
import ad.mapper.AbReveOrderMapper;
import ad.service.AS_.DeService.Deservice;
import ad.util.Page;

@Service
public class DeServiceImpl implements Deservice{
	
	@Autowired
	private AbReveOrderMapper abreveordermappers;
	




	@Override
	public List<DeAllasTitle> selectDeAllBytime(String creattime,String endtime) {
		 List<DeAllasTitle>  list =abreveordermappers.selectBytime(creattime,endtime);
		return list;
	}

	@Override
	public Page IncomequeryForPageSelectAllDe(int pageSize, int page , int userid) {
		long allRow = abreveordermappers.getIncomeAllRowCount(userid); // 总记录数
		System.out.println("广告的总记录数是："+allRow);
		int totalPage = Page.countTatalPage(pageSize,Integer.parseInt(allRow+"")); // 总页数
		final int offset = Page.countOffset(pageSize, page); // 当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = Page.countCurrentPage(page); // 当前页
		List<DeAllasTitle> list= abreveordermappers.selectIncomeAllDe(offset, length,userid);
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
	public Page AgentqueryForPageSelectAllDe(int pageSize, int page ,int userid) {
		long allRow = abreveordermappers.getAgentAllRowCount(userid); // 总记录数
		System.out.println("代理的总记录数是"+allRow);
		int totalPage = Page.countTatalPage(pageSize,Integer.parseInt(allRow+"")); // 总页数
		final int offset = Page.countOffset(pageSize, page); // 当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = Page.countCurrentPage(page); // 当前页
		List<DeAllasTitle> list= abreveordermappers.selectAgentAllDe(offset, length,userid);
		System.out.println(list.size()+"mmmmmmmmmmmmmmmm");
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
	public Page IncomequeryForPageSelectAllDeOnTheTime(int pageSize, int page, String createtime, String endetime,int  usid ) {
		long allRow = abreveordermappers.getIncomeAllRowCountOnTime(createtime,endetime,usid); // 总记录数
		System.out.println("广告的总记录数是："+allRow);
		int totalPage = Page.countTatalPage(pageSize,Integer.parseInt(allRow+"")); // 总页数
		final int offset = Page.countOffset(pageSize, page); // 当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = Page.countCurrentPage(page); // 当前页
		List<DeAllasTitle> list= abreveordermappers.selectIncomeAllDeOnTheTime(offset, length,createtime,endetime,usid);
		System.out.println(list.size()+"time----wwwwwwwwwwww");
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
	public Page AgentqueryForPageSelectAllDeOnTheTime(int pageSize, int page, String createtime, String endetime,int usid) {
		long allRow = abreveordermappers.getAgentAllRowCountOnTime(createtime,endetime,usid); // 总记录数
		System.out.println("代理的总记录数是"+allRow);
		int totalPage = Page.countTatalPage(pageSize,Integer.parseInt(allRow+"")); // 总页数
		final int offset = Page.countOffset(pageSize, page); // 当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = Page.countCurrentPage(page); // 当前页
		List<DeAllasTitle> list= abreveordermappers.selectAgentAllDeOnTheTime(offset, length, createtime, endetime,usid);
		System.out.println(list.size()+"time----mmmmmmmmmm");
		Page pm = new Page();
		pm.setPageSize(pageSize);
		pm.setCurrentPage(currentPage);
		pm.setAllRow(Integer.parseInt(allRow+""));
		pm.setTotalPage(totalPage);
		pm.setList(list);
		//pm.init();
		return pm;
	}

	/**
	 * 获取当前代理ID
	 */
	@Override
	public Integer selectidBytyid(String usid) {
		Integer i =abreveordermappers.selectuseridBytyid(usid);
		return i;
	}

	@Override
	public List<IncomeRankings> selectIncomeTop10(String createtime, String endetime, int usid) {
		List<IncomeRankings> incometop = abreveordermappers.selectIncomeTop10(createtime, endetime, usid);
		return incometop;
	}

	@Override
	public List<AgentRankings> selectAgentTop10(String createtime, String endetime, int usid) {
		List<AgentRankings> agenttop = abreveordermappers.selectAgentTop10(createtime, endetime, usid);
		return agenttop;
	}

	@Override
	public Float selectEarnings(String createtime, String endetime, int usid) {
		Float i = abreveordermappers.selectEarnings(createtime, endetime, usid);
		return i;
	}

	@Override
	public Integer selectcynum(int id) {
		Integer num = abreveordermappers.selectCyLevel(id);
		return num;
	}

	@Override
	public List<DeAllasTitle> selectIncomeDeAll(Integer userID) {
		List<DeAllasTitle> list = abreveordermappers.selectIncomeAllDeById(userID);
		return list;
	}

	@Override
	public List<DeAllasTitle> selectAgentDeAll(Integer userID) {
		List<DeAllasTitle> Alist = abreveordermappers.selectAgentAllDeById(userID);
		return Alist;
	}


	
	
	
	
}
