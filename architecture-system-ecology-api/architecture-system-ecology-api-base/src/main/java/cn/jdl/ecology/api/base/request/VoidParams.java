package cn.jdl.ecology.api.base.request;

import cn.jdl.ecology.api.base.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author DaoDao
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class VoidParams extends PageParam implements Serializable {

    /**
     * 无实际业务含义，仅为 spring.jackson.serialization.FAIL_ON_EMPTY_BEANS=false
     */
    private Long id;

}
