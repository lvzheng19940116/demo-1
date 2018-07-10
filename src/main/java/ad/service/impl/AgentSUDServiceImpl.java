package ad.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import ad.bean.AbProxyUser;
import ad.mapper.AbProxyUserMapper;
import ad.mapper.TablesMapper;
import ad.service.IAbProxyUserService;
import ad.service.IAgentSUDService;
import ad.service.AS_.DeService.Deservice;
import ad.util.Constends;
import ad.util.DateUtil;
import ad.util.DesCrypt;
import ad.util.HttpConnection;
import ad.util.MessageUtils;
import ad.util.sixNum;

import net.sf.json.JSONSerializer;

@Service
public class AgentSUDServiceImpl implements IAgentSUDService {
	
	@Autowired
	private IAbProxyUserService abProxyUserService;
	@Autowired
	private Deservice deservices;
	@Autowired
	TablesMapper ablesMapper;
	@Autowired
	private AbProxyUserMapper abProxyUserMapper;

	/**
	 * 添加代理用户
	 * @param abProxyUser
	 * @param req
	 * @return
	 */
	@Override
	public String AddProxyInfo(AbProxyUser abProxyUser, HttpServletRequest req) {
		// 获取当前代理--统一用户中心的用户编号
		String ussn = req.getParameter("proxy_id");
		// 获取当前代理ID 根据根据统一用户中心的用户编号
		Integer id = deservices.selectidBytyid(ussn);
		Integer cynum = deservices.selectcynum(id);
		if (id == null || "".equals(id)) {
			return "";
		} else {
			// System.out.println("当前的代理ID是：添加代理===============" + id + "等级" +
			// cynum);
		}
		abProxyUser.setFatherId(id);
		abProxyUser.setAgencyLevel(cynum + 1);
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			String token = req.getParameter("token");
			String siteCode = req.getParameter("siteCode");
			String userId = DateUtil.createKey();
			// String serverURL = "http://172.22.53.12:8080"+
			// "/addUserInfo.action";
			String serverURLRole = HttpConnection.serverURL + "/updateUserRole.action";
			try {
				// 获取userId AbAdvertiser selectMaxId()
				String commonReturnMessage = null;
				// 绑定角色
				String advertiser_roleId = "";
				if (cynum < 2) {
					advertiser_roleId = Constends.ab_proxy_user_roleId;
				}
				if (cynum == 2) {
					advertiser_roleId = Constends.ab_proxy_user3_roleId;
				}
				advertiser_roleId = Constends.ab_proxy_user_roleId;
				Map<String, Object> qxmap = new HashMap<>();
				qxmap.put("userAccount", abProxyUser.getProxyPhone());//abProxyUser.getProxyName()
				qxmap.put("mobTel", abProxyUser.getProxyPhone());
				qxmap.put("email", abProxyUser.getProxyEmail());
				//String userPassword = sixNum.sixNum();
				qxmap.put("userPassword", "123456");//DesCrypt.encrypt(userPassword)
				// qxmap.put("userPassword", DesCrypt.encrypt("123456"));
				qxmap.put("siteCode", siteCode);
				qxmap.put("userId", userId);
				qxmap.put("roleId", advertiser_roleId);
				// System.out.println(qxmap);
				// System.out.println(serverURLRole);
				String httpGETRole = HttpConnection.httpPost(serverURLRole, JSONSerializer.toJSON(qxmap).toString(),
						token);
				// System.out.println(httpGETRole +
				// "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
				JSONObject strToJSONobjectRole = MessageUtils.strToJSONobject(httpGETRole);
				String string = strToJSONobjectRole.getString("success");
				if (string.equals("true")) {
					try {
						// int saveObject =
						// iAbAdvertiserService.saveObject(record);
						// commonReturnMessage =
						// MessageUtils.commonReturnMessage(saveObject,
						// "success");
						abProxyUser.setProxyPassword("123456");
						abProxyUser.setCreateTime(new Date());
						abProxyUser.setUserid(userId);
						abProxyUser.setAppkey(DateUtil.createKey()+selectMax());
						int type = 0;
						String name = abProxyUser.getProxyName();
						int i = abProxyUserService.selectProxyUserByName(name);
						if (i == 0) {
							type = abProxyUserService.insertSelective(abProxyUser);
							if (type == 1) {
								int typeNumber = abProxyUserService.updateByPrimaryId(abProxyUser);
								if (typeNumber == 1) {
									m.put("code", 1);
									m.put("message", "success");
									m.put("success", "true");
								}
							}
						} else {
							m.put("code", 150);
							m.put("message", "error");
							m.put("success", "false");
						}
						return JSONSerializer.toJSON(m).toString();
					} catch (Exception e) {
						return MessageUtils.commonReturnMessage(0, "fail");
					} finally {
					}
				}
				return commonReturnMessage;
			} catch (Exception e) {
				return MessageUtils.commonReturnMessage(0, "远程推送异常");
			}
		} catch (Exception e) {
			m.put("code", 0);
			m.put("message", "fail");
			return JSONSerializer.toJSON(m).toString();
		}
	}
	
	/**
	 * 修改代理用户
	 * 
	 * @param abProxyUser
	 * @param req
	 * @return
	 */
	@Override
	public String UpdateProxyInfo(AbProxyUser abProxyUser, HttpServletRequest req) {
		Integer id = Integer.valueOf(req.getParameter("id"));
		AbProxyUser newAbProxyUser =abProxyUserMapper.selectByPrimaryKey(id);
		//System.out.println(newAbProxyUser.getProxyEmail());
		Map<String, Object> m = new HashMap<String, Object>();
		// 推送远程修改的内容
		String serverURL = HttpConnection.serverURL + "/updateUserInfo.action";
		String token = req.getParameter("token");
		String siteCode = req.getParameter("siteCode");
		Map<String, String> rolePara = new HashMap<String, String>();
		rolePara.put("siteCode", siteCode);// 业务中心代码
		rolePara.put("userID", newAbProxyUser.getUserid());// 用户中心代码
		rolePara.put("token", token);
		rolePara.put("mobTel", abProxyUser.getProxyPhone());// 用户手机号
		rolePara.put("email", newAbProxyUser.getProxyEmail());// 用户邮箱
		int type = 0;
		String httpPOST = HttpConnection.HttpPost(rolePara, serverURL);
		JSONObject strToJSONobject = MessageUtils.strToJSONobject(httpPOST);
		// 判断是佛修改成功
		if (("true").equals(strToJSONobject.getString("success"))) {
			type = abProxyUserMapper.updateByPrimaryKeySelective(abProxyUser);
		}
		if (type == 1) {
			m.put("code", 1);
			m.put("message", "success");
			m.put("success", "true");
		} else {
			m.put("code", 1);
			m.put("message", "error");
			m.put("success", "false");
		}
		return JSONSerializer.toJSON(m).toString();
	}
	
	public Integer selectMax() {
		Integer maxId = ablesMapper.selectMaxId();
		return maxId;
	}
}
