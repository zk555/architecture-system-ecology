package cn.jdl.ecology.ext.persistence;

import lombok.Data;

/**
 * @author chaoyang
 * @date 2022年09月17日 18:16
 */
@Data
public class ItemDO {

    private Long itemId;

    private String title;

    private Long priceInCents;

    private Long sellerId;

}
