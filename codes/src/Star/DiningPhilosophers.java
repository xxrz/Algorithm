package Star;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {

    //控制筷子的拿起和放下
    private final ReentrantLock[] lockList = {
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
    };

    //定义信号量：限制最多只有4个哲学家持有筷子
    private Semaphore limit = new Semaphore(4);


    public void DiningPhilosophers(){

    }


    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int left = philosopher;
        int right = (philosopher + 1)%5;

        limit.acquire();
        lockList[left].lock();
        pickLeftFork.run();
        lockList[right].lock();
        pickRightFork.run();
        eat.run();

        putLeftFork.run();
        lockList[left].unlock();
        putRightFork.run();
        lockList[right].unlock();
        limit.release();



    }

    public static void main(String[] args) {

        AtomicInteger fork = new AtomicInteger(2);

        fork.compareAndSet(1,3);
        System.out.println(fork);

        ThreadLocal<Integer> test = new ThreadLocal<>();

    }
}
