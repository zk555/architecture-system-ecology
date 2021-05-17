package cn.jdl.ecologyy.pay.config;

import cn.jdl.ecologyy.pay.config.bean.HelloConfig;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 *   javaConfig , Spring的无配置化
 */
@Configurable
public class SpringConfig {

    @Bean
    private HelloConfig hellpConfiog(){
        return new HelloConfig();
    }

}
