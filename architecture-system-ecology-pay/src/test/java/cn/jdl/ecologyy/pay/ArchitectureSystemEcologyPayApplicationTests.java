package cn.jdl.ecologyy.pay;

import cn.jdl.ecologyy.pay.config.bean.HelloConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ArchitectureSystemEcologyPayApplicationTests {

    @Resource
    private HelloConfig helloConfig;

    @Test
    void contextLoads() {
        System.out.println(helloConfig.sayHello());
    }

}
