package ad.controller;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ad.bean.AbAdver;
import ad.bean.AbReveOrder;
import ad.service.IAbProxyUserService;
import ad.service.IAbReveOrderService;
import ad.service.IAdvertisingManService;

import net.sf.json.JSONSerializer;


/**
 * 报表信息类
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/abReportInfo")
public class AbReportInfoController {

	@Autowired
	private IAdvertisingManService iAdvertisingManService;
	@Autowired
	IAbReveOrderService abReveOrderService;
	@Autowired
	IAbProxyUserService abProxyUserService;
	
	/**
	 * 主查询接口
	 * @param abReveOrder
	 * @param req
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ReportStatistics", produces = {"application/json; charset=utf-8"})
	public String reportStatistics(AbReveOrder abReveOrder,HttpServletRequest req,HttpServletResponse response){
		Map<String,Object> m = new HashMap<String,Object>();
		try{
			/**
			 * 查询
			 */
			String result = abReveOrderService.queryReportStatistics(abReveOrder);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
	/**
	 * 查询广告
	 * @param req
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/GetAdverIdList", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String getAdverIdList(HttpServletRequest req,HttpServletResponse response){
		Map<String,Object> m = new HashMap<String,Object>();
		try{
			/**
			 * 查询所有已上线的并且产生收益的广告
			 */
			List<AbAdver> abAdverList = iAdvertisingManService.getAdverIdList();
			m.put("abAdverList" ,abAdverList);
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
	/**
	 * 查询代理
	 * @param req
	 * @param response
	 * @param adverId
	 * @return
	 */
	@RequestMapping(value = "/GetProxyIdList", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String getProxyIdList(HttpServletRequest req,HttpServletResponse response){
		Map<String,Object> m = new HashMap<String,Object>();
		try{
			/**
			 * 查询所有已上线的并且产生收益的广告所投放的代理
			 */
			List<AbReveOrder> abReveOrderList = abReveOrderService.getProxyIdList();
			m.put("list" ,abReveOrderList);
		}catch(Exception e){
			m.put("code", 0);
			m.put("message", "fail");
			e.printStackTrace();
		}
		return JSONSerializer.toJSON(m).toString();
	}
	/**
	 * 查询应用名称
	 * @param req
	 * @param response
	 * @param proxyId
	 * @param adverId
	 * @return
	 */
	@RequestMapping(value = "/GetAppNameList", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String getAppNameList(HttpServletRequest req,HttpServletResponse response){
		Map<String,Object> m = new HashMap<String,Object>();
		try{
			/**
			 * 查询所有已上线的并且产生广告收益的应用
			 */
			List<AbReveOrder> abReveOrderList = abReveOrderService.getAppNameList();
			m.put("list" ,abReveOrderList);
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
	/**
	 * 按着条件导出(导出excel)
	 * @param req
	 * @param response
	 * @param abProxyUser
	 * @return
	 * @throws FileNotFoundException 
	 * @throws Exception 
	 */
	@RequestMapping(value = "/DownloadReportStatistics", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public void downloadReportStatistics(HttpServletRequest req,HttpServletResponse response,AbReveOrder abReveOrder) throws FileNotFoundException {
		abReveOrderService.downloadReportStatistics(response,abReveOrder);
	}
	
}
