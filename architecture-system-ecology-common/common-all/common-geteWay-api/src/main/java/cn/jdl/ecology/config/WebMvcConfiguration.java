package cn.jdl.ecology.config;

import cn.jdl.ecology.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/6/24 17:49
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    private static final String[] excludePathPatterns = {"/api/token/api_token"};


    @Autowired
    private TokenInterceptor tokenInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns(excludePathPatterns);
    }
}
