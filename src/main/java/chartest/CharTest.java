package chartest;

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
 * 创建时间：2019/5/29 下午4:15
 */
public class CharTest {
    public static void main(String[] args) {
        char a='a';
        for (int i = 0; i < 25; i++) {
            System.out.print(a);
            a++;
        }

        String b="abcdef";
        StringBuffer sb = new StringBuffer(b);
        StringBuffer reverse = sb.reverse();
        System.out.println("--------");
        System.out.println(reverse.toString());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().maxMemory());
    }
}
