package cn.jdl.ecology.rpc.rpcService.impl;

import cn.jdl.ecology.rpc.annotation.RpcService;
import cn.jdl.ecology.rpc.rpcService.IHelloService;

/**
 * @author zhaokai108
 * @version 0.0.1
 * @description:
 * @create 2021-05-25 15:20
 **/
@RpcService(value = IHelloService.class, version = "v1.0")
public class HelloServiceImpl implements IHelloService {
    @Override
    public String sayHello(double money) {
        System.out.println("【V1.0】request in sayHello:" + money);
        return "【V1.0】Say Hello:" + money;
    }
}
