package cn.jdl.ecology.client.handler;

import cn.jdl.ecology.client.dataBridge.RpcRequest;
import cn.jdl.ecology.client.transport.RpcNetTransport;
import cn.jdl.ecology.client.zk.IServiceDiscovery;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhaokai108
 * @version 0.0.1
 * @description:
 * @create 2021-05-25 15:39
 **/
public class RemoteInvocationHandler  implements InvocationHandler {

    private IServiceDiscovery serviceDiscovery;
    private String version;

    public RemoteInvocationHandler(IServiceDiscovery serviceDiscovery,String version) {
        this.serviceDiscovery=serviceDiscovery;
        this.version=version;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //请求数据的包装
        RpcRequest rpcRequest=new RpcRequest();
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setParamTypes(method.getParameterTypes());
        rpcRequest.setParameters(args);
        rpcRequest.setVersion(version);
        String serviceName=rpcRequest.getClassName();
        if(!StringUtils.isEmpty(version)){
            serviceName=serviceName+"-"+version;
        }
        String serviceAddress=serviceDiscovery.discovery(serviceName);
        //远程通信
        RpcNetTransport netTransport=new RpcNetTransport(serviceAddress);
        Object result=netTransport.send(rpcRequest);

        return result;
    }
}
