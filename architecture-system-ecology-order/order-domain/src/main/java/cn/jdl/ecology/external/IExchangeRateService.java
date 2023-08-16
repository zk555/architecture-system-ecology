package cn.jdl.ecology.external;


import cn.jdl.ecology.types.Currency;
import cn.jdl.ecology.types.ExchangeRate;

/**
 * @author chaoyang
 * @date 2022年08月17日 17:30
 */

public interface IExchangeRateService {

    ExchangeRate getExchangeRate(Currency source, Currency target);
}
