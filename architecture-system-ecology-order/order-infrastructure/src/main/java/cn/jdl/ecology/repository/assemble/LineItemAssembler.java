package cn.jdl.ecology.repository.assemble;

import cn.jdl.ecology.domain.entity.LineItem;
import cn.jdl.ecology.persistence.po.LineItemPO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author chaoyang
 * @date 2022年09月03日 20:22
 */
@Mapper(componentModel = "spring")
public interface LineItemAssembler {



    @Mappings({
        @Mapping(target = "id", source = "id.id"),
        @Mapping(target = "orderId", source = "orderId.id"),
        @Mapping(target = "itemId", source = "itemId.id"),
        @Mapping(target = "quantity", source = "quantity.quantity")
    })
    LineItemPO fromLineItem(LineItem lineItem);

    @Mappings({
        @Mapping(target = "id.id", source = "id"),
        @Mapping(target = "orderId.id", source = "orderId"),
        @Mapping(target = "itemId.id", source = "itemId"),
        @Mapping(target = "quantity.quantity", source = "quantity")
    })
    LineItem toLineItem(LineItemPO lineItemDO);
}
