package cn.jdl.ecology.ext.facade;


import cn.jdl.ecology.ext.dto.ItemDTO;

/**
 * @author chaoyang
 * @date 2022年09月17日 18:03
 * 商品Facade接口
 */

public interface ItemFacade {
    ItemDTO getItem(Long itemId);
}
