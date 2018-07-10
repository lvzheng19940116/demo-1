package ad.service.impl;

import java.awt.Font;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ad.bean.AbBankCard;
import ad.bean.AbProxyUser;
import ad.bean.AbReveOrder;
import ad.bean.AbReveOrderDetails;
import ad.bean.AS_.AgentBean.BTListAgent;
import ad.bean.AS_.AgentBean.DayProxyAll;
import ad.mapper.AbBankCardMapper;
import ad.mapper.AbProxyUserMapper;
import ad.mapper.AbReveOrderDetailsMapper;
import ad.mapper.AbReveOrderMapper;
import ad.service.IAbReveOrderService;
import ad.util.DateUtil;
import ad.util.Excel2007;
import ad.util.GetClassPath;

import net.sf.json.JSONSerializer;

@Service
public class AbReveOrderServiceImpl implements IAbReveOrderService{
	private static final Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
	@Autowired
	AbReveOrderMapper abReveOrderMapper;
	@Autowired
	AbBankCardMapper abBankCardMapper;
	@Autowired
	AbReveOrderDetailsMapper abReveOrderDetailsMapper;
	@Autowired
	private AbProxyUserMapper abProxyUserMapper;
	
	/**
	 * 查询所有的订单
	 */
	@Override
	public List<AbReveOrder> select(AbReveOrder abReveOrder){
		//查询所有的订单
		List<AbReveOrder> abReveOrderList = abReveOrderMapper.select(abReveOrder);
		return abReveOrderList;
	}
	@Override
	public AbReveOrder selectNum(){
		AbReveOrder totalNumber = abReveOrderMapper.selectNum();
		return totalNumber;
	}
	@Override
	public AbBankCard selectBankNumber(Integer proxyId){
		AbBankCard card = abBankCardMapper.selectBankNumber(proxyId);
		return card;
	}
	@Override
	public Float selectCurrentIncome(AbReveOrder abReveOrder){
		Float currentIncome = abReveOrderMapper.selectCurrentIncome(abReveOrder);
		return currentIncome;
	}
	@Override
	public Float getNewAddIncome(String yesterday,Integer adverId,Integer proxyId,String appName){
		Float newAddIncome = abReveOrderMapper.getNewAddIncome(yesterday,adverId,proxyId,appName);
		return newAddIncome;
	}
	@Override
	public Float getAllIncome(Integer adverId,Integer proxyId,String appName){
		Float allIncome = abReveOrderMapper.getAllIncome(adverId,proxyId,appName);
		return allIncome;
	}
	@Override
	public List<AbReveOrder> selectCurrentList(String time1,String time2){
		List<AbReveOrder> AbReveOrderList = abReveOrderMapper.selectCurrentList(time1,time2);
		return AbReveOrderList;
	}
	@Override
	public List<AbReveOrder> getProxyIdList(){
		List<AbReveOrder> AbReveOrderList = abReveOrderMapper.getProxyIdList();
		return AbReveOrderList;
	}
	@Override
	public List<AbReveOrder> getAppNameList(){
		List<AbReveOrder> AbReveOrderList = abReveOrderMapper.getAppNameList();
		return AbReveOrderList;
	}
	/**
	 * 累计收益
	 */
	@Override
	public Float selectProfitNum(String starttime, String endtime, Integer id) {
		Float o =abReveOrderMapper.selectByFatheridOrAndTimes(starttime, endtime, id);
		return o;
	}
	/**
	 * 代理饼图显示数据来源 top10
	 */
	@Override
	public List<BTListAgent> selectAgentAllByProidOrAndTimes(String starttime, String endtime, Integer id) {
		List<BTListAgent> list= abReveOrderMapper.selectAgentAllTop10ByProidOrAndTimes(starttime, endtime, id);
		return list;
	}
	/**
	 * 代理饼图显示数据来源 无top10
	 */
	@Override
	public List<BTListAgent> selectAgentAllByProidOrAndTimesNoTen(String starttime, String endtime, Integer id) {
		List<BTListAgent> list= abReveOrderMapper.selectAgentAllNoTop10ByProidOrAndTimes(starttime, endtime, id);
		return list;
	}
	/**
	 * 代理饼图显示
	 */
	@Override
	public Float selectOwnProByProidOrAndTime(String starttime, String endtime, Integer id) {
		Float f = abReveOrderMapper.selectOwnProByProidOrAndTimes(starttime, endtime, id);
		return f;
	}
	/**
	 * 代理饼图显示
	 */
	@Override
	public Float selectOwnAndSubAgentProByProidOrAndTime(String starttime, String endtime, Integer id) {
		Float f = abReveOrderMapper.selectOwnAndSubAgentProByProidOrAndTimes(starttime, endtime, id);
		return f;
	}
	@Override
	public List<AbReveOrder> reportStatistics(Integer adverId,Integer proxyId,String appName,String startTime,String endTime){
		List<AbReveOrder> abReveOrderList = abReveOrderMapper.reportStatistics(adverId,proxyId,appName,startTime,endTime);
		return abReveOrderList;
	}
	@Override
	public List<AbReveOrder> reportStatisticsList(Integer adverId,Integer proxyId,String appName,String startTime,String endTime,Integer page){
		List<AbReveOrder> abReveOrderList = abReveOrderMapper.reportStatisticsList(adverId,proxyId,appName,startTime,endTime,page);
		return abReveOrderList;
	}
	@Override
	public List<AbReveOrder> downloadReportStatistics(Integer adverId,Integer proxyId,String appName,String startTime,String endTime){
		List<AbReveOrder> abReveOrderList = abReveOrderMapper.downloadReportStatistics(adverId,proxyId,appName,startTime,endTime);
		return abReveOrderList;
	}
	@Override
	public List<AbReveOrder> sortByProxyId(String startTime,String endTime){
		List<AbReveOrder> abReveOrderList = abReveOrderMapper.sortByProxyId(startTime,endTime);
		return abReveOrderList;
	}
	@Override
	public List<AbReveOrderDetails> sortByProxyIdOfToday(String today,String tableName){
		List<AbReveOrderDetails> abReveOrderList = abReveOrderDetailsMapper.sortByProxyIdOfToday(today,tableName);
		return abReveOrderList;
	}
	@Override
	public List<AbReveOrderDetails> sortByAdverIdOfToday(String today,String tableName){
		List<AbReveOrderDetails> abReveOrderList = abReveOrderDetailsMapper.sortByAdverIdOfToday(today,tableName);
		return abReveOrderList;
	}
	@Override
	public List<AbReveOrderDetails> sortByAppNameOfToday(String today,String tableName){
		List<AbReveOrderDetails> abReveOrderList = abReveOrderDetailsMapper.sortByAppNameOfToday(today,tableName);
		return abReveOrderList;
	}
	@Override
	public List<AbReveOrder> sortByAdverId(String startTime,String endTime){
		List<AbReveOrder> abReveOrderList = abReveOrderMapper.sortByAdverId(startTime,endTime);
		return abReveOrderList;
	}
	@Override
	public List<AbReveOrder> sortByAppName(String startTime,String endTime){
		List<AbReveOrder> abReveOrderList = abReveOrderMapper.sortByAppName(startTime,endTime);
		return abReveOrderList;
	}
	/**
	 * 区间查询 折线图显示
	 */
	@Override
	public List<DayProxyAll> AgentProDayALL(String Start_date, String End_date, Integer id,String type ) {
		List<DayProxyAll> list = abReveOrderMapper.selectDayProxyByTimesAndId(Start_date, End_date, id,type);
		return list;
	}
	
