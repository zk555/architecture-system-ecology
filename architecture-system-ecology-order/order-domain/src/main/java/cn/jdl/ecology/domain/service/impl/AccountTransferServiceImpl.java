package cn.jdl.ecology.domain.service.impl;

import cn.jdl.ecology.domain.entity.Account;
import cn.jdl.ecology.domain.service.AccountTransferService;
import cn.jdl.ecology.types.ExchangeRate;
import cn.jdl.ecology.types.Money;
import org.springframework.stereotype.Service;

/**
 * @author chaoyang
 * @date 2022年08月22日 16:46
 */
@Service
public class AccountTransferServiceImpl implements AccountTransferService {



    @Override
    public void transfer(Account sourceAccount, Account targetAccount, Money targetMoney,
                         ExchangeRate exchangeRate) {
        Money sourceMoney = exchangeRate.exchangeTo(targetMoney);
        sourceAccount.deposit(sourceMoney);
        targetAccount.withdraw(targetMoney);
    }
}
