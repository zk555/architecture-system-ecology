package cn.jdl.ecology.repository.impl;


import cn.jdl.ecology.domain.dto.OrderQuery;
import cn.jdl.ecology.domain.entity.LineItem;
import cn.jdl.ecology.domain.entity.Order;
import cn.jdl.ecology.persistence.mapper.LineItemMapper;
import cn.jdl.ecology.persistence.mapper.OrderMapper;
import cn.jdl.ecology.persistence.po.LineItemPO;
import cn.jdl.ecology.persistence.po.OrderPO;
import cn.jdl.ecology.repository.OrderRepository;
import cn.jdl.ecology.repository.Page;
import cn.jdl.ecology.repository.assemble.LineItemAssembler;
import cn.jdl.ecology.repository.assemble.OrderAssembler;
import cn.jdl.ecology.repository.snapshot.*;
import cn.jdl.ecology.types.OrderId;
import cn.jdl.ecology.types.StoreId;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chaoyang
 * @date 2022年09月01日 10:39
 */
@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl extends DbRepositorySupport<Order, OrderId> implements OrderRepository {


    private  final OrderMapper orderDAO;


    private final LineItemMapper lineItemDAO;

//    private final Cache cache;


    private final OrderAssembler orderAssembler;


    private final LineItemAssembler lineAssembler;

//    protected OrderRepositoryImpl(Class<Order> targetClass) {
//        super(targetClass);
//    }



    @Override
    protected void onInsert(Order aggregate) {

    }

    @Override
    protected Order onSelect(OrderId orderId) {
        return null;
    }

    @Override
    protected void onUpdate(Order aggregate, EntityDiff diff) {
        if (diff.isSelfModified()) {
            OrderPO orderDO = orderAssembler.fromOrder(aggregate);
            orderDAO.updateById(orderDO);
        }

        Diff lineItemDiffs = diff.getDiff("lineItems");
        if (lineItemDiffs instanceof ListDiff) {
            ListDiff diffList = (ListDiff) lineItemDiffs;
            for (Diff itemDiff : diffList) {
                if (itemDiff.getType() == DiffType.Removed) {
                    LineItem line = (LineItem) itemDiff.getOldValue();
                    //子实体不能有独立的Repository，不可以单独保存和取出，必须要通过聚合根的Repository实例化
                    //TODO 这里的LineItemPO 要替换成 OrderPO
//                    LineItemPO lineDO = lineAssembler.fromLineItem(line);
//                    lineItemDAO.deleteById(lineDO.getId());
                }
                if (itemDiff.getType() == DiffType.Added) {
                    LineItem line = (LineItem) itemDiff.getNewValue();
//                    LineItemPO lineDO = lineAssembler.fromLineItem(line);
//                    lineItemDAO.insert(lineDO);
                }
                if (itemDiff.getType() == DiffType.Modified) {
                    LineItem line = (LineItem) itemDiff.getNewValue();
                    LineItemPO lineDO = lineAssembler.fromLineItem(line);
                    lineItemDAO.updateById(lineDO);
                }
            }
        }
    }

    @Override
    protected void onDelete(Order aggregate) {

    }

    @Override
    public void attach(Order aggregate) {

    }

    @Override
    public void detach(Order aggregate) {

    }

    @Override
    public Order find(OrderId orderId) {

        OrderPO orderDO = orderDAO.selectById(orderId.getId());
        return orderAssembler.toOrder(orderDO);
    }

    @Override
    public void remove(@NotNull Order aggregate) {
        OrderPO orderDO = orderAssembler.fromOrder(aggregate);
        orderDAO.deleteById(orderDO.getId());
    }

    @Override
    public Order save(Order aggregate) {
        if (aggregate.getId() != null && aggregate.getId().getId() > 0) {
            // update
            OrderPO orderDO = orderAssembler.fromOrder(aggregate);
            orderDAO.updateById(orderDO);
            for (LineItem lineItem: aggregate.getLineItems()) {
                save(lineItem);
            }
        } else {
            // insert
            OrderPO orderDO = orderAssembler.fromOrder(aggregate);
            orderDAO.insert(orderDO);
            aggregate.setId(orderAssembler.toOrder(orderDO).getId());
        }
        return aggregate;
    }

    private void save(LineItem lineItem) {
        if (lineItem.getId() != null && lineItem.getId().getId() > 0) {
            LineItemPO lineItemDO = lineAssembler.fromLineItem(lineItem);
            lineItemDAO.updateById(lineItemDO);
        } else {
            LineItemPO lineItemDO = lineAssembler.fromLineItem(lineItem);
            lineItemDAO.insert(lineItemDO);
            lineItem.setId(lineAssembler.toLineItem(lineItemDO).getId());
        }
    }

    @Override
    public Long count(OrderQuery query) {
        return null;
    }

    @Override
    public com.baomidou.mybatisplus.extension.plugins.pagination.Page<Order> query(OrderQuery query) {

        List<OrderPO> orderDOS = orderDAO.selectList(new QueryWrapper<OrderPO>().lambda().eq(OrderPO::getId, query.getOrderId()));
        long count = orderDAO.selectCount(new QueryWrapper<OrderPO>().lambda().eq(OrderPO::getId, query.getOrderId()));
        List<Order> result = orderDOS.stream().map(orderAssembler::toOrder).collect(Collectors.toList());
        return Page.with(result, count);
    }

    @Override
    public Order findInStore(OrderId id, StoreId storeId) {
        OrderPO orderDO = orderDAO.findInStore(id.getId(), storeId.getId());
        return orderAssembler.toOrder(orderDO);
    }
}
