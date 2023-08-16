package cn.jdl.ecology.ext.client;


import cn.jdl.ecology.ext.client.fallback.ExternalItemFallbackService;
import cn.jdl.ecology.ext.persistence.ItemDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chaoyang
 * @date 2022年09月17日 18:18
 */
@FeignClient(name = "external-item", fallback = ExternalItemFallbackService.class)
public interface ExternalItemService {

    @RequestMapping(value = "/getItem", method = RequestMethod.POST)
    ItemDO getItem(@RequestParam Long itemId);
}
