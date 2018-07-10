package ad.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import ad.bean.AbProxyUser;
import ad.bean.AbReveOrder;
import ad.mapper.AbProxyUserMapper;
import ad.mapper.AbReveOrderMapper;
import ad.service.IAbIncomeRankService;
import ad.util.DateUtil;
import ad.util.Excel2007;
import ad.util.ExcelUtil07;
import ad.util.GetClassPath;
import ad.util.MsExcelW;

import net.sf.json.JSONSerializer;

@Service
public class AbIncomeRankServiceImpl implements IAbIncomeRankService{

	@Autowired
	private AbProxyUserMapper abProxyUserMapper;
	@Autowired
	AbReveOrderMapper abReveOrderMapper;
	
	/**下线数量和金额排行榜(较快)
	 * @param completeDate
	 * @return
	 */
	@Override
	public String queryRevenueChartsList(String completeDate){
		Map<String,Object> m = new HashMap<String,Object>();
		String time0=null;
		String time1=null;
		try{
			String[] time = completeDate.split(",");
			if(!completeDate.equals("")){
				 time0 = time[0];
				 time1 = time[1];
			}
			//下线数量排行
			List<AbProxyUser> abProxyUserDownList = abProxyUserMapper.queryRevenueChartsList(time0,time1);
			for(AbProxyUser u:abProxyUserDownList){
				AbReveOrder abReveOrder = new AbReveOrder();
				abReveOrder.setProxyId(u.getId());
				Float currentIncome = abReveOrderMapper.selectCurrentIncome(abReveOrder);
				u.setCurrentIncome(currentIncome);
				if(u.getFatherId() !=null && !u.getFatherId().equals("")){
					AbProxyUser queryById = abProxyUserMapper.selectByPrimaryKey(u.getFatherId());
					u.setUpperId(queryById.getId()+"");//上线ID
					u.setUpperName(queryById.getProxyUserName());//上线名称
					u.setUpperPhone(queryById.getProxyPhone());//上线手机号
				}
			}
			m.put("abProxyUserDownList", abProxyUserDownList);
			//金额排行
			List<AbProxyUser> abProxyUserEarList = new ArrayList<AbProxyUser>();
			List<AbReveOrder> abReveOrderList = abReveOrderMapper.selectCurrentList(time0,time1);
			for(AbReveOrder u:abReveOrderList){
				AbProxyUser abProxyUser = new AbProxyUser();
				abProxyUser = abProxyUserMapper.selectByPrimaryKey(u.getProxyId());
				if(abProxyUser.getFatherId() !=null && !("").equals(abProxyUser.getFatherId())){
					AbProxyUser query = abProxyUserMapper.selectByPrimaryKey(abProxyUser.getFatherId());
					abProxyUser.setUpperId(query.getId()+"");//上线ID
					abProxyUser.setUpperName(query.getProxyUserName());//上线名称
					abProxyUser.setUpperPhone(query.getProxyPhone());//上线手机号
				}
				abProxyUser.setCurrentIncome(u.getCurrentIncome());
				abProxyUserEarList.add(abProxyUser);
			}
			m.put("code", 200);
			m.put("message", "ok");
			m.put("success", "true");
			m.put("abProxyUserEarList", abProxyUserEarList);
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
	@Override
	public String queryRevenueChartsList1(String completeDate,int type){
		Map<String,Object> m = new HashMap<String,Object>();
		String time0=null;
		String time1=null;
		try{
			String[] time = completeDate.split(",");
			if(!completeDate.equals("")){
				 time0 = time[0];
				 time1 = time[1];
			}
			if(type ==1){
				//下线数量排行
				List<AbProxyUser> abProxyUserList = abProxyUserMapper.queryRevenueChartsList(time0,time1);
				for(AbProxyUser u:abProxyUserList){
					AbReveOrder abReveOrder = new AbReveOrder();
					abReveOrder.setProxyId(u.getId());
					Float currentIncome = abReveOrderMapper.selectCurrentIncome(abReveOrder);
					u.setCurrentIncome(currentIncome);
					if(u.getFatherId() !=null && !u.getFatherId().equals("")){
						AbProxyUser queryById = abProxyUserMapper.selectByPrimaryKey(u.getFatherId());
						u.setUpperId(queryById.getId()+"");//上线ID
						u.setUpperName(queryById.getProxyUserName());//上线名称
						u.setUpperPhone(queryById.getProxyPhone());//上线手机号
					}
				}
				m.put("code", 200);
				m.put("message", "ok");
				m.put("success", "true");
				m.put("abProxyUser", abProxyUserList);
			}else{
				//金额排行
				List<AbProxyUser> abProxyUserList = new ArrayList<AbProxyUser>();
				List<AbReveOrder> abReveOrderList = abReveOrderMapper.selectCurrentList(time0,time1);
				for(AbReveOrder u:abReveOrderList){
					AbProxyUser abProxyUser = new AbProxyUser();
					abProxyUser = abProxyUserMapper.selectByPrimaryKey(u.getProxyId());
					if(abProxyUser.getFatherId() !=null && !("").equals(abProxyUser.getFatherId())){
						AbProxyUser query = abProxyUserMapper.selectByPrimaryKey(abProxyUser.getFatherId());
						abProxyUser.setUpperId(query.getId()+"");//上线ID
						abProxyUser.setUpperName(query.getProxyUserName());//上线名称
						abProxyUser.setUpperPhone(query.getProxyPhone());//上线手机号
					}
					abProxyUser.setCurrentIncome(u.getCurrentIncome());
					abProxyUserList.add(abProxyUser);
				}
				m.put("code", 200);
				m.put("message", "ok");
				m.put("success", "true");
				m.put("abProxyUser", abProxyUserList);
			}
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
	 * @throws FileNotFoundException 
	 */
	@Override
	public void downLoadRevenueChartsList(HttpServletResponse response,Integer type,String completeDate) throws FileNotFoundException{
		//获取下载地址
		String downPath = GetClassPath.ClassPath() ; 
		//下载到服务器上的名字
        String fttpName = DateUtil.createKey()+".xlsx";
		List<AbProxyUser> abProxyUserList = new ArrayList<AbProxyUser>();
		String time0=null;
		String time1=null;
		String name=null;//模板名称
		try{
			String[] time = completeDate.split(",");
			if(!completeDate.equals("")){
				 time0 = time[0];
				 time1 = time[1];
			}
			if(type ==1){
				name="下线数量";
				//下线数量排行
				abProxyUserList = abProxyUserMapper.queryRevenueChartsList(time0,time1);
				for(AbProxyUser u:abProxyUserList){
					AbReveOrder abReveOrder = new AbReveOrder();
					abReveOrder.setProxyId(u.getId());
					Float currentIncome = abReveOrderMapper.selectCurrentIncome(abReveOrder);
					u.setCurrentIncome(currentIncome);
					if(u.getFatherId() !=null && !u.getFatherId().equals("")){
						AbProxyUser queryById = abProxyUserMapper.selectByPrimaryKey(u.getFatherId());
						u.setUpperId(queryById.getId()+"");//上线ID
						u.setUpperName(queryById.getProxyUserName());//上线名称
						u.setUpperPhone(queryById.getProxyPhone());//上线手机号
					}
				}
			}else{
				//金额排行
				name="金额";
				List<AbReveOrder> abReveOrderList = abReveOrderMapper.selectCurrentList(time0,time1);
				for(AbReveOrder u:abReveOrderList){
					AbProxyUser abProxyUser = new AbProxyUser();
					abProxyUser = abProxyUserMapper.selectByPrimaryKey(u.getProxyId());
					if(abProxyUser.getFatherId() !=null && !("").equals(abProxyUser.getFatherId())){
						AbProxyUser query = abProxyUserMapper.selectByPrimaryKey(abProxyUser.getFatherId());
						abProxyUser.setUpperId(query.getId()+"");//上线ID
						abProxyUser.setUpperName(query.getProxyUserName());//上线名称
						abProxyUser.setUpperPhone(query.getProxyPhone());//上线手机号
					}
					abProxyUser.setCurrentIncome(u.getCurrentIncome());
					abProxyUserList.add(abProxyUser);
				}
			}
			//下载
			 String title = name+"排行榜";  
		        List<String> titleList = new ArrayList<String>();
				List<String> columnList = new ArrayList<String>();
				List<Map> dataList = new ArrayList();
				titleList.add("序号");
				titleList.add("用户ID");
				titleList.add("手机号");
				titleList.add("用户昵称");
				titleList.add("佣金金额");
				titleList.add("下线数量");
				titleList.add("上线ID");
				titleList.add("上线昵称");
				titleList.add("上线手机号");
				columnList.add("index");
				columnList.add("id");
				columnList.add("proxyPhone");
				columnList.add("proxyUserName");
				columnList.add("currentIncome");
				columnList.add("offlineNumber");
				columnList.add("fatherId");
				columnList.add("upperName");
				columnList.add("distributionRatio");
				if(abProxyUserList !=null){
					for(int i=0;i<abProxyUserList.size();i++){
						Map<String,Object> m = new HashMap<String,Object>();
						m.put("index", 1+i);
						m.put("id", abProxyUserList.get(i).getId());
						m.put("proxyPhone", abProxyUserList.get(i).getProxyPhone());
						m.put("proxyUserName", abProxyUserList.get(i).getProxyUserName());
						m.put("currentIncome", abProxyUserList.get(i).getCurrentIncome() ==null?0:abProxyUserList.get(i).getCurrentIncome());
						m.put("offlineNumber", abProxyUserList.get(i).getOfflineNumber());
						m.put("fatherId", abProxyUserList.get(i).getUpperId() ==null?"":abProxyUserList.get(i).getUpperId());
						m.put("upperName", abProxyUserList.get(i).getUpperName() ==null?"":abProxyUserList.get(i).getUpperName());
						m.put("distributionRatio", abProxyUserList.get(i).getDistributionRatio());
						dataList.add(m);
					}
				}
		        Excel2007 excel = new Excel2007();
		        try {
					excel.openWorkbook(downPath+"\\"+fttpName,title,titleList.size()-1);
					excel.addTable(titleList,columnList,dataList);
			        excel.lineNum += 2;
			        excel.closedObject();
				} catch (Exception e) {
					e.printStackTrace();
				}
		        // 文件下载
				download(response,name+"排行榜.xlsx",downPath,fttpName);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			File f = new File(downPath+"\\"+fttpName);  // 输入要删除的文件位置
			if(f.exists()) {
				f.delete();
			}
		}
	}
	protected void download(HttpServletResponse response, String filename,String downPath,String fttpName) {
		// 将数据写入模版文件
		//String filename = writeFile(taskNo);
        // 文件下载SysStatic.WEB_REAL_PATH).append("WEB-INF\\download\\"
		StringBuilder webPath = new StringBuilder();
		webPath.append(downPath);
        try {
        	String fullFileName = webPath + "\\" + fttpName;
            System.out.println(fullFileName);
            File outfile = new File(fullFileName);
        	//设置文件MIME类型
            response.setContentType("application/octet-stream");
            //response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.replaceAll(" ", "").getBytes("utf-8"),"iso8859-1"));
            //设置Content-Disposition
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.replaceAll(" ", "").getBytes("utf-8"),"iso8859-1"));
            response.addHeader("Content-Length", "" + outfile.length());  //返回头 文件大小
            //读取目标文件，通过response将目标文件写到客户端
            //获取目标文件的绝对路径
	        InputStream in = new FileInputStream(fullFileName);
	        OutputStream out = response.getOutputStream();
	        //写文件
	        int b;
	        while((b=in.read())!= -1)
	        {
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
	 * 导出excel
	 * @param req
	 * @param response
	 * @param type
	 * @param completeDate
	 * @throws FileNotFoundException 
	 */
	@Override
	public void downLoadRevenueChartsList1(HttpServletResponse response,Integer type,String completeDate) throws FileNotFoundException{
		//下载路径
		String downPath = GetClassPath.ClassPath() ; 
		List<AbProxyUser> abProxyUserList = new ArrayList<AbProxyUser>();
		String time0=null;
		String time1=null;
		String name=null;//模板名称
		String filename =null;
		try{
			String[] time = completeDate.split(",");
			if(!completeDate.equals("")){
				 time0 = time[0];
				 time1 = time[1];
			}
			if(type ==1){
				name="下线数量";
				//下线数量排行
				abProxyUserList = abProxyUserMapper.queryRevenueChartsList(time0,time1);
				for(AbProxyUser u:abProxyUserList){
					AbReveOrder abReveOrder = new AbReveOrder();
					abReveOrder.setProxyId(u.getId());
					Float currentIncome = abReveOrderMapper.selectCurrentIncome(abReveOrder);
					u.setCurrentIncome(currentIncome);
					if(u.getFatherId() !=null && !u.getFatherId().equals("")){
						AbProxyUser queryById = abProxyUserMapper.selectByPrimaryKey(u.getFatherId());
						u.setUpperId(queryById.getId()+"");//上线ID
						u.setUpperName(queryById.getProxyUserName());
						u.setUpperPhone(queryById.getProxyPhone());
					}
				}
			}else{
				//金额排行
				name="金额";
				List<AbReveOrder> abReveOrderList = abReveOrderMapper.selectCurrentList(time0,time1);
				for(AbReveOrder u:abReveOrderList){
					AbProxyUser abProxyUser = new AbProxyUser();
					abProxyUser = abProxyUserMapper.selectByPrimaryKey(u.getProxyId());
					if(abProxyUser.getFatherId() !=null && !("").equals(abProxyUser.getFatherId())){
						AbProxyUser query = abProxyUserMapper.selectByPrimaryKey(abProxyUser.getFatherId());
						abProxyUser.setUpperId(query.getId()+"");//上线ID
						abProxyUser.setUpperName(query.getProxyUserName());
						abProxyUser.setUpperPhone(query.getProxyPhone());
					}
					abProxyUser.setCurrentIncome(u.getCurrentIncome());
					abProxyUserList.add(abProxyUser);
				}
			}
			//下载
			// 将数据写入模版文件
			filename = writeTemplate(name,abProxyUserList,downPath);
			if (filename == null) {
				return ;
			}
			// 文件下载
			download(response,name+"排行榜.xlsx",downPath,filename);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			File f = new File(downPath+"\\"+filename);  // 输入要删除的文件位置
			if(f.exists()){
				f.delete();
			}
		}
	}
	/**ORDER PARTS LIST
	 * 将数据写入模版文件
	 * @return 文件名称
	 */
	private String writeTemplate(String name,List<AbProxyUser> abProxyUserList,String downPath) throws FileNotFoundException{
		File path = new File(ResourceUtils.getURL("file:").getPath());
		//模板路径
		String classPath = path.getAbsolutePath()+GetClassPath.printPath;
		// 获取数据结构
		String printTemplateName = "排行榜.xlsx";
		// 源模板路径
		String sourcePath = classPath;
		String sourcePathFileName = sourcePath + printTemplateName;
		// 目标路径（下载路径）
		String targetPath = downPath;
		//下载到服务器上的名字
        String fttpName = DateUtil.createKey()+".xlsx";
		String targetFileName = fttpName;
		ExcelUtil07 excelx = new ExcelUtil07();
		try {
			if (!excelx.init(sourcePathFileName)){
				return null;
			}
			// 写用户自定义变量信息
			writeTemplateContent(excelx,abProxyUserList,name+"排行榜");
			//
			excelx.writeExcelx(targetPath + "\\" + targetFileName);
			return targetFileName;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	private static void writeTemplateContent(MsExcelW excelx, List<AbProxyUser> abProxyUserList,String titleName) {
		//此处是增加excel列的问题模块
		if(abProxyUserList !=null && abProxyUserList.size()-2>0){
			excelx.insertRow(0, 2,abProxyUserList.size()-2);//增加所有的行
		}
		excelx.gotoCellWriteText(0, 0, 0, titleName, false); // 序号
		for (int i = 0; i < abProxyUserList.size(); i++) {
			excelx.gotoCellWriteText(0, i + 2, 0, i+1+"", false); // 序号
			excelx.gotoCellWriteText(0, i + 2, 1, abProxyUserList.get(i).getProxyName()+"", false); // 用户ID
			excelx.gotoCellWriteText(0, i + 2, 2, abProxyUserList.get(i).getProxyPhone()+"", false); // 手机号
			excelx.gotoCellWriteText(0, i + 2, 3, abProxyUserList.get(i).getProxyUserName()+"", false); // 用户昵称
			excelx.gotoCellWriteText(0, i + 2, 4, abProxyUserList.get(i).getCurrentIncome()==null?"0":abProxyUserList.get(i).getCurrentIncome()+"", false); // 佣金金额
			excelx.gotoCellWriteText(0, i + 2, 5, abProxyUserList.get(i).getOfflineNumber()==null?"":abProxyUserList.get(i).getOfflineNumber()+"", false); // 下线人数
			excelx.gotoCellWriteText(0, i + 2, 6, abProxyUserList.get(i).getUpperId()==null?"":abProxyUserList.get(i).getUpperId(), false); // 上线ID
			excelx.gotoCellWriteText(0, i + 2, 7, abProxyUserList.get(i).getUpperName()==null?"":abProxyUserList.get(i).getUpperName()+"", false); // 上线名称
			excelx.gotoCellWriteText(0, i + 2, 8, abProxyUserList.get(i).getDistributionRatio()==null?"":abProxyUserList.get(i).getDistributionRatio()+"", false); // 与上线分佣
//			excelx.setColumnWidth(0, 11+i, 5);//设置每一列的宽度
		}
	}
}
