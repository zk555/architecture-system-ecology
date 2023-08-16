package cn.jdl.ecology.persistence.mapper;

import cn.jdl.ecology.persistence.po.OrderPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author chaoyang
 * @date 2022年09月01日 10:40
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderPO> {


    @Select("select * from order where id = #{orderId} and item_id = #{storeId}")
    OrderPO findInStore(Long orderId, Long storeId);
}
