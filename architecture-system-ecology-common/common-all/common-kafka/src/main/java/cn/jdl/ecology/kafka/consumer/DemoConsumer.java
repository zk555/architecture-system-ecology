package cn.jdl.ecology.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/6/8 18:55
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class DemoConsumer extends Thread{

    private final KafkaConsumer<Integer,String> consumer;
    private final String topic;

    public DemoConsumer(String topic){
        Properties properties=new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.13.102:9092,192 .168.13.103:9092,192.168.13.104:9092");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "practice-consumer");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");//设置offset自动提交
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");//自动提交间隔时间
        properties.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.IntegerDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");//对于当前groupid来说，消息的offset从最早的消息开始消费
                consumer= new KafkaConsumer<>(properties);
        this.topic=topic;
    }

    @Override
    public void run() {
        while(true) {
            consumer.subscribe(Collections.singleton(this.topic));
            ConsumerRecords<Integer, String> records =
                    consumer.poll(Duration.ofSeconds(1));
            records.forEach(record -> {
                System.out.println(record.key() + " " + record.value() + " -> offset:" + record.offset());
            });
        }
    }

    public static void main(String[] args) {
        new DemoConsumer("test").start();
    }
}
