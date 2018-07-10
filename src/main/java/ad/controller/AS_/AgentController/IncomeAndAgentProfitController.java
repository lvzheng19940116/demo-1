package ad.controller.AS_.AgentController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ad.bean.AS_.pageBean;
import ad.bean.AS_.DE.AgentProfitDetailed;
import ad.bean.AS_.DE.DeAllasTitle;
import ad.bean.AS_.DE.IncomeProfitDetailed;
import ad.service.IIncomeAndAgentProfitService;
import ad.service.LCYIAbProxyUserService;
import ad.service.AS_.DeService.Deservice;
import ad.util.DateUtil;
import ad.util.Excel2007;
import ad.util.GetClassPath;
import ad.util.Page;

import net.sf.json.JSONSerializer;

/**
 * 广告和代理的收益明细
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/IncomeAndAgentProfit")
public class IncomeAndAgentProfitController {
	
	@Autowired
	private Deservice deservices;
	
	@Autowired
	private LCYIAbProxyUserService lcyabuserservice;
	@Autowired
	private IIncomeAndAgentProfitService iIncomeAndAgentProfitService;
	
	/**
	 * 查询几级代理
	 * @param req
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/WhatSerch", produces = { "application/json; charset=utf-8" })
	public Integer WhatSerch(HttpServletRequest req,HttpServletResponse response){
		return iIncomeAndAgentProfitService.WhatSerch(req, response);
	}
	
	
	/**
	 * 广告和代理收益明细导出接口
	 * @param req
	 * @param response
	 * @return
	 * @throws FileNotFoundException 
	 */
	@RequestMapping(value = "/ExportExcelIncomeAandAgent", produces = { "application/json; charset=utf-8" })
	public synchronized void ExportExcelIncomeAandAgent(HttpServletRequest req,HttpServletResponse response) throws FileNotFoundException{
		iIncomeAndAgentProfitService.ExportExcelIncomeAandAgent(req, response);
	}
	
	/**
	 * 区间查询代理收益和广告收益明细
	 * @param req
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/IncomeDetails", produces = { "application/json; charset=utf-8" })
	public String queryIncomeDe(HttpServletRequest req,HttpServletResponse response) {
   		return iIncomeAndAgentProfitService.queryIncomeDe(req, response);
    }
}
