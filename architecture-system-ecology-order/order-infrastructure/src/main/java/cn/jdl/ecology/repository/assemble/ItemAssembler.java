package cn.jdl.ecology.repository.assemble;

import cn.jdl.ecology.domain.entity.Item;
import cn.jdl.ecology.persistence.po.ItemDetailPO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author chaoyang
 * @date 2022年09月01日 14:25
 */
@Mapper(componentModel = "spring")
public interface ItemAssembler {




    @Mappings({
        @Mapping(target = "id", source = "itemId")
    })
    Item toItem(ItemDetailPO itemDetailPO);
}
