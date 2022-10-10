package testThread;

import java.util.concurrent.*;

public class T4{
    private static int var = 9;

    public static void main(String[] args) throws InterruptedException {
        //倒数的计数器,不是放线程的数量
        CountDownLatch countDownLatch = new CountDownLatch(var);
        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i = 0;i < 9;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    synchronized (T4.class) {
                        var--;
                        System.out.println(Thread.currentThread().getName()+":"+var);
                        countDownLatch.countDown();
                    }
                }
            });
        }
        countDownLatch.await();
        System.out.println("over");
        executorService.shutdown();
    }
}
