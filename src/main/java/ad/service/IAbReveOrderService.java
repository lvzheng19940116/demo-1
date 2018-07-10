package ad.service;

import java.io.FileNotFoundException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import ad.bean.AbBankCard;
import ad.bean.AbReveOrder;
import ad.bean.AbReveOrderDetails;
import ad.bean.AS_.AgentBean.BTListAgent;
import ad.bean.AS_.AgentBean.DayProxyAll;

public interface IAbReveOrderService {
	
	public List<AbReveOrder> select(AbReveOrder abReveOrder);
	public AbReveOrder selectNum();
	public AbBankCard selectBankNumber(Integer proxyId);
	public String queryRevenueOrdersList(AbReveOrder abReveOrder);
	public Float selectCurrentIncome(AbReveOrder abReveOrder);
	public Float getNewAddIncome(String yesterday,Integer adverId,Integer proxyId,String appName);
	public Float getAllIncome(Integer adverId,Integer proxyId,String appName);
	public Float selectProfitNum(String starttime ,String endtime ,Integer id);
	public List<AbReveOrder> selectCurrentList(String time0,String time1);
	public List<AbReveOrder> getProxyIdList();
	public List<AbReveOrder> getAppNameList();
	public List<BTListAgent> selectAgentAllByProidOrAndTimes(String starttime ,String endtime ,Integer id);
	public List<BTListAgent> selectAgentAllByProidOrAndTimesNoTen (String starttime ,String endtime ,Integer id);
	public Float selectOwnProByProidOrAndTime(String starttime ,String endtime ,Integer id);
	public Float selectOwnAndSubAgentProByProidOrAndTime(String starttime ,String endtime ,Integer id);
	public List<AbReveOrder> reportStatistics(Integer adverId,Integer proxyId,String appName,String startTime,String endTime);
	public List<AbReveOrder> reportStatisticsList(Integer adverId,Integer proxyId,String appName,String startTime,String endTime,Integer page);
	public List<AbReveOrder> downloadReportStatistics(Integer adverId,Integer proxyId,String appName,String startTime,String endTime);
	public List<AbReveOrder> sortByProxyId(String startTime,String endTime);
	public List<AbReveOrderDetails> sortByProxyIdOfToday(String today,String tableName);
	public List<AbReveOrderDetails> sortByAdverIdOfToday(String today,String tableName);
	public List<AbReveOrderDetails> sortByAppNameOfToday(String today,String tableName);
	public List<AbReveOrder> sortByAdverId(String startTime,String endTime);
	public List<AbReveOrder> sortByAppName(String startTime,String endTime);
	public List<DayProxyAll> AgentProDayALL(String Start_date ,String End_date ,Integer id,String type );
	public String queryRevenueOrdersAllList(AbReveOrder abReveOrder);
	public String queryReportStatistics(AbReveOrder abReveOrder);
	public void downloadReportStatistics(HttpServletResponse response,AbReveOrder abReveOrder) throws FileNotFoundException;
}
