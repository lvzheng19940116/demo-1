package lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author LvZheng
 * 创建时间：2021/2/22 下午3:33
 */
public class SemaphoreDemo {
    /*
    Semaphore也是一个线程同步的辅助类，可以维护当前访问自身的线程个数，并提供了同步机制。使用Semaphore可以控制同时访问资源的线程个数，例如，实现一个文件允许的并发访问数。
    Semaphore 基本能完成 ReentrantLock 的所有工作，使用方法也与之类似，通过 acquire()与
release()方法来获得和释放临界资源。

    互斥锁的机制

   Semaphore的主要方法摘要：
　　void acquire():从此信号量获取一个许可，在提供一个许可前一直将线程阻塞，否则线程被中断。
　　void release():释放一个许可，将其返回给信号量。
　　int availablePermits():返回此信号量中当前可用的许可数。
　　boolean hasQueuedThreads():查询是否有线程正在等待获取。

    1. public void acquire(): 用来获取一个许可，若无许可能够获得，则会一直等待，直到获得许可。
    2. public void acquire(int permits):获取 permits 个许可
    3. public void release() { } :释放许可。注意，在释放许可之前，必须先获获得许可。
    4. public void release(int permits) { }:释放 permits 个许可
    上面 4 个方法都会被阻塞，如果想立即得到执行结果，可以使用下面几个方法
    1. public boolean tryAcquire():尝试获取一个许可，若获取成功，则立即返回 true，若获取失败，则立即返回 false
    2. public boolean tryAcquire(long timeout, TimeUnit unit):尝试获取一个许可，若在指定的时间内获取成功，则立即返回 true，否则则立即返回 false
    3. public boolean tryAcquire(int permits):尝试获取 permits 个许可，若获取成功，则立即返回 true，若获取失败，则立即返回 false
    4. public boolean tryAcquire(int permits, long timeout, TimeUnit unit): 尝试获取 permits个许可，若在指定的时间内获取成功，则立即返回 true，否则则立即返回 false
    5. 还可以通过 availablePermits()方法得到可用的许可数目
    */

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        final Semaphore sp = new Semaphore(3);//创建Semaphore信号量，初始化许可大小为3
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            Runnable runnable = new Runnable() {
                public void run() {
                    try {
                        sp.acquire();//请求获得许可，如果有可获得的许可则继续往下执行，许可数减1。否则进入阻塞状态
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread().getName() +
                            "进入，当前已有" + (3 - sp.availablePermits()) + "个并发");
                    try {
                        Thread.sleep((long) (Math.random() * 10000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread().getName() +
                            "即将离开");
                    sp.release();//释放许可，许可数加1
                    //下面代码有时候执行不准确，因为其没有和上面的代码合成原子单元
                    System.out.println("线程" + Thread.currentThread().getName() +
                            "已离开，当前已有" + (3 - sp.availablePermits()) + "个并发");
                }
            };
            service.execute(runnable);
        }
    }


}
