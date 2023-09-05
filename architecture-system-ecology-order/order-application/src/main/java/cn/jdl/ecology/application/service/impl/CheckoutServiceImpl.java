package cn.jdl.ecology.application.service.impl;

import cn.jdl.ecology.application.assemble.OrderDtoAssembler;
import cn.jdl.ecology.application.cqe.CheckoutCommand;
import cn.jdl.ecology.application.dto.OrderDTO;
import cn.jdl.ecology.application.handler.impl.CheckoutCommandHandler;
import cn.jdl.ecology.application.service.CheckoutService;
import cn.jdl.ecology.application.cqe.OrderQuery;
import cn.jdl.ecology.application.cqe.UpdateOrderCommand;
import cn.jdl.ecology.domain.entity.Order;
import cn.jdl.ecology.ext.dto.ItemDTO;
import cn.jdl.ecology.ext.facade.InventoryFacade;
import cn.jdl.ecology.ext.facade.ItemFacade;
import cn.jdl.ecology.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

/**
 * @author chaoyang
 * @date 2022年09月15日 15:49
 */
@Validated
@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final OrderDtoAssembler orderDtoAssembler = OrderDtoAssembler.INSTANCE;


    private final ItemFacade itemFacade;

    private final InventoryFacade inventoryFacade;

    private final OrderRepository orderRepository;


    private final CheckoutCommandHandler checkoutCommandHandler;

    @Override
    public OrderDTO checkout(@Valid CheckoutCommand cmd) {
        ItemDTO item = itemFacade.getItem(cmd.getItemId());
        if (item == null) {
            throw new IllegalArgumentException("Item not found");
        }

        boolean withholdSuccess = inventoryFacade.withhold(cmd.getItemId(), cmd.getQuantity());
        if (!withholdSuccess) {
            throw new IllegalArgumentException("Inventory not enough");
        }

        Order order = new Order();
        order.setBuyerId(cmd.getUserId());
        order.setSellerId(item.getSellerId());
        order.setItemId(item.getItemId());
        order.setItemTitle(item.getTitle());
        order.setItemUnitPrice(item.getPriceInCents());
        order.setCount(cmd.getQuantity());

        Order savedOrder = orderRepository.save(order);

        return orderDtoAssembler.orderToDTO(savedOrder);

//        return checkoutCommandHandler.handle(cmd);
    }
    @Override
    public OrderDTO checkoutV2(@Valid CheckoutCommand cmd) {
        ItemDTO item = itemFacade.getItem(cmd.getItemId());
        if (item == null) {
            throw new IllegalArgumentException("Item not found");
        }

        boolean withholdSuccess = inventoryFacade.withhold(cmd.getItemId(), cmd.getQuantity());
        if (!withholdSuccess) {
            throw new IllegalArgumentException("Inventory not enough");
        }
        return checkoutCommandHandler.handle(cmd);
    }

    @Override
    public OrderDTO updateOrder(@Valid UpdateOrderCommand cmd) {
        return null;
    }

//    @Override
//    public OrderDTO payReceived(PaymentReceivedEvent event) {
//        return null;
//    }
//
//    @Override
//    public OrderDTO payCanceled(PaymentCanceledEvent event) {
//        return null;
//    }
//
//    @Override
//    public OrderDTO packageSent(PackageSentEvent event) {
//        return null;
//    }
//
//    @Override
//    public OrderDTO delivered(DeliveredEvent event) {
//        return null;
//    }

    @Override
    public List<OrderDTO> query(OrderQuery query) {
        return null;
    }

    @Override
    public OrderDTO getOrder(Long orderId) {
        return null;
    }
}
