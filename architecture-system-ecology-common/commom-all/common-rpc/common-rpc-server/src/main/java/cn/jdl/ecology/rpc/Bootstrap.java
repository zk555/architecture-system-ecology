package cn.jdl.ecology.rpc;

import cn.jdl.ecology.rpc.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhaokai108
 * @version 0.0.1
 * @description:
 * @create 2021-05-25 15:17
 **/
public class Bootstrap {

    public static void main( String[] args )
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        ((AnnotationConfigApplicationContext) context).start();
    }
}
