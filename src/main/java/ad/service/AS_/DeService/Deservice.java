package ad.service.AS_.DeService;

import java.util.List;


import ad.bean.AbReveOrder;
import ad.bean.AbReveOrderExample;
import ad.bean.AS_.AgentBean.AgentRankings;
import ad.bean.AS_.DE.DeAllasTitle;
import ad.bean.AS_.IncomeBean.IncomeRankings;
import ad.util.Page;

public interface Deservice {
	
 
	List<DeAllasTitle> selectDeAllBytime(String creattime,String endtime);
	 
	Page IncomequeryForPageSelectAllDe(int pageSize, int page, int userid);
	 
	Page AgentqueryForPageSelectAllDe(int pageSize, int page ,int userid);
	
	
	Page IncomequeryForPageSelectAllDeOnTheTime(int pageSize, int page,String createtime,String endetime,int  usid );
	 
	Page AgentqueryForPageSelectAllDeOnTheTime(int pageSize, int page,String createtime,String endetime,int  usid );
	
	Integer selectidBytyid(String usid);
	Integer selectcynum(int id);
	
	List<IncomeRankings> selectIncomeTop10(String createtime,String endetime,int usid);
	
	List<AgentRankings> selectAgentTop10(String createtime,String endetime,int usid);
	
	Float selectEarnings (String createtime,String endetime,int usid);

	List<DeAllasTitle> selectIncomeDeAll(Integer userID);

	List<DeAllasTitle> selectAgentDeAll(Integer userID);
	
}