	/**
	 * 收益订单查询(所有数据)
	 * @param abReveOrder
	 * @return
	 */
	@Override
	public String queryRevenueOrdersAllList(AbReveOrder abReveOrder){
		Map<String,Object> m = new HashMap<String,Object>();
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat orderTime=new SimpleDateFormat("yyyy-MM-dd");
		try{
			//页面分页处理
			int page = abReveOrder.getPage();
			abReveOrder.setPage((page-1)*10);
			//查询所有的订单
			List<AbReveOrder> abReveOrderList = this.select(abReveOrder);
			for(AbReveOrder aOrder :abReveOrderList){
				if(aOrder.getCreateTime()!=null){
					aOrder.setTime(time.format(aOrder.getCreateTime()));
				}
				if(aOrder.getOrderDate() != null){
					aOrder.setOrderDateTime(orderTime.format(aOrder.getOrderDate()));
				}
				//查询银行卡号
//				AbBankCard card = abReveOrderService.selectBankNumber(aOrder.getProxyId());
//				if(card !=null){
//					aOrder.setBankCardNumber(card.getBankCardNumber());
//				}
				//查询用户登录ID
				AbProxyUser queryById = abProxyUserMapper.selectByPrimaryKey(aOrder.getProxyId());
				aOrder.setProxyName(queryById.getProxyName());
			}
			//查询所有的条数
			AbReveOrder totalNumber = this.selectNum();
			m.put("code", 200);
			m.put("message", "success");
			m.put("abReveOrder", abReveOrderList);
			m.put("total", totalNumber ==null?0:totalNumber.getTotalNumber());
		}catch(Exception e){
			m.put("code", 0);
			m.put("message", "fail");
			e.printStackTrace();
		}
		return JSONSerializer.toJSON(m).toString();
	}
	
