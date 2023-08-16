package cn.jdl.ecology.application.service;


import cn.jdl.ecology.application.dto.OrderDTO;
import cn.jdl.ecology.types.OrderId;

/**
 * @author chaoyang
 * @date 2022年09月01日 14:15
 */

public interface OrderService {

    OrderDTO getOrderDetail(OrderId orderId);

}
