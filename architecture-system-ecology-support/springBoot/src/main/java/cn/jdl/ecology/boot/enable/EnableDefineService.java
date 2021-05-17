package cn.jdl.ecology.boot.enable;

/**
 * 所有符合条件的@Configuration 配置加载到当前 SpringBoot 创建并使用的 IoC 容器中。
 */

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({CacheImportSelector.class})
public @interface EnableDefineService {
}
