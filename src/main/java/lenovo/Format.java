package lenovo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;



/**
* @author LvZheng
* 创建时间：2018年1月26日 上午11:03:24
*/
public class Format {
public static void main(String[] args) {
    String youNumber = "1";  
    // 0 代表前面补充0   
    // 10代表长度为10   
    // d 代表参数为正数型   
    StringBuffer stb=new StringBuffer();
    stb.append("0000000000"+youNumber);
   // String str="0000000000"+youNumber;
   // String str = String.format("%010s", youNumber);  
    System.out.println(stb); // 0000000001   
    
    String num = "1";
    boolean equalsIgnoreCase2 = num.equalsIgnoreCase("1");
    System.out.println("=="+equalsIgnoreCase2);
    
    if (num.length()<10) {    	
    	StringBuffer str=new StringBuffer();
		for (int i = 0; i < 18; i++) {			
		    str.append(0+num);
		   // System.out.println(str);
		}
		System.out.println(str);
	}
    String leftPad = StringUtils.leftPad(num, 18, "0");
    System.out.println("---"+leftPad);
    
    //str = str.replace("，",",")
    boolean equalsIgnoreCase = StringUtils.equalsIgnoreCase("abc", "ABC");
    System.out.println(equalsIgnoreCase);
    
    
    List l=new ArrayList();
    l.add(1);
    l.add(2);
    List l1=new ArrayList(l);
    for (Object object : l1) {
		System.out.println("---"+l1);
	}	
    
    List list = Lists.newArrayList(l);
    for (Object object : list) {
		System.out.println(list);
	}
    
    
}
}
