package ad.controller.AS_.AgentController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ad.bean.AS_.IncomeBean.IncomeRankings;
import ad.service.IIncomeRankingsService;
import ad.service.AS_.DeService.Deservice;
import ad.util.DateUtil;

import net.sf.json.JSONSerializer;

/**
 * 广告收益排行
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/IncomeRankings")
public class IncomeRankingsController {

	@Autowired
	private IIncomeRankingsService iIncomeRankingsService;
	
	/**
	 * 得到广告收益top10数据
	 * @param req
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/AdverRevenueTop10", produces = { "application/json; charset=utf-8" })
	public String queryIncomeRankings(HttpServletRequest req, HttpServletResponse response) {
		return iIncomeRankingsService.queryIncomeRankings(req, response);
	}

}
