package cn.jdl.ecology.annotation;

/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/7/5 10:39
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public @interface CircuitBreaker {

    public int timeout = 0;

    long timeout();
}
