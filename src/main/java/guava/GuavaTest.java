package guava;

import com.example.demo.test1.Temp;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.HashMap;
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
* 创建时间：2018年6月7日 上午11:08:14
*/
public class GuavaTest {

	
	public static void main(String[] args) {
		
		//@Property
		
		ArrayList<Object> newArrayList = Lists.newArrayList();
		HashMap<Object, Object> newHashMap = Maps.newHashMap();
		Map<String,Object > map=new HashMap<String,Object>(256);


		Temp emp=new Temp();
		GuavaTest.add(emp);
		System.out.println(emp.getId());

	}
	
	public static void add(Temp emp){

		emp.setId(1);


	}
	
	
	
}
