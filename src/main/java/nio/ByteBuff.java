package nio;

import java.nio.ByteBuffer;

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
* 创建时间：2018年9月12日 下午3:38:04
*/

public class ByteBuff {
	public static void main(String[] args) {
		 System.out.println("----------Test allocate--------");  
		    System.out.println("before alocate:"  
		            + Runtime.getRuntime().freeMemory());  
		      
		    // 如果分配的内存过小，调用Runtime.getRuntime().freeMemory()大小不会变化？  
		    // 要超过多少内存大小JVM才能感觉到？  
		    ByteBuffer buffer = ByteBuffer.allocate(102400); //缓冲区 
		    System.out.println("buffer = " + buffer);  
		      
		    System.out.println("after alocate:"  
		            + Runtime.getRuntime().freeMemory());  
		      
		    // 这部分直接用的系统内存，所以对JVM的内存没有影响  
		    ByteBuffer directBuffer = ByteBuffer.allocateDirect(102400);  
		    System.out.println("directBuffer = " + directBuffer);  
		    System.out.println("after direct alocate:"  
		            + Runtime.getRuntime().freeMemory());  
		      
		    System.out.println("----------Test wrap--------");  
		    byte[] bytes = new byte[32];  
		    buffer = ByteBuffer.wrap(bytes);  
		    System.out.println(buffer);  
		      
		    buffer = ByteBuffer.wrap(bytes, 10, 10);  
		    System.out.println(buffer);  
	}
}
