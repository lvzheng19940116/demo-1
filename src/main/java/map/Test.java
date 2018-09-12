package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
*以动手实践为荣,以只看不练为耻.
*以打印日志为荣,以出错不报为耻.
*以局部变量为荣,以全局变量为耻.
*以单元测试为荣,以手工测试为耻.
*以代码重用为荣,以复制粘贴为耻.
*以多态应用为荣,以分支判断为耻.
*以定义常量为荣,以魔法数字为耻.
*以总结思考为荣,以不求甚解为耻.
*
* @author LvZheng
* 创建时间：2018年9月4日 下午3:23:42
*/
public class Test {
	public static void main(String[] args) {
		Map<String,Object>  map=new HashMap<String,Object> ();
		List<Emp> list=new ArrayList<Emp>();
		Emp emp =new Emp("1","lvzheng","18");
		Emp emp1 =new Emp("2","boy","18");
		list.add(emp);
		list.add(emp1);
		map.put("item", list);
		 for (Object value :map.values()) {
		      System.out.println(value);
		    }
		
		
		 int a=3;//000011
		 //简单加密二进制取反（a^0xff）
		 System.out.println(Integer.toBinaryString(a^0xff));   
		 
		for (int i = 0; i < 6; i++) {
			System.out.print(i);
		}
		int i=15;
		int j=15;
		i=j++;
		System.out.println(i);
		
		j=++ i;
		System.out.println(j);
	}
}
