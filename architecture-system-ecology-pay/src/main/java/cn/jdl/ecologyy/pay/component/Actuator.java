package cn.jdl.ecologyy.pay.component;

import cn.jdl.ecologyy.pay.annotation.CheckerCode;
import cn.jdl.ecologyy.pay.annotation.ServiceCode;
import cn.jdl.ecologyy.pay.checker.Checker;
import cn.jdl.ecologyy.pay.service.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 执行器
 * 使用继承 ApplicationObjectSupport 的方式获取 ApplicationContext
 * 使用自定义注解获取不同 code 码对应的组件实例
 *
 * @author zhaokai
 */
@Slf4j
@Component
public class Actuator extends ApplicationObjectSupport {

    /**
     * 校验执行器 map
     */
    private final static Map<String, Checker> CHECKER_MAP = new HashMap<>();

    /**
     * 服务执行器 map
     */
    private final static Map<String, Service> SERVICE_MAP = new HashMap<>();

    /**
     * 初始化 spring 容器时，将所有执行器存入 map 中
     * 方便 controller 层调用
     *
     * @param context ApplicationContext
     * @throws BeansException e
     */
    @Override
    protected void initApplicationContext(ApplicationContext context) throws BeansException {
        /*
         * 0. 调用父类的 initApplicationContext 方法，初始化 spring 容器的上下文
         */
        super.initApplicationContext(context);

        /*
         * 1. 通过自定义注解获取 checker bean 实例，存入 map
         */
        Map<String, Object> checkerBeanMap = context.getBeansWithAnnotation(CheckerCode.class);
        checkerBeanMap.keySet().forEach(beanName -> {
            Object bean = checkerBeanMap.get(beanName);
            if (bean instanceof Checker) {
                CheckerCode[] checkerCodes = bean.getClass().getAnnotationsByType(CheckerCode.class);
                if (checkerCodes.length == 1) {
                    String serviceCode = checkerCodes[0].value().code;
                    CHECKER_MAP.put(serviceCode, (Checker) bean);
                    log.info("加载校验执行器: " + serviceCode + ": " + beanName);
                } else {
                    error(bean);
                }
            }

        });
        /*
         * 2. 通过自定义注解获取 service bean 实例，存入 map
         */
        Map<String, Object> serviceBeanMap = context.getBeansWithAnnotation(ServiceCode.class);
        serviceBeanMap.keySet().forEach(beanName -> {
            Object bean = serviceBeanMap.get(beanName);
            if (bean instanceof Service) {
                ServiceCode[] serviceCodes = bean.getClass().getAnnotationsByType(ServiceCode.class);
                if (serviceCodes.length == 1) {
                    String serviceCode = serviceCodes[0].value().code;
                    SERVICE_MAP.put(serviceCode, (Service) bean);
                    log.info("加载服务执行器: " + serviceCode + ": " + beanName);
                } else {
                    error(bean);
                }
            }
        });
        /*
         * 3. 日志记录执行器加载数量
         */
        log.info("校验执行器加载完成: " + CHECKER_MAP.size());
        log.info("服务执行器共加完成: " + SERVICE_MAP.size());
    }

    /**
     * 记录 未获取到自定义注解 的错误日志
     *
     * @param bean Object
     */
    private void error(Object bean) {
        Annotation[] annotations = bean.getClass().getAnnotations();
        List<String> list = new ArrayList<>();
        for (Annotation annotation : annotations) {
            list.add(annotation.toString());
        }
        log.error("未获取到自定义注解: " + String.join(", ", list));
    }

    /**
     * 获取服务执行器
     *
     * @param serviceCode String
     * @return Service
     */
    public static Service getService(String serviceCode) {
        return SERVICE_MAP.get(serviceCode);
    }

    /**
     * 获取校验执行器
     *
     * @param checkerCode String
     * @return Checker
     */
    public static Checker getChecker(String checkerCode) {
        return CHECKER_MAP.get(checkerCode);
    }

}
