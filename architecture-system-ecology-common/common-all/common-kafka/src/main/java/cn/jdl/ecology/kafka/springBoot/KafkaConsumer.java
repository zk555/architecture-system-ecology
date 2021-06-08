package cn.jdl.ecology.kafka.springBoot;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/6/8 19:38
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
@Component
public class KafkaConsumer {
    @KafkaListener(topics = {"test"})
    public void listener(ConsumerRecord record){
        Optional<?> msg=Optional.ofNullable(record.value());
        if(msg.isPresent()){
            System.out.println(msg.get());
        }
    }
}
