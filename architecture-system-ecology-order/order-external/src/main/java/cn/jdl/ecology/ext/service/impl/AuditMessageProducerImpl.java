package cn.jdl.ecology.ext.service.impl;

import cn.jdl.ecology.domain.types.AuditMessage;
import cn.jdl.ecology.message.IAuditMessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author chaoyang
 * @date 2022年08月19日 14:18
 */
@Service
@RequiredArgsConstructor
public class AuditMessageProducerImpl implements IAuditMessageProducer {

    private static final String TOPIC_AUDIT_LOG = "TOPIC_AUDIT_LOG";



    private final KafkaTemplate<String, String> kafkaTemplate;


    @Override
    public void send(AuditMessage message) {
        String messageBody = message.serialize();
        kafkaTemplate.send(TOPIC_AUDIT_LOG, messageBody);

//        return SendResult.success();
    }
}
