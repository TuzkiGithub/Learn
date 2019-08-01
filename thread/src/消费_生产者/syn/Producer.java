package 消费_生产者.syn;

public class Producer implements Runnable {

    private Resource resource;

    Producer(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run() {

        //对资源加锁
        synchronized (resource) {
            System.out.println("生产者" + Thread.currentThread().getName() + " Get Lock");
            while (resource.count.equals(Resource.MAXSIZE)) {
                //缓存池已满
                try {
                    System.out.println("生产者" + Thread.currentThread().getName() + "缓存池已满！");
                    resource.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            resource.count++;
            System.out.println("生产者" + Thread.currentThread().getName() + "[资源数]:" + resource.count);
            //唤醒其他线程
            resource.notifyAll();
        }
    }
}
