package cn.jdl.ecology.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/7/5 10:13
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
@Aspect
@Component
public class ServerControllerAspect {

    private ExecutorService executorService = Executors.newFixedThreadPool(20);


    @Around("execution(* cn.jdl.ecology.aspect.Hystrix2Aspect.advancedSay(..)) && arg(message)")
    public Object advancedSayIntimeout(ProceedingJoinPoint point, String message) throws Throwable {
        Future<Object> future = executorService.submit(() -> {
            Object returnValue = null;
            try {
                returnValue = point.proceed(new Object[]{message});
            } catch (Throwable ex) {
            }
            return returnValue;
        });

        Object returnValue = null;
        try {
            returnValue = future.get(100, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            future.cancel(true); // 取消执行
            returnValue = errorContent("");
        }
        return returnValue;
    }

    public String errorContent(String message) {
        return "Fault";
    }

    @PreDestroy
    public void destroy() {
        executorService.shutdown();
    }
}
