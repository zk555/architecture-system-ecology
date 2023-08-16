package cn.jdl.ecology.ext.facade.impl;

import cn.jdl.ecology.ext.client.ExternalInventoryService;
import cn.jdl.ecology.ext.facade.InventoryFacade;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author chaoyang
 * @date 2022年09月17日 18:29
 * 库存Facade实现
 */
@Service
public class InventoryFacadeImpl implements InventoryFacade {

    @Resource
    private ExternalInventoryService externalInventoryService;

    @Override
    public boolean withhold(Long itemId, Integer quantity) {
        return externalInventoryService.withhold(itemId, quantity);
    }
}
