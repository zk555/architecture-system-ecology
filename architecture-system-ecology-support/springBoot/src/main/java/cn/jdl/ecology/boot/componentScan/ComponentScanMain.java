package cn.jdl.ecology.boot.componentScan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 扫描指定的包
 */
@ComponentScan(basePackages = "cn.jdl.ecology.boot.componentScan")
public class ComponentScanMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(ComponentScanMain.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (int i = 0; i <beanDefinitionNames.length; i++) {
            if (beanDefinitionNames[i].equals("valueClass")){
                System.out.println(beanDefinitionNames[i].toString());
            }
        }
    }

}
