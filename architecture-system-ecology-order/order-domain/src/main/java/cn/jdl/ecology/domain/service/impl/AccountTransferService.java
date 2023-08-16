package cn.jdl.ecology.domain.service.impl;

import cn.jdl.ecology.domain.entity.Account;
import cn.jdl.ecology.domain.service.IAccountTransferService;
import cn.jdl.ecology.external.IExchangeRateService;
import cn.jdl.ecology.types.ExchangeRate;
import cn.jdl.ecology.types.Money;

public class AccountTransferService implements IAccountTransferService {

    private IExchangeRateService iExchangeRateService;

    @Override
    public void transfer(Account sourceAccount, Account targetAccount, Money targetMoney, ExchangeRate exchangeRate) {
        Money sourceMoney = exchangeRate.exchangeTo(targetMoney);
        sourceAccount.deposit(sourceMoney);
        targetAccount.withdraw(targetMoney);
    }
}
