package cn.jdl.ecology.advice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Description: 通过future实现集群容错
 * @Author zhaokai108
 * @Date 2021/7/5 9:33
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
@RequestMapping("/api")
@RestController
public class Hystrix2Advice {

    private final ExecutorService executorService = Executors.newFixedThreadPool(1);

    /**
     * 功能：利用异常处理器版本实现
     *
     * @param null 1
     * @version 0.0.1
     * @author zhaokai108
     * @date 2021/7/5 9:34
     */
    @GetMapping("say2")
    public String say2(@RequestParam String message) throws Exception {
        Future<String> future = executorService.submit(() -> {
            return doSay2(message);
        });
        // 等待100ms获取结果
        String returnValue = null;
        try {
            returnValue = future.get(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            future.cancel(true);  //取消执行
            throw e;
        }
        return returnValue;
    }

    private String doSay2(String message) {

        return "";
    }

    private static String errorContent(String message) {

        return "fail";
    }


    /**
     * 功能：aop 实现
     *
     * @param message 1
     * @version 0.0.1
     * @author zhaokai108
     * @date 2021/7/5 10:11
     */
    @GetMapping("/advanced/say")
    public String advancedSay(@RequestParam String message) throws Exception {
        return doSay2(message);
    }
}
