package cn.jdl.ecology.lock;

import cn.jdl.ecology.exception.UnableToAquireLockException;

/**
 * @Description: 获取锁管理类
 * @Author zhaokai108
 * @Date 2021/7/8 15:47
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public interface DistributedLocker {


    <T> T lock(String resourceName, AquiredLockWorker<T> worker) throws UnableToAquireLockException, Exception;

    <T> T lock(String resourceName, AquiredLockWorker<T> worker, int lockTime) throws UnableToAquireLockException, Exception;
}
