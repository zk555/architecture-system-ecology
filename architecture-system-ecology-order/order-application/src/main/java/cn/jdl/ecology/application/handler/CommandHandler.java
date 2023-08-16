package cn.jdl.ecology.application.handler;


import cn.jdl.ecology.application.dto.OrderDTO;
import cn.jdl.ecology.application.cqe.CheckoutCommand;
import cn.jdl.ecology.repository.Identifier;

/**
 * @author chaoyang
 * @date 2022年09月15日 17:01
 */

public interface CommandHandler<T, ID extends Identifier> {

    OrderDTO handle(CheckoutCommand cmd);

}
