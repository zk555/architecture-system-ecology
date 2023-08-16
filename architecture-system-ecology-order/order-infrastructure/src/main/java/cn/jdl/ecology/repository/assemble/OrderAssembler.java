package cn.jdl.ecology.repository.assemble;

import cn.jdl.ecology.domain.entity.Order;
import cn.jdl.ecology.persistence.po.OrderPO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author chaoyang
 * @date 2022年09月01日 14:25
 */
@Mapper(componentModel = "spring")
public interface OrderAssembler {



    @Mappings({
        @Mapping(target = "id.id", source = "id"),
        @Mapping(target = "address.detail", source = "addressDetail")
    })
    Order toOrder(OrderPO orderPO);
    @Mappings({
    @Mapping(target = "addressDetail", source = "address.detail"),
    @Mapping(target = "id", source = "id.id")
    })
    OrderPO fromOrder(Order aggregate);
}
