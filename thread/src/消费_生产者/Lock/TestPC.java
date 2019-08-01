package 消费_生产者.Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Package: 生产者_消费者问题.Lock
 * User: 25414
 * Date: 2019/8/1
 * Time: 10:11
 * Description:
 */
public class TestPC {
    private static Resource resource = new Resource();
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        Consumer consumer = new Consumer(resource, lock, condition);
        Producer producer = new Producer(resource, lock, condition);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(producer);
        Thread thread3 = new Thread(producer);
        Thread thread4 = new Thread(producer);
        Thread thread5 = new Thread(consumer);
        Thread thread6 = new Thread(consumer);
        Thread thread7 = new Thread(consumer);
        Thread thread8 = new Thread(consumer);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();


    }
}
