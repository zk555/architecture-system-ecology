package cn.jdl.ecology.domain.eventbus;

/**
 * @author chaoyang
 * @date 2022年09月14日 10:51
 */

public interface Bus {

    void register(Object subscriber);

    void unregister(Object subscriber);

    void post(Object event);

    void post(Object event, String topic);

    void close();

    String getBusName();
}
