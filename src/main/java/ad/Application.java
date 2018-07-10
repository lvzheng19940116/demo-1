
package ad;

//import org.apache.logging.log4j.core.config.Scheduled;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

/**
 * @Desc: 项目启动类
 * @Author: ZhangYue
 * @Date: create in 2017/12/1
 * @copyright Navi WeCloud
 */
@EnableTransactionManagement
@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = { "ad" })


@MapperScan("ad.mapper")
//@Scheduled
@EnableScheduling
@ServletComponentScan
public class Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.setWebEnvironment(true);
		app.run(args);
	}

	@Bean
	public RestTemplate restTemplate() {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setConnectionRequestTimeout(10000);
		factory.setConnectTimeout(10000);
		factory.setReadTimeout(10000);
		return new RestTemplate(factory);
	}

}
