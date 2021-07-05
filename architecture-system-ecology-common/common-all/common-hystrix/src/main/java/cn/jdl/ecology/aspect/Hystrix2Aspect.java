package cn.jdl.ecology.aspect;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: 通过future实现集群容错
 * @Author zhaokai108
 * @Date 2021/7/5 9:33
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
@RequestMapping("/api")
@RestController
public class Hystrix2Aspect {

    private final ExecutorService executorService = Executors.newFixedThreadPool(1);

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

    private String doSay2(String message) {

        return "";
    }

    private static String errorContent(String message) {

        return "fail";
    }



}
