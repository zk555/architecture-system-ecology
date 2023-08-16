package cn.jdl.ecology.http;

import cn.jdl.ecology.application.service.TransferService;
import cn.jdl.ecology.datahelper.vo.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

/**
 * @author chaoyang
 * @date 2022年08月17日 13:41
 */
@RestController("transfer/")
@RequiredArgsConstructor
public class TransferController {
    private final TransferService transferService;

    public Result<Boolean> transfer(String targetAccountNumber, BigDecimal amount, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        return transferService.transfer(userId, targetAccountNumber, amount, "CNY");
    }

}
