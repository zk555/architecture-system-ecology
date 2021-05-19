package cn.jdl.ecology.api.pay.exception;

import cn.jdl.ecology.api.pay.constant.PayCodeMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author zhaokai108
 * @version 0.0.1
 * @description:
 * @create 2021-05-19 14:14
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class PayException  extends RuntimeException implements Serializable {

    private String code;

    public PayException(String code, String message) {
        super(message);
        this.code = code;
    }

    public PayException(String message, Throwable cause) {
        super(message, cause);
    }

    public PayException(PayCodeMessage codeMessage) {
        super(codeMessage.message);
        this.code = codeMessage.code;
    }

    public PayException(PayCodeMessage codeMessage, Exception e) {
        super(codeMessage.message, e);
        this.code = codeMessage.code;
    }
}
