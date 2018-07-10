package ad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ad.bean.TempMenu;
import ad.mapper.TempMenuMapper;

@Service
public class TempMenuServiceImpl {
	@Autowired
	private TempMenuMapper tempMenuMapper;
	
	public List<TempMenu> selectByCondition(TempMenu been){
		List<TempMenu> list = tempMenuMapper.selectByCondition(been);
		
		return list;
	}
}
