package ad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import ad.bean.AbProxyUser;
import ad.service.IAbProxyUserService;
import ad.service.IAdsCountedByDayService;
import ad.util.MessageUtils;

@Controller
@ResponseBody
@RequestMapping("/bydayCount")
public class AdsCountedByDayController {
	@Autowired
	private IAbProxyUserService IIAbProxyUserService;
	@Autowired
	private IAdsCountedByDayService iAdsCountedByDayService;

	/**
	 * 查询统计数据
	 * @return
	 */
	@RequestMapping(value = "/queryAgencyAll", produces = { "application/json; charset=utf-8" })
	public String queryAgency() {
		return iAdsCountedByDayService.queryAgency();
	}

	@RequestMapping(value = "/statisticsDay", produces = { "application/json; charset=utf-8" })
	public String queryByDayCount() {
		try {
			return MessageUtils.jsonRetrunListMessage(1, "success", null);
		} catch (Exception e) {
			return MessageUtils.commonReturnMessage(0, "fail");
		}

	}

}
