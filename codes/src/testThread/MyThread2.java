package testThread;

public class MyThread2 implements Runnable{
    static private int var = 9;

    public static void main(String[] args) throws InterruptedException {
        MyThread2 myThread2 = new MyThread2();
        Thread t1 = new Thread(myThread2);
        Thread t2 = new Thread(myThread2);
        Thread t3 = new Thread(myThread2);
        t1.start();
        t2.start();
        t3.start();
        t1.join(); //主线程等待t1线程结束
        t2.join();//主线程等待t2线程结束
        t3.join();//主线程等待t3线程结束
        //其他不要ran,t1不等t2之类的
        System.out.println("结束");
    }
    @Override
    public void run() {
        while(true){
            synchronized (MyThread2.class){
                if(var==0) {

                    break;
                }
                var--;
                System.out.println(Thread.currentThread().getName()+":var:"+var);
            }
        }
    }
}
