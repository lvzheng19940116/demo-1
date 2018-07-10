package ad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ad.bean.AbAdvertProxyAssociation;
import ad.bean.AbProxyUser;
import ad.mapper.AbAdvertProxyAssociationMapper;
import ad.service.IProportionService;
import ad.util.MessageUtils;

@Service
public class ProportionServiceImpl implements IProportionService {

	@Autowired
	private AbAdvertProxyAssociationMapper abAdvertProxyAssociationMapper;
	
	/**
	 * 广告分成比例分页查询
	 * 
	 * @param been
	 * @return
	 */
	@Override
	public String queryByPage(AbAdvertProxyAssociation been) {
		try {
			been.setPage((been.getPage() - 1) * 10);
			//查询广告分成比例数据
			List<AbAdvertProxyAssociation> list = abAdvertProxyAssociationMapper.queryByPage(been);
			//查询总数
			long total = abAdvertProxyAssociationMapper.selectTotal();
			return MessageUtils.jsonRetrunListTotalMessage(1, "success", list, total);
		} catch (Exception e) {
			return MessageUtils.commonReturnMessage(0, "fail");
		}
	}
	
	/**
	 * 修改广告分成比例
	 */
	@Override
	public String updateDistribution(AbProxyUser been) {
		try {
			int code = abAdvertProxyAssociationMapper.updateByKey(been);
			return MessageUtils.commonReturnMessage(code, "success");
		} catch (Exception e) {
			return MessageUtils.commonReturnMessage(0, "fail");
		}
	}
}
