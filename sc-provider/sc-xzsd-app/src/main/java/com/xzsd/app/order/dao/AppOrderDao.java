package com.xzsd.app.order.dao;

import com.xzsd.app.goods.entity.Goods;
import com.xzsd.app.order.entity.Order;
import com.xzsd.app.order.entity.OrderNotes;
import com.xzsd.app.order.entity.Stores;
import com.xzsd.app.register.entity.ClientUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AppOrderDao {
    /**
     * 添加订单
     * @param order
     * @return
     */
    int addOrder(Order order);

    /**
     * 添加订单详情
     * @param orderNotes
     * @return
     */
    int addOrderNotes(OrderNotes orderNotes);

    Stores findStoresByUserId(String userId);

    ClientUser findClientUserById(String userId);

    Goods findGoodsById(String goodsCode);

}
