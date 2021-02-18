package lock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LvZheng
 * 创建时间：2021/2/7 下午3:32
 */
public class ConditionDemo {

    /**
     * ReentantLock 继承接口 Lock 并实现了接口中定义的方法，他是一种可重入锁，除了能完
     * 成 synchronized 所能完成的所有工作外，还提供了诸如可响应中断锁、可轮询锁请求、定时锁等
     * 避免多线程死锁的方法。
     *
     * @param args
     */
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();

    private static boolean flag = true;

    public static void main(String[] args) throws Exception {
        Thread waitThread = new Thread(new Waiter(), "Wait Thread");
        waitThread.start();
        Thread.sleep(1000);
        Thread notifyThread = new Thread(new Notifier(), "Notify Thread");
        notifyThread.start();
    }

    private static class Waiter implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                while (flag) {
                    System.out.println(Thread.currentThread() + " flag is true. wait @ " +
                            new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    condition.await();
                    System.out.println("执行await");
                }
                System.out.println(Thread.currentThread() + " flag is false. running @ " +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            } finally {
                lock.unlock();
            }
        }
    }

    private static class Notifier implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println(Thread.currentThread() + " hold lock. notify @ " +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));

                condition.signalAll();

                flag = false;
                Thread.sleep(5000); // Thread.sleep() 不会释放锁

                System.out.println(Thread.currentThread() + " hold lock again. sleep @ " +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            } finally {
                lock.unlock();
            }

        }
    }

}
