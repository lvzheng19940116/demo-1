package lenovo;

import java.security.MessageDigest;
import java.sql.Timestamp;

/**
 * 
 * @author LvZheng 创建时间：2018年1月29日 下午5:11:38
 */
public class AuthKeyGen {

	// private static final Logger LOG = Logger.getLogger(AuthKeyGen.class);

	public String getAuthKey(String client_id, String client_secret) {
		Timestamp now = new Timestamp(System.currentTimeMillis());
		String authInfo_plain = client_id + client_secret + "AT" + now.getTime();
		String authInfo_md5 = getMD5(authInfo_plain, 16);
		// String authInfo_md5 = SimpleMD5.getMD5(authInfo_plain, 16);
		// LOG.info(authInfo_md5);
		return authInfo_md5 + "." + now.getTime();
	}

	private String getMD5(String text, int length) {
		StringBuilder sb = new StringBuilder(40);
		try {
			MessageDigest MD5 = MessageDigest.getInstance("MD5");
			byte[] info_mid = MD5.digest(text.getBytes());
			for (byte x : info_mid) {
				if ((x & 0xff) >> 4 == 0) {
					sb.append("0").append(Integer.toHexString(x & 0xff));
				} else {
					sb.append(Integer.toHexString(x & 0xff));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (length == 16)
			return sb.toString().substring(8, 24);
		else
			return sb.toString();

	}

	public static void main(String[] args) {
		String log4jPath = AuthKeyGen.class.getClassLoader().getResource("").getPath() + "log4j.properties";
		// PropertyConfigurator.configure(log4jPath);
		System.out.println(log4jPath);
		// LOG.info("~~~~~~~~~~~~~");
		
//		// 订单
//		 String appKey = "9F4E4F9A379C47C38FD598EB5DB0CE37";
//		 System.out.println("MSP-AppKey : " + appKey);
//		 String client_id = "7A040F4F27CD48E48CF3D7E8D89F05B4";
//		 String client_secret = "6A87231D8FC4456A9C97924556F3860B";
		
//		// 合同
		String appKey = "C4C8FBF74A12429B91E916DE9EED7144";
		System.out.println("MSP-AppKey : " + appKey);
		String client_id = "EEC05A24D05A4E38ABFC09B9AD01E8B6";
		String client_secret = "C36A9665558242478A458CDA320A153B";
		
		// //权限
		// String appKey = "FA0C4B2415AD407691074E49AA892059";
		// System.out.println("MSP-AppKey : " + appKey);
		// String client_id = "593D6ECB8933491082FFE55BB2E2E63E";
		// String client_secret = "7051FD3F43B54099A6B8240434910DB8";
		
		// //权限
		// String appKey = "C47660F7A5D844CA9D1976AC544DC6B9";
		// System.out.println("MSP-AppKey : " + appKey);
		// String client_id = "168E9C9A4ED14CECB1FEA97BB152C963";
		// String client_secret = "0AE005BDE2394DE0BD992B77D60A0B3F";
		AuthKeyGen akg = new AuthKeyGen();
		String authKey = akg.getAuthKey(client_id, client_secret);
		System.out.println("MSP-AuthKey: " + authKey);
	}
}
