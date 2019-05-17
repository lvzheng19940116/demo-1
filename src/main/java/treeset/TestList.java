package treeset;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @author LvZheng
* 创建时间：2018年5月4日 上午10:30:21
*/
public class TestList {

	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
	//	list.add("aaa");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i);
		}
		System.out.println("0000");


		String str = "a,b,c";
		List<String> aaa = Arrays.asList(StringUtils.commaDelimitedListToStringArray(str));
		System.out.println(aaa);
	}





}
