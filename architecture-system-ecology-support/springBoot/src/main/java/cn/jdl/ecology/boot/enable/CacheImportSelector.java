package cn.jdl.ecology.boot.enable;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * selector  可用根据不同条件激活bean,再注入到IOC中
 */
public class CacheImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        Map<String, Object> attributes =
                annotationMetadata.getAnnotationAttributes(EnableDefineService.class.getName());
        //动态注入bean :自己去实现判断逻辑实现动态配置

        return new String[]{CacheService.class.getName()}; //返回的是一个固定的CacheService
    }
}
