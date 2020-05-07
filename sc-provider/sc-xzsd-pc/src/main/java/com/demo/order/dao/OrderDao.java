package com.demo.order.dao;

import com.demo.order.entity.Order;
import com.demo.order.entity.OrderNotes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderDao {
    /**
     * 订单列表查询
     * @param order
     * @return
     */
    List<Order> listOrderByPage(Order order);

    /**
     * 订单详情
     * @param orderCode
     * @return
     */
    List<OrderNotes> findOrderById(String orderCode);

    /**
     * 订单状态修改
     * @param listCode
     * @param orderStatus
     * @param userId
     * @return
     */
    int updateOrderStatus(@Param("listCode")List<String> listCode,@Param("orderStatus") String orderStatus,@Param("userId") String userId);

}
