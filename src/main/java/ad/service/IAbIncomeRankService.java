package ad.service;

import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletResponse;

public interface IAbIncomeRankService  {

	public String queryRevenueChartsList(String completeDate);
	public String queryRevenueChartsList1(String completeDate,int type);
	public void downLoadRevenueChartsList(HttpServletResponse response,Integer type,String completeDate) throws FileNotFoundException;
	public void downLoadRevenueChartsList1(HttpServletResponse response,Integer type,String completeDate) throws FileNotFoundException;
}
