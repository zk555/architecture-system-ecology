package cn.jdl.ecology.juc.twoPhaseTermination;

/**
 * @Description: 阻塞状态下线程如何终止
 * @Author zhaokai108
 * @Date 2021/6/22 11:53
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class ThreadExecutor {
    /**
     * 执行线程
     */
    private Thread executeThread;
    /**
     * 运行状态
     */
    private volatile boolean isRunning = false;

    /**
     * @param task 发生阻塞的线程任务
     */
    public void execute(Runnable task) {
        executeThread = new Thread(() -> {
            Thread childThread = new Thread(task);

            // 子线程设置为守护线程
            childThread.setDaemon(true);

            childThread.start();
            try {
                // 强行执行子线程，使其进入休眠状态
                childThread.join();
                isRunning = true;
            } catch (
                    InterruptedException e) {
                //e.printStackTrace();
            }
        });

        executeThread.start();
    }

    /**
     * @param mills 强制结束任务的时长阈值
     */
    public void shutdown(long mills) {
        long currentTime = System.currentTimeMillis();
        while (!isRunning) {
            if ((System.currentTimeMillis() - currentTime) >= mills) {
                System.out.println("任务超时，需要结束他!");
                executeThread.interrupt();
                break;
            }


        }

        isRunning = false;
    }

    public static void main(String[] args) {

        ThreadExecutor executor = new ThreadExecutor();
        long start = System.currentTimeMillis();
        executor.execute(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.shutdown(1000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}


/**
 * interrupt ：会影响一些阻塞的方法，是线程没有处理完成造成数据丢失
 */