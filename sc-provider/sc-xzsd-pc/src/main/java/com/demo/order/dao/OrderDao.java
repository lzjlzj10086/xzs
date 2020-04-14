package com.demo.order.dao;

import com.demo.order.entity.Order;
import com.demo.order.entity.OrderNotes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {

    List<Order> listOrder(Order order);

    List<OrderNotes> findOrderById(String orderCode);

    int updateOrderStatus(Order order);

}
