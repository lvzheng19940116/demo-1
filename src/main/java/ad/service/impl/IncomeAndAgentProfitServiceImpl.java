package ad.service.impl;

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
import org.springframework.stereotype.Service;

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

@Service
public class IncomeAndAgentProfitServiceImpl implements IIncomeAndAgentProfitService {

	@Autowired
	private Deservice deservices;

	@Autowired
	private LCYIAbProxyUserService lcyabuserservice;

	/**
	 * 查询几级代理
	 * @param req
	 * @param response
	 * @return
	 */
	@Override
	public Integer WhatSerch(HttpServletRequest req, HttpServletResponse response) {
		String userID = req.getParameter("proxy_id");
		Integer id = deservices.selectidBytyid(userID);
		if (id == null || "".equals(id)) {
			return 0;
		} else {
			// System.out.println("当前的代理ID是：===============" + id);
		}
		Integer cy = lcyabuserservice.thisAgentCy(id);
		return cy;
	}

	/**
	 * 广告和代理收益明细导出接口
	 * @param req
	 * @param response
	 * @return
	 * @throws FileNotFoundException 
	 */
	@Override
	public void ExportExcelIncomeAandAgent(HttpServletRequest req, HttpServletResponse response) {
		System.out.println("进入下载");
		String times = req.getParameter("dateStr");
		String crtpg1 = req.getParameter("IncomePage");
		String crtpg2 = req.getParameter("AgentPage");
		// String types = req.getParameter("Type");
		String userID = req.getParameter("proxy_id");
		Integer Limit = Integer.valueOf(req.getParameter("Limit"));
		// System.out.println(times+"-----"+crtpg1);System.out.println(times+"-----"+crtpg2);
		Integer currentPage1 = Integer.valueOf(crtpg1);
		Integer currentPage2 = Integer.valueOf(crtpg2);
		pageBean Inpb = new pageBean();
		pageBean Agpb = new pageBean();
		if (currentPage1 == null) {
			currentPage1 = 1;
		}
		if (currentPage2 == null) {
			currentPage2 = 1;
		}
		// System.out.println(userID+" pppppppp");
		// 获取当前代理ID 根据根据统一用户中心的用户编号
		Integer id = deservices.selectidBytyid(userID);
		// System.out.println("当前的代理ID是：==============="+id);
		List<IncomeProfitDetailed> IncomeJDataList = new ArrayList<>(); // 广告收益集合
		List<AgentProfitDetailed> AgentJDataList = new ArrayList<>(); // 代理收益集合
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		// 如果是默认加载或者用户把时间删除查询 null时 都返回最近的收益明细
		if ("newtime".equals(times) || "null".equals(times) || null == times || "".equals(times)) {
			if ("1".equals("1")) {
				// 广告的分页查询
				Page Incomepage = deservices.IncomequeryForPageSelectAllDe(Limit, currentPage1, id);
				Inpb.setAllRow(Incomepage.getAllRow());
				Inpb.setCurrentPage(Incomepage.getCurrentPage());
				Inpb.setPagesizi(Incomepage.getPageSize());
				Inpb.setTotalPage(Incomepage.getTotalPage());
				List<DeAllasTitle> list1 = Incomepage.getList();
				if (list1.size() > 0 && list1 != null) {
					for (int i = 0; i < list1.size(); i++) {
						DeAllasTitle a = list1.get(i);
						IncomeProfitDetailed incomeedy = new IncomeProfitDetailed();
						incomeedy.setIncomeCreateDate(sdf.format(a.getCreateDate()));
						incomeedy.setIncomeEarningsAmount(a.getEarningsAmount().toString());
						incomeedy.setIncomeSource(a.getIncomeSource().toString());
						IncomeJDataList.add(incomeedy);
					}
				}
			}
			if ("2".equals("2")) {
				// 代理的分页查询
				Page Agentpage = deservices.AgentqueryForPageSelectAllDe(Limit, currentPage2, id);
				Agpb.setAllRow(Agentpage.getAllRow());
				Agpb.setCurrentPage(Agentpage.getCurrentPage());
				Agpb.setPagesizi(Agentpage.getPageSize());
				Agpb.setTotalPage(Agentpage.getTotalPage());
				List<DeAllasTitle> list2 = Agentpage.getList();
				if (list2.size() > 0 && list2 != null) {
					for (int j = 0; j < list2.size(); j++) {
						DeAllasTitle b = list2.get(j);
						AgentProfitDetailed agentedy = new AgentProfitDetailed();
						agentedy.setAgentCreateDate(
								new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(list2.get(j).getCreateDate()));
						agentedy.setAgentEarningsAmount(b.getEarningsAmount().toString());
						agentedy.setAgentSource(b.getAgentSource().toString());
						AgentJDataList.add(agentedy);
					}
				}
			}
		} else {
			String[] timearr = times.split(",");
			if (timearr.length > 0) {
				String Start_date = timearr[0];
				String End_date = timearr[1];
				if (Start_date.equals(End_date)) {
					Integer apend = Integer.valueOf(End_date.substring(8)) + 1;
					End_date = End_date.substring(0, 8) + apend.toString();
					System.out.println(End_date);
				}
				// System.out.println(Start_date+" "+End_date);
				// 广告的分页查询--加区间条件
				Page Incomepage = deservices.IncomequeryForPageSelectAllDeOnTheTime(Limit, currentPage1, Start_date,
						End_date, id);
				Inpb.setAllRow(Incomepage.getAllRow());
				Inpb.setCurrentPage(Incomepage.getCurrentPage());
				Inpb.setPagesizi(Incomepage.getPageSize());
				Inpb.setTotalPage(Incomepage.getTotalPage());
				List<DeAllasTitle> list1 = Incomepage.getList();
				for (int i = 0; i < list1.size(); i++) {
					DeAllasTitle a = list1.get(i);
					IncomeProfitDetailed incomeedy = new IncomeProfitDetailed();
					incomeedy.setIncomeCreateDate(sdf.format(a.getCreateDate()));
					incomeedy.setIncomeEarningsAmount(a.getEarningsAmount().toString());
					incomeedy.setIncomeSource(a.getIncomeSource().toString());
					IncomeJDataList.add(incomeedy);
				}
				// 代理的分页查询 -- 加区间条件
				Page Agentpage = deservices.AgentqueryForPageSelectAllDeOnTheTime(Limit, currentPage2, Start_date,
						End_date, id);
				Agpb.setAllRow(Agentpage.getAllRow());
				Agpb.setCurrentPage(Agentpage.getCurrentPage());
				Agpb.setPagesizi(Agentpage.getPageSize());
				Agpb.setTotalPage(Agentpage.getTotalPage());
				List<DeAllasTitle> list2 = Agentpage.getList();
				for (int j = 0; j < list2.size(); j++) {
					DeAllasTitle b = list2.get(j);
					AgentProfitDetailed agentedy = new AgentProfitDetailed();
					agentedy.setAgentCreateDate((sdf.format(b.getCreateDate())));
					agentedy.setAgentEarningsAmount(b.getEarningsAmount().toString());
					agentedy.setAgentSource(b.getAgentSource().toString());
					AgentJDataList.add(agentedy);
				}
			}
		}
		System.out.println(IncomeJDataList.size() + "广告" + "   " + AgentJDataList.size() + "代理");
		// String userID = req.getParameter("proxy_id");
		// Integer id = deservices.selectidBytyid(userID);
		// if (id == null || "".equals(id)) {
		//
		// } else {
		// System.out.println("当前的代理ID是：===============" + id);
		// }
		// List<DeAllasTitle> listIncomeDe = deservices.selectIncomeDeAll(id);
		// System.out.println(listIncomeDe.size()+" 广告导出查询条数");
		//
		// List<DeAllasTitle> listAgentDe = deservices.selectAgentDeAll(id);
		// System.out.println(listAgentDe.size()+" 代理导出查询条数");
		// =============================
		// MD5 md5 = new MD5();
		// String title = "广告与代理收益明细Excel";
		// String newdate = md5.getMD5ofStr(new SimpleDateFormat("yyyy-MM-dd
		// hh:mm:ss").format(new Date())).substring(1, 16);
		//
		// String FileNames = "E:/"+newdate+".xls";
		// 获取下载地址
		String downPath = "";
		try {
			downPath = GetClassPath.ClassPath();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String title = "收益明细表";
		List<String> IncometitleList = new ArrayList();
		List<String> IncomecolumnList = new ArrayList();
		List<Map> IncomedataList = new ArrayList();
		List<String> AgenttitleList = new ArrayList();
		List<String> AgentcolumnList = new ArrayList();
		List<Map> AgentdataList = new ArrayList();
		IncometitleList.add("广告收益日期");
		IncometitleList.add("广告收益金额（元）");
		IncometitleList.add("广告来源");
		IncomecolumnList.add("CreateDate");
		IncomecolumnList.add("EarningsAmount");
		IncomecolumnList.add("IncomeSource");
		for (int i = 0; i < IncomeJDataList.size(); i++) {
			Map m = new HashMap();
			m.put("CreateDate", IncomeJDataList.get(i).getIncomeCreateDate());
			m.put("EarningsAmount", IncomeJDataList.get(i).getIncomeEarningsAmount());
			m.put("IncomeSource", IncomeJDataList.get(i).getIncomeSource());
			IncomedataList.add(m);
		}
		AgenttitleList.add("代理收益日期");
		AgenttitleList.add("代理收益金额（元）");
		AgenttitleList.add("所属代理");
		AgentcolumnList.add("CreateDate");
		AgentcolumnList.add("EarningsAmount");
		AgentcolumnList.add("AgentSource");
		for (int i = 0; i < AgentJDataList.size(); i++) {
			Map m = new HashMap();
			m.put("CreateDate", AgentJDataList.get(i).getAgentCreateDate());
			m.put("EarningsAmount", AgentJDataList.get(i).getAgentEarningsAmount());
			m.put("AgentSource", AgentJDataList.get(i).getAgentSource());
			AgentdataList.add(m);
		}
		Excel2007 excel = new Excel2007();
		// 下载到服务器上的名字
		String fttpName = DateUtil.createKey() + ".xlsx";
		try {
			excel.openWorkbook(downPath + "\\" + fttpName, title, IncometitleList.size() - 1);
			excel.addTable(IncometitleList, IncomecolumnList, IncomedataList);
			excel.lineNum += 2;
			excel.addTable(AgenttitleList, AgentcolumnList, AgentdataList);
			excel.closedObject();
			// 文件下载
			download(response, "代理信息表.xlsx", downPath, fttpName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 删除服务器上的刚才下载时的文件
			// 输入要删除的文件位置
			File f = new File(downPath + "\\" + fttpName);
			if (f.exists()) {
				f.delete();
			}
		}
	}

	protected void download(HttpServletResponse response, String filename, String downPath, String fttpName) {
		// 将数据写入模版文件
		// String filename = writeFile(taskNo);
		// 文件下载SysStatic.WEB_REAL_PATH).append("WEB-INF\\download\\"
		StringBuilder webPath = new StringBuilder();
		webPath.append(downPath);
		try {
			// 文件在服务器中的路径
			String fullFileName = webPath + "\\" + fttpName;
			System.out.println(fullFileName);
			File outfile = new File(fullFileName);
			// 设置文件MIME类型
			response.setContentType("application/octet-stream");
			// response.addHeader("Content-Disposition", "attachment;filename="
			// + new String(filename.replaceAll(" ",
			// "").getBytes("utf-8"),"iso8859-1"));
			// 设置Content-Disposition
			response.addHeader("Content-Disposition",
					"attachment;filename=" + new String(filename.replaceAll(" ", "").getBytes("utf-8"), "iso8859-1"));
			response.addHeader("Content-Length", "" + outfile.length()); // 返回头
																			// 文件大小
			// 读取目标文件，通过response将目标文件写到客户端
			// 获取目标文件的绝对路径
			InputStream in = new FileInputStream(fullFileName);
			OutputStream out = response.getOutputStream();
			// 写文件
			int b;
			while ((b = in.read()) != -1) {
				out.write(b);
			}
			in.close();
			out.close();
		} catch (SocketException e) {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 区间查询代理收益和广告收益明细
	 * @param req
	 * @param response
	 */
	@Override
	public String queryIncomeDe(HttpServletRequest req, HttpServletResponse response) {
		String times = req.getParameter("dateStr");
		String crtpg = req.getParameter("Page");
		String types = req.getParameter("Type");
		String userID = req.getParameter("proxy_id");
		Integer Limit = Integer.valueOf(req.getParameter("Limit"));
		System.out.println(times + "-----" + crtpg);
		Integer currentPage = Integer.valueOf(crtpg);
		pageBean Inpb = new pageBean();
		pageBean Agpb = new pageBean();
		if (currentPage == null) {
			currentPage = 1;
		}
		System.out.println(userID + "          pppppppp");
		// 获取当前代理ID 根据根据统一用户中心的用户编号
		Integer id = deservices.selectidBytyid(userID);
		System.out.println("当前的代理ID是：===============" + id);
		List IncomeJDataList = new ArrayList<>(); // 广告收益集合
		List AgentJDataList = new ArrayList<>(); // 代理收益集合
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		// 如果是默认加载或者用户把时间删除查询 null时 都返回最近的收益明细
		if ("newtime".equals(times) || "null".equals(times) || null == times || "".equals(times)) {
			if ("1".equals(types)) {
				// 广告的分页查询
				Page Incomepage = deservices.IncomequeryForPageSelectAllDe(Limit, currentPage, id);
				Inpb.setAllRow(Incomepage.getAllRow());
				Inpb.setCurrentPage(Incomepage.getCurrentPage());
				Inpb.setPagesizi(Incomepage.getPageSize());
				Inpb.setTotalPage(Incomepage.getTotalPage());
				List<DeAllasTitle> list1 = Incomepage.getList();
				if (list1.size() > 0 && list1 != null) {
					for (int i = 0; i < list1.size(); i++) {
						DeAllasTitle a = list1.get(i);
						IncomeProfitDetailed incomeedy = new IncomeProfitDetailed();
						incomeedy.setIncomeCreateDate(sdf.format(a.getCreateDate()));
						incomeedy.setIncomeEarningsAmount(a.getEarningsAmount().toString());
						incomeedy.setIncomeSource(a.getIncomeSource().toString());
						IncomeJDataList.add(incomeedy);
					}
				}
			}
			if ("2".equals(types)) {
				// 代理的分页查询
				Page Agentpage = deservices.AgentqueryForPageSelectAllDe(Limit, currentPage, id);
				Agpb.setAllRow(Agentpage.getAllRow());
				Agpb.setCurrentPage(Agentpage.getCurrentPage());
				Agpb.setPagesizi(Agentpage.getPageSize());
				Agpb.setTotalPage(Agentpage.getTotalPage());
				List<DeAllasTitle> list2 = Agentpage.getList();
				if (list2.size() > 0 && list2 != null) {
					for (int j = 0; j < list2.size(); j++) {
						DeAllasTitle b = list2.get(j);
						AgentProfitDetailed agentedy = new AgentProfitDetailed();
						agentedy.setAgentCreateDate(
								new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(list2.get(j).getCreateDate()));
						agentedy.setAgentEarningsAmount(b.getEarningsAmount().toString());
						agentedy.setAgentSource(b.getAgentSource().toString());
						AgentJDataList.add(agentedy);
					}
				}
			}
		} else {
			String[] timearr = times.split(",");
			if (timearr.length > 0) {
				String Start_date = timearr[0];
				String End_date = timearr[1];
				System.out.println(Start_date + "   " + End_date);
				// 广告的分页查询--加区间条件
				Page Incomepage = deservices.IncomequeryForPageSelectAllDeOnTheTime(Limit, currentPage, Start_date,
						End_date, id);
				Inpb.setAllRow(Incomepage.getAllRow());
				Inpb.setCurrentPage(Incomepage.getCurrentPage());
				Inpb.setPagesizi(Incomepage.getPageSize());
				Inpb.setTotalPage(Incomepage.getTotalPage());
				List<DeAllasTitle> list1 = Incomepage.getList();
				for (int i = 0; i < list1.size(); i++) {
					DeAllasTitle a = list1.get(i);
					IncomeProfitDetailed incomeedy = new IncomeProfitDetailed();
					incomeedy.setIncomeCreateDate(sdf.format(a.getCreateDate()));
					incomeedy.setIncomeEarningsAmount(a.getEarningsAmount().toString());
					incomeedy.setIncomeSource(a.getIncomeSource().toString());
					IncomeJDataList.add(incomeedy);
				}
				// 代理的分页查询 -- 加区间条件
				Page Agentpage = deservices.AgentqueryForPageSelectAllDeOnTheTime(Limit, currentPage, Start_date,
						End_date, id);
				Agpb.setAllRow(Agentpage.getAllRow());
				Agpb.setCurrentPage(Agentpage.getCurrentPage());
				Agpb.setPagesizi(Agentpage.getPageSize());
				Agpb.setTotalPage(Agentpage.getTotalPage());
				List<DeAllasTitle> list2 = Agentpage.getList();
				for (int j = 0; j < list2.size(); j++) {
					DeAllasTitle b = list2.get(j);
					AgentProfitDetailed agentedy = new AgentProfitDetailed();
					agentedy.setAgentCreateDate((sdf.format(b.getCreateDate())));
					agentedy.setAgentEarningsAmount(b.getEarningsAmount().toString());
					agentedy.setAgentSource(b.getAgentSource().toString());
					AgentJDataList.add(agentedy);
				}
			}
		}
		Map remap = new HashMap<>();
		remap.put("message", "ok");
		remap.put("code", "200");
		remap.put("success", "true");
		remap.put("IncomeJymx", IncomeJDataList);
		remap.put("AgentJymx", AgentJDataList);
		remap.put("Incomespages", Inpb);
		remap.put("Agentspages", Agpb);
		return JSONSerializer.toJSON(remap).toString();
	}
}
