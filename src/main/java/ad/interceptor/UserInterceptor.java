package ad.interceptor;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import ad.bean.AdOperationLog;
import ad.service.IAdOperationLogService;
import ad.util.Constends;
import ad.util.DateUtil;
import ad.util.RedisUtil;

import net.sf.json.JSONObject;
import redis.clients.jedis.Jedis;

@Component
public class UserInterceptor implements HandlerInterceptor {

	@Autowired
	private IAdOperationLogService adOperationLogService;

	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/**
		 * 对来自后台的请求统一进行日志处理
		 */
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String uri = request.getRequestURI();
		//System.out.println(uri);

		String mode = uri.split("/")[1];
		String method = "";
		try {
			method = uri.split("/")[2];
		} catch (Exception e1) {
		}
		if (mode.equals("adverman") && method.equals("Get_Adver_5day_ForSDK")) {
			return true;
		}

		String swtx_key = request.getParameter("swtx_key");
		if (swtx_key != null && swtx_key.length() > 0) {
			String key2 = DateUtil.getMD5KeyByUrl();
			if (swtx_key.equals(key2)) {
				return true;
			}
		}

		String token = request.getParameter("token");
		// System.out.println(token);
		if (token == null || token.length() == 0) {
			Cookie[] cookies = request.getCookies();
			if (null != cookies) {
				for (Cookie cookie : cookies) {
					String name = cookie.getName();
					String value = cookie.getValue();
					if (name.equals("token")) {
						token = value;
					}
				}
			}
		}
		// System.out.println(token+"*********前置通知");

		if (!mode.equals("userLogin")) {
			Jedis jedis = RedisUtil.getJedis();
			String userjson = jedis.get("CUSER=" + token);
			String menujson = jedis.get("MENU=" + token);
			if (userjson == null || userjson.length() == 0) {
				RedisUtil.returnResource(jedis);
				response.getWriter().print("{\"error\":\"session timeout\"}");
				return false;
			} else {
				jedis.set("CUSER=" + token, userjson);
				jedis.expire("CUSER=" + token, 3600);

				jedis.set("MENU=" + token, menujson);
				jedis.expire("MENU=" + token, 3600);
			}
			RedisUtil.returnResource(jedis);
		}

		return true;
	}

	@Override
	// 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o,
			ModelAndView modelAndView) throws Exception {
		String url = request.getRequestURL().toString();
		String me = request.getMethod();
		String uri = request.getRequestURI();
		String mode = uri.split("/")[1];
		String method = "";
		try {
			method = uri.split("/")[2];
		} catch (Exception e1) {
		}
		// System.out.println("uri="+uri);

		int log_type = 1; // 用户
		String module_type = Constends.pro.getProperty(mode);
		String operation_type = Constends.pro.getProperty(method);
		int user_type = 0;
		String user_id = "";
		String user_name = "";
		String ip_address = getIpAddr(request);
		String create_time = DateUtil.getCurrentDateTime("yyyy-MM-dd HH:mm:ss");
		String token = request.getParameter("token");
		Jedis jedis = RedisUtil.getJedis();

		if (token == null || token.length() == 0) {
			Cookie[] cookies = request.getCookies();
			if (null != cookies) {
				for (Cookie cookie : cookies) {
					String name = cookie.getName();
					String value = cookie.getValue();
					if (name.equals("token")) {
						token = value;
					}
				}
			}
		}
		// System.out.println(token+"---------------------后置通知");

		String userjson = jedis.get("CUSER=" + token);
		if (userjson == null || userjson.equals("null")) {
			userjson = "";
		}
		if (userjson.length() > 0) {
			try {
				JSONObject user = JSONObject.fromObject(userjson);
				// user_type = Integer.parseInt(user.getString("userType"));
				user_id = user.getString("userID");
				user_name = user.getString("userAccount");
				// System.out.println(user_name);
				RedisUtil.returnResource(jedis);
				AdOperationLog adlog = new AdOperationLog();
				adlog.setOperationType(operation_type);
				adlog.setLogType(log_type);
				adlog.setModuleType(module_type);
				adlog.setUserId(user_id);
				adlog.setIpAddress(ip_address);
				adlog.setCreateTime(new Date());
				adlog.setUserName(user_name);
				if (operation_type != null) {
					adOperationLogService.insertSelective(adlog);
				}

				// String sql = "insert into ad_operation_log
				// (operation_type,log_type,module_type,user_type,user_id,ip_address,create_time,user_name)
				// values (?,?,?,?,?,?,?,?)";
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	// 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object o, Exception e) throws Exception {

	}
}
