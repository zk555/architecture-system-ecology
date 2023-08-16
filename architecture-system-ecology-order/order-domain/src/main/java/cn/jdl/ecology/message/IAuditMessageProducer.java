package cn.jdl.ecology.message;

import cn.jdl.ecology.domain.types.AuditMessage;


/**
 * 消息操作，依赖acl
 */
public interface IAuditMessageProducer {

    void send(AuditMessage message);

}
