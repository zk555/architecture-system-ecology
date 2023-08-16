package cn.jdl.ecology.ext.client.fallback;


import cn.jdl.ecology.ext.client.IYahooForexService;

import java.math.BigDecimal;

/**
 * @author chaoyang
 * @date 2022年09月09日 15:29
 */

public class YahooForexFallbackService implements IYahooForexService {

    @Override
    public BigDecimal getExchangeRate(String value, String value1) {
        return null;
    }
}
