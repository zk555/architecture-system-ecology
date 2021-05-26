package cn.jdl.ecology.dubbo.mock;


import cn.jdl.ecology.api.ISayHelloService;


public class SayHelloServiceMock implements ISayHelloService {
    @Override
    public String sayHello() {
        return "服务端发生异常， 被降解了。返回兜底数据。。。";
    }
}
