package cn.jdl.ecology;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/7/6 15:37
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
@SpringBootApplication // 标准 Spring Boot 应用
@EnableDiscoveryClient // 激活服务发现客户端
@EnableScheduling
@EnableFeignClients
public class SpringCloudClientApplication {
}
