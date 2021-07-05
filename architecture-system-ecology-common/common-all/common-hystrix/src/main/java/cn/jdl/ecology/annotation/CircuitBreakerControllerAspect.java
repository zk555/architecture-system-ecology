package cn.jdl.ecology.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

import java.lang.reflect.Method;


/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/7/5 10:34
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class CircuitBreakerControllerAspect {

    @Around("execution(* com.gupao.micro.services.spring.cloud." +
            "server.controller.ServerController.advancedSay2(..)) && args(message) && @annotation(circuitBreaker)")
    public Object advancedSay2InTimeout(ProceedingJoinPoint point,
                                        String message,
                                        CircuitBreaker circuitBreaker) throws Throwable {
        long timeout = circuitBreaker.timeout();
        return doInvoke(point, message, timeout);
    }

    private Object doInvoke(ProceedingJoinPoint point, String message, long timeout) {
        return null;
    }


    /**
     * 功能：反射API实现
     *
     * @param point   1
     * @param message 2
     * @version 0.0.1
     * @author zhaokai108
     * @date 2021/7/5 10:51
     */
    @Around("execution(* com.gupao.micro.services.spring.cloud." +
            "server.controller.ServerController.advancedSay2(..)) && args(message) ")
    public Object advancedSay2InTimeout(ProceedingJoinPoint point,
                                        String message) throws Throwable {

        long timeout = -1;
        if (point instanceof MethodInvocationProceedingJoinPoint) {
            MethodInvocationProceedingJoinPoint methodPoint = (MethodInvocationProceedingJoinPoint) point;
            MethodSignature signature = (MethodSignature) methodPoint.getSignature();
            Method method = signature.getMethod();
            CircuitBreaker circuitBreaker = method.getAnnotation(CircuitBreaker.class);
            timeout = circuitBreaker.timeout();
        }
        return doInvoke(point, message, timeout);
    }
}
