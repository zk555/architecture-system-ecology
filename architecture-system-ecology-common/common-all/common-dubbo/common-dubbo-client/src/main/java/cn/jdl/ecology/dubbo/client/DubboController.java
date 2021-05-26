package cn.jdl.ecology.dubbo.client;


import cn.jdl.ecology.api.ISayHelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DubboController {
    //Dubbo提供的注解,loadbalance = "roundrobin",timeout = 1,cluster ="failfast",mock = "cn.jdl.ecology.dubbo.mock.SayHelloServiceMock",check = false)
    @Reference
    ISayHelloService sayHelloService; //dubbo://

    @GetMapping("/sayhello")
    public String sayHello() throws InterruptedException {
        return sayHelloService.sayHello(); //我调用这个服务可能失败，如果失败了，我要怎么处理
    }



}
