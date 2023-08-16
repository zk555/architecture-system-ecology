package cn.jdl.ecology.persistence.mapper;

import cn.jdl.ecology.persistence.po.ItemDetailPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chaoyang
 * @date 2022年09月01日 17:09
 */
@Mapper
public interface ItemMapper extends BaseMapper<ItemDetailPO> {

}
