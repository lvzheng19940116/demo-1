package polymorphic;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Optional;

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
 * 创建时间：2019/4/23 下午3:17
 */
public class PolymorphicController {
    //多态
    static class Parent {
        void foo() {
            System.out.println("Parent foo()");
        }
    }

    static class Child1 extends Parent {
        @Override
        void foo() {
            System.out.println("Child1 foo()");
        }
    }

    static class Child2 extends Parent {
        @Override
        void foo() {
            System.out.println("Child2 foo()");
        }
    }

    public static void main(String[] args) throws Exception {
        Parent instance1 = new Child1();
        Parent instance2 = new Child2();
        instance1.foo(); //==> Child foo()
        instance2.foo();


        String fontPath = Optional.ofNullable(ClassUtils.getDefaultClassLoader())
                .map(classLoader -> classLoader.getResource("static/font/simsun.ttc"))
                .map(URL::getPath)
                .orElseThrow(() -> new RuntimeException("未找到字体文件!!!"));
        System.out.println(fontPath);

        String rootPath = ClassUtils.getDefaultClassLoader().getResource("static/font/simsun.ttc").getPath();
        System.out.println(rootPath);

        String path = ResourceUtils.getURL("classpath:static/font/simsun.ttc").getPath();
        System.out.println(path);

        String path1 = new ClassPathResource("static/font/simsun.ttc").getFile().getPath();
        String pp = ResourceUtils.getURL("classpath:static").getPath() + "/font/simsun.ttc";
        System.out.println(path1);

        ClassPathResource classPathResource = new ClassPathResource("static/font/simsun.ttc");
        BufferedReader br = new BufferedReader(new InputStreamReader(classPathResource.getInputStream()));
        System.out.println("____" + br.read());



        String p = System.getProperty("user.dir") + "/src/main/resources/static/font/simsun.ttc";
        System.out.println(p);


        String s = "file:/data/server/pcsd-contract-manger-0.0.1-SNAPSHOT.jar!/BOOT-INF/classes!/static/font/simsun.ttc";
        if (s.contains("file:")) {

            String substring = s.substring(5, s.length());
            System.out.println(substring);
        }
        //   Properties properties = PropertiesLoaderUtils.loadAllProperties("static/font/simsun.ttc");

         String path2 = PolymorphicController.class.getResource("/").getPath()+"/static/font/simsun.ttc";
        System.out.println(path2);

    }
}
