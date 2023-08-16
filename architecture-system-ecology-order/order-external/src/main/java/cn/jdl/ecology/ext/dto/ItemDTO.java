package cn.jdl.ecology.ext.dto;

import lombok.Data;

/**
 * @author chaoyang
 * @date 2022年09月17日 18:02
 */
// 自定义的内部值类
@Data
public class ItemDTO {

    private Long itemId;
    private Long sellerId;
    private String title;
    private Long priceInCents;

}
