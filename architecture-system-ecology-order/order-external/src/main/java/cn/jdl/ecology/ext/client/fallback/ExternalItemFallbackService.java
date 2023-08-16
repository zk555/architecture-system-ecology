package cn.jdl.ecology.ext.client.fallback;


import cn.jdl.ecology.ext.client.ExternalItemService;
import cn.jdl.ecology.ext.persistence.ItemDO;

/**
 * @author chaoyang
 * @date 2022年09月17日 18:19
 */

public class ExternalItemFallbackService implements ExternalItemService {

    @Override
    public ItemDO getItem(Long itemId) {
        return null;
    }
}
