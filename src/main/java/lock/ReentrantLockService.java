package lock;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LvZheng
 * 创建时间：2021/2/5 下午3:45
 */
public class ReentrantLockService {
    /**
     * ReentantLock 继承接口 Lock 并实现了接口中定义的方法，他是一种可重入锁，除了能完
     * 成 synchronized 所能完成的所有工作外，还提供了诸如可响应中断锁、可轮询锁请求、定时锁等
     * 避免多线程死锁的方法。
     * @param args
     */

    public static void main(String[] args) {

        //非公平锁
        ReentrantLock reentrantLock = new ReentrantLock();
        //非公平锁
        ReentrantLock reentrantLock1 = new ReentrantLock(false);
        //公平锁
        ReentrantLock reentrantLock2 = new ReentrantLock(true);
        //创建 Condition
        Condition condition = reentrantLock.newCondition();

        try {
            //lock 加锁
            reentrantLock.lock();
            //1：wait 方法等待：
            //System.out.println("开始 wait");
            condition.await(1L, TimeUnit.SECONDS);
            //通过创建 Condition 对象来使线程 wait，必须先执行 lock.lock 方法获得锁
            //:2：signal 方法唤醒
            condition.signal();//condition 对象的 signal 方法可以唤醒 wait 线程
            for (int i = 0; i < 10; i++) {
                System.out.println("ThreadName=" + Thread.currentThread().getName() + (" " + (i + 1)));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放锁
            reentrantLock.unlock();
        }


    }
}
