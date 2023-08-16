package cn.jdl.ecology.ext.client.fallback;


import cn.jdl.ecology.ext.client.ExternalInventoryService;

/**
 * @author chaoyang
 * @date 2022年09月17日 18:32
 */

public class ExternalInventoryFallbackService implements ExternalInventoryService {

    @Override
    public boolean withhold(Long itemId, Integer quantity) {
        return false;
    }
}
