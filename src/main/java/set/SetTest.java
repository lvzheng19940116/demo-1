package set;

import com.example.demo.test.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
 * 创建时间：2019/6/28 3:44 PM
 */
public class SetTest {

    public static void main(String[] args) {
        Person person1=new Person();
        person1.setId(1L);
        person1.setName("1");



        Person person2=new Person();
        person2.setId(2L);
        person2.setName("1");


        Person person3=new Person();
        person3.setId(1L);
        person3.setName("1");


        Person person4=new Person();
        person4.setId(2L);
        person4.setName("2");


        List<Person> list=new ArrayList<Person>();
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        System.out.println("list:"+list);

        Set<Person> set=new HashSet<Person>();
        set.add(person1);
        set.add(person2);
        set.add(person3);
        set.add(person4);
        System.out.println("set:"+set);
    }

}
