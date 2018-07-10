package treeset;

import java.util.Comparator;
import java.util.TreeSet;

import com.example.demo.test.User;

/**
* @author LvZheng
* 创建时间：2018年1月24日 上午9:25:34
*/
public class Tree {
public static void main(String[] args) {
	 TreeSet<User> terrset =new TreeSet<User>(
			/**
			 * 匿名内部类
			 */
			 new Comparator<User>() {
				@Override
				public int compare(User o1, User o2) {
					// TODO Auto-generated method stub
					return 0;
				}				
			});
	 
	 long startTime=System.nanoTime();
	 for (int i = 0; i < 100; i++) {
		System.out.print(i);
	}
	 long endTime=System.nanoTime();
	 
	 System.out.println();
	 System.out.println(endTime-startTime);
	 
	 
	 
	 
	 
	 long startTime1=System.currentTimeMillis();
	 for (int i = 0; i < 1000; i++) {
		System.out.print(i);
	}
	 System.out.println();
	 long endTime1=System.currentTimeMillis();
	 System.out.println(endTime1-startTime1);
		
	 long startTimeMillis = System.currentTimeMillis();

	 long endTimeMillis = System.currentTimeMillis();

 //	 logger.info("接单总用时:" + (endTimeMillis-startTimeMillis) + "--");

}
}
