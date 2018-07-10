package ThreadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
* 创建时间：2018年6月5日 上午9:16:28
*/
public class CallableTest implements Callable<String>{

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "lvzheng";
	}
	public static void main(String[] args) {
		//创建线程
		ExecutorService threadPool = Executors.newSingleThreadExecutor( );
		Future<String> future = threadPool.submit(new CallableTest());
		try {
			//获取值
			String string = future.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}finally {
			//停止线程
            threadPool.shutdown();
        }
	}	
}
