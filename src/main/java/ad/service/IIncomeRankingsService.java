package ad.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IIncomeRankingsService {

	String queryIncomeRankings(HttpServletRequest req, HttpServletResponse response);
}
