package 消费_生产者.syn;

public class TestPC {
    private static Resource resource = new Resource();
    public static void main(String[] args) {

        Producer p = new Producer(resource);
        Consumer c = new Consumer(resource);


        Thread t1 = new Thread(p, "p1");
        Thread t2 = new Thread(p, "p2");
        Thread t3 = new Thread(p, "p3");
        Thread t4 = new Thread(p, "p4");
        Thread t5 = new Thread(c, "c1");
        Thread t6 = new Thread(c, "c2");
        Thread t7 = new Thread(c, "c3");

        t1.start();
        t2.start();
        t3.start();
        t4.start();


        t6.start();
        t7.start();

    }
}
