package cn.jdl.ecology.client;

import cn.jdl.ecology.client.api.IHelloService;
import cn.jdl.ecology.client.config.SpringConfig;
import cn.jdl.ecology.client.proxy.RpcProxyClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhaokai108
 * @version 0.0.1
 * @description:
 * @create 2021-05-25 15:28
 **/
public class App {

    public static void main( String[] args ) throws InterruptedException {
        ApplicationContext context=new
                AnnotationConfigApplicationContext(SpringConfig.class);
        RpcProxyClient rpcProxyClient=context.getBean(RpcProxyClient.class);

        IHelloService iHelloService=rpcProxyClient.clientProxy
                (IHelloService.class,"v1.0");
        for(int i=0;i<100;i++) {
            Thread.sleep(2000);
            System.out.println(iHelloService.sayHello(1.0));
        }
    }
}
