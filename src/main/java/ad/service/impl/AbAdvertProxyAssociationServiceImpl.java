package ad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ad.bean.AbAdvertProxyAssociation;
import ad.bean.AbProxyUser;
import ad.mapper.AbAdvertProxyAssociationMapper;
import ad.service.IAbAdvertProxyAssociationService;

@Service
public class AbAdvertProxyAssociationServiceImpl implements IAbAdvertProxyAssociationService {
	@Autowired
	private AbAdvertProxyAssociationMapper abAdvertProxyAssociationMapper;

	@Override
	public int saveObject(AbAdvertProxyAssociation been) {
		int code = abAdvertProxyAssociationMapper.insertSelective(been);
		return code;
	}

	@Override
	public List<AbAdvertProxyAssociation> queryByAdverId(Integer id) {
		List<AbAdvertProxyAssociation> list = abAdvertProxyAssociationMapper.selectByAdverId(id);
		return list;
	}

	@Override
	public int updateByProxyId(AbAdvertProxyAssociation been) {
		int code = abAdvertProxyAssociationMapper.updateByProxyId(been);
		return code;
	}

	/**
	 * 查询广告分成比例数据
	 */
	@Override
	public List<AbAdvertProxyAssociation> queryByPage(AbAdvertProxyAssociation been) {
		List<AbAdvertProxyAssociation> queryByPage = abAdvertProxyAssociationMapper.queryByPage(been);

		return queryByPage;
	}
	/**
	 * 查询广告分成比例总条数
	 */
	@Override
	public long selectTotal() {
		long total = abAdvertProxyAssociationMapper.selectTotal();
		return total;
	}

	/**
	 * 修改广告分成比例
	 */
	@Override
	public int updateByKey(AbProxyUser been) {
		int code = abAdvertProxyAssociationMapper.updateByKey(been);
		return code;
	}

	@Override
	public int deleteByAdverId(Integer id) {
		int code = abAdvertProxyAssociationMapper.deleteByAdverId(id);
		return code;
	}

}
