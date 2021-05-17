package cn.jdl.ecology.boot.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 托管bean到spring管理
 */
public class ConfigurationMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(ConfigurationMain.class);
        ValueClass valueClass = (ValueClass) applicationContext.getBean("valueClass");

        System.out.println(valueClass.toString());
    }
}
