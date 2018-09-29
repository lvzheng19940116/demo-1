package ad.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class HttpConnection {
    private static final String APPLICATION_JSON = "application/json";
    private static final String CONTENT_TYPE_TEXT_JSON = "text/json";

    public static String serverURL = Constends.serverURL; //内网测试环境的权限管理 在公司用

    public static String sendPost(String url, String param) {

		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";

		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

    /**
     *
     * @param url
     * @param jsonParam
     * @param token
     * @return
     */
    public static String httpPost(String url,String jsonParam,String token){
//        DefaultHttpClient httpClient = new DefaultHttpClient();//post请求返回结果
//        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 2000);
//        httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 2000);
//        ResponseHandler<String> responseHandler = new BasicResponseHandler();
//        HttpPost post = new HttpPost(url);String str = "";
//        post.setHeader("Content-type", "application/json; charset=utf-8");
//        post.setHeader("Connection", "Close");
//        post.addHeader("token",token);
//        try {
//            if (null != jsonParam) {
//                //解决中文乱码问题
//                StringEntity entity = new StringEntity(jsonParam, "utf-8");
//                entity.setContentEncoding("UTF-8");
//                entity.setContentType("application/json");
//                post.setEntity(entity);
//            }
//            HttpResponse result = httpClient.execute(post);
//            url = URLDecoder.decode(url, "UTF-8");
//            //if (result.getStatusLine().getStatusCode() == 200) {/**请求发送成功，并得到响应**/
//                try {
//                    str = EntityUtils.toString(result.getEntity());/**读取服务器返回过来的json字符串数据**/
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            //}
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        String str=null;
        return str;
    }

    public static String HttpGET(Map params,String url){
    	String token = "";
    	if(params!=null && params.size()>0){
			Set<String> set = params.keySet();
			url += "?";
			for(String key:set){
				if(key.equals("token")){
					token = (String)params.get(key);
				}
				url += key+"="+params.get(key)+"&";
			}
		}

        HttpGet get = new HttpGet(url);
        if(token.length()>0){
        	get.addHeader("token",token);
        }
        org.apache.http.client.HttpClient client = new DefaultHttpClient();
        String temp = "";
        try {

            HttpResponse response = client.execute(get);
            HttpEntity entity = response.getEntity();
           temp = EntityUtils.toString(entity, "UTF-8");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return temp;
    }


    public static String HttpPost(Map pa,String url){
    	//httpClient
    	org.apache.http.client.HttpClient httpClient = new DefaultHttpClient();

        // get method
        HttpPost httpPost = new HttpPost(url);
        String token = "";
        // set header
        httpPost.setHeader("Content-Type","application/x-www-form-urlencoded");

        //set params
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        if(pa!=null && pa.size()>0){
			Set<String> set = pa.keySet();
			for(String key:set){
				if(key.equals("token")){
					token = (String)pa.get(key);
				}
				params.add(new BasicNameValuePair(key,(String)pa.get(key)));
			}
		}

        if(token.length()>0){
        	httpPost.addHeader("token",token);
        }
        try{
            httpPost.setEntity(new UrlEncodedFormEntity(params));
        }catch (Exception e) {}

        //response
        HttpResponse response = null;
        try{
            response = httpClient.execute(httpPost);
        }catch (Exception e) {}

        //get response into String
        String temp="";
        try{
            HttpEntity entity = response.getEntity();
            temp=EntityUtils.toString(entity,"UTF-8");
        }catch (Exception e) {}

        return temp;
    }

    /******************
     * 根据指定参数 访问url获取返回值
     * @param params
     * @param url
     * @return
     */
    public static String getURLObject(Map params,String url){
		String re = "";
		if(params!=null && params.size()>0){
			Set<String> set = params.keySet();
			url += "?";
			for(String key:set){
				url += key+"="+params.get(key)+"&";
			}
		}
		HttpClient client = new HttpClient();

		PostMethod httpPost = new PostMethod(url);

		try {
			client.executeMethod(httpPost);
			if(httpPost.getStatusCode()==200){
				re = httpPost.getResponseBodyAsString().trim();
			}
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
    }




	/*public static void main(String[] args) {


		Map map1 = new HashMap();
		map1.put("userAccount", "usera19");
		map1.put("mobTel", "18866655515");
		map1.put("email", "556666991@qq.com");
		map1.put("userPassword", "12346");
		map1.put("siteCode", "webUser");

		map1.put("userId", "c55e3b4d223842bd93183fe16ebdb857");
		map1.put("roleId", "78");
		//map1.put("token", "ca1ee1ef8d574ad491782a10c6b49314");


		String url = HttpConnection.serverURL+"/updateUserRole.action";
		String pa = JSONSerializer.toJSON(map1).toString();
		String data = HttpConnection.httpPost(url,pa,"ca1ee1ef8d574ad491782a10c6b49314");

		//String data = HttpConnection.HttpGET(map1,url);
		System.out.println(url);
		System.out.println(pa+"******************"+data);

		JSONObject jsonobject = JSONObject.fromObject(data);
		JSONObject data3 = (JSONObject) jsonobject.get("data");
		System.out.println(data3.get("userId"));
		net.sf.json.JSONObject jsonObject = (net.sf.json.JSONObject)JSONSerializer.toJSON(data);
		String code = jsonObject.getString("code");
		System.out.println(jsonObject.getJSONObject("data"));
		if(code!=null && code.equals("200") && jsonObject.getJSONObject("data")!=null){
			try {
				String token2 = jsonObject.getJSONObject("data").getString("token");
				if(token2!=null && token2.length()>0){
					System.out.println(token2);
				}
			} catch (Exception e) {

			}
		}
		else{
			System.out.println(jsonObject.getString("message"));
		}


		JSONObject jsonObject = (JSONObject)JSONSerializer.toJSON(data);
		try{
			int userID = jsonObject.getJSONObject("user").getInt("userID");
		}catch(Exception e){}

	}*/

}




