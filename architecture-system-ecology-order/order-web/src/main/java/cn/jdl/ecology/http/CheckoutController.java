package cn.jdl.ecology.http;

import cn.jdl.ecology.application.cqe.CheckoutCommand;
import cn.jdl.ecology.datahelper.exception.ResultHandler;
import cn.jdl.ecology.application.dto.OrderDTO;
import cn.jdl.ecology.application.service.CheckoutService;
import cn.jdl.ecology.datahelper.vo.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chaoyang
 * @date 2022年09月15日 10:30
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class CheckoutController {

    private final CheckoutService checkoutService;

    @ResultHandler
    @PostMapping("checkout")
    public Result<OrderDTO> checkout(Long itemId, Integer quantity) {
        CheckoutCommand cmd = new CheckoutCommand();
        OrderDTO orderDTO = checkoutService.checkout(cmd);
        return Result.success(orderDTO);
    }
}
