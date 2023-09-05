package cn.jdl.ecology.domain.eventbus;

import java.util.concurrent.Executor;

/**
 * @author chaoyang
 * @date 2022年09月14日 10:25
 */

public class EventBus implements Bus {

    //  事件注册器
    private final EventRegistry registry = new EventRegistry();

    private String busName;

    private final static String DEFAULT_BUS_NAME = "default";

    private final static String DEFAULT_TOPIC = "default-topic";

    // 事件分发器
    private final EventDispatcher dispatcher;

    public EventBus() {
        this(DEFAULT_BUS_NAME, null, EventDispatcher.SEQ_EXECUTOR);
    }

    public EventBus(String busName) {
        this(busName, null, EventDispatcher.SEQ_EXECUTOR);
    }

    public EventBus(String busName, EventExceptionHandler eventExceptionHandler, Executor executor) {
        this.busName = busName;
        this.dispatcher = EventDispatcher.newDispatcher(eventExceptionHandler, executor);
    }

    public EventBus(EventExceptionHandler eventExceptionHandler) {
        this(DEFAULT_BUS_NAME, eventExceptionHandler, EventDispatcher.SEQ_EXECUTOR);
    }

    @Override
    public void register(Object subscriber) {
        registry.bind(subscriber);
    }

    @Override
    public void unregister(Object subscriber) {
        registry.unbind(subscriber);
    }

    @Override
    public void post(Object event) {
        post(event, DEFAULT_TOPIC);
    }

    @Override
    public void post(Object event, String topic) {
        dispatcher.dispatch(this, registry, event, topic);
    }

    @Override
    public void close() {
        dispatcher.close();
    }

    @Override
    public String getBusName() {
        return busName;
    }
}
