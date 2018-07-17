package path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
*以动手实践为荣,以只看不练为耻.
*以打印日志为荣,以出错不报为耻.
*以局部变量为荣,以全局变量为耻.
*以单元测试为荣,以手工测试为耻.
*以代码重用为荣,以复制粘贴为耻.
*以多态应用为荣,以分支判断为耻.
*以定义常量为荣,以魔法数字为耻.
*以总结思考为荣,以不求甚解为耻.
*
* @author LvZheng
* 创建时间：2018年7月13日 下午2:59:29
*/
public class urltest {
	
	
	public static void main(String[] args) {
		getXMLDoc3("aaa");
	}
	public static  String getXMLDoc3(String XMLUrl ) {// 通过XML文件网页抓取网页信息返回json格式字符串，即所有的节点信息
		StringBuilder	temp=null;
		int responseCode=0;
		try {// 局域网访问外网的话，需要设置代理
		// System.getProperties().setProperty("http.proxyHost", "proxy.cmcc");
		// System.getProperties().setProperty("http.proxyPort", "8080");
			URL url = new URL("http://madp.lenovo.cn/uat/group1/downfile?file=Z3JvdXBOYW1lPWdyb3VwMSZmaWxlTmFtZT1NMDAvMDYvNzEvQ25oeFlGdEZzbm1BWk9rWEFBQUNadUZJZUJzNzg3LnBkZiZmaWxlVHlwZT0z&groupName=group1&fileName=M00/06/71/CnhxYFtFsnmAZOkXAAACZuFIeBs787.pdf");
			
			String accessToken = "QzczRTIzQUMyNzcwMDAwMUU0QkFDQUIxOTg4QTFDQjkxNTMxMTI5NTUzNDM4";
			//accessToken=http://10.122.12.243:8080/v1/tenants/lenovo/apps/C73E23AC2760000134621118E3EC3BB0/service/auth/serverside/token?aaaaaaaa
			String appkey = "C73E23AC2760000134621118E3EC3BB0";

			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Cookie", "accessToken = QzczRTIzQUMyNzcwMDAwMUU0QkFDQUIxOTg4QTFDQjkxNTMxMTI5NTUzNDM4, appkey = C73E23AC2760000134621118E3EC3BB0");
			connection.setRequestProperty("Content-Type",
					"application/yang.data+json");
			
			responseCode = connection.getResponseCode();  
            if (responseCode != 200) {  
                 
                System.out.println(" Error===" + responseCode);
            } else {  
                System.out.println(responseCode);
            }  
			InputStream input = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			String line = "";
				temp = new StringBuilder();
			while ((line = br.readLine()) != null) {
				temp.append(line + "\n");
			}
			br.close();

		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(temp.toString());
		return temp.toString();
	}
}
