package cn.jdl.ecologyy.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhaikai
 */
//@EnableAsync
//@EnableCaching
//@EnableBinding({RabbitSource.class, RabbitSink.class, KafkaSource.class, KafkaSink.class})
//@EnableDiscoveryClient
@SpringBootApplication
public class PayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayApplication.class, args);
    }
}
