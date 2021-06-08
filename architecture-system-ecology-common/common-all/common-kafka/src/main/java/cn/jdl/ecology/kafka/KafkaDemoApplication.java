package cn.jdl.ecology.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/6/8 19:42
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class KafkaDemoApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context= SpringApplication.run
                (KafkaDemoApplication.class, args);
        KafkaProducer kafkaProducer=context.getBean(KafkaProducer.class);
        for(int i=0;i<3;i++){
//            kafkaProducer.send();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
