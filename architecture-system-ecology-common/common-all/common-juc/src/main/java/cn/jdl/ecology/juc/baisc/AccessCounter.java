package cn.jdl.ecology.juc.baisc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/6/5 12:05
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class AccessCounter {

    public AtomicInteger atomicInteger = new AtomicInteger();

    public void access(){
        atomicInteger.incrementAndGet();
    }
}
