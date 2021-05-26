package cn.jdl.ecology.dubbo.provider;

import cn.jdl.ecology.api.ISayHelloService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author zhaokai108
 * @version 0.0.1
 * @description:
 * @create 2021-05-26 16:14
 **/
@Service
public class SayHelloServiceImpl implements ISayHelloService {
    @Override
    public String sayHello() throws InterruptedException {
        System.out.println("Come in SayHello()");
        return "Hello Dubbo";
    }
}
