package cn.jdl.ecologyy.pay.annotation;

import cn.jdl.ecology.api.pay.enums.PayApiCode;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhaokai108
 * @version 0.0.1
 * @description: Checker 校验执行器的服务编码 ApiCode 标记注解
 *  用于通过 ApiCode 获取对应的 Checker
 * @create 2021-05-19 11:30
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CheckerCode {

    /**
     * ApiCode 为枚举类型
     * code 与 Request 的 service 对应，也与 Controller 中 RequestMapping 的 Path 对应
     *
     * @return HelloWorldApiCode
     */
    PayApiCode value();

}
