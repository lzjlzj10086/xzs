package com.xzsd.app.order.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.order.entity.Judge;
import com.xzsd.app.order.entity.Order;
import com.xzsd.app.order.service.AppOrderService;
import com.xzsd.app.register.entity.ClientUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/appOrder")
public class AppOrderController {

    @Resource
    private AppOrderService appOrderService;
    @PostMapping("addOrder")
    public AppResponse addOrder(String goodsCode,String amount,String userId){
        try {
            AppResponse appResponse = appOrderService.addOrder(goodsCode,amount,userId);
            return appResponse;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("listOrder")
    public AppResponse listOrder(Integer orderStatus,String userId){
        try {
            AppResponse appResponse = appOrderService.listOrder(orderStatus,userId);
            return appResponse;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("updateOrderStatus")
    public AppResponse updateOrderStatus(Order order){
        try {
            AppResponse appResponse = appOrderService.updateOrderStatus(order);
            return appResponse;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("findOrderById")
    public AppResponse findOrderById(Order order){
        try {
            AppResponse appResponse = appOrderService.findOrderById(order);
            return appResponse;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("addJudge")
    public AppResponse addJudge(@RequestBody Judge judge){
        try {
            AppResponse appResponse = appOrderService.addJudge(judge);
            return appResponse;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("listGoodsToJudge")
    public AppResponse listGoodsToJudge(String orderCode,String userId){
        try {
            AppResponse appResponse = appOrderService.listGoodsToJudge(orderCode,userId);
            return appResponse;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        }
    }
}
