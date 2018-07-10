package ad.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IIncomeAndAgentProfitService {

	Integer WhatSerch(HttpServletRequest req,HttpServletResponse response);
	void ExportExcelIncomeAandAgent(HttpServletRequest req,HttpServletResponse response);
	String queryIncomeDe(HttpServletRequest req,HttpServletResponse response);
}
