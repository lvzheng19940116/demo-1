package ad.config;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MyEmbeddedServletContainerFactory extends TomcatEmbeddedServletContainerFactory {

	@Autowired
	private Environment environment;

	@Override
	public EmbeddedServletContainer getEmbeddedServletContainer(ServletContextInitializer... initializers) {
		// 设置端口
		this.setPort(Integer.parseInt(environment.getProperty("tomcat.port")));
		return super.getEmbeddedServletContainer(initializers);
	}

	@Override
	protected void customizeConnector(Connector connector) {
		super.customizeConnector(connector);
		Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
		// 设置最大连接数
		protocol.setMaxConnections(800);
		// 设置最大线程数
		protocol.setMaxThreads(800);
		protocol.setConnectionTimeout(30000);
	}
}
