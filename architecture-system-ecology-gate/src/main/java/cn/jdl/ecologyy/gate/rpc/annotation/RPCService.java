package cn.jdl.ecologyy.gate.rpc.annotation;

import java.lang.annotation.*;

/**
 * rpc 注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
public @interface RPCService {
	String value() default "";

}
