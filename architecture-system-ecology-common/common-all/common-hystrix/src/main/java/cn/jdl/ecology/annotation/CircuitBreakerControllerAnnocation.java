package cn.jdl.ecology.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

import java.util.concurrent.Semaphore;

/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/7/5 10:34
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class CircuitBreakerControllerAnnocation {

    private Semaphore semaphore = null;

    @Around("execution(* com.gupao.micro.services.spring.cloud." +
            "server.controller.ServerController.advancedSay3(..))" +
            " && args(message)" +
            " && @annotation(circuitBreaker) ")
    public Object advancedSay3InSemaphore(ProceedingJoinPoint point,
                                          String message,
                                          SemaphoreCircuitBreaker circuitBreaker) throws Throwable {
        int value = circuitBreaker.value();
        if (semaphore == null) {
            semaphore = new Semaphore(value);
        }
        Object returnValue = null;
        try {
            if (semaphore.tryAcquire()) {
                returnValue = point.proceed(new Object[]{message});
                Thread.sleep(1000);
            } else {
                returnValue = errorContent("");
            }
        } finally {
            semaphore.release();
        }

        return returnValue;

    }

    private Object errorContent(String s) {
        return s;
    }
}
