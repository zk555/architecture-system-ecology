package cn.jdl.ecology.application.service.impl;

import cn.jdl.ecology.datahelper.vo.Result;
import cn.jdl.ecology.domain.entity.Account;
import cn.jdl.ecology.domain.service.IAccountTransferService;
import cn.jdl.ecology.domain.types.AuditMessage;
import cn.jdl.ecology.external.IExchangeRateService;
import cn.jdl.ecology.message.IAuditMessageProducer;
import cn.jdl.ecology.repository.AccountRepository;
import cn.jdl.ecology.application.service.TransferService;
import cn.jdl.ecology.types.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author chaoyang
 * @date 2022年08月22日 17:20
 */
@Service
@RequiredArgsConstructor
public class TransferServiceImplNew implements TransferService {

    private final AccountRepository accountRepository;
    private final IAuditMessageProducer auditMessageProducer;
    private final IExchangeRateService exchangeRateService;
    private final IAccountTransferService accountTransferService;

    @Override
    public Result<Boolean> transfer(Long sourceUserId, String targetAccountNumber, BigDecimal targetAmount,
                                    String targetCurrency) {
        // 参数校验
        Money targetMoney = new Money(targetAmount, new Currency(targetCurrency));

        // 读数据
        Account sourceAccount = accountRepository.find(new UserId(sourceUserId));
        Account targetAccount = accountRepository.find(new AccountNumber(targetAccountNumber));
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRate(sourceAccount.getCurrency(), targetMoney.getCurrency());

        // 业务逻辑
        accountTransferService.transfer(sourceAccount, targetAccount, targetMoney, exchangeRate);

        // 保存数据
        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);

        // 发送审计消息
        AuditMessage message = new AuditMessage(sourceAccount, targetAccount, targetMoney);
        auditMessageProducer.send(message);

        return Result.success(true);
    }
}
