package proxy.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class Test {
    public static void main(String[] args) throws Exception {
        ProductService productService = new ProductServiceImpl();
        //生成代理类
        ProductService instance =(ProductService) new JdkInvocationHandler().getInstance(productService);
        instance.addProduct("iphone");
        /**
         * 这里我们将jdk生成的代理类输出了出来，方便后面分析使用
         *
         * 我们知道代理类是通过Proxy类的ProxyClassFactory工厂生成的，
         * 这个工厂类会去调用ProxyGenerator类的generateProxyClass()方法来生成代理类的字节码。
         * ProxyGenerator这个类存放在sun.misc包下，我们可以通过OpenJDK源码来找到这个类，
         * 该类的generateProxyClass()静态方法的核心内容就是去调用generateClassFile()
         * 实例方法来生成Class文件
         */
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{productService.getClass()});
        FileOutputStream os = new FileOutputStream("Proxy0.class");
        os.write(bytes);
        os.close();

    }
}
