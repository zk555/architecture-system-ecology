package cn.jdl.ecology.domain.eventbus;

/**
 * @author chaoyang
 * @date 2022年09月14日 10:50
 */

public interface EventExceptionHandler {
    void handle(Throwable cause, EventContext context);
}
