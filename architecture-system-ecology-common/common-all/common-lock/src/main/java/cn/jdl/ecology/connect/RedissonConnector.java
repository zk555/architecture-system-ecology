package cn.jdl.ecology.connect;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/7/8 16:18
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
@Component
public class RedissonConnector {
    RedissonClient redisson;

    @PostConstruct
    public void init() {
        redisson = Redisson.create();
    }

    public RedissonClient getClient() {
        return redisson;
    }
}
