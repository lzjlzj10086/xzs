package com.demo.order.dao;

import com.demo.order.entity.Order;
import com.demo.order.entity.OrderNotes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderDao {

    List<Order> listOrderByPage(Order order);

    List<OrderNotes> findOrderById(String orderCode);

    int updateOrderStatus(@Param("listCode")List<String> listcode);

}
