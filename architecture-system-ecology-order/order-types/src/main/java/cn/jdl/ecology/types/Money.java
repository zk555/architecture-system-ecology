package cn.jdl.ecology.types;

import lombok.Value;

import java.math.BigDecimal;



@Value
public class Money implements Comparable<Money> {
    BigDecimal amount;
    Currency currency;
    public Money(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public int compareTo(Money otherMoney) {
        return getAmount().compareTo(otherMoney.getAmount());
    }

    public Money add(Money money) {
        return new Money(getAmount().add(money.getAmount()),getCurrency());
    }

    public Money subtract(Money money) {
        return new Money(getAmount().subtract(money.getAmount()), getCurrency());
    }
}
