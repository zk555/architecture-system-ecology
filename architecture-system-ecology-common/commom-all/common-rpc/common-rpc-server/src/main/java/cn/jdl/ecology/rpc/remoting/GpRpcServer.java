package cn.jdl.ecology.rpc.remoting;

import cn.jdl.ecology.rpc.annotation.RpcService;
import cn.jdl.ecology.rpc.handler.ProcessorHandler;
import cn.jdl.ecology.rpc.zk.IRegistryCenter;
import cn.jdl.ecology.rpc.zk.RegistryCenterWithZk;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaokai108
 * @version 0.0.1
 * @description:
 * @create 2021-05-25 15:04
 **/
public class GpRpcServer implements ApplicationContextAware, InitializingBean {

    private Map<String, Object> handlerMap = new HashMap();

    private int port;

    private IRegistryCenter registryCenter = new RegistryCenterWithZk();

    public GpRpcServer(int port) {
        this.port = port;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //接收客户端的链接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //处理已经被接收的链接
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).
                    childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().
                                    addLast(new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null))).
                                    addLast(new ObjectEncoder()).
                                    addLast(new ProcessorHandler(handlerMap));
                        }
                    });
            serverBootstrap.bind(port).sync();
            System.out.println("rpc 服务启动完成！！！");
        } finally {
           /* workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();*/
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("开始扫描rpcServer注解");
        Map<String, Object> serviceBeanMap = applicationContext.getBeansWithAnnotation(RpcService.class);
        if (!serviceBeanMap.isEmpty()) {
            for (Object servcieBean : serviceBeanMap.values()) {
                //拿到注解
                RpcService rpcService = servcieBean.getClass().getAnnotation((RpcService.class));
                String serviceName = rpcService.value().getName();//拿到接口类定义
                String version = rpcService.version(); //拿到版本号
                if (!StringUtils.isEmpty(version)) {
                    serviceName += "-" + version;
                }
                handlerMap.put(serviceName, servcieBean);
                registryCenter.registry(serviceName, getAddress() + ":" + port);
            }
        }
    }

    private static String getAddress() {
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return inetAddress.getHostAddress();// 获得本机的ip地址
    }
}
