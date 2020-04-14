package com.demo.order.controller;

import com.demo.goodslevel.entity.GoodsLevel;
import com.demo.order.entity.Order;
import com.demo.order.service.OrderService;
import com.demo.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsLevel.class);

    @Resource
    private OrderService orderService;

    @PostMapping("listOrder")
    public AppResponse listOder(Order order){
        try {
            return orderService.listOrder(order);
        }catch (Exception e){
            logger.error("订单分页查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("findOrderById")
    public AppResponse listOder(String orderCode){
        try {
            return orderService.findOrderById(orderCode);
        }catch (Exception e){
            logger.error("订单详情查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @PostMapping("updateOrderStatus")
    public AppResponse updateOrderStatus(Order order){
        try {
            return orderService.updateOrderStatus(order);
        }catch (Exception e){
            logger.error("订单修改失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}