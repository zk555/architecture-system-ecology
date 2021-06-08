package cn.jdl.ecology.kafka.springBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/6/8 19:38
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
@Component
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    public void send(){
        kafkaTemplate.send("test","msgKey","msgData");
    }
}
