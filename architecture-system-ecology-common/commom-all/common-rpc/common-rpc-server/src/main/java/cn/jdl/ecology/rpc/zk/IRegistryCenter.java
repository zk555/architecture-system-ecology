package cn.jdl.ecology.rpc.zk;

/**
 * @author zhaokai108
 * @version 0.0.1
 * @description: 服务注册名称和服务注册地址实现服务的管理
 * @create 2021-05-25 15:06
 **/
public interface IRegistryCenter {

    /**
     * 服务注册名称和服务注册地址实现服务的管理
     * @param serviceName
     * @param serviceAddress
     */
    void registry(String serviceName,String serviceAddress);
}
