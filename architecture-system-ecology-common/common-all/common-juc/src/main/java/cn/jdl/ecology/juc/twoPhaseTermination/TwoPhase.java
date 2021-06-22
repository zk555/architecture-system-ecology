package cn.jdl.ecology.juc.twoPhaseTermination;

import cn.jdl.ecology.juc.guarded.request.Request;
import cn.jdl.ecology.juc.guarded.request.RequestManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Description: 两阶段终止模式
 * @Author zhaokai108
 * @Date 2021/6/22 11:41
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class TwoPhase {

    // 离线存储数据恢复线程运行标识
    private volatile boolean isRunning = true;

    private List offList = new ArrayList();

    private Queue<Request> queue = new ArrayBlockingQueue<Request>(1000);

    public void run() {
        while (offList.size() > 0) {
            try {
                if (!isRunning) {
                    while (!queue.isEmpty()) {
                        Request request = queue.poll();
                        RequestManager.store(request);

                    }
                    break;
                }
            } catch (Exception e) {

            }
        }
    }


    // 程序开关
    public void isOk(boolean isRunning) {
        this.isRunning = isRunning;
    }
}
