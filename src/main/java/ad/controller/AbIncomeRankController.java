package ad.controller;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ad.service.IAbIncomeRankService;
import ad.service.IAbProxyUserService;
import ad.service.IAbReveOrderService;

import net.sf.json.JSONSerializer;

/**
 * 收益排行榜Controller类
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/abIncomeRank")
public class AbIncomeRankController {

	@Autowired
	IAbProxyUserService abProxyUserService;
	@Autowired
	IAbReveOrderService abReveOrderService;
	@Autowired
	IAbIncomeRankService abIncomeRankService;
	
	/**下线数量和金额排行榜(较快)
	 * 
	 * @param req
	 * @param response
	 * @param type
	 * @param completeDate
	 * @return
	 */
	@RequestMapping(value = "/QueryRevenueChartsList", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String QueryRevenueChartsList(HttpServletRequest req,HttpServletResponse response,String completeDate) {
		Map<String,Object> m = new HashMap<String,Object>();
		try{
			String result = abIncomeRankService.queryRevenueChartsList(completeDate);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
	
	/**下线数量和金额排行榜
	 * 
	 * @param req
	 * @param response
	 * @param type
	 * @param completeDate
	 * @return
	 */
	@RequestMapping(value = "/QueryRevenueChartsList1", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String QueryRevenueChartsList1(HttpServletRequest req,HttpServletResponse response,int type,String completeDate) {
		Map<String,Object> m = new HashMap<String,Object>();
		try{
			String result = abIncomeRankService.queryRevenueChartsList1(completeDate,type);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
	/**
	 * 导出excel
	 * @param req
	 * @param response
	 * @param type
	 * @param completeDate
	 */
	@RequestMapping(value = "/DownLoadRevenueChartsList", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public void downLoadRevenueChartsList(HttpServletRequest req,HttpServletResponse response,Integer type,String completeDate) throws FileNotFoundException{
		abIncomeRankService.downLoadRevenueChartsList(response,type,completeDate);
	}
	/**
	 * 导出excel
	 * @param req
	 * @param response
	 * @param type
	 * @param completeDate
	 */
	@RequestMapping(value = "/DownLoadRevenueChartsList1", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public void downLoadRevenueChartsList1(HttpServletRequest req,HttpServletResponse response,Integer type,String completeDate) throws FileNotFoundException{
		abIncomeRankService.downLoadRevenueChartsList1(response,type,completeDate);
	}
}
