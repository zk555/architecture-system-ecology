package cn.jdl.ecology.dynamic.nacos.core;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: load config
 * @Author zhaokai108
 * @Date 2021/6/4 9:43
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
@NacosPropertySource(name="paas",dataId = "hello-world.properties",groupId = "DEFAULT_GROUP",autoRefreshed = true)
@RestController
public class NacosConfigController {


    @NacosValue(value = "${server.port:hello Nacos}",autoRefreshed = true)
    private String info;

    @GetMapping("/get")
    public String get(){
        return info;
    }

}
