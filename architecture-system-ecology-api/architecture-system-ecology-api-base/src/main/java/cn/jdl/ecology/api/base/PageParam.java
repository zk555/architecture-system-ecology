package cn.jdl.ecology.api.base;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * 带有分页条件的查询参数
 *
 * @author DaoDao
 */
@Data
public abstract class PageParam implements Serializable {

    /**
     * 当前页码
     * 起始页为 1
     */
    @Min(value = 1, message = "Page 页码不可小于 {value}")
    @Max(value = Integer.MAX_VALUE, message = "page 页码不可大于 {value}")
    private int page = 1;

    /**
     * 分页步长（每页数量）
     * > 0
     */
    @Min(value = 1, message = "Size 分页步长不可小于 {value}")
    @Max(value = Integer.MAX_VALUE, message = "Size 分页步长不可大于 {value}")
    private int size = 10;

}
