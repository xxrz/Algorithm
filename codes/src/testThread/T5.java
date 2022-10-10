package testThread;

//public class T5{
//    //两个资源
//    static final Object resource1 = new Object();
//    static final Object resource2 = new Object();
//
//    public static void main(String[] args) {
//
//        Runnable r1 = new Runnable() {
//            @Override
//            public void run() {
//                synchronized (resource1){
//                    try {
//                        System.out.println("t1:get resource1");
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    synchronized (resource2){
//                        System.out.println("t1:get resource2");
//                    }
//                }
//
//            }
//        };
//
//        Runnable r2 = new Runnable() {
//            @Override
//            public void run() {
//                synchronized (resource2){
//                    try {
//                        System.out.println("t2:get resource2");
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    synchronized (resource1){
//                        System.out.println("t2:get resource1");
//                    }
//                }
//
//            }
//        };
//
//        Thread t1 = new Thread(r1);
//        Thread t2 = new Thread(r2);
//        t1.start();
//        System.out.println("t1 start");
//        t2.start();
//        System.out.println("t2 start");
//    }
//
//}

import java.util.concurrent.locks.ReentrantLock;

//解决死锁
/*
1.避免多次锁定。尽量避免同一个线程对多个 Lock 进行锁定。
2.具有相同的加锁顺序。
3.使用定时锁。程序在调用 acquire() 方法加锁时可指定 timeout 参数
4.同时分配多个资源，renntarntlock，绑定，破坏占有且等待
 */
public class T5{
    //两个资源
    static ReentrantLock resource1 = new ReentrantLock();
    static ReentrantLock resource2 = new ReentrantLock();

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                resource1.lock();
                System.out.println("t1:get resource1");
                resource2.lock();
                System.out.println("t1:get resource2");
                resource1.unlock();
                resource2.unlock();
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                resource2.lock();
                System.out.println("t2:get resource2");
                resource1.lock();
                System.out.println("t2:get resource1");
                resource1.unlock();
                resource2.unlock();
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        System.out.println("t1 start");
        t2.start();
        System.out.println("t2 start");
    }

}
