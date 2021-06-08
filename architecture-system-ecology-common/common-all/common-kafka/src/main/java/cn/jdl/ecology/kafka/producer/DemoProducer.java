package cn.jdl.ecology.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 消息提供者
 * @Author zhaokai108
 * @Date 2021/6/8 18:50
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class DemoProducer extends Thread {


    private final KafkaProducer<Integer,String> producer;
    private final String topic;

    public DemoProducer(String topic){
        Properties properties=new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"123.56.237.248:9092");
        properties.put(ProducerConfig.CLIENT_ID_CONFIG,"practice-producer");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                IntegerSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        producer=new KafkaProducer<Integer, String>(properties);
        this.topic = topic;
    }
    @Override
    public void run() {
        int num=0;
        while(num<50){
            String msg="pratice test message:"+num;
            try {
                producer.send(new ProducerRecord<Integer, String>
                        (topic,msg)).get();
                TimeUnit.SECONDS.sleep(2);
                num++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new DemoProducer("test").start();
    }
}
