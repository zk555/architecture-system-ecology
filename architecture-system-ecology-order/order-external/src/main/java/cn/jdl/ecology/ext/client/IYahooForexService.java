package cn.jdl.ecology.ext.client;


import cn.jdl.ecology.ext.client.fallback.YahooForexFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * 文件远端请求
 *
 * @author chaoyang
 * @date 2022/7/25 10:13
 */
@FeignClient(name = "yahoo-forex", fallback = YahooForexFallbackService.class)
public interface IYahooForexService {


	@RequestMapping(value = "/getExchangeRate", method = RequestMethod.POST)
	BigDecimal getExchangeRate(@RequestParam String value, @RequestParam String value1);
}
