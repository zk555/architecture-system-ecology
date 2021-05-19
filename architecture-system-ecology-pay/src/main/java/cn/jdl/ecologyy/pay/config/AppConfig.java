package cn.jdl.ecologyy.pay.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaokai108
 * @version 0.0.1
 * @description:
 * @create 2021-05-19 11:59
 **/
@Data
//@RefreshScope
@Configuration
public class AppConfig {

    /**
     * 应用名称
     * Request.client
     * Response.service
     */
    @Value("${spring.application.name:}")
    private String application;

    /**
     * 系统编码
     */
    @Value("${app.system:hello-world}")
    private String system;

    /**
     * 被禁用的服务接口
     */
    @Value("${app.api-disabled:a,b}")
    private String[] apiDisabled;
}
