package http;

import org.apache.http.HttpEntity;
import org.apache.http.ProtocolVersion;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 以动手实践为荣,以只看不练为耻.
 * 以打印日志为荣,以出错不报为耻.
 * 以局部变量为荣,以全局变量为耻.
 * 以单元测试为荣,以手工测试为耻.
 * 以代码重用为荣,以复制粘贴为耻.
 * 以多态应用为荣,以分支判断为耻.
 * 以定义常量为荣,以魔法数字为耻.
 * 以总结思考为荣,以不求甚解为耻.
 *
 * @author LvZheng
 * 创建时间：2018/10/12 上午10:50
 */
public class HttpClientTest {
    public static void main(String[] args) {
        CloseableHttpClient client = HttpClients.createDefault();
        String url="https://www.world-check.com/premium-dynamic-download/?lag=DAY&format=TSV-GZ";
//		String url3="https://www.apiopen.top/journalismApi";
//		String url2="https://api.weixin.qq.com/sns/oauth2/access_token?appid=appid&code=code&grant_type=authorization_code";
        HttpGet get=new HttpGet(url);
        ProtocolVersion protocolVersion = get.getProtocolVersion();
        System.out.println(protocolVersion.getProtocol());
        try {
            //该网页需要认证（用户名、密码）
            HttpClientContext context=new HttpClientContext();
            CredentialsProvider credentialsProvider=new BasicCredentialsProvider();
            credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("ThRe1207", "Welcome82"));
            context.setCredentialsProvider(credentialsProvider);
            CloseableHttpResponse execute = client.execute(get, context);
            //----以下一样
            HttpEntity entity = execute.getEntity();
            InputStream in = entity.getContent();
            StringBuilder builder=new StringBuilder();
            BufferedReader bufreader =new BufferedReader(new InputStreamReader(in,"UTF-8"));
            for (String temp=bufreader.readLine();temp!=null;temp= bufreader.readLine()) {
                builder.append(temp);
            }
            System.out.println(builder.toString());
        } catch (ClientProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
