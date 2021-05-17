package cn.jdl.ecology.api.base.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author DaoDao
 */
@Data
public class VoidMessage implements Serializable {

    /**
     * 无实际业务含义，仅为 spring.jackson.serialization.FAIL_ON_EMPTY_BEANS=false
     */
    private Long id;

}
