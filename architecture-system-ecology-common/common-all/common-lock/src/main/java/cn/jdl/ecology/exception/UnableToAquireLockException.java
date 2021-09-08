package cn.jdl.ecology.exception;

/**
 * @Description: 不能获取锁的异常类：
 * @Author zhaokai108
 * @Date 2021/7/8 16:11
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class UnableToAquireLockException extends RuntimeException {

    public UnableToAquireLockException() {
    }

    public UnableToAquireLockException(String message) {
        super(message);
    }

    public UnableToAquireLockException(String message, Throwable cause) {
        super(message, cause);
    }
}
