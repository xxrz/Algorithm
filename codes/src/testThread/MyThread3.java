package testThread;

public class MyThread3 implements Runnable{
    static private int var = 9;

    public static void main(String[] args) throws InterruptedException {
        MyThread3 myThread3 = new MyThread3();
        Thread t1 = new Thread(myThread3);
        Thread t2 = new Thread(myThread3);
        Thread t3 = new Thread(myThread3);
        t1.start();
        t2.start();
        t3.start();
        while(true){
            if(MyThread3.var==0){
                break;
            }
        }
        //其他不要ran,t1不等t2之类的
        System.out.println("结束");
    }
    @Override
    public void run() {
        while(true){
            synchronized (MyThread3.class){
                if(var==0) {
                    break;
                }
                var--;
                System.out.println(Thread.currentThread().getName()+":var:"+var);
            }
        }
    }
}