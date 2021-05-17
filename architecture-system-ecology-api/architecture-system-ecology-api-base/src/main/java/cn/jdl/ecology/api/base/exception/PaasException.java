package cn.jdl.ecology.api.base.exception;

import cn.jdl.ecology.api.base.enums.BaseResCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author DaoDao
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PaasException extends RuntimeException implements Serializable {

    private String code;

    public PaasException(String message) {
        super(message);
        this.code = BaseResCode._9999.code;
    }

    public PaasException(String code, String message) {
        super(message);
        this.code = code;
    }

    public PaasException(String message, Throwable cause) {
        super(message, cause);
    }

    public PaasException(BaseResCode baseResCode) {
        super(baseResCode.desc);
        this.code = baseResCode.code;
    }

    public PaasException(BaseResCode baseResCode, Exception e) {
        super(baseResCode.desc, e);
        this.code = baseResCode.code;
    }

}
