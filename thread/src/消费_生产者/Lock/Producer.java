package 消费_生产者.Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created with IntelliJ IDEA.
 * Package: 生产者_消费者问题.Lock
 * User: 25414
 * Date: 2019/8/1
 * Time: 9:58
 * Description:
 */
public class Producer implements Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */

    private Resource resource;
    private Lock lock;
    private Condition condition;

    Producer(Resource resource, Lock lock, Condition condition) {
        this.resource = resource;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println("生产者 " + Thread.currentThread().getName() + " Get Lock!");
            while (resource.count.equals(resource.MAXSIZE)) {
                System.out.println("生产者" + Thread.currentThread().getName() + " 缓存池已满,等待消费!");
                condition.await();
            }
            resource.count++;
            System.out.println("生产者 " + Thread.currentThread().getName() + " 生产完成，【资源数】： " + resource.count);
            condition.signalAll();
        } catch (Exception e) {
            System.err.println("EXCEPTION!!!");
        } finally {
            System.out.println("生产者" + Thread.currentThread().getName() + " Lost Lock!");
            lock.unlock();
        }
    }
}
