package time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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
* 创建时间：2018年6月12日 上午10:08:00
*/
public class TimeTest {
	public static void main(String[] args) {
		Random rm = new Random();

		// 获得随机数
		double pross = (rm.nextDouble()) ;
		System.out.println(pross);
		// 将获得的获得随机数转化为字符串
		String fixLenthString = String.valueOf(pross);

		// 返回固定的长度的随机数
		String substring = fixLenthString.substring(2, 12);
		System.out.println(substring);


//		String time="1256006105375";
//		Date date=new Date(Long.parseLong(time)); 
//		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
//		time=formatter.format(date); 
//		System.out.println(time); 
	
		String time="2010-11-20 11:10:10"; 
		  
		  Date date=null; 
		  SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		  try {
			date=formatter.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		  System.out.println(date); 
		
		
	}
	
}
