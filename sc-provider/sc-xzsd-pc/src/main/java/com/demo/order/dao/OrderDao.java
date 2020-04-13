package com.demo.order.dao;

import com.demo.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {

    List<Order> listOrder(Order order);

    Order findOrderById(String orderCode);

    int updateOrderStatus(String orderCoder,String orderStatus);

}
