package cn.jdl.ecology.starter.format.autoconfiguration;


import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * 接收yaml中的属性
 */
@ConfigurationProperties(prefix=HelloProperties.HELLO_FORMAT_PREFIX)
public class HelloProperties {

    /**
     * 配置文件中的属性
     */
    public static final String HELLO_FORMAT_PREFIX="cn.jdl.ecology.starter.format";
    private Map<String,Object> info;

    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }
}
