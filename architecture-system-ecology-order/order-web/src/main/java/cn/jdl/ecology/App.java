package cn.jdl.ecology;

import cn.jdl.ecology.application.config.SwordProto;
import cn.jdl.ecology.application.config.WeaponPrototype;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigurationProperties({SwordProto.class, WeaponPrototype.class})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);    }
}