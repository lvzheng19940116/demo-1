//package FeignGet;
//
//import java.util.Enumeration;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//
///**
//*以动手实践为荣,以只看不练为耻.
//*以打印日志为荣,以出错不报为耻.
//*以局部变量为荣,以全局变量为耻.
//*以单元测试为荣,以手工测试为耻.
//*以代码重用为荣,以复制粘贴为耻.
//*以多态应用为荣,以分支判断为耻.
//*以定义常量为荣,以魔法数字为耻.
//*以总结思考为荣,以不求甚解为耻.
//*
//* @author LvZheng
//* 创建时间：2018年7月4日 下午6:00:52
//*/
//public class FeignHeader {
//	@Bean
//    public RequestInterceptor headerInterceptor() {
//        return new RequestInterceptor() {
//            @Override
//            public void apply(RequestTemplate requestTemplate) {
//                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
//                        .getRequestAttributes();
//                HttpServletRequest request = attributes.getRequest();
//                Enumeration<String> headerNames = request.getHeaderNames();
//                if (headerNames != null) {
//                    while (headerNames.hasMoreElements()) {
//                        String name = headerNames.nextElement();
//                        String values = request.getHeader(name);
//                        requestTemplate.header(name, values);
//                    }
//                }
//            }
//        };
//    }
//}
