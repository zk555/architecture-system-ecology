package cn.jdl.ecology.domain.eventbus;

import java.util.concurrent.Executor;

/**
 * @author chaoyang
 * @date 2022年09月14日 10:57
 */

public class AsyncEventBus extends EventBus {
    private final static String DEFAULT_BUS_NAME = "default-async";

    public AsyncEventBus() {
        this(DEFAULT_BUS_NAME, null, EventDispatcher.POOL_EXECUTOR);
    }

    public AsyncEventBus(String busName) {
        this(busName, null, EventDispatcher.POOL_EXECUTOR);
    }

    public AsyncEventBus(String busName, EventExceptionHandler eventExceptionHandler, Executor executor) {
        super(busName, eventExceptionHandler, executor);
    }

    public AsyncEventBus(EventExceptionHandler eventExceptionHandler) {
        this(DEFAULT_BUS_NAME, eventExceptionHandler, EventDispatcher.POOL_EXECUTOR);
    }
}
