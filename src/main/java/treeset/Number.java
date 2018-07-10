package treeset;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
* @author LvZheng
* 创建时间：2018年3月8日 下午2:12:18
*/
public class Number {
public static void main(String[] args) {
	  String Orderno = null;
      String maxOrderno = "NO201803080002"; // 从数据库查询出的最大编号
      System.out.println("maxOrderno=" + maxOrderno);
      SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd"); // 时间字符串产生方式
      String uid_pfix = "NO" + format.format(new Date()); // 组合流水号前一部分，NO+时间字符串，如：NO20160126
      System.out.println("time=" + format.format(new Date()));
      if (maxOrderno != null && maxOrderno.contains(uid_pfix)) {
          String uid_end = maxOrderno.substring(10, 14); // 截取字符串最后四位，结果:0001
          System.out.println("uid_end=" + uid_end);
          int endNum = Integer.parseInt(uid_end); // 把String类型的0001转化为int类型的1
          System.out.println("endNum=" + endNum);
          int tmpNum = 10000 + endNum + 1; // 结果10002
          System.out.println("tmpNum=" + tmpNum);
          Orderno = uid_pfix + subStr("" + tmpNum, 1);// 把10002首位的1去掉，再拼成NO201601260002字符串
      } else {
          Orderno = uid_pfix + "0001";
      }
      System.out.println(Orderno);
  }
	public static String subStr(String str, int start) {
	    if (str == null || str.equals("") || str.length() == 0)
	        return "";
	    if (start < str.length()) {
	        return str.substring(start);
	    } else {
	        return "";
	    }
}
}
	
	  
	




