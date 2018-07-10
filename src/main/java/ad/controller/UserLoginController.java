package ad.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import ad.bean.TempMenu;
import ad.service.impl.TempMenuServiceImpl;
import ad.util.Constends;
import ad.util.HttpConnection;
import ad.util.RedisUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("/userLogin")
public class UserLoginController {
	@Autowired
	private TempMenuServiceImpl tempMenuService;

	@RequestMapping(value = "/login")
	/*********************
	 * 用户登录
	 * 
	 * @param req
	 * @param response
	 * @return
	 */
	public String login(HttpServletRequest req, HttpServletResponse response) {

		String username = req.getParameter("userAccount");
		String password = req.getParameter("userpassword");
		String siteCode = req.getParameter("siteCode");
		String token = "";

		Map map1 = new HashMap();
		map1.put("username", username);
		map1.put("password", password);//DesCrypt.encrypt(password)
		map1.put("siteCode", siteCode);
		// 去权限管理登录验证 得到用户信息和token
		String AsyncUrl = HttpConnection.serverURL + "/Login.action";
		String data = HttpConnection.HttpGET(map1, AsyncUrl);
		JSONObject user = new JSONObject();
		//System.out.println(data);

		try {
			JSONObject jsonobject = JSONObject.fromObject(data);
			user = (JSONObject) jsonobject.get("user");
			token = (String) jsonobject.get("token");
		} catch (Exception e1) {
			user.put("error", "用户名或密码不正确");
			return JSONSerializer.toJSON(user).toString();
		}

		user.put("token", token);
		user.put("siteCode", siteCode);
		String roleId = "0";
		try {
			roleId = user.getString("roleId");
		} catch (Exception e) {
		}
		int roleType = 1;
		if(roleId.equals(Constends.ab_advertiser_roleId)){
			roleType = 3;
		}
		else if(roleId.equals(Constends.ab_proxy_user_roleId) || roleId.equals(Constends.ab_proxy_user3_roleId)){
			roleType = 4;
		}
		user.put("roleType", roleType);
		
		Map map2 = new HashMap();
		map2.put("userID", (String) user.get("userID"));
		map2.put("siteCode", siteCode);
		map2.put("token", token);

		// 再去权限管理获取用户权限菜单
		String AsyncUrl2 = HttpConnection.serverURL + "/GetMenuInfo.action";
//		System.out.println(AsyncUrl2);
		// System.out.println(AsyncUrl2+"?userID="+(String)user.get("userID")+"&siteCode="+siteCode+"&token="+token);
		String data2 = HttpConnection.HttpGET(map2, AsyncUrl2);

		JSONObject jsonobject = JSONObject.fromObject(data2);
		JSONArray menusCode = (JSONArray) jsonobject.get("menusCode");
		String menustr1 = JSONSerializer.toJSON(menusCode).toString();
		jsonobject.put("menusCode", menustr1);
//		JSONObject js = JSONObject.fromObject(menustr1);
		menusCode = (JSONArray) (JSONArray) jsonobject.get("menusCode");
		TempMenu been = new TempMenu();
		been.setList(menusCode);
		List<TempMenu> tempMenu = null;
		if (!menusCode.isEmpty()) {
			tempMenu = tempMenuService.selectByCondition(been);
		}
		user.put("homePage", "login");
		if (menusCode != null && menusCode.size() > 0) {
			JSONObject ob = (JSONObject) menusCode.get(0);
			if(((String)ob.get("orderNum")).equals("1")){
				ob = (JSONObject) menusCode.get(1);
				String code = (String) ob.get("code");
				user.put("homePage", code);
			}else{
				ob=(JSONObject) menusCode.get(0);
				String code = (String) ob.get("code");
				user.put("homePage", code);
			}
			
		}

		Jedis jedis = RedisUtil.getJedis();
		String menustr = JSONSerializer.toJSON(menusCode).toString();
		jedis.set("MENU=" + token, menustr);	
		jedis.expire("MENU=" + token, 3600);
		System.out.println("存入Jedis权限菜单----" + menustr);
		//
		// jedis.set("ROUTE=" + token, JSON.toJSONString(tempMenu));
		// jedis.expire("ROUTE=" + token, 3600);
		// System.out.println("存入Jedis路由信息----" + tempMenu);

		// 存入用户信息和菜单信息到redis
		jedis.set("CUSER=" + token, JSONSerializer.toJSON(user).toString());
		jedis.expire("CUSER=" + token, 3600);

		jedis.set("ROUTE=" + token, JSON.toJSONString(tempMenu));
		jedis.expire("ROUTE=" + token, 3600);

		RedisUtil.returnResource(jedis);
		// 将用户的token存入Cookie客户端 用户刷新页面时获取redis信息用
		Cookie cookie = new Cookie("token", (String) user.get("token"));
		response.addCookie(cookie);// 将cookie返回加入
//		System.out.println(menusCode);
		Map m = new HashMap();
		m.put("user", user);
		m.put("menu", menusCode);
		m.put("route", JSON.parseArray(JSON.toJSONString(tempMenu)));
		return JSONSerializer.toJSON(m).toString();
	}

