package cn.jdl.ecology.domain.entity;

import cn.jdl.ecology.exception.DailyLimitExceededException;
import cn.jdl.ecology.exception.InsufficientFundsException;
import cn.jdl.ecology.exception.InvalidCurrencyException;
import cn.jdl.ecology.types.*;
import lombok.Data;


/**
 * @author chaoyang
 * @date 2022年08月17日 13:55
 */
@Data
public class Account  {
    private AccountId id;
    private AccountNumber accountNumber;
    private UserId userId;
    private Money available;
    private Money dailyLimit;

    public Currency getCurrency() {
        return this.available.getCurrency();
    }

    // 转入
    public void deposit(Money money) {
        if (!this.getCurrency().equals(money.getCurrency())) {
            throw new InvalidCurrencyException();
        }
        this.available = this.available.add(money);
    }

    // 转出
    public void withdraw(Money money) {
        if (this.available.compareTo(money) < 0) {
            throw new InsufficientFundsException();
        }
        if (this.dailyLimit.compareTo(money) < 0) {
            throw new DailyLimitExceededException();
        }
        this.available = this.available.subtract(money);
    }

}
