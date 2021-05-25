package cn.jdl.ecology.rpc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhaokai108
 * @version 0.0.1
 * @description:
 * @create 2021-05-25 15:02
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RpcService {

    Class<?> value(); //拿到服务的接口

    /**
     * 版本号
     */
    String version() default "";

}
