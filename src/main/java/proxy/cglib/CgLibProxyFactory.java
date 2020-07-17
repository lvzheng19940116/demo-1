package proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author LvZheng
 * 创建时间：2020/7/17 6:10 下午
 * cglib动态代理
 */
public class CgLibProxyFactory implements MethodInterceptor {

    public  Object getInstance(Class clazz){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("======插入cglib前置通知======");
        Object proex = methodProxy.invokeSuper(o, objects);
        System.out.println("======插入cglib后者通知======");
        return proex;
    }
}
