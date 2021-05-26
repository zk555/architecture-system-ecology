package cn.jdl.ecology.client.proxy;

import cn.jdl.ecology.client.handler.RemoteInvocationHandler;
import cn.jdl.ecology.client.zk.IServiceDiscovery;
import cn.jdl.ecology.client.zk.ServiceDiscoveryWithZk;

import java.lang.reflect.Proxy;

/**
 * @author zhaokai108
 * @version 0.0.1
 * @description:
 * @create 2021-05-25 15:31
 **/
public class RpcProxyClient {

    private IServiceDiscovery serviceDiscovery=new ServiceDiscoveryWithZk();



    public <T> T clientProxy(final Class<T> interfaceCls, String version){

        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(),
                new Class<?>[]{interfaceCls},new RemoteInvocationHandler(serviceDiscovery,version));
    }
}
