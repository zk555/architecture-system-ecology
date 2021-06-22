package cn.jdl.ecology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication
public class TestProjectAppication {

    public static void main(String[] args) {

        // 随机端口
        SpringApplication springBootApplication= new SpringApplication(TestProjectAppication.class);

        Map<String,Object> properties = new LinkedHashMap<>();
        properties.put("server.port" ,0);

        springBootApplication.setDefaultProperties(properties);
        springBootApplication.run(args);

        //Spring boot  , 标记当前一些功能

        //
    }
}
