package cn.jdl.ecology.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.io.Writer;
import java.util.concurrent.TimeoutException;

/**
 * @Description: 异常拦截器
 * @Author zhaokai108
 * @Date 2021/7/5 9:54
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
@RestControllerAdvice(assignableTypes = Hystrix2Advice.class)
public class CircuitBreakerControllerAdvice {

    @ExceptionHandler
    public void onTimeoutException(TimeoutException e
            , Writer writer) throws IOException {
        writer.write(errorContent(""));
        writer.flush();
        writer.close();
    }

    private String errorContent(String s) {
        return "Fault";
    }
}
