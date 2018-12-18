package rest;

import org.springframework.context.annotation.Configuration;

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
 * 创建时间：2018/10/24 上午10:39
 */
@Configuration
public class RestConfig {

    //        // 启动的时候要注意，由于我们在controller中注入了RestTemplate，所以启动的时候需要实例化该类的一个实例
//    @Autowired
//    private RestTemplateBuilder builder;
//
//    // 使用RestTemplateBuilder来实例化RestTemplate对象，spring默认已经注入了RestTemplateBuilder实例
//    @Bean
//    public RestTemplate restTemplate() {
//        return builder.setConnectTimeout(20000).setReadTimeout(20000).build();
//    }
//    @Bean
//    public RestTemplate customRestTemplate() {
//        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//        httpRequestFactory.setConnectionRequestTimeout(20000);
//        httpRequestFactory.setConnectTimeout(20000);
//        httpRequestFactory.setReadTimeout(20000);
//
//        return new RestTemplate(httpRequestFactory);
//    }
//    @Bean
//    public RestTemplate customRestTemplate() {
//        //生成一个设置了连接超时时间、请求超时时间、异常最大重试次数的httpClient
//        RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(30000).setConnectTimeout(30000).setSocketTimeout(30000).build();
//        HttpClientBuilder builder = HttpClientBuilder.create().setDefaultRequestConfig(config).setRetryHandler(new DefaultHttpRequestRetryHandler(3, false));
//        HttpClient httpClient = builder.build();
//        //使用httpClient创建一个ClientHttpRequestFactory的实现
//        ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
//        //ClientHttpRequestFactory作为参数构造一个使用作为底层的RestTemplate
//        return new RestTemplate(requestFactory);
//    }
}
