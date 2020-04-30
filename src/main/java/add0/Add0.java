package add0;

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
 * 创建时间：2019/6/5 上午9:42
 */
public class Add0 {

    public static void main(String[] args) {

        String ba = "100002";
        String substring = ba.substring(1, ba.length());
        System.out.println(substring);
        int length = ba.length()-1;
        System.out.println(length);
        int i3 = Integer.parseInt(ba);
        System.out.println(i3);
        String str11 = String.format("%0" + 10+ "d", Integer.valueOf(i3));

        System.out.println(str11);


//
//        int youNumber = 1;
//        // 0 代表前面补充0
//        // 10代表长度为10
//        // d 代表参数为正数型
//        String s = "9";
//        String s1 = "10";
//        String s2 = s1 + s;
//        System.out.println(s2);
//        String str = String.format("%0" + s + "d", Integer.valueOf(s2));
//        // 0000000001
//        System.out.println(str);
//        System.out.println(str.length());
//
//
//        Integer i = 10;
//        Integer i1 = 10;
//        Integer i2 = i + i1;
//        System.out.println(i2);
    }
}
