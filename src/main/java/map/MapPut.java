package map;

import java.util.HashMap;
import java.util.Map;

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
 * 创建时间：2019/6/3 下午5:25
 */
public class MapPut {
    public static void main(String[] args) {
        Map<String, String> map=new HashMap<String, String>();

        map.put("abc","123");
        map.put("aaa","123");
        System.out.println(map);
        map.put("abc","456");
        System.out.println(map);
        map.put("abc","789");
        System.out.println(map);
    }
}
