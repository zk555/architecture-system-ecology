package cn.jdl.ecology.domain.service;


import cn.jdl.ecology.domain.entity.Account;
import cn.jdl.ecology.types.ExchangeRate;
import cn.jdl.ecology.types.Money;

/**
 * @author chaoyang
 * @date 2022年08月22日 16:45
 */

public interface AccountTransferService {
    void transfer(Account sourceAccount, Account targetAccount, Money targetMoney, ExchangeRate exchangeRate);
}
