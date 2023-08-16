package cn.jdl.ecology.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class InvalidCurrencyException extends RuntimeException {

    public InvalidCurrencyException() {
        super("无效货币异常");
    }
}
