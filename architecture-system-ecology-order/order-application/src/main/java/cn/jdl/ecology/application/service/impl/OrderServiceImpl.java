package cn.jdl.ecology.application.service.impl;

import cn.jdl.ecology.application.assemble.OrderDtoAssembler;
import cn.jdl.ecology.application.dto.OrderDTO;
import cn.jdl.ecology.application.service.OrderService;
import cn.jdl.ecology.domain.entity.Item;
import cn.jdl.ecology.domain.entity.Order;
import cn.jdl.ecology.repository.ItemRepository;
import cn.jdl.ecology.repository.OrderRepository;
import cn.jdl.ecology.types.OrderId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author chaoyang
 * @date 2022年09月01日 14:16
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderDtoAssembler assembler;
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    @Override
    public OrderDTO getOrderDetail(OrderId orderId) {
        Order order = orderRepository.find(orderId);
        Item item = itemRepository.find(order.getItemId());
        return assembler.toDTO(order, item); // 原来的很多复杂转化逻辑都收敛到一行代码了
    }

}
