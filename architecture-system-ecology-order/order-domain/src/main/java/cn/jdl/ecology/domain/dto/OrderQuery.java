package cn.jdl.ecology.domain.dto;

import lombok.Data;

/**
 * @author chaoyang
 * @date 2022年09月02日 13:18
 */
@Data
public class OrderQuery {
    private String orderId;
    private String creator;
}
