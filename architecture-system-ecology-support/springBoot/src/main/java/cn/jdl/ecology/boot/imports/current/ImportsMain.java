package cn.jdl.ecology.boot.imports.current;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ImportsMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        for (int i = 0; i <beanDefinitionNames.length; i++) {
            System.out.println(beanDefinitionNames[i].toString());
        }
    }
}
