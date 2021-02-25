package queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author LvZheng
 * 创建时间：2021/2/25 下午5:38
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws Exception{
        /**
         *    Java并发包中的阻塞队列一共7个，当然他们都是线程安全的。
         *
         * 　　ArrayBlockingQueue：一个由数组结构组成的有界阻塞队列。
         * 　　LinkedBlockingQueue：一个由链表结构组成的有界阻塞队列。
         * 　　PriorityBlockingQueue：一个支持优先级排序的无界阻塞队列。
         * 　　DealyQueue：一个使用优先级队列实现的无界阻塞队列。
         * 　　SynchronousQueue：一个不存储元素的阻塞队列。
         * 　　LinkedTransferQueue：一个由链表结构组成的无界阻塞队列。
         * 　　LinkedBlockingDeque：一个由链表结构组成的双向阻塞队列。
         */
        BlockingQueue queue1 = new ArrayBlockingQueue(1024);
        BlockingQueue queue2 = new DelayQueue();
        BlockingQueue queue3 = new LinkedBlockingQueue(1024);
        BlockingQueue queue4 = new PriorityBlockingQueue(1024);
        BlockingQueue queue5 = new SynchronousQueue();
        BlockingQueue queue6 = new LinkedTransferQueue();
        BlockingQueue queue7 = new LinkedBlockingDeque();


        // 声明一个容量为10的缓存队列
        BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);

        //new了三个生产者和一个消费者
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        // 借助Executors
        ExecutorService service = Executors.newCachedThreadPool();
        // 启动线程
        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        service.execute(consumer);

        // 执行10s
        Thread.sleep(10 * 1000);
        producer1.stop();
        producer2.stop();
        producer3.stop();

        Thread.sleep(2000);
        // 退出Executor
        service.shutdown();

    }
}
