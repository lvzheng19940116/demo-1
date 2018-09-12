package path;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

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
* 创建时间：2018年7月11日 上午9:40:49
*/
public class InetAdress {
	 public static void main(String[] args) throws UnknownHostException {
	        InetAddress inetAddress = InetAddress.getByName("localhost");
	        // InetAddress inetAddress = InetAddress.getByName("DESKTOP-O1HAIQJ");
	        String hostName = inetAddress.getHostName();
	        // 获取主机名
	        System.out.println("hostName => " + hostName);
	        // 获取 IP 地址
	        String hostAdress = inetAddress.getHostAddress();
	        System.out.println("hostAdress => " + hostAdress);
	        
	        
	     // 获取本机的InetAddress实例
			InetAddress address = InetAddress.getLocalHost();
			System.out.println("计算名：" + address.getHostName());
			System.out.println("IP地址：" + address.getHostAddress());
			byte[] bytes = address.getAddress();// 获取字节数组形式的IP地址
			System.out.println("字节数组形式的IP：" + Arrays.toString(bytes));
			System.out.println(address);  	// 直接输出InetAddress对象
			


	    }
}
