package ad.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IAgentRankingsService {

	String queryIncomeRankings(HttpServletRequest req, HttpServletResponse response);
}
