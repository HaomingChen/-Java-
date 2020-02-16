package lock.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock不会像synchronized一样, 异常的时候自动释放锁, 所以最佳实践是,finally时释放锁, 以便保证发生异常的时候锁一定被释放
 *
 * @author Haoming Chen
 * Created on 2020/2/15
 */
public class MustUnlock {

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.lock();
        try {
            //获取本锁保护的资源
            System.out.println(Thread.currentThread().getName() + "开始执行任务");
        } finally {
            lock.unlock();
        }
    }
}
