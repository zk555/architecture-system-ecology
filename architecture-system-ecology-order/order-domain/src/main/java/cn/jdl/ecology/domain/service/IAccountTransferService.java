package cn.jdl.ecology.domain.service;

import cn.jdl.ecology.domain.entity.Account;
import cn.jdl.ecology.types.ExchangeRate;
import cn.jdl.ecology.types.Money;

public interface IAccountTransferService {

    void transfer(Account sourceAccount, Account targetAccount, Money targetMoney, ExchangeRate exchangeRate);

}
