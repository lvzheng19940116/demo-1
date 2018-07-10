package untils;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author LvZheng
 *
 * 2018年4月18日
 */
public class DateUtil {
	/**
	 * 得到几天前的时间
	 * 
	 * @param d
	 * @param day
	 * @return
	 */
	public static Date getDateBefore(Date d, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
		return now.getTime();
	}

	/**
	 * 得到几天后的时间
	 * 
	 * @param d
	 * @param day
	 * @return
	 */
	public static Date getDateAfter(Date d, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
		return now.getTime();
	}
	
	
	public static void main(String[] args) {
		Date dateAfter = getDateAfter(new Date(),40);
		Date dateAfter3 = getDateAfter(new Date(),4);
		System.out.println(dateAfter);
		System.out.println(dateAfter3);
		if(dateAfter3.compareTo(dateAfter3)<0) {
			System.out.println(1);
		}else {
			System.out.println(2);
		}
		
		String str="zc6";
		String upperCase = str.toUpperCase();
		System.out.println(upperCase);
		if (!StringUtils.isBlank("1")) {
			System.out.println(1);
		}else {
			System.out.println(2);
		}
		
		
		
	}
}
