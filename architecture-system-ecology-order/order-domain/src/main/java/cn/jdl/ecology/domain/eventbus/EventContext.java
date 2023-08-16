package cn.jdl.ecology.domain.eventbus;

import java.lang.reflect.Method;

/**
 * @author chaoyang
 * @date 2022年09月14日 10:50
 */

public interface EventContext {

    String getSource();

    Object getSubscriber();

    Method getSubscribe();

    Object getEvent();
}
