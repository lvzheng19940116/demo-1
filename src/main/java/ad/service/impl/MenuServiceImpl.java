package ad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ad.bean.TempMenu;
import ad.mapper.TempMenuMapper;
import ad.service.IMenuService;
@Service
public class MenuServiceImpl implements IMenuService {

	@Autowired
	private TempMenuMapper tempMenuMapper;

	@Override
	public List<TempMenu> queryMenuList() {
		List<TempMenu> list = tempMenuMapper.queryByCondtion();
		return list;
	}

}
