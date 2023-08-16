package cn.jdl.ecology.repository;


import cn.jdl.ecology.domain.entity.Order;
import cn.jdl.ecology.types.OrderId;

import java.util.List;

/**
 * @author chaoyang
 * @date 2022年09月02日 15:23
 */

public interface Page<T extends Aggregate<OrderId>> {

    static com.baomidou.mybatisplus.extension.plugins.pagination.Page<Order> with(List<Order> result, long count) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Order> orderPage = new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>();
        orderPage.setRecords(result);
        orderPage.setCurrent(1);
        orderPage.setTotal(count);
        orderPage.setSize(count);
        return orderPage;

    }
}
