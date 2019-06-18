package listtomap;

import com.example.demo.test.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
 * 创建时间：2019/6/4 上午9:54
 */
public class ListToMap {
    public static List list() {

        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setId(1);
        user1.setAge("12");

        User user2 = new User();
        user2.setId(2);
        user2.setAge("13");

        userList.add(user1);
        userList.add(user2);
        return userList;
    }

    public static void main(String[] args) {
        List list = ListToMap.list();
        Object collect = list.stream().collect(Collectors.toMap(User::getId, a -> a, (key1, key2) -> key2));
        System.out.println(collect);
        Object collect1 = list.stream().collect(Collectors.toMap(User::getId, User::getAge, (key1, key2) -> key2));
        System.out.println(collect1);



        String string="1213";
        String substring = string.substring(0, 2);
        System.out.println(substring);
    }

}
