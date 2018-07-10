package ad.service.impl;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ad.bean.AbBillingInfo;
import ad.bean.AbProxyUser;
import ad.mapper.AbBillingInfoMapper;
import ad.mapper.AbProxyUserMapper;
import ad.service.IAbBillingInfoService;

import net.sf.json.JSONSerializer;

@Service
public class AbBillingInfoServiceImpl implements IAbBillingInfoService {
	
	private static final Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
	@Autowired
	AbBillingInfoMapper abBillingInfoMapper;
	
	@Autowired
	private AbProxyUserMapper abProxyUserMapper;
	
	/**
	 * 结算记录查询
	 */
	@Override
	public List<AbBillingInfo> select(AbBillingInfo abBillingInfo){
		//结算记录查询
		List<AbBillingInfo> abBillingInfoList = abBillingInfoMapper.select(abBillingInfo);
		return abBillingInfoList;
	}
	/**
	 * 处理转账或是完成
	 */
	@Override
	public int updateByPrimaryKeySelective(AbBillingInfo abBillingInfo){
		//处理转账或是完成
		int type = abBillingInfoMapper.updateByPrimaryKeySelective(abBillingInfo);
		return type;
	} 
	
	@Override
	public Float setCumulativeIncome(int id){
		Float cumulativeIncome = abBillingInfoMapper.setCumulativeIncome(id);
		return cumulativeIncome;
	}
	