	/**
	 * 收益订单查询
	 * @param req
	 * @param response
	 * @param abReveOrder
	 * @return
	 */
	@Override
	public String queryRevenueOrdersList(AbReveOrder abReveOrder){
		Map<String,Object> m = new HashMap<String,Object>();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat orderTime=new SimpleDateFormat("yyyy-MM-dd");
		try{
			//前台传过来的值需要进行一些的处理
			//判断前台的搜索条件
			//判断搜索条件是否为收益用户手机号
			if(abReveOrder.getRegionFlag().equals("rofitTelephone") && !abReveOrder.getRegionName().trim().equals("")){
				abReveOrder.setProxyPhone(abReveOrder.getRegionName());
			}
			//判断搜索条件是否为收益用户ID
			if(abReveOrder.getRegionFlag().equals("rofitUserId") && !abReveOrder.getRegionName().trim().equals("")){
//				abReveOrder.setProxyName(abReveOrder.getRegionName());
				//判断输入的用户Id是否为纯数字
				boolean type = pattern.matcher(abReveOrder.getRegionName()).matches();
				if(type ==true){
					abReveOrder.setProxyId(Integer.valueOf(abReveOrder.getRegionName()));
				}
				else{
					m.put("fail", 0);
					return JSONSerializer.toJSON(m).toString();
				}
			}
			//判断搜索条件是否为收益用户名称
			if(abReveOrder.getRegionFlag().equals("rofitUserName") && !abReveOrder.getRegionName().trim().equals("")){
				abReveOrder.setProxyUserName(abReveOrder.getRegionName());
			}
			//判断搜索条件是否为订单时间
			if( !abReveOrder.getOrderTime().trim().equals("") && abReveOrder.getOrderTime() !=null){
				abReveOrder.setCreateTime(new Date());
				String[] time = abReveOrder.getOrderTime().split(",");
				abReveOrder.setTime1(time[0]);
				abReveOrder.setTime2(time[1]);
			}
			int page = abReveOrder.getPage();
			abReveOrder.setPage((page-1)*10);
			List<AbReveOrder> abReveOrderList = abReveOrderMapper.queryRevenueOrdersList(abReveOrder);
			for(AbReveOrder u:abReveOrderList){
				if(u.getCreateTime()!=null){
					u.setTime(format.format(u.getCreateTime()));
				}
				if(u.getOrderDate() != null && !u.getOrderDate().equals("")){
					u.setOrderDateTime(orderTime.format(u.getOrderDate()));
				}
				//查询银行卡
//				AbBankCard card = abReveOrderService.selectBankNumber(u.getProxyId());
//				if(card !=null){
//					u.setBankCardNumber(card.getBankCardNumber());
//				}
				//查询用户登录ID
				AbProxyUser queryById = abProxyUserMapper.selectByPrimaryKey(u.getProxyId());
				u.setProxyName(queryById.getProxyName());
			}
			m.put("code", 200);
			m.put("message", "ok");
			m.put("success", "true");
			m.put("abReveOrder", abReveOrderList);
			m.put("total", abReveOrderList.size()==0?0:abReveOrderList.get(0).getTotalNumber());
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
	
	/**
	 * 主查询接口
	 * @param abReveOrder
	 * @return
	 */
	@Override
	public String queryReportStatistics(AbReveOrder abReveOrder){
		
		Map<String,Object> m = new HashMap<String,Object>();
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format=new SimpleDateFormat("MM-dd");
		String yesterday = DateUtil.getCurrentDatePreDays(time.format(new Date()),"yyyy-MM-dd",1); //昨天
		String startTime = null;
		String endTime = null;
		try{
			if(abReveOrder.getOrderTime() !=null && !abReveOrder.getOrderTime().equals("")&& !abReveOrder.getOrderTime().equals("null")){
				String[] complete = abReveOrder.getOrderTime().split(",");
				startTime = complete[0];
				endTime = complete[1];
			}
			if(abReveOrder.getOrderTime().equals("") || abReveOrder.getOrderTime().equals("null")){
				endTime = yesterday;
			}
			//根据前台输入的条件查询相关的信息
			List<AbReveOrder> abList = this.reportStatistics(abReveOrder.getAdverId(),abReveOrder.getProxyId(),abReveOrder.getAppName(),startTime,endTime);
			List<AbReveOrder>   abReveOrderList = new ArrayList<AbReveOrder>();
			Date dBegin = null;
			Date dEnd = null;
			if(abList.size() !=0){
				if(startTime !=null){
					dBegin = time.parse(startTime);
				}
				else{
					dBegin=abList.get(0).getOrderDate();
				}
				dEnd = time.parse(endTime);
				//算出时间段
				//处理前台时间段，即使没有该段时间内没有数据也要把该段时间输出出来
				List<Date> lDate = DateUtil.findDates(dBegin, dEnd); 
				  for (Date date : lDate){
					  boolean flag = false;
					  AbReveOrder ab = new AbReveOrder();
					  String dete= time.format(date);
					  for(AbReveOrder a:abList){
							a.setOrderDateTime(time.format(a.getOrderDate()));
							if(time.format(a.getOrderDate()).equals(dete)){
								abReveOrderList.add(a);
								flag = true;
								continue;
							}
						}
					  if(!flag){
							ab.setOrderDateTime(dete);
							ab.setEarningsAmount(0f);
							abReveOrderList.add(ab);
						}
//				   System.out.println(sdf.format(date));
				  }
			}
			if(startTime !=null && endTime !=null && abList.size() ==0){
				dBegin = time.parse(startTime);
				dEnd = time.parse(endTime);
				List<Date> lDate = DateUtil.findDates(dBegin, dEnd); 
				  for (Date date : lDate){
					  AbReveOrder ab = new AbReveOrder();
					  String dete= time.format(date);
							ab.setOrderDateTime(dete);
							ab.setEarningsAmount(0f);
							abReveOrderList.add(ab);
				  }
			}
			for(AbReveOrder ab:abReveOrderList){
				String orderDateTime = ab.getOrderDateTime();
				ab.setOrderDateTime(format.format(time.parse(orderDateTime)));
			}
			//列表数据
			List<AbReveOrder>   list = this.reportStatisticsList(abReveOrder.getAdverId(),abReveOrder.getProxyId(),abReveOrder.getAppName(),startTime,endTime,(abReveOrder.getPage()-1)*10);
			for(AbReveOrder b:list){
				b.setOrderDateTime(time.format(b.getOrderDate()));
				AbProxyUser queryById = abProxyUserMapper.selectByPrimaryKey(b.getProxyId());
				b.setProxyUserName(queryById.getProxyUserName());
				b.setProxyName(queryById.getProxyName());
				
			};
			//昨日新增收益
			Float newAddIncome = this.getNewAddIncome(yesterday,abReveOrder.getAdverId(),abReveOrder.getProxyId(),abReveOrder.getAppName());
			//所有收益
			Float allIncome = this.getAllIncome(abReveOrder.getAdverId(),abReveOrder.getProxyId(),abReveOrder.getAppName());
			//昨日新增代理
			Integer newAddProxy = abProxyUserMapper.getNewAddProxy(yesterday);
			m.put("abReveOrderList", abReveOrderList);
			m.put("list", list);
			m.put("newAddIncome", newAddIncome ==null?0:newAddIncome);
			m.put("allIncome", allIncome==null?0:allIncome);
			m.put("newAddProxy" ,newAddProxy);
			m.put("total", list.size() ==0?0:list.get(0).getTotalNumber());
			m.put("code", 200);
			m.put("message", "ok");
			m.put("success", "true");
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
	public static CategoryDataset createDataSet(List<AbReveOrder> abReveOrderList) {  
	      DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
	      for(AbReveOrder ab:abReveOrderList){
	    	  categoryDataset.addValue(ab.getEarningsAmount(), "月份", ab.getOrderDateTime().substring(6, 10));
	      }
		    return categoryDataset;
//	      return DatasetUtilities.createCategoryDataset(rowKeys, colKeys, data);  
	  }
	// 根据CategoryDataset创建JFreeChart对象  
    public static JFreeChart createChart(CategoryDataset categoryDataset) {  
        // 创建JFreeChart对象：ChartFactory.createLineChart  
    	SimpleDateFormat time=new SimpleDateFormat("收益情况");
        JFreeChart jfreechart = ChartFactory.createLineChart(time.format(new Date()), // 标题  
                null, // categoryAxisLabel （category轴，横轴，X轴标签）  
                "收益金额", // valueAxisLabel（value轴，纵轴，Y轴的标签）  
                categoryDataset, // dataset  
                PlotOrientation.VERTICAL, true, // legend  
                false, // tooltips  
                false); // URLs  
        // 使用CategoryPlot设置各种参数。以下设置可以省略。  
        CategoryPlot plot = (CategoryPlot)jfreechart.getPlot();  
        // 背景色 透明度  
        plot.setBackgroundAlpha(0.5f);  
        // 前景色 透明度  
        plot.setForegroundAlpha(0.5f); 
        plot.setNoDataMessage("暂无数据显示！");
        // 其他设置 参考 CategoryPlot类  
        LineAndShapeRenderer renderer = (LineAndShapeRenderer)plot.getRenderer();
        renderer.setBaseShapesVisible(false); // series 点（即数据点）可见  
        renderer.setBaseLinesVisible(true); // series 点（即数据点）间有连线可见  
        renderer.setUseSeriesOffset(true); // 设置偏移量  
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());  
        renderer.setBaseItemLabelsVisible(true); 
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 20));
        domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 20));//x轴的字体
        NumberAxis numberaxis = (NumberAxis) plot.getRangeAxis();
        plot.getRangeAxis().setLabelFont(new Font("宋体", Font.BOLD, 20));//设置y轴字体
        numberaxis.setTickLabelFont(new Font("黑体", Font.PLAIN, 20));//设置Y轴坐标上的文字
        numberaxis.setLabelFont(new Font("黑体", Font.PLAIN, 26));//设置Y轴的标题文字
        jfreechart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 18));//设置下标的字体
        jfreechart.getTitle().setFont(new Font("宋体",Font.BOLD,26));//设置标题字体
        return jfreechart;  
    }
    // 保存为文件  
    public static void saveAsFile(JFreeChart chart, String outputPath,  
            int weight, int height) {  
        FileOutputStream out = null;  
        try {  
            File outFile = new File(outputPath);  
            if (!outFile.getParentFile().exists()) {  
                outFile.getParentFile().mkdirs();  
            }  
            out = new FileOutputStream(outputPath);  
            // 保存为PNG  
            // ChartUtilities.writeChartAsPNG(out, chart, 600, 400);  
            // 保存为JPEG  
            ChartUtilities.writeChartAsJPEG(out, chart, weight, height);  
            out.flush();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (out != null) {  
                try {  
                    out.close();  
                } catch (IOException e) {  
                    // do nothing  
                }  
            }  
        }  
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
	@Override
	public void downloadReportStatistics(HttpServletResponse response,AbReveOrder abReveOrder) throws FileNotFoundException{
		//获取下载地址
		String downPath = GetClassPath.ClassPath() ; 
		//下载到服务器上的名字
        String fttpNameOfJPG = DateUtil.createKey()+".jpg";
		Map<String , Object> result = selectReportStatistics(abReveOrder);
		List<AbReveOrder> abReveOrderList =  (List<AbReveOrder>)result.get("abReveOrderList");
		//下载折现图---两种下载图片的方式
//				JFreeChart chart = getSeriesChart(createDataset(abReveOrderList));
//			    writeChart(chart, downPath+"\\"+fttpNameOfJPG);
	    // 步骤1：创建CategoryDataset对象（准备数据）  
        CategoryDataset dataset = createDataSet(abReveOrderList);  
        // 步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置  
        JFreeChart freeChart = createChart(dataset);  
        // 步骤3：将JFreeChart对象输出到文件，Servlet输出流等  
        int weight,  height;
        if(abReveOrderList.size() <=7){
        	weight =1000;
        	height =600;
        }else if(7<abReveOrderList.size() && abReveOrderList.size()<14){
        	weight =1400;
        	height =800;
        }else if(14<abReveOrderList.size() && abReveOrderList.size()<21){
        	weight =1800;
        	height =1200;
        }else{
        	weight =2200;
        	height =1800;
        }
        saveAsFile(freeChart, downPath+"\\"+fttpNameOfJPG, weight, height);  
	    //excel列表数据
	    List<AbReveOrder>	list =  (List<AbReveOrder>)result.get("list");
        String title = "报表信息表";  
        List<String> titleList = new ArrayList<String>();
		List<String> columnList = new ArrayList<String>();
		List<Map> dataList = new ArrayList();
		titleList.add("日期");
		titleList.add("广告ID");
		titleList.add("收益金额");
		titleList.add("来源代理ID");
		titleList.add("来源代理名称");
		columnList.add("orderDateTime");
		columnList.add("adverId");
		columnList.add("earningsAmount");
		columnList.add("proxyId");
		columnList.add("proxyUserName");
		for(AbReveOrder ab : list){
			Map<String,Object> m = new HashMap<String,Object>();
			m.put("orderDateTime", ab.getOrderDateTime());
			m.put("adverId", ab.getAdverId());
			m.put("earningsAmount", ab.getEarningsAmount());
			m.put("proxyId", ab.getProxyName());
			m.put("proxyUserName", ab.getProxyUserName());
			dataList.add(m);
		}
        Excel2007 excel = new Excel2007();
        //下载到服务器上的名字
        String fttpNameOfExcel = DateUtil.createKey()+".xlsx";
        try {
			excel.openWorkbook(downPath+"\\"+fttpNameOfExcel,title,titleList.size()-1);
	        excel.addTable(titleList,columnList,dataList);
	        excel.lineNum += 2;
	        excel.addImg(downPath+"\\"+fttpNameOfJPG,0,5,excel.lineNum,excel.lineNum+25);
	        excel.closedObject();
	        // 文件下载
			download(response,"报表信息.xlsx",downPath,fttpNameOfExcel);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			File f = new File(downPath+"\\"+fttpNameOfExcel);  // 输入要删除的文件位置
			if(f.exists()) {f.delete();}
			File f1 = new File(downPath+"\\"+fttpNameOfJPG);  // 输入要删除的文件位置
			if(f1.exists()) {f1.delete();}
		}
	}
	//导出给前台浏览器
	protected void download(HttpServletResponse response, String filename,String downPath,String fttpName) {
		// 将数据写入模版文件
		//String filename = writeFile(taskNo);
        // 文件下载SysStatic.WEB_REAL_PATH).append("WEB-INF\\download\\"
		StringBuilder webPath = new StringBuilder();
		webPath.append(downPath);
        try {
        	String fullFileName = webPath+"\\" + fttpName;
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
	//查询所要导出满足要求的list
	protected Map<String , Object> selectReportStatistics(AbReveOrder abReveOrder){
		Map<String,Object> m = new HashMap<String,Object>();
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd");
		String yesterday = DateUtil.getCurrentDatePreDays(time.format(new Date()),"yyyy-MM-dd",1); //昨天
		String startTime = null;
		String endTime = null;
		try{
			if(abReveOrder.getOrderTime() !=null && !abReveOrder.getOrderTime().equals("")&& !abReveOrder.getOrderTime().equals("null")){
				String[] complete = abReveOrder.getOrderTime().split(",");
				startTime = complete[0];
				endTime = complete[1];
			}
			if(abReveOrder.getOrderTime().equals("") || abReveOrder.getOrderTime().equals("null")){
				endTime = yesterday;
			}
			List<AbReveOrder>   abList = this.reportStatistics(abReveOrder.getAdverId(),abReveOrder.getProxyId(),abReveOrder.getAppName(),startTime,endTime);
			List<AbReveOrder>   abReveOrderList = new ArrayList<AbReveOrder>();
			Date dBegin = null;
			Date dEnd = null;
			if(abList.size() !=0){
				if(startTime !=null){
					dBegin = time.parse(startTime);
				}
				else{
					dBegin=abList.get(0).getOrderDate();
				}
				dEnd = time.parse(endTime);
				//算出时间段
				List<Date> lDate = DateUtil.findDates(dBegin, dEnd); 
				  for (Date date : lDate){
					  boolean flag = false;
					  AbReveOrder ab = new AbReveOrder();
					  String dete= time.format(date);
					  for(AbReveOrder a:abList){
							a.setOrderDateTime(time.format(a.getOrderDate()));
							if(time.format(a.getOrderDate()).equals(dete)){
								abReveOrderList.add(a);
								flag = true;
								continue;
							}
						}
					  if(!flag){
							ab.setOrderDateTime(dete);
							ab.setEarningsAmount(0f);
							abReveOrderList.add(ab);
						}
//				   System.out.println(sdf.format(date));
				  }
			}
			if(startTime !=null && endTime !=null && abList.size() ==0){
				dBegin = time.parse(startTime);
				dEnd = time.parse(endTime);
				List<Date> lDate = DateUtil.findDates(dBegin, dEnd); 
				  for (Date date : lDate){
					  AbReveOrder ab = new AbReveOrder();
					  String dete= time.format(date);
							ab.setOrderDateTime(dete);
							ab.setEarningsAmount(0f);
							abReveOrderList.add(ab);
					  
				  }
			}
			//列表数据
			List<AbReveOrder>	list = this.downloadReportStatistics(abReveOrder.getAdverId(),abReveOrder.getProxyId(),abReveOrder.getAppName(),startTime,endTime);
			for(AbReveOrder b:list){
				b.setOrderDateTime(time.format(b.getOrderDate()));
				AbProxyUser queryById = abProxyUserMapper.selectByPrimaryKey(b.getProxyId());
				b.setProxyUserName(queryById.getProxyUserName());
				b.setProxyName(queryById.getProxyName());
			};
			m.put("abReveOrderList", abReveOrderList);
			m.put("list", list);
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return m;
	}
	protected JFreeChart getSeriesChart(XYDataset xydataset){
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("", "", "收益金额",xydataset, true, true, true);
        XYPlot xyplot = (XYPlot) jfreechart.getPlot();
        DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();
        dateaxis.setDateFormatOverride(new SimpleDateFormat("yyyy-MM-dd"));
        dateaxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题
        dateaxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
        ValueAxis rangeAxis=xyplot.getRangeAxis();//获取柱状
        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
        jfreechart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
        jfreechart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
        return jfreechart;
    } 
	@SuppressWarnings("deprecation")
	protected  XYDataset createDataset(List<AbReveOrder> abReveOrderList) {  //这个数据集有点多，但都不难理解
		TimeSeries timeseries = new TimeSeries("时间",Day.class);
		SimpleDateFormat time0=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat time=new SimpleDateFormat("dd");
		SimpleDateFormat time1=new SimpleDateFormat("MM");
		SimpleDateFormat time2=new SimpleDateFormat("yyyy");
		Integer day = null;
		Integer month = null;
		Integer year = null;
		for(AbReveOrder ab:abReveOrderList){
			try {
				day = Integer.valueOf(time.format(time0.parse(ab.getOrderDateTime())));
				month = Integer.valueOf(time1.format(time0.parse(ab.getOrderDateTime())));
				year = Integer.valueOf(time2.format(time0.parse(ab.getOrderDateTime())));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			timeseries.add(new Day(day,month,year), ab.getEarningsAmount());
		}
         TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
         timeseriescollection.addSeries(timeseries);
         return timeseriescollection;
  }
	public void writeChart(JFreeChart jfreechart,String path){
 	   try {
			ByteArrayOutputStream fos = new ByteArrayOutputStream();
				try {
					ChartUtilities.writeChartAsJPEG(
						fos, //文件流
						1, //JPEGͼ格式
						jfreechart, //ͳ结果图
						1000, //宽65500
						500,//高
						null //ChartRenderingInfo 
						);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				File file=new File(path);
				if (!file.exists()) {
					file.createNewFile();
				}
				DataOutputStream to=new DataOutputStream(new FileOutputStream(file));
				fos.writeTo(to);
				
				to.close();
			fos.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
}
