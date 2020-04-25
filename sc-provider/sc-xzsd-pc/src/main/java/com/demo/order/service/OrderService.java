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
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class OrderService {

    @Resource
    private OrderDao orderDao;

    public AppResponse listOrder(Order order){
        if (order.getRole() == 2){
            order.setStoresBossCode(order.getUserId());
        }
        List<Order> orderList = orderDao.listOrderByPage(order);
        return AppResponse.success("分页列表成功",getPageInfo(orderList));
    }

    public AppResponse findOrderById(String orderCode){
        List<OrderNotes> orderNotes = orderDao.findOrderById(orderCode);
        return AppResponse.success("订单详情",orderNotes);
    }

    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderStatus(String orderCode,String orderStatus,String userId){
        List<String> listcode = Arrays.asList(orderCode.split(","));
        int count = orderDao.updateOrderStatus(listcode,orderStatus,userId);
        if(count == 0){
            AppResponse.bizError("修改失败");
        }
        return AppResponse.success("修改成功");
    }
}
