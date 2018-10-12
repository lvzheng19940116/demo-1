package proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class Test {
    public static void main(String[] args) throws Exception {
        ProductService productService = new ProductServiceImpl();
        ProductService instance =(ProductService) new JdkInvocationHandler().getInstance(productService);
        instance.addProduct("iphone");
        // 这里我们将jdk生成的代理类输出了出来，方便后面分析使用
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{productService.getClass()});

        FileOutputStream os = new FileOutputStream("Proxy0.class");
        os.write(bytes);
        os.close();

    }
}
