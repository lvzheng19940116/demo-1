package path;

import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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
* 创建时间：2018年6月22日 下午2:10:28
*/
public class PathTest {
	public static void main(String[] args) {
		String resource = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		System.out.println(resource);
		URL resource2 = App.class.getResource("");
		System.out.println(resource2);
		
//		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//		HttpServletRequest request = attributes.getRequest();
//		String contextPath = request.getContextPath();
//		System.out.println(contextPath);
	}
}
