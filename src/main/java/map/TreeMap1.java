package map;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 以动手实践为荣,以只看不练为耻. 以打印日志为荣,以出错不报为耻. 以局部变量为荣,以全局变量为耻. 以单元测试为荣,以手工测试为耻.
 * 以代码重用为荣,以复制粘贴为耻. 以多态应用为荣,以分支判断为耻. 以定义常量为荣,以魔法数字为耻. 以总结思考为荣,以不求甚解为耻.
 *
 * @author LvZheng 创建时间：2018年9月12日 下午2:48:39
 */
public class TreeMap1 {
	//treemap排序问题
	public static void main(String[] args) {
		System.out.println("---------------- 默认 排序结果-----------------");
		createDefaultSortTreeMap();
		System.out.println("---------------- 自定义 排序结果-----------------");
		createDefinitionSortTreeMap();
	}

	public static void createDefaultSortTreeMap() {
		TreeMap<String, String> map = new TreeMap<String, String>();

		init(map);
		print(map);
	}

	public static void createDefinitionSortTreeMap() {

		TreeMap<String, String> map = new TreeMap<String, String>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}

		});

		init(map);
		print(map);
	}

	public static void init(Map<String, String> map) {
		map.put("c", "1");
		map.put("a", "1");
		map.put("bb", "1");
		map.put("b", "1");
	}

	public static void print(Map<String, String> map) {
	        Iterator<Entry<String, String>> it = map.entrySet().iterator();
	        while(it.hasNext()) {
	            Entry<String, String> entry = it.next();
	            System.out.println(entry.getKey() + " : " + entry.getValue());
	        }
	}
	
}
