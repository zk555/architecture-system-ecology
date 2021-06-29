package cn.jdl.ecology.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 防止重复提交
 * @Author zhaokai108
 * @Date 2021/6/24 17:51
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotRepeatSubmit {
    /**
     * 过期时间，单位毫秒
     **/
    long value() default 5000;
}
