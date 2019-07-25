package listrepeat;

import lombok.Data;

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
 * 创建时间：2019/6/5 下午3:39
 */
@Data
public class Listrepeat {
    private String id;
    private String name;
    private String age;




    public static void main(String[] args) {
        List<String> A = new ArrayList<String>();
        A.add("C");
        A.add("D");
        System.out.println(A.size());



        List<String> B = new ArrayList<String>();
        B.add("C");
        B.add("D");
        B.add("E");
        B.add("F");
        List<String> C = new ArrayList<String>();
        C.addAll(A);
        //交集  retainAll
        C.retainAll(B);
        System.out.println(C);
        B.removeAll(A);
        System.out.println(B);

        List<Listrepeat> list = new ArrayList<Listrepeat>();
        Listrepeat listrepeat=new Listrepeat();

        listrepeat.setName("11");
        listrepeat.setAge("111");
        list.add(listrepeat);

        List<String> collect = list.stream().map(Listrepeat::getName).collect(Collectors.toList());

        List<Listrepeat> list1 = new ArrayList<Listrepeat>();
        Listrepeat listrepeat1=new Listrepeat();
        listrepeat1.setName("11");
        listrepeat1.setAge("111");

        Listrepeat listrepeat2=new Listrepeat();
        listrepeat2.setName("22");
        listrepeat2.setAge("222");
        list1.add(listrepeat1);
        list1.add(listrepeat2);

        long l = System.currentTimeMillis();
        List<Listrepeat> collect1 = list1.stream().filter(b -> !collect.contains(b.getName())).collect(Collectors.toList());
        long l1 =   System.currentTimeMillis();

        System.out.println(l1-l);

        System.out.println(collect1);

        long l2 =    System.currentTimeMillis();
        list1.removeAll(list);
        long l3 =   System.currentTimeMillis();
        System.out.println(l3-l2);

        System.out.println(list1);

    }

}