	/*******************
	 * 修改用户密码
	 * 
	 * @param req
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/updatePass")
	public String updatePass(HttpServletRequest req, HttpServletResponse response) {

		String userID = req.getParameter("userID");
		String token = req.getParameter("token");
		String siteCode = req.getParameter("siteCode");
		String password = req.getParameter("password");
		String oldPassword = req.getParameter("oldPassword");

		Map map1 = new HashMap();
		map1.put("userID", userID);
		map1.put("token", token);
		map1.put("siteCode", siteCode);
		map1.put("password", password);
		map1.put("oldPassword", oldPassword);
		// 去权限中心修改用户密码
		String AsyncUrl = HttpConnection.serverURL + "/updatePass.action";
		String data = HttpConnection.HttpPost(map1, AsyncUrl);

		return data;
	}

	@RequestMapping(value = "/logout")
	/***************
	 * 用户登出
	 * 
	 * @param req
	 * @param response
	 * @return
	 */
	public String logout(HttpServletRequest req, HttpServletResponse response) {

		String userID = req.getParameter("userID");
		String token = req.getParameter("token");
		String siteCode = req.getParameter("siteCode");

		Map map1 = new HashMap();
		map1.put("userID", userID);
		map1.put("token", token);
		map1.put("siteCode", siteCode);

		// 去权限中心登出
		String AsyncUrl = HttpConnection.serverURL + "/Logout.action";
		String data = HttpConnection.HttpGET(map1, AsyncUrl);
		Jedis jedis = RedisUtil.getJedis();
		jedis.del("CUSER=" + token);
		jedis.del("MENU=" + token);
		jedis.del("ROUTE=" + token);
		RedisUtil.returnResource(jedis);

		Cookie cookie = new Cookie("token", token);
		cookie.setMaxAge(0);
		response.addCookie(cookie);// 将cookie返回加入
		return "{\"userID\":\"" + userID + "\",\"success\":\"true\"} ";
	}

