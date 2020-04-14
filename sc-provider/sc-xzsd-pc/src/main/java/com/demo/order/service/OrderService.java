package com.demo.order.service;

import com.demo.order.dao.OrderDao;
import com.demo.order.entity.Order;
import com.demo.order.entity.OrderNotes;
import com.demo.util.AppResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderService {

    @Resource
    private OrderDao orderDao;

    public AppResponse listOrder(Order order){
        if (order.getRole() == 2){
            order.setStoresBossCode(order.getUserId());
        }
        PageHelper.startPage(order.getPageNum(),order.getPageSize());
        List<Order> listOrder = orderDao.listOrder(order);
        PageInfo<Order> pageInfo =new PageInfo<Order>(listOrder);
        return AppResponse.success("分页列表成功",pageInfo);
    }

    public AppResponse findOrderById(String orderCode){
        List<OrderNotes> orderNotes = orderDao.findOrderById(orderCode);
        return AppResponse.success("订单详情",orderNotes);
    }

    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderStatus(Order order){
        int count = orderDao.updateOrderStatus(order);
        if(count == 0){
            AppResponse.bizError("修改失败");
        }
        return AppResponse.success("修改成功");
    }
}
