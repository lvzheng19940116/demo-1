package http;


import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

public class Main {

    //<dependency>
//<groupId>org.apache.httpcomponents</groupId>
//<artifactId>httpcore</artifactId>
//</dependency>
//<dependency>
//<groupId>org.apache.httpcomponents</groupId>
//<artifactId>httpclient</artifactId>
//<version>4.5.6</version>
//</dependency>
    public static void main(String[] args) {
        String apiUrl = "https://www.world-check.com/portal/Downloads/world-check-deleted-v2.csv.gz";
//        String apiUrl = "https://www.baidu.com/";
        HttpResponse response = null;
        HttpClient httpclient=new DefaultHttpClient();
        try {
            HttpGet httpGet = new HttpGet(apiUrl);
            //身份认证

            String authString = "ThRe0206" + ":" + "Westin9999";
            byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
            String authStringEnc = new String(authEncBytes);
            String s= "Basic " + authStringEnc;
            httpGet.addHeader("Authorization", s);
            httpGet.addHeader("User-Agent", "MSIE 7.0");
            response = httpclient.execute(httpGet);
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



