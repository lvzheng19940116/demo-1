package md5;

import java.util.Base64;

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
 * 创建时间：2019/3/11 下午4:58
 */
public class Base {


    public static void main(String[] args) {
        String base64String="1234qwer@#$";
        String msg= java.util.Base64.getEncoder().encodeToString(base64String.getBytes());
        System.out.println("加密："+msg);

        String string = Base64.getEncoder().encodeToString(msg.getBytes());
        System.out.println("加密："+string);

    }
}
