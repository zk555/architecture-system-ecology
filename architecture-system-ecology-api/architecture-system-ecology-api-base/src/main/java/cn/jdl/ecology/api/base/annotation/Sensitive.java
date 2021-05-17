package cn.jdl.ecology.api.base.annotation;

import cn.jdl.ecology.api.base.enums.SensitiveType;
import cn.jdl.ecology.api.base.json.JacksonSensitiveSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.*;

/**
 * 敏感数据对象注解
 * 暂时不做全局注解捆绑：JacksonAnnotationsInside
 * 注解在 class 上面表示当前类序列化时，需要脱敏
 * 注解在 field 上面表示当前属性序列化时，需要按照指定的参数脱敏
 *
 * @author DaoDao
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@JsonSerialize(using = JacksonSensitiveSerializer.class)
public @interface Sensitive {

    /**
     * 脱敏规则类型
     */
    SensitiveType type() default SensitiveType.CUSTOM;

    /**
     * 正则
     */
    String regex() default "";

    /**
     * 替换
     */
    String replace() default "****";

}
