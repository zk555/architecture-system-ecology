package cn.jdl.ecology.domain.entity;

import cn.jdl.ecology.types.ItemId;
import cn.jdl.ecology.types.LineItemId;
import cn.jdl.ecology.types.OrderId;
import cn.jdl.ecology.types.Quantity;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 *
 * 子订单实体
 * @author chaoyang
 * @date 2022年09月03日 20:04
 */
@Data
@Builder
public class LineItem {

    private LineItemId id;
    // 主订单ID
    private OrderId orderId;
    // 商品ID
    private ItemId itemId;
    // 价格
    private BigDecimal price;

    private Quantity quantity;

}
