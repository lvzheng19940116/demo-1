package ad.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class Constends {
	public static Properties pro = null; // 属性对象
	public static String ab_advertiser_roleId = ""; // 广告主角色编号
	public static String ab_proxy_user_roleId = ""; // 代理用户角色编号
	public static String ab_proxy_user3_roleId = "";
	public static String RedisAddress = "";
	public static int RedisPORT = 0;
	public static String RedisAUTH = "";
	public static String serverURL = "";
	public static ResourceBundle bundle = null;
	private static BufferedInputStream inputStream;

	static {
		pro = new Properties();
		try {
			InputStream in = Constends.class.getResourceAsStream("app.properties");
			pro.load(in);
			in.close();
			String proFilePath = System.getProperty("user.dir") + "/app.properties";
			inputStream = new BufferedInputStream(new FileInputStream(proFilePath));
			bundle = new PropertyResourceBundle(inputStream);
			inputStream.close();
			RedisAddress = bundle.getString("RedisAddress");
			RedisPORT = Integer.parseInt(bundle.getString("RedisPORT"));
			RedisAUTH = bundle.getString("RedisAUTH");
			serverURL = bundle.getString("serverURL");
			ab_advertiser_roleId = bundle.getString("ab_advertiser_roleId");
			ab_proxy_user_roleId = bundle.getString("ab_proxy_user_roleId");
			ab_proxy_user3_roleId = bundle.getString("ab_proxy_user3_roleId");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * public static void main(String[] args){
	 * System.out.println(ab_advertiser_roleId); }
	 */
}
