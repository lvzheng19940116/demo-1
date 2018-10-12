package http;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 以动手实践为荣,以只看不练为耻. 以打印日志为荣,以出错不报为耻. 以局部变量为荣,以全局变量为耻. 以单元测试为荣,以手工测试为耻.
 * 以代码重用为荣,以复制粘贴为耻. 以多态应用为荣,以分支判断为耻. 以定义常量为荣,以魔法数字为耻. 以总结思考为荣,以不求甚解为耻.
 *
 * @author LvZheng 创建时间：2018年7月11日 上午9:53:35
 */
public class HttpTest {
	public static void main(String[] args) throws MalformedURLException {
		BufferedReader in = null;
		String result = null;
		try {
			URL url = new URL("http://www.baidu.com");
//			InputStream openStream = url.openStream();
//			InputStreamReader inputStreamReader=new InputStreamReader(openStream,"UTF-8");
//			BufferedReader BufferedReader=new BufferedReader(inputStreamReader);			
			in = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			StringBuffer sb = new StringBuffer();
			String str = null;
			
			BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html"),"UTF-8"));
			String s=null;
			
//			while ((str = in.readLine()) != null) {
//				sb.append(str).append("\n");
//			}
			while ((s = in.readLine()) != null) {				
				bufferedWriter.append(s);
				bufferedWriter.newLine();
			}
			
			bufferedWriter.flush();
			bufferedWriter.close();			
			result = sb.toString();
			System.out.println(result);
		} catch (Exception ex) {
		} finally {
			if (in != null) {
				try {					
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
