package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author LvZheng
 * 创建时间：2020/7/17 5:45 下午
 */
public class JdkTest implements InvocationHandler {

    private Object target;

    public JdkTest(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        Object o = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
        return o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(proxy, args);

        return invoke;
    }
}
