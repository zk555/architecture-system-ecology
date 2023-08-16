package cn.jdl.ecology.application.cqe;

import lombok.Data;

/**
 * @author chaoyang
 * @date 2022年09月15日 15:20
 */
@Data
public class OrderQuery {
    private Long sellerId;
    private Long itemId;
    private int currentPage;
    private int pageSize;
}
