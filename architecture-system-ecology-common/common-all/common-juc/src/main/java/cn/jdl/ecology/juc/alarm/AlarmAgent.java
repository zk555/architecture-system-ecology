package cn.jdl.ecology.juc.alarm;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/6/15 20:18
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class AlarmAgent {
    //初始化报警服务，和报警服务器建立连接，并定时发送心跳信息
    public void init(){
        Thread connecttingThread = new Thread(new ConnectingTask());
        connecttingThread.start();

        //每隔5分钟发送一次心跳包到报警服务器
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(5, new ThreadFactory() {

            private AtomicInteger index = new AtomicInteger();
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread();
                thread.setName("heard - thread -" + index );
                // 当JVM退出时退出
                thread.setDaemon(true);

                return thread;
            }
        });

        //定时器,每5S执行一次
        scheduledThreadPoolExecutor.scheduleAtFixedRate(new HeartbeatTask(),5000,2000, TimeUnit.MILLISECONDS);

    }
}
