package cn.jdl.ecology.ext.facade.impl;

import cn.jdl.ecology.ext.client.ExternalItemService;
import cn.jdl.ecology.ext.dto.ItemDTO;
import cn.jdl.ecology.ext.facade.ItemFacade;
import cn.jdl.ecology.ext.persistence.ItemDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chaoyang
 * @date 2022年09月17日 18:04
 * 商品facade实现
 */
@Service
public class ItemFacadeImpl implements ItemFacade {

    @Resource
    private ExternalItemService externalItemService;

    @Override
    public ItemDTO getItem(Long itemId) {
        ItemDO itemDO = externalItemService.getItem(itemId);
        if (itemDO != null) {
            ItemDTO dto = new ItemDTO();
            dto.setItemId(itemDO.getItemId());
            dto.setTitle(itemDO.getTitle());
            dto.setPriceInCents(itemDO.getPriceInCents());
            dto.setSellerId(itemDO.getSellerId());
            return dto;
        }
        return null;
    }
}
