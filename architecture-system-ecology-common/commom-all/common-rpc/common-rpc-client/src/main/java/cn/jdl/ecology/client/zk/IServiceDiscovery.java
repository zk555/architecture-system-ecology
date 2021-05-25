package cn.jdl.ecology.client.zk;

/**
 * @author zhaokai108
 * @version 0.0.1
 * @description:  查询服务地址
 * @create 2021-05-25 15:34
 **/
public interface IServiceDiscovery {

    //根据服务名称返回服务地址
    String  discovery(String serviceName);
}
