package cn.jdl.ecology.types;
import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class ExchangeRate {

    private BigDecimal rate;
    private Currency from;
    private Currency to;

    public ExchangeRate(BigDecimal rate, Currency from, Currency to) {
        this.rate = rate;
        this.from = from;
        this.to = to;
    }

    public Money exchange(Money fromMoney) {
        notNull(fromMoney);
        isTrue(this.from.equals(fromMoney.getCurrency()));
        BigDecimal targetAmount = fromMoney.getAmount().multiply(rate);
        return new Money(targetAmount, to);
    }

    public Money exchangeTo(Money targetMoney) {
        return new Money(targetMoney.getAmount(), targetMoney.getCurrency());
    }
}
