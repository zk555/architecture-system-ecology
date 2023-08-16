package cn.jdl.ecology.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author chaoyang
 * @date 2022年08月22日 16:37
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class InsufficientFundsException extends RuntimeException {

    public InsufficientFundsException() {
        super("资金不足异常");
    }
}
