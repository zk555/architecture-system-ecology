package cn.jdl.ecology.juc.guarded.request;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:  BlockingQueue的实现原理： 利用等待-通知机制完成阻塞
 * @Author zhaokai108
 * @Date 2021/6/22 10:05
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class RequestQueue {

    private Queue<Request> queue = new ArrayBlockingQueue<Request>(1000);

    ReentrantLock lock = new ReentrantLock();

    Condition condition = lock.newCondition();

    // 出队
    public Request get() {
        Request request = null;

        lock.lock();
        try {
            while (queue.isEmpty()) { //队列空
                condition.await();
            }
            request = queue.poll();
        } catch (InterruptedException e) {
            condition.signalAll();
        } finally {
            lock.unlock();
        }
        return request;
    }

    //入队
    public void put(Request request){
        lock.lock();
        try{
            while (queue.size() >= 500){ // 队列满了
                condition.await();
            }
            queue.offer(request);
            condition.signalAll();
        }catch (InterruptedException e) {
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
