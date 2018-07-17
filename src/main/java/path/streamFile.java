package path;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletResponse;

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
* 创建时间：2018年7月16日 下午3:14:54
*/
public class streamFile {
	
	
	private void getXMLDoc3(String sowurl, String cookie, HttpServletResponse response) {// 通过XML文件网页抓取网页信息返回json格式字符串，即所有的节点信息
		try {// 局域网访问外网的话，需要设置代理
				// System.getProperties().setProperty("http.proxyHost", "proxy.cmcc");
				// System.getProperties().setProperty("http.proxyPort", "8080");
			URL url = new URL(sowurl);
			String accessToken = "QzczRTIzQUMyNzcwMDAwMUU0QkFDQUIxOTg4QTFDQjkxNTMxMTI5NTUzNDM4";
			// accessToken=http://10.122.12.243:8080/v1/tenants/lenovo/apps/C73E23AC2760000134621118E3EC3BB0/service/auth/serverside/token?aaaaaaaa
			String cookie2 = "C73E23AC2760000134621118E3EC3BB0";
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Cookie", cookie);
//			connection.setRequestProperty("Charset", "UTF-8");
//			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			InputStream input = connection.getInputStream();
//			 //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型   
			response.setContentType("multipart/form-data");
			// 2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)
			response.setHeader("Content-Disposition", "attachment;fileName=" + "a.pdf");
			byte[] file =input2byte(input);
			OutputStream out = null;
	        try {
	            out = response.getOutputStream();
	            out.write(file);
	            out.flush();
	        } catch (IOException e) {
	        //    logger.error("download file failed. errorMessage[{}]", e.getMessage());
	        } finally {
	            if (null != out) {
	                try {
	                    out.close();
	                } catch (IOException e) {
	              //      logger.error("OutputStream close failed. errorMessage[{}]", e.getMessage());
	                }
	            }

	        }

		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static final byte[] input2byte(InputStream inStream) throws IOException {
		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
		byte[] buff = new byte[100];
		int rc = 0;
		while ((rc = inStream.read(buff, 0, 100)) > 0) {
			swapStream.write(buff, 0, rc);
		}
		byte[] in2b = swapStream.toByteArray();
		return in2b;
	}

	public static File writeBytesToFile(byte[] b, String outputFile) {
		File file = null;
		FileOutputStream os = null;

		try {
			file = new File(outputFile);
			os = new FileOutputStream(file);
			os.write(b);
		} catch (Exception var13) {
			var13.printStackTrace();
		} finally {
			try {
				if (os != null) {
					os.close();
				}
			} catch (IOException var12) {
				var12.printStackTrace();
			}

		}

		return file;
	}

}
