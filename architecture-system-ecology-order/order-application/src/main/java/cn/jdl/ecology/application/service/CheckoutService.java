package cn.jdl.ecology.application.service;


import cn.jdl.ecology.application.dto.OrderDTO;
import cn.jdl.ecology.application.cqe.CheckoutCommand;
import cn.jdl.ecology.application.cqe.OrderQuery;
import cn.jdl.ecology.application.cqe.UpdateOrderCommand;

import javax.validation.Valid;
import java.util.List;

/**
 * @author chaoyang
 * @date 2022年09月15日 14:53
 */

public interface CheckoutService {
    // 下单
    OrderDTO checkout(@Valid CheckoutCommand cmd);

    OrderDTO updateOrder(@Valid UpdateOrderCommand cmd);
//    // 支付成功
//    OrderDTO payReceived(@Valid PaymentReceivedEvent event);
//    // 支付取消
//    OrderDTO payCanceled(@Valid PaymentCanceledEvent event);
//    // 发货
//    OrderDTO packageSent(@Valid PackageSentEvent event);
//    // 收货
//    OrderDTO delivered(@Valid DeliveredEvent event);
    // 批量查询
    List<OrderDTO> query(OrderQuery query);
    //单个查询
    OrderDTO getOrder(Long orderId); // 注意单一ID查询可以不用Query
}
