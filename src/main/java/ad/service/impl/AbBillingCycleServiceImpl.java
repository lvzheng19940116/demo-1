package ad.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ad.bean.AbBillingCycle;
import ad.mapper.AbBillingCycleMapper;
import ad.service.IAbBillingCycleService;

import net.sf.json.JSONSerializer;

@Service
public class AbBillingCycleServiceImpl implements IAbBillingCycleService {

	@Autowired
	AbBillingCycleMapper abBillingCycleMapper;
	
	/**
	 * 	查询结算管理接口
	 */
	@Override
	public AbBillingCycle select(){
		AbBillingCycle abBillingCycle = abBillingCycleMapper.select();
		return abBillingCycle;
	}
	@Override
	public AbBillingCycle selectByPrimaryKey(int id){
		AbBillingCycle abBillingCycle = abBillingCycleMapper.selectByPrimaryKey(id);
		return abBillingCycle;
	}
	@Override
	public int insertSelective(AbBillingCycle abBillingCycle){ 
		int type = abBillingCycleMapper.insertSelective(abBillingCycle);
		return type;
	}
	@Override
	public int updateByPrimaryKeySelective(AbBillingCycle abBillingCycle){ 
		int type = abBillingCycleMapper.updateByPrimaryKeySelective(abBillingCycle);
		return type;
	}
	
	/**
	 * 修改结算日接口
	 * @param abBillingCycle
	 * @return
	 */
	@Override
	public String updateBillingCycle(AbBillingCycle abBillingCycle){ 
		Map<String,Object> m = new HashMap<String,Object>();
		int type =0;
		try{
			//查询结算日的信息
			AbBillingCycle abBilling = this.selectByPrimaryKey(abBillingCycle.getId());
			/**
			 * 逻辑：
			 * 1数据库表中只能存在一条数据
			 * 2项目刚开始启动的时候表中有可能数据没有，那样修改佣金管理就是在新加数据
			 * 3数据存在的时候，修改数据的时候修改数据库存在的那条数据
			 */
			if(abBilling ==null){
				abBillingCycle.setCreateTime(new Date());
				 type=this.insertSelective(abBillingCycle);
				 if(type ==1){
					 m.put("code", 200);
					 m.put("message", "ok");
					 m.put("success", "true");
					 m.put("result", type);
				 }else{
					 m.put("code", 0);
					 m.put("message", "fail");
					 m.put("result", type);
				 }
			}
			else{ 
				abBillingCycle.setCreateTime(new Date());
				type = this.updateByPrimaryKeySelective(abBillingCycle);
				if(type ==1){
					m.put("code", 200);
					 m.put("message", "ok");
					 m.put("success", "true");
					 m.put("result", type);
				 }else{
					 m.put("code", 0);
					 m.put("message", "fail");
					 m.put("result", type);
				 }
			}
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
	
	/**
	 * 返回代理级别  modified by caiqp
	 * 当没有数据时默认返回三级代理
	 */
	@Override
	public String getAgentNumber() {
		String count=abBillingCycleMapper.getAgentNumber();
		if(count==null){
			return "3";
		}else{
			return abBillingCycleMapper.getAgentNumber();
		}
	}
}
