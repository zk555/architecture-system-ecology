package cn.jdl.ecology.rpc.config;

import cn.jdl.ecology.rpc.remoting.GpRpcServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaokai108
 * @version 0.0.1
 * @description:
 * @create 2021-05-25 15:18
 **/
@Configuration
@ComponentScan(basePackages = "cn.jdl.ecology.rpc.rpcService")
public class SpringConfig {

    @Bean(name="gpRpcServer")
    public GpRpcServer gpRpcServer(){
        return new GpRpcServer(8080);
    }
}