	@RequestMapping(value = "/getUserToken")
	/*****************
	 * 获取用户token及用户信息
	 * 
	 * @param req
	 * @param response
	 * @return
	 */
	public String getUserToken(HttpServletRequest req, HttpServletResponse response) {

		String token = "";
		Jedis jedis = RedisUtil.getJedis();
		Cookie[] cookies = req.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				String value = cookie.getValue();
				if (name.equals("token")) {
					token = value; // 从Cookie中获取用户的token
				}
			}
		}
		if (token.length() > 0) {
			String userjson = jedis.get("CUSER=" + token);// 从redis中通过token获取用户的信息
			String menujson = jedis.get("MENU=" + token);// 从redis中通过token获取权限菜单信息
			String routejson = jedis.get("ROUTE=" + token);
			if (userjson == null || "null".equals(userjson)) {
				userjson = "";
			}
			if (userjson.length() > 0) {
				jedis.set("CUSER=" + token, userjson);
				jedis.expire("CUSER=" + token, 3600);

				jedis.set("MENU=" + token, menujson);
				jedis.expire("MENU=" + token, 3600);
				RedisUtil.returnResource(jedis);
				JSONObject user = JSONObject.fromObject(userjson);
				JSONArray menu = JSONArray.fromObject(menujson);
				Map m = new HashMap();
				m.put("user", user);
				m.put("menu", menu);
				m.put("route", routejson);
				return JSONSerializer.toJSON(m).toString();
			} else {
				return "{\"error\":\"session timeout\"}";
			}
		} else {
			return "{\"error\":\"session timeout\"}";
		}

	}

	@RequestMapping(value = "/GetMenuInfo")
	/*****************
	 * 获取用户权限菜单
	 * 
	 * @param req
	 * @param response
	 * @return
	 * 
	 */
	public String GetMenuInfo(HttpServletRequest req, HttpServletResponse response) {

		String userID = req.getParameter("userID");
		String siteCode = req.getParameter("siteCode");
		String token = req.getParameter("token");
		Jedis jedis = RedisUtil.getJedis();
		String menujson = jedis.get("MENU=" + token); // 从redis中通过token获取权限菜单

		if (menujson == null || menujson.length() == 0) { // 如果为空则去权限中心获取
															// 再存入redis中
			Map map1 = new HashMap();
			map1.put("userID", userID);
			map1.put("siteCode", siteCode);
			map1.put("token", token);

			String AsyncUrl = HttpConnection.serverURL + "/GetMenuInfo.action";
			String data2 = HttpConnection.HttpGET(map1, AsyncUrl);

			JSONObject jsonobject = JSONObject.fromObject(data2);
			JSONArray menusCode = (JSONArray) jsonobject.get("menusCode");
			if (menusCode != null && menusCode.size() > 0) {
				JSONObject ob = (JSONObject) menusCode.get(0);
				String code = (String) ob.get("code");

				for (int i = 0; i < menusCode.size(); i++) {
					JSONObject obj = (JSONObject) menusCode.get(i);
					String name = (String) obj.get("name");
					if (name.equals("广告统计-按天") || name.equals("广告统计-分时")) {
						JSONObject o = new JSONObject();
						o.put("id", "ad_1");
						o.put("name", "广告统计");
						o.put("orderNum", "0");
						o.put("pid", "0");
						o.put("leaf", "0");
						o.put("code", "ad_1");
						o.put("type", "1");
						menusCode.add(o);
						break;
					}
				}

				for (int i = 0; i < menusCode.size(); i++) {
					JSONObject obj = (JSONObject) menusCode.get(i);
					String name = (String) obj.get("name");
					if (name.equals("代理用户管理") || name.equals("用户信息")) {
						JSONObject o = new JSONObject();
						o.put("id", "ad_2");
						o.put("name", "用户管理");
						o.put("orderNum", "0");
						o.put("pid", "0");
						o.put("leaf", "0");
						o.put("code", "ad_2");
						o.put("type", "1");
						menusCode.add(o);
						break;
					}
				}

				for (int i = 0; i < menusCode.size(); i++) {
					JSONObject obj = (JSONObject) menusCode.get(i);
					String name = (String) obj.get("name");
					if (name.equals("结算管理") || name.equals("收益订单管理") || name.equals("结算数据管理") || name.equals("结算记录")) {
						JSONObject o = new JSONObject();
						o.put("id", "ad_3");
						o.put("name", "佣金管理");
						o.put("orderNum", "0");
						o.put("pid", "0");
						o.put("leaf", "0");
						o.put("code", "ad_3");
						o.put("type", "1");
						menusCode.add(o);
						break;
					}
				}

				for (int i = 0; i < menusCode.size(); i++) {
					JSONObject obj = (JSONObject) menusCode.get(i);
					String name = (String) obj.get("name");
					if (name.equals("报表信息") || name.equals("报表概要") || name.equals("收益比例") || name.equals("收益排行榜")) {
						JSONObject o = new JSONObject();
						o.put("id", "ad_4");
						o.put("name", "报表管理");
						o.put("orderNum", "0");
						o.put("pid", "0");
						o.put("leaf", "0");
						o.put("code", "ad_4");
						o.put("type", "1");
						menusCode.add(o);
						break;
					}
				}
				menujson = JSONSerializer.toJSON(menusCode).toString();

			}

			jedis.set("MENU=" + token, menujson);
			jedis.expire("MENU=" + token, 3600);

			System.out.println("从权限中心获取用户菜单----" + menujson);
		}
		RedisUtil.returnResource(jedis);

		return menujson;
	}

}
