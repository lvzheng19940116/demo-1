package proxy.cglib;

import lombok.extern.slf4j.Slf4j;
import proxy.jdk.ProductService;
import proxy.jdk.ProductServiceImpl;

/**
 * @author LvZheng
 * 创建时间：2020/7/17 7:33 下午
 */
@Slf4j
public class CgLibTest {
    public static void main(String[] args) {
        ProductService productService = new ProductServiceImpl();
        ProductService instance = (ProductService)new CgLibProxyFactory().getInstance(productService.getClass());
        instance.addProduct("cglib");

    }
}
