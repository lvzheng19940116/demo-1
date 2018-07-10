package ad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import ad.bean.AbAdvertProxyAssociation;
import ad.bean.AbProxyUser;
import ad.service.IAbAdvertProxyAssociationService;
import ad.service.IProportionService;
import ad.util.MessageUtils;

/**
 * 广告配置后台分成比例管理
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/prop")
public class ProportionController {

	@Autowired
	private IAbAdvertProxyAssociationService iiiAbAdvertProxyAssociationService;
	@Autowired
	private IProportionService iProportionService;

	/**
	 * 广告分成比例分页查询
	 * 
	 * @param been
	 * @return
	 */
	@RequestMapping(value = "/QueryDistribution", produces = { "application/json; charset=utf-8" })
	public String queryByPage(AbAdvertProxyAssociation been) {
		return iProportionService.queryByPage(been);
	}

	/**
	 * 广告分成比例修改
	 * 
	 * @param been
	 * @return
	 */
	@RequestMapping(value = "/UpdateDistribution", produces = { "application/json; charset=utf-8" })
	public String updateDistribution(AbProxyUser been) {
		return iProportionService.updateDistribution(been);
	}

}
