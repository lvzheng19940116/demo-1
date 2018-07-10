package ThreadTest;
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
* 创建时间：2018年6月4日 上午9:29:47
*/
public class RunnableTest implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(i);
		}
		
	}	
	public static void main(String[] args) {
		//真实对象
		RunnableTest rt=new RunnableTest();
		//代理对象
		Thread t=new Thread(rt);
		t.start();
		for (int i = 0; i < 1000; i++) {
			System.out.println("a"+i);
		}
		
	}
}

