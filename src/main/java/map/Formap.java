package map;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

/**
 * 以动手实践为荣,以只看不练为耻. 以打印日志为荣,以出错不报为耻. 以局部变量为荣,以全局变量为耻. 以单元测试为荣,以手工测试为耻.
 * 以代码重用为荣,以复制粘贴为耻. 以多态应用为荣,以分支判断为耻. 以定义常量为荣,以魔法数字为耻. 以总结思考为荣,以不求甚解为耻.
 *
 * @author LvZheng 创建时间：2018年9月13日 上午10:41:52
 */
public class Formap {
	public static void main(String[] args) {
		Map<String, Object> map = Maps.newHashMap();
		map.put("c", "1");
		map.put("a", "1");
		map.put("bb", "1");
		map.put("b", "1");
		//Lambda 获取key and value
		map.forEach((key,value)->{
			System.out.println(key+":"+value);
		});
		System.out.println("----------");
		//遍历map
		for (Object  string : map.values()) {
			System.out.println(string);
		}
		for (String  string : map.keySet()) {
			System.out.println(string);
		}
		// map.entrySet()
		for (Map.Entry<String, Object> string : map.entrySet()) {
			System.out.println("key:"+string.getKey() +"value:"+string.getValue());
		}
		//迭代器遍历
		Iterator<Entry<String, Object>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, Object> next = iterator.next();
			System.out.println(next.getKey()+":"+next.getValue());
		}
		
		
	}

}
