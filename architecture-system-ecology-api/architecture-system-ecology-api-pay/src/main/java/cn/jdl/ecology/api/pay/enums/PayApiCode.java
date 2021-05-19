package cn.jdl.ecology.api.pay.enums;

import cn.jdl.ecology.api.pay.constant.PayServiceCodeConstant;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhaokai108
 * @version 0.0.1
 * @description: 服务API编码
 * @create 2021-05-19 11:31
 **/
@AllArgsConstructor
public enum PayApiCode {
    /**
     * api code
     */
    _ORDER_000001(PayServiceCodeConstant._0000001, "创建订单"),

    ;

    /**
     * 服务编码
     */
    public final String code;
    /**
     * 服务说明
     */
    public final String message;

    public String getCode(PayApiCode payApiCode){
        if (payApiCode == null){
            return null;
        }
        return payApiCode.code;
    }
    /**
     * get
     *
     * @param code String
     * @return PayApiCode
     */
    public static PayApiCode get(String code) {
        for (PayApiCode apiCode : PayApiCode.values()) {
            if (code.equals(apiCode.code)) {
                return apiCode;
            }
        }
        return null;
    }
}
