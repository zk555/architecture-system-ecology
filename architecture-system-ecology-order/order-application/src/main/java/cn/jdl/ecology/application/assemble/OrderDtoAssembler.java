package cn.jdl.ecology.application.assemble;


import cn.jdl.ecology.application.dto.OrderDTO;
import cn.jdl.ecology.domain.entity.Item;
import cn.jdl.ecology.domain.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author chaoyang
 * @date 2022年09月01日 11:21
 */
@Mapper(componentModel = "spring")
public interface OrderDtoAssembler {

    OrderDtoAssembler INSTANCE = Mappers.getMapper(OrderDtoAssembler.class);

    // 通过各种实体，生成DTO
    @Mappings({
        @Mapping(target = "id", source = "order.id.id"),
        @Mapping(target = "itemTitle", source = "item.title"),
        @Mapping(target = "detailAddress", source = "order.address.detail"),
    })
    OrderDTO toDTO(Order order, Item item);


    @Mappings({
        @Mapping(target = "id", source = "id.id"),
        @Mapping(target = "itemTitle", source = "itemTitle"),
        @Mapping(target = "detailAddress", source = "address.detail"),
    })
    OrderDTO orderToDTO(Order savedOrder);

    // 通过DTO，生成实体

}
