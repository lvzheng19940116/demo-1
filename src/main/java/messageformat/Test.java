package messageformat;

import java.text.MessageFormat;
import java.util.Date;

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
 * 创建时间：2018/10/17 上午10:43
 */
public class Test {
    public static void main(String[] args) {
        String str="{1},{1}";//"{1},{0}"/"{0},{1}"
        Object[] obj={"aaa",new Date()};
        String format = MessageFormat.format(str, obj);
        System.out.println(format);
    }
}
