package ad.controller.AS_.AgentController;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ad.bean.AS_.AgentBean.AgentRankings;
import ad.bean.AS_.IncomeBean.IncomeRankings;
import ad.service.IAgentRankingsService;
import ad.service.AS_.DeService.Deservice;
import ad.util.DateUtil;

import net.sf.json.JSONSerializer;

/**
 * 代理收益排行
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/AgentRankings")
public class AgentRankingsController {

	@Autowired
	private IAgentRankingsService iAgentRankingsService;

	/**
	 * 代理收益top10 数据来源
	 * @param req
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ProxyRevenueTop10")
	public String queryIncomeRankings(HttpServletRequest req, HttpServletResponse response) {
		return iAgentRankingsService.queryIncomeRankings(req, response);
	}

}
