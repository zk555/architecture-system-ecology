package cn.jdl.ecology.api.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 带有分页信息的数据响应
 *
 * @author DaoDao
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageMessage<T> implements Serializable {

    /**
     * 当前页码
     * 起始页为 1
     */
    private int page = 1;

    /**
     * 分页步长（每页数量）
     * > 0
     */
    private int size = 10;

    /**
     * 总条数
     */
    private long total = 0L;

    /**
     * 数据列表
     */
    private List<T> list;

}
