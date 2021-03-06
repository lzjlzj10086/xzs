package com.xzsd.app.storesBoss.dao;

import com.xzsd.app.order.entity.Order;
import com.xzsd.app.storesBoss.entity.Driver;
import com.xzsd.app.storesBoss.entity.Stores;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ManagerOrdersDao {
    /**
     * 店长端订单列表
     * @param orderStatus,userId
     * @return
     */
    List<Order> listManagerOrdersByPage(@Param("orderStatus") Integer orderStatus,@Param("userId") String userId);
    /**
     * 修改订单状态
     * @param order
     * @return
     */
    int updateManangerOrderState(Order order);

    /**
     * 店长端订单详情查询
     * @param orderCode
     * @return
     */
    Order findOrderById(String orderCode);

    /**
     * 店长的司机查询
     * @param userId
     * @return
     */
    List<Driver> listManangerDrivers(String userId);

    /**
     * 获取门店信息
     * @param userId
     * @return
     */
    Stores getUser(String userId);
}
