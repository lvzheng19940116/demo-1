package ad.service.impl;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ad.bean.AbAdvertProxyAssociation;
import ad.bean.AbOrderDetailsAssociated;
import ad.bean.AbProxyUser;
import ad.bean.AbReveOrderDetails;
import ad.mapper.AbAdvertProxyAssociationMapper;
import ad.mapper.AbOrderDetailsAssociatedMapper;
import ad.mapper.AbProxyUserMapper;
import ad.mapper.AbReveOrderDetailsMapper;
import ad.service.IAbReveOrderDetailsService;

import net.sf.json.JSONSerializer;

@Service
public class AbReveOrderDetailsServiceImpl implements IAbReveOrderDetailsService{

	@Autowired
	AbReveOrderDetailsMapper abReveOrderDetailsMapper;
	
	@Autowired
	AbOrderDetailsAssociatedMapper abOrderDetailsAssociatedMapper;
	
	@Autowired
	private AbProxyUserMapper abProxyUserMapper;
	
	@Autowired
	AbAdvertProxyAssociationMapper abAdvertProxyAssociationMapper;
	
	@Override
	public AbReveOrderDetails selectByPrimaryKey(AbReveOrderDetails abReveOrderDetail){
		AbReveOrderDetails abReveOrderDetails = abReveOrderDetailsMapper.select(abReveOrderDetail);
		return abReveOrderDetails;
	}
	@Override
	public AbOrderDetailsAssociated selectByorderId(AbOrderDetailsAssociated abOrderDetailsAssociated){
		AbOrderDetailsAssociated AbOrderDetail=abOrderDetailsAssociatedMapper.selectByorderId(abOrderDetailsAssociated);
		return AbOrderDetail;
	}
	@Override
	public List<AbReveOrderDetails> selectAbReveOrderDetailsList(AbReveOrderDetails abReveOrderDetails){
		List<AbReveOrderDetails> abReveOrderDetailsList=abReveOrderDetailsMapper.selectAbReveOrderDetailsList(abReveOrderDetails);
		return abReveOrderDetailsList;
	}

	/**
	 * 查询详细的条数
	 * @param abOrderDetailsAssociated
	 * @return
	 */
	@Override
	public String queryRevenueOrdersDetails(AbReveOrderDetails abReveOrderDetails){
		/**
		 * 逻辑：
		 * 1查询详细的数据要去详细的查询列表查询数据
		 * 2查询出来的数据分为两种情况：
		 * 3自己产生的和下级代理产生的
		 * 4分别给产生代理，产生用户手机号，产生用户名称赋值
		 */
		Map<String,Object> m = new HashMap<String,Object>();
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try{
			//判断前台是否输入时间
			if(abReveOrderDetails.getEvenTime() !=null && !("").equals(abReveOrderDetails.getEvenTime()) &&!("null").equals(abReveOrderDetails.getEvenTime())){
				String[] evenTime = abReveOrderDetails.getEvenTime().split(",");
				abReveOrderDetails.setEvenStartTime(evenTime[0]);
				abReveOrderDetails.setEvenEndTime(evenTime[1]);
			}
			//分页处理
			int page = abReveOrderDetails.getPage();
			abReveOrderDetails.setPage((page-1)*10);
			//查询详细的信息
			List<AbReveOrderDetails> abReveOrderDetailsList = this.selectAbReveOrderDetailsList(abReveOrderDetails);
			for(AbReveOrderDetails u:abReveOrderDetailsList){
				if(u.getCreateTime() != null){
					u.setTime(time.format(u.getCreateTime()));
				}
				//自己产生的
				if(u.getType() ==1){
					AbProxyUser queryById = abProxyUserMapper.selectByPrimaryKey(u.getProxyId());
					if(queryById.getAgencyLevel() ==1){
						AbAdvertProxyAssociation abAdvertProxyAssociation = new AbAdvertProxyAssociation();
						abAdvertProxyAssociation.setAdverId(abReveOrderDetails.getAdverId());
						abAdvertProxyAssociation.setProxyId(abReveOrderDetails.getProxyId());
						abAdvertProxyAssociation.setProxyGrade(queryById.getAgencyLevel());
						AbAdvertProxyAssociation abAdvertProxy = abAdvertProxyAssociationMapper.selectAbAdvertProxy(abAdvertProxyAssociation);
						u.setDistributionRatio(abAdvertProxy==null?queryById.getDistributionRatio():abAdvertProxy.getDistributionRatio());//分佣比例
					}else{
						u.setDistributionRatio(queryById.getDistributionRatio());//分佣比例
					}
					u.setProxyName(queryById.getId()+"");//收益用户ID
					u.setProxyUserName(queryById.getProxyUserName());//收益名称
					u.setProxyPhone(queryById.getProxyPhone());//收益手机号
					u.setSubProxyName(queryById.getId()+"");//产生ID
					u.setSubProxyUserName(queryById.getProxyUserName());//产生用户名
					u.setSubProxyPhone(queryById.getProxyPhone());//产生手机号
				}
				//别人产生的
				else{
					//收益用户的信息
					AbProxyUser queryById = abProxyUserMapper.selectByPrimaryKey(u.getProxyId());
					u.setProxyName(queryById.getId()+"");
					u.setProxyUserName(queryById.getProxyUserName());//收益名称
					u.setProxyPhone(queryById.getProxyPhone());//收益手机号
					//产生收益用户的信息
					AbProxyUser queryBySubProxyId = abProxyUserMapper.selectByPrimaryKey(u.getSubProxyId());
					u.setSubProxyName(queryBySubProxyId.getId()+"");//产生用户ID
					u.setSubProxyUserName(queryBySubProxyId.getProxyUserName());//产生用户名称
					u.setSubProxyPhone(queryBySubProxyId.getProxyPhone());//产生手机号
					u.setDistributionRatio(queryBySubProxyId.getDistributionRatio());
				}
			}
			m.put("code", 200);
			m.put("message", "ok");
			m.put("success", "true");
			m.put("abReveOrderDetailsList", abReveOrderDetailsList);
			m.put("total", abReveOrderDetailsList.size() ==0?0:abReveOrderDetailsList.get(0).getTotalNumber());
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
}
