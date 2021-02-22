package lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author LvZheng
 * 创建时间：2021/2/22 下午6:20
 */
public class CyclicBarrierDemo {
    /**
     * 字面意思回环栅栏，通过它可以实现让一组线程等待至某个状态之后再全部同时执行。叫做回环
     * 是因为当所有等待线程都被释放以后，CyclicBarrier 可以被重用。我们暂且把这个状态就叫做
     * barrier，当调用 await()方法之后，线程就处于 barrier 了。
     * <p>
     * CyclicBarrier 中最重要的方法就是 await 方法，它有 2 个重载版本：
     * 1. public int await()：用来挂起当前线程，直至所有线程都到达 barrier 状态再同时执行后续任务；
     * 2. public int await(long timeout, TimeUnit unit)：让这些线程等待至一定的时间，如果还有
     * 线程没有到达 barrier 状态就直接让到达 barrier 的线程执行后续任务。
     *
     * @param args
     */
    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N);
        for (int i = 0; i < N; i++)
            new Writer(barrier).start();
    }

    static class Writer extends Thread {
        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(5000); //以睡眠来模拟线程需要预定写入数据操作
                System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务，比如数据操作");
        }
    }
}
