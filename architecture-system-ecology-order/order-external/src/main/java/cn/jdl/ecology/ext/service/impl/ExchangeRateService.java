package cn.jdl.ecology.ext.service.impl;

import cn.jdl.ecology.ext.client.IYahooForexService;
import cn.jdl.ecology.external.IExchangeRateService;
import cn.jdl.ecology.types.Currency;
import cn.jdl.ecology.types.ExchangeRate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author chaoyang
 * @date 2022年08月17日 17:31
 */
@Service
@RequiredArgsConstructor
public class ExchangeRateService implements IExchangeRateService {

    private final IYahooForexService IYahooForexService;

    @Override
    public ExchangeRate getExchangeRate(Currency source, Currency target) {
        if (source.equals(target)) {
            return new ExchangeRate(BigDecimal.ONE, source, target);
        }
        BigDecimal forex = IYahooForexService.getExchangeRate(source.getValue(), target.getValue());
        return new ExchangeRate(forex, source, target);
    }
}
