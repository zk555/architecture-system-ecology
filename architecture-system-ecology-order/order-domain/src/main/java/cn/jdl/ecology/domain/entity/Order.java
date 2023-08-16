package cn.jdl.ecology.domain.entity;

import cn.jdl.ecology.repository.Aggregate;
import cn.jdl.ecology.types.*;
import lombok.Data;
import java.util.List;
import java.util.UUID;

/**
 * @author chaoyang
 * @date 2022年09月01日 13:36
 */
@Data
public class Order  implements Aggregate<OrderId> {


    private OrderId id;

    private UserId userId;

    private Long itemId;

    private Address address;

    private List<LineItem> lineItems;

    private OrderState status;

    private Long buyerId;

    private Long sellerId;

    private String itemTitle;

    private Long itemUnitPrice;

    private Integer count;

    @Override
    public OrderId getId() {
        return  new OrderId(Long.valueOf(UUID.randomUUID().toString()));
    }

    public void addLineItem(ItemId itemId, Quantity quantity, Money money) {

        LineItem lineItem = LineItem.builder().itemId(itemId).quantity(quantity)
            .price(money.getAmount()).build();
        lineItems.add(lineItem);
    }

    public Long getTotalCost() {
        return itemUnitPrice * count;
    }

    public void pay() {


    }
}
