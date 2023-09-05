package cn.jdl.ecology.application.handler.impl;


import cn.jdl.ecology.application.cqe.CheckoutCommand;
import cn.jdl.ecology.application.cqe.UpdateOrderCommand;
import cn.jdl.ecology.application.dto.OrderDTO;
import cn.jdl.ecology.application.handler.CommandHandler;

/**
 * @author chaoyang
 * @date 2022年09月15日 17:19
 */

public class OrderCommandHandler implements CommandHandler<UpdateOrderCommand, OrderDTO> {

    @Override
    public OrderDTO handle(UpdateOrderCommand cmd) {
        return null;
    }
}
