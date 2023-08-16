package cn.jdl.ecology.repository.impl;

import cn.jdl.ecology.domain.entity.Item;
import cn.jdl.ecology.persistence.mapper.ItemMapper;
import cn.jdl.ecology.persistence.po.ItemDetailPO;
import cn.jdl.ecology.repository.ItemRepository;
import cn.jdl.ecology.repository.assemble.ItemAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @author chaoyang
 * @date 2022年09月01日 14:45
 */
@Repository
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepository {

    private final ItemMapper itemDAO;

    private final ItemAssembler itemAssembler;


    @Override
    public Item find(Long itemId) {
        ItemDetailPO itemDetailPO = itemDAO.selectById(itemId);

        return itemAssembler.toItem(itemDetailPO);
    }
}
