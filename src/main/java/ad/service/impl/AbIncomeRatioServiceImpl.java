package ad.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ad.bean.AbAdver;
import ad.bean.AbProxyUser;
import ad.bean.AbReveOrder;
import ad.mapper.AbAdverMapper;
import ad.mapper.AbProxyUserMapper;
import ad.mapper.AbReveOrderMapper;
import ad.service.IAbIncomeRatioService;
import ad.util.DateUtil;

import net.sf.json.JSONSerializer;

@Service
public class AbIncomeRatioServiceImpl implements IAbIncomeRatioService{

	@Autowired
	AbReveOrderMapper abReveOrderMapper;
	@Autowired
	private AbProxyUserMapper abProxyUserMapper;
	@Autowired
	private AbAdverMapper abAdverMapper;
	
	/**
	 * 收益比例查询类
	 * @param abReveOrder
	 * @return
	 */
	@Override
	public String revenueRatio(AbReveOrder abReveOrder){
		Map<String,Object> m = new HashMap<String,Object>();
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd");
		String startTime = null;
		String endTime = null;
		try{
			String yesterday = DateUtil.getCurrentDatePreDays(time.format(new Date()),"yyyy-MM-dd",1); //昨天
//			String twoDaysAgo = DateUtil.getCurrentDatePreDays(time.format(new Date()),"yyyy-MM-dd",2); //前天
			String sevenDaysAgo = DateUtil.getCurrentDatePreDays(time.format(new Date()),"yyyy-MM-dd",7); //7天前
			String thirtyDaysAgo = DateUtil.getCurrentDatePreDays(time.format(new Date()),"yyyy-MM-dd",30); //30天前
			//给前台饼图赋值
			String [] colors = {"#E68191","#AECD8B","#85B4CA","#E6B981","#A98BCD","#808080"};
			//日期控件传过来的时间
			if(abReveOrder.getOrderTime() !=null && !abReveOrder.getOrderTime().equals("")&& !abReveOrder.getOrderTime().equals("null")){
				String[] complete = abReveOrder.getOrderTime().split(",");
				startTime = complete[0];
				endTime = complete[1];
			}else{
				//昨天
				if(abReveOrder.getTimeFlag() ==0){
					startTime=yesterday;
					endTime=yesterday;
				}
				//近一周
				if(abReveOrder.getTimeFlag() ==1){
					startTime=sevenDaysAgo;
					endTime=yesterday;
				}
				//近30天
				if(abReveOrder.getTimeFlag() ==2){
					startTime=thirtyDaysAgo;
					endTime=yesterday;
				}
			}
			//收益渠道比例
			List<AbReveOrder> proxyListfirst = abReveOrderMapper.sortByProxyId(startTime,endTime);
			//echars显示用到的值
			List<AbReveOrder> proxyList = new ArrayList<AbReveOrder>();
			//详细的值
			List<AbReveOrder> proxyDetailsList = new ArrayList<AbReveOrder>();
			//收益渠道(左面的)
			List<AbReveOrder> proxyList1 = new ArrayList<AbReveOrder>();
			//收益渠道(左面的)详细
			List<AbReveOrder> proxyDetailsList1 = new ArrayList<AbReveOrder>();
			//收益渠道(右面的)
			List<AbReveOrder> proxyList2 = new ArrayList<AbReveOrder>();
			//收益渠道(右面的)详细
			List<AbReveOrder> proxyDetailsList2 = new ArrayList<AbReveOrder>();
			if(proxyListfirst.size() >0){
				for(int i=0;i<proxyListfirst.size();i++){
					AbReveOrder abOrder = new AbReveOrder();
					AbReveOrder abOrderDetails = new AbReveOrder();
					if(i>4){
						break;
					}else{
						AbProxyUser queryById = abProxyUserMapper.selectByPrimaryKey(proxyListfirst.get(i).getProxyId());
						//截取的字段（登录的账号）
						abOrder.setEarningsAmount(proxyListfirst.get(i).getEarningsAmount());
						//代理账号
						String proxyName = null;
						proxyName = queryById.getProxyUserName().substring(0, queryById.getProxyUserName().length()>6?6:queryById.getProxyUserName().length());
						abOrder.setProxyName(proxyName.length() ==6?proxyName+"...":proxyName);
						proxyList.add(abOrder);
						//详细的字段（登录的账号）
						abOrderDetails.setEarningsAmount(proxyListfirst.get(i).getEarningsAmount());
						abOrderDetails.setProxyName(queryById.getProxyUserName());
						proxyDetailsList.add(abOrderDetails);
					}
				}
				//截取（登录的账号）
				if(proxyList.size() >5){
					Float earningsAmount = 0F;
					AbReveOrder abOrder1 = new AbReveOrder();
					for(int i=5;i<proxyListfirst.size();i++){
						earningsAmount+=proxyListfirst.get(i).getEarningsAmount();
					}
					abOrder1.setEarningsAmount(earningsAmount);
					abOrder1.setProxyName("其他");
					proxyList.add(abOrder1);
				}
				//详细（登录的账号）
				if(proxyDetailsList.size() >5){
					Float earningsAmount = 0F;
					AbReveOrder abOrderDetails1 = new AbReveOrder();
					for(int i=5;i<proxyListfirst.size();i++){
						earningsAmount+=proxyListfirst.get(i).getEarningsAmount();
					}
					abOrderDetails1.setEarningsAmount(earningsAmount);
					abOrderDetails1.setProxyName("其他");
					proxyDetailsList.add(abOrderDetails1);
				}
			}
			//截取（登录的账号）
			if(proxyList.size()>0){
				for(int i=0;i<proxyList.size();i++){
					AbReveOrder ab = new AbReveOrder();
					if(i%2 ==0){
						ab.setEarningsAmount(proxyList.get(i).getEarningsAmount());
						ab.setProxyName(proxyList.get(i).getProxyName());
						ab.setColor(colors[i]);
						proxyList1.add(ab);
					}else{
						ab.setEarningsAmount(proxyList.get(i).getEarningsAmount());
						ab.setProxyName(proxyList.get(i).getProxyName());
						ab.setColor(colors[i]);
						proxyList2.add(ab);
					}
				}
			}
			//详细（登录的账号）
			if(proxyDetailsList.size()>0){
				for(int i=0;i<proxyDetailsList.size();i++){
					AbReveOrder abDetails = new AbReveOrder();
					if(i%2 ==0){
						abDetails.setEarningsAmount(proxyDetailsList.get(i).getEarningsAmount());
						abDetails.setProxyName(proxyDetailsList.get(i).getProxyName());
						abDetails.setColor(colors[i]);
						proxyDetailsList1.add(abDetails);
					}else{
						abDetails.setEarningsAmount(proxyDetailsList.get(i).getEarningsAmount());
						abDetails.setProxyName(proxyDetailsList.get(i).getProxyName());
						abDetails.setColor(colors[i]);
						proxyDetailsList2.add(abDetails);
					}
				}
			}
			//收益广告比例
			List<AbReveOrder> adverListfirst = abReveOrderMapper.sortByAdverId(startTime,endTime);
			//echars显示用到的值
			List<AbReveOrder> adverList = new ArrayList<AbReveOrder>();
			//详细的值
			List<AbReveOrder> adverDetailList = new ArrayList<AbReveOrder>();
			//收益广告(左面的)
			List<AbReveOrder> adverList1 = new ArrayList<AbReveOrder>();
			//收益广告(左面的)详细
			List<AbReveOrder> adverDetailList1 = new ArrayList<AbReveOrder>();
			//收益渠道(右面的)
			List<AbReveOrder> adverList2 = new ArrayList<AbReveOrder>();
			//收益渠道(右面的)详细
			List<AbReveOrder> adverDetailList2 = new ArrayList<AbReveOrder>();
			if(adverListfirst.size() >0){
				for(int i=0;i<adverListfirst.size();i++){
					AbReveOrder abOrder = new AbReveOrder();
					AbReveOrder abOrderDetail = new AbReveOrder();
					if(i>4){
						break;
					}else{
						AbAdver abAdver = abAdverMapper.selectByPrimaryKey(adverListfirst.get(i).getAdverId());
						//截取字段（广告标题）
						abOrder.setEarningsAmount(adverListfirst.get(i).getEarningsAmount());
						//广告标题
						String adverTitle = null;
						adverTitle = abAdver.getAdverTitle().substring(0,abAdver.getAdverTitle().length()>6?6:abAdver.getAdverTitle().length());
						abOrder.setAdverTitle(adverTitle.length() ==6?adverTitle+"...":adverTitle);
						adverList.add(abOrder);
						//完全的字段（广告标题）
						abOrderDetail.setEarningsAmount(adverListfirst.get(i).getEarningsAmount());
						abOrderDetail.setAdverTitle(abAdver.getAdverTitle());
						adverDetailList.add(abOrderDetail);
					}
				}
				//截取字段（广告标题）
				if(adverList.size() >5){
					Float earningsAmount = 0F;
					AbReveOrder abOrder1 = new AbReveOrder();
					for(int i=5;i<proxyListfirst.size();i++){
						earningsAmount+=adverListfirst.get(i).getEarningsAmount();
					}
					abOrder1.setEarningsAmount(earningsAmount);
					abOrder1.setAdverTitle("其他");
					adverList.add(abOrder1);
				}
				//完全的字段（广告标题）
				if(adverDetailList.size() >5){
					Float earningsAmount = 0F;
					AbReveOrder abOrderDetail1 = new AbReveOrder();
					for(int i=5;i<proxyListfirst.size();i++){
						earningsAmount+=adverListfirst.get(i).getEarningsAmount();
					}
					abOrderDetail1.setEarningsAmount(earningsAmount);
					abOrderDetail1.setAdverTitle("其他");
					adverDetailList.add(abOrderDetail1);
				}
			}
			//截取广告标题的list
			if(adverList.size()>0){
				for(int i=0;i<adverList.size();i++){
					AbReveOrder ab = new AbReveOrder();
					if(i%2 ==0){
						ab.setEarningsAmount(adverList.get(i).getEarningsAmount());
						ab.setAdverTitle(adverList.get(i).getAdverTitle());
						ab.setColor(colors[i]);
						adverList1.add(ab);
					}else{
						ab.setEarningsAmount(adverList.get(i).getEarningsAmount());
						ab.setAdverTitle(adverList.get(i).getAdverTitle());
						ab.setColor(colors[i]);
						adverList2.add(ab);
					}
				}
			}
			//完整广告标题的list
			if(adverDetailList.size()>0){
				for(int i=0;i<adverDetailList.size();i++){
					AbReveOrder abDetail = new AbReveOrder();
					if(i%2 ==0){
						abDetail.setEarningsAmount(adverDetailList.get(i).getEarningsAmount());
						abDetail.setAdverTitle(adverDetailList.get(i).getAdverTitle());
						abDetail.setColor(colors[i]);
						adverDetailList1.add(abDetail);
					}else{
						abDetail.setEarningsAmount(adverDetailList.get(i).getEarningsAmount());
						abDetail.setAdverTitle(adverDetailList.get(i).getAdverTitle());
						abDetail.setColor(colors[i]);
						adverDetailList2.add(abDetail);
					}
				}
			}
			//收益应用比例
			List<AbReveOrder> applicationListfirst = abReveOrderMapper.sortByAppName(startTime,endTime);
			//echars显示用到的值
			List<AbReveOrder> applicationList = new ArrayList<AbReveOrder>();
			//详细的收益名称的值
			List<AbReveOrder> applicationDetailsList = new ArrayList<AbReveOrder>();
			//收益应用(左面的)截取
			List<AbReveOrder> applicationList1 = new ArrayList<AbReveOrder>();
			//收益应用(左面的)详细
			List<AbReveOrder> applicationDetailsList1 = new ArrayList<AbReveOrder>();
			//收益应用(右面的)截取
			List<AbReveOrder> applicationList2 = new ArrayList<AbReveOrder>();
			//收益应用(右面的)详细
			List<AbReveOrder> applicationDetailsList2 = new ArrayList<AbReveOrder>();
			if(adverListfirst.size() >0){
				for(int i=0;i<applicationListfirst.size();i++){
					AbReveOrder abOrder = new AbReveOrder();
					AbReveOrder abOrderDetails = new AbReveOrder();
					if(i>4){
						break;
					}else{
						//EChars显示用到的值(截取应用名字后的值)
						abOrder.setEarningsAmount(applicationListfirst.get(i).getEarningsAmount());
						//应用名称
						String appName=null;
						appName = applicationListfirst.get(i).getAppName().substring(
								0, applicationListfirst.get(i).getAppName().length()>6?6:applicationListfirst.get(i).getAppName().length());
						abOrder.setAppName(appName.length()==6?appName+"...":appName);
						applicationList.add(abOrder);
						//EChars显示用到的值(完全显示应用名字的值)
						abOrderDetails.setEarningsAmount(applicationListfirst.get(i).getEarningsAmount());
						abOrderDetails.setAppName(applicationListfirst.get(i).getAppName());
						applicationDetailsList.add(abOrderDetails);
					}
				}
				//EChars显示用到的值(截取应用名字后的值)
				if(applicationList.size() >5){
					Float earningsAmount = 0F;
					AbReveOrder abOrder1 = new AbReveOrder();
					for(int i=5;i<applicationListfirst.size();i++){
						earningsAmount+=applicationListfirst.get(i).getEarningsAmount();
					}
					abOrder1.setEarningsAmount(earningsAmount);
					abOrder1.setAppName("其他");
					applicationList.add(abOrder1);
				}
				//EChars显示用到的值(完全显示应用名字的值)
				if(applicationDetailsList.size() >5){
					Float earningsAmount = 0F;
					AbReveOrder abOrderDetails1 = new AbReveOrder();
					for(int i=5;i<applicationListfirst.size();i++){
						earningsAmount+=applicationListfirst.get(i).getEarningsAmount();
					}
					abOrderDetails1.setEarningsAmount(earningsAmount);
					abOrderDetails1.setAppName("其他");
					applicationDetailsList.add(abOrderDetails1);
				}
			}
			//截取应用的名字
			if(applicationList.size()>0){
				for(int i=0;i<applicationList.size();i++){
					AbReveOrder ab = new AbReveOrder();
					if(i%2 ==0){
						ab.setEarningsAmount(applicationList.get(i).getEarningsAmount());
						ab.setAppName(applicationList.get(i).getAppName());
						ab.setColor(colors[i]);
						applicationList1.add(ab);
					}else{
						ab.setEarningsAmount(applicationList.get(i).getEarningsAmount());
						ab.setAppName(applicationList.get(i).getAppName());
						ab.setColor(colors[i]);
						applicationList2.add(ab);
					}
				}
			}
			//完整的应用的名字
			if(applicationDetailsList.size()>0){
				for(int i=0;i<applicationDetailsList.size();i++){
					AbReveOrder abDetails = new AbReveOrder();
					if(i%2 ==0){
						abDetails.setEarningsAmount(applicationDetailsList.get(i).getEarningsAmount());
						abDetails.setAppName(applicationDetailsList.get(i).getAppName());
						abDetails.setColor(colors[i]);
						applicationDetailsList1.add(abDetails);
					}else{
						abDetails.setEarningsAmount(applicationDetailsList.get(i).getEarningsAmount());
						abDetails.setAppName(applicationDetailsList.get(i).getAppName());
						abDetails.setColor(colors[i]);
						applicationDetailsList2.add(abDetails);
					}
				}
			}
			//收益渠道ECahrs用到的数据
			m.put("proxyList", proxyList);
			//收益广告(左面的)截取
			m.put("proxyList1", proxyList1);
			//收益广告(右面的)截取
			m.put("proxyList2", proxyList2);
			//收益广告(左面的)详细
			m.put("proxyDetailsList1", proxyDetailsList1);
			//收益广告(右面的)详细
			m.put("proxyDetailsList2", proxyDetailsList2);
			//收益广告ECahrs用到的数据
			m.put("adverList", adverList);
			//收益广告(左面的)截取
			m.put("adverList1", adverList1);
			//收益广告(右面的)截取
			m.put("adverList2", adverList2);
			//收益广告(左面的)详细
			m.put("adverDetailList1", adverDetailList1);
			//收益广告(右面的)详细
			m.put("adverDetailList2", adverDetailList2);
			//收益应用ECahrs用到的数据
			m.put("applicationList", applicationList);
			//收益应用(左面的)截取
			m.put("applicationList1", applicationList1);
			//收益应用(右面的)截取
			m.put("applicationList2", applicationList2);
			//收益应用(左面的)详细
			m.put("applicationDetailsList1", applicationDetailsList1);
			//收益应用(右面的)详细
			m.put("applicationDetailsList2", applicationDetailsList2);
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
}
