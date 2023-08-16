package cn.jdl.ecology.repository;


import cn.jdl.ecology.domain.entity.Item;

/**
 * @author chaoyang
 * @date 2022年09月01日 14:43
 */

public interface ItemRepository {


    Item find(Long itemId);
}
