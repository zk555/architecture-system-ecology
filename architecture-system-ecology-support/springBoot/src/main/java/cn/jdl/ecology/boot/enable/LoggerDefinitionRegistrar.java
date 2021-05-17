package cn.jdl.ecology.boot.enable;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

/**
 * 实现 ImportBeanDefinitionRegistrar 接口进行动态注入
 */
public class LoggerDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        Class beanClass=LoggerService.class;
        RootBeanDefinition beanDefinition=new RootBeanDefinition(beanClass);
        String beanName= StringUtils.uncapitalize(beanClass.getSimpleName());
        beanDefinitionRegistry.registerBeanDefinition(beanName,beanDefinition);
    }
}
