package cn.jdl.ecology.juc.guarded;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Description: Notify()和notifyAll()这两者是有区别的，notify() 是会随机地通知等待队列中的任意一个线程，而 notifyAll() 会通知等待队列中的所有线程。
 * @Author zhaokai108
 * @Date 2021/6/15 19:34
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class GuardedQueue {

    private final Queue<Integer> sourceList;

    public GuardedQueue() {
        this.sourceList = new LinkedBlockingQueue<>();
    }

    // 如果队列为空，阻塞
    public synchronized Integer get() {
        while (sourceList.isEmpty()) {
            try {
                wait();    // ‹--- 如果队列为null，等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return sourceList.peek();
    }

    // 队列添加元素
    public synchronized void put(Integer e) {
        sourceList.add(e);
        notifyAll();  //‹--- 通知，继续执行
    }

    public static void main(String[] args) throws InterruptedException {
        GuardedQueue guardedQueue = new GuardedQueue();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> {
            guardedQueue.get();
            System.out.println("get");
        }
        );
        Thread.sleep(2000);
        executorService.execute(() -> {
            guardedQueue.put(20);
            System.out.println("put");
             }
        );
        executorService.shutdown();
        executorService.awaitTermination(30, TimeUnit.SECONDS);
    }
}
