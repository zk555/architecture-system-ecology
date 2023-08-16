package cn.jdl.ecology.repository;


import cn.jdl.ecology.domain.dto.OrderQuery;
import cn.jdl.ecology.domain.entity.Order;
import cn.jdl.ecology.types.OrderId;
import cn.jdl.ecology.types.StoreId;

/**
 * @author chaoyang
 * @date 2022年09月01日 10:38
 */

public interface OrderRepository  extends Repository<Order, OrderId> {

    // 自定义Count接口，在这里OrderQuery是一个自定义的DTO
    Long count(OrderQuery query);

    // 自定义分页查询接口
    com.baomidou.mybatisplus.extension.plugins.pagination.Page<Order> query(OrderQuery query);

    // 自定义有多个条件的查询接口
    Order findInStore(OrderId id, StoreId storeId);

}
