package testThread;

public class MyThread implements Runnable{
    private static int var = 9;

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread t1 = new Thread(myThread);
        Thread t2 = new Thread(myThread);
        Thread t3 = new Thread(myThread);
        t1.start();
        t2.start();
        t3.start();
    }


    @Override
    public void run() {
        while(true){
            synchronized (MyThread.class){
                if(var==0) {
                    System.out.println("结束");
                    break;
                }
                var--;
                System.out.println(Thread.currentThread().getName()+":var:"+var);
            }
        }
    }
}
