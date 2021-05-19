package cn.jdl.ecology.api.pay.constant;

import lombok.AllArgsConstructor;

/**
 * @author zhaokai108
 * @version 0.0.1
 * @description:
 * @create 2021-05-19 14:16
 **/
@AllArgsConstructor
public enum PayCodeMessage {
    /**
     * 服务 00
     */
    SUCCESS("0000", "成功"),
    ERROR("9999", "错误"),
    NO_SUCH_SERVICE("0003", "没有此项服务"),
    SERVICE_DISABLED("0004", "服务已禁用"),
    CHECKER_UNAVAILABLE("0005", "校验执行器不可用"),
    SERVICE_UNAVAILABLE("0006", "服务执行器不可用"),
    REQUEST_PARAM_NOT_NULL("0007", "请求参数不可为空"),
    REQUEST_PARAM_ERROR("0008", "请求参数错误"),

    HELLO_WORLD_ERROR("1111", "喵~(=^.^=)"),

    ;

    /**
     * 响应编码
     */
    public final String code;
    /**
     * 响应说明
     */
    public final String message;

    /**
     * get
     *
     * @param code String
     * @return HelloWorldCodeMessage
     */
    public static PayCodeMessage get(String code) {
        for (PayCodeMessage codeMessage : PayCodeMessage.values()) {
            if (code.equals(codeMessage.code)) {
                return codeMessage;
            }
        }
        return null;
    }
}
