package single;

/**
 * 以动手实践为荣,以只看不练为耻. 以打印日志为荣,以出错不报为耻. 以局部变量为荣,以全局变量为耻. 以单元测试为荣,以手工测试为耻.
 * 以代码重用为荣,以复制粘贴为耻. 以多态应用为荣,以分支判断为耻. 以定义常量为荣,以魔法数字为耻. 以总结思考为荣,以不求甚解为耻.
 *
 * @author LvZheng 创建时间：2018年9月12日 上午9:35:51
 */
public class Singleton {
	//饿汉式 类初始化立即加载 由于加载类时天然线程安全方法没有同步效率高
	private static Singleton instance = new Singleton();

	private Singleton() {

	}

	public static Singleton getsingleton() {

		return instance;
	}

}

//懒汉式  延时加载/懒加载  用的时候在加载  多个线程调用（并发） 效率低下
class Singlenton1{
	private static Singlenton1 instance =null;
	
	private Singlenton1() {}
	
	public static synchronized Singlenton1 getinstance() {
		if (null==instance) {
			instance=new Singlenton1();
		}
		return instance;
	}
	
}
