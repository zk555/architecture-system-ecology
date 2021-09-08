package cn.jdl.ecology.lock;

/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/7/8 15:48
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public interface AquiredLockWorker<T> {

    /**
     * 功能：获取锁后需要处理的逻辑
     *
     * @param 1
     * @version 0.0.1
     * @author zhaokai108
     * @date 2021/7/8 15:48
     */
    T invokeAfterLockAquire() throws Exception;
}
