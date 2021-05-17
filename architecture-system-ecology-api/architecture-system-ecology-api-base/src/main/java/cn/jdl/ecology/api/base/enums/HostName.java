package cn.jdl.ecology.api.base.enums;

import lombok.AllArgsConstructor;

/**
 * @author DaoDao
 */
@AllArgsConstructor
public enum HostName {

    /**
     * host
     */
    PAAS_GATEWAY("paas.mfe88.com", "PAAS 网关"),
    SAAS_GATEWAY("saas.mfe88.com", "SAAS 网关"),

    ;

    /**
     * 服务编码
     */
    public final String code;

    /**
     * 服务名称
     */
    public final String name;

    /**
     * get
     *
     * @param code String
     * @return ServiceName
     */
    public static ServiceName get(String code) {
        for (ServiceName serviceName : ServiceName.values()) {
            if (code.equals(serviceName.code)) {
                return serviceName;
            }
        }
        return null;
    }
}