	/**
	 * 结算记录查询所有数据的接口
	 * @param abBillingInfo
	 */
	@Override
	public String queryBillingAllInformationList(AbBillingInfo abBillingInfo){
		Map<String,Object> m = new HashMap<String,Object>();
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try{
			//处理分页的功能
			int page = abBillingInfo.getPage();
			abBillingInfo.setPage((page-1)*10);
			//结算记录查询
			List<AbBillingInfo> abBillingInfoList = this.select(abBillingInfo);
			for(AbBillingInfo abInfo:abBillingInfoList){
				//时间的格式化
				if(abInfo.getCreateTime() != null){
					abInfo.setClearTime(time.format(abInfo.getCreateTime()));
				}
				if(abInfo.getStartTime() != null){
					abInfo.setClearStartTime(time.format(abInfo.getStartTime()));
				}
				if(abInfo.getEndTime() != null){
					abInfo.setClearEndTime(time.format(abInfo.getEndTime()));
				}
				//查询代理ID
				AbProxyUser queryById = abProxyUserMapper.selectByPrimaryKey(abInfo.getBillingUserId());
				if(queryById !=null){
					abInfo.setProxyName(queryById.getId()+"");
				}
			}
			m.put("code", 200);
			m.put("message", "success");
			m.put("abBillingInfo", abBillingInfoList);
			m.put("total", abBillingInfoList.size() ==0?0:abBillingInfoList.get(0).getTotalNumber());
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
	
	/**
	 *结算信息查询接口
	 *查询条件：结算用户ID（手机号、用户名、银行卡号）、金额范围、时间范围、结算状态（需要点击转账的、需要点击完成的）
	 * @param abBillingInfo
	 * @return
	 */
	@Override
	public String queryBillingInformationList(AbBillingInfo abBillingInfo){
		Map<String,Object> m = new HashMap<String,Object>();
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try{
			//因为前台控件传过来的值是String类型，这里需要转换
			//判断前台的搜索条件
			//判断搜索条件是否为结算用户手机号
			if(abBillingInfo.getRegionFlag().equals("clearingTelephone") && !abBillingInfo.getClearingName().trim().equals("")){
				abBillingInfo.setProxyPhone(abBillingInfo.getClearingName());
			}
			//判断搜索条件是否为结算用户ID
			if(abBillingInfo.getRegionFlag().equals("clearingUserId") && !abBillingInfo.getClearingName().trim().equals("")){
//				abBillingInfo.setProxyName(abBillingInfo.getClearingName());
				//判断输入的用户Id是否为纯数字
				boolean type = pattern.matcher(abBillingInfo.getClearingName()).matches();
				if(type ==true){
					abBillingInfo.setBillingUserId(Integer.valueOf(abBillingInfo.getClearingName()));
				}
				else{
					m.put("fail", 0);
					 return JSONSerializer.toJSON(m).toString();
				}
			}
			//判断搜索条件是否为结算用户名称
			if(abBillingInfo.getRegionFlag().equals("clearingUserName") && !abBillingInfo.getClearingName().trim().equals("")){
				abBillingInfo.setProxyUserName(abBillingInfo.getClearingName());
			}
			//判断搜索条件是否为结算记录生成时间
			if(abBillingInfo.getTimeFlag().equals("clearingTime") && !abBillingInfo.getCompleteDate().trim().equals("")){
				abBillingInfo.setCreateTime(new Date());
				String[] completeDate = abBillingInfo.getCompleteDate().split(",");
				abBillingInfo.setTime1(completeDate[0]);
				abBillingInfo.setTime2(completeDate[1]);
			}
			//判断搜索条件是否为结算起始时间
			if(abBillingInfo.getTimeFlag().equals("clearingStartTime") && !abBillingInfo.getCompleteDate().trim().equals("")){
				abBillingInfo.setStartTime(new Date());
				String[] completeDate = abBillingInfo.getCompleteDate().split(",");
				abBillingInfo.setTime1(completeDate[0]);
				abBillingInfo.setTime2(completeDate[1]);
			}
			//判断搜索条件是否为结算完成时间
			if(abBillingInfo.getTimeFlag().equals("clearingEndTime") && !abBillingInfo.getCompleteDate().trim().equals("")){
				abBillingInfo.setEndTime(new Date());
				String[] completeDate = abBillingInfo.getCompleteDate().split(",");
				abBillingInfo.setTime1(completeDate[0]);
				abBillingInfo.setTime2(completeDate[1]);
			}
			//分页处理
			int page = abBillingInfo.getPage();
			abBillingInfo.setPage((page-1)*10);
			//按搜索条件的查询接口
			List<AbBillingInfo> abBillingIList = abBillingInfoMapper.queryBillingInformationList(abBillingInfo);
			for(AbBillingInfo abInfo:abBillingIList){
				//时间的格式化
				if(abInfo.getCreateTime() != null){
					abInfo.setClearTime(time.format(abInfo.getCreateTime()));
				}
				if(abInfo.getStartTime() != null){
					abInfo.setClearStartTime(time.format(abInfo.getStartTime()));
				}
				if(abInfo.getEndTime() != null){
					abInfo.setClearEndTime(time.format(abInfo.getEndTime()));
				}
				//查询代理ID
				AbProxyUser queryById = abProxyUserMapper.selectByPrimaryKey(abInfo.getBillingUserId());
				if(queryById !=null){
					abInfo.setProxyName(queryById.getId()+"");
				}
			}
			m.put("code", 200);
			m.put("message", "success");
			m.put("abBillingIList", abBillingIList);
			m.put("total", abBillingIList.size() ==0?0:abBillingIList.get(0).getTotalNumber());
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	} 
	
	/**
	 * 结算数据管理转账和完成
	 * @param ids(主键)
	 * @param flag(标记)
	 * @return
	 */
	@Override
	public String transferCompleted(String ids,String flag){
		Map<String,Object> m = new HashMap<String,Object>();
		int typeResult =0;
		try{
			//处理批量的事件
			List<String> idList = Arrays.asList(ids.split(","));
			for(int i=0;i<idList.size();i++){
				AbBillingInfo abBillingInfo = new AbBillingInfo();
				abBillingInfo.setId(Integer.valueOf(idList.get(i)));
				if(flag.equals("0")){
					abBillingInfo.setStartTime(new Date());
					abBillingInfo.setFlag(1);
				}else{
					abBillingInfo.setEndTime(new Date());
					abBillingInfo.setFlag(2);
				}
				//处理转账或是完成
				int type = this.updateByPrimaryKeySelective(abBillingInfo);
				if(type ==1){
					typeResult++;
				}else{
					break;
				}
			}
			//判断是否全部完成
			if(typeResult ==idList.size()){
				m.put("result", 200);
				m.put("code", 1);
				m.put("message", "success");
			}else{
				m.put("result", 0);
				m.put("code", 0);
				m.put("message", "fail");
			}
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
} 
