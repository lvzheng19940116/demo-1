package ad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import ad.bean.AbProxyUser;
import ad.mapper.AbProxyUserMapper;
import ad.service.IAbProxyUserService;
import ad.service.IAdsCountedByDayService;
import ad.util.MessageUtils;
@Service
public class AdsCountedByDayServiceImpl implements IAdsCountedByDayService {
	
	@Autowired
	private AbProxyUserMapper abProxyUserMapper;

	/**
	 * 查询按天统计数据
	 */
	@Override
	public String queryAgency() {
		try {
			//查询所有广告主
			List<AbProxyUser> list = abProxyUserMapper.queryAllProxyUser();
			return MessageUtils.jsonRetrunListMessage(1, "success", list);
		} catch (Exception e) {
			String jsonString = JSON.toJSONString(e);
			System.out.println(jsonString);
			return MessageUtils.commonReturnMessage(0, "fail");
		}
	}
}
