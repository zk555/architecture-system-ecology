package cn.jdl.ecology.domain.eventbus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author chaoyang
 * @date 2022年09月14日 10:35
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Subscribe {
    // 注解时可指定topic
    String topic() default "default-topic";
}
