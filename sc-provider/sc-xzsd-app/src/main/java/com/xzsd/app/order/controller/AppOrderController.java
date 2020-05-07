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

    /**
     * 添加订单
     * @param goodsCode
     * @param amount
     * @param userId
     * @return
     */
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

    /**
     * 订单列表查询
     * @param orderStatus
     * @param userId
     * @return
     */
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

    /**
     * 修改订单状态
     * @param order
     * @return
     */
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

    /**
     * 查看订单详情
     * @param order
     * @return
     */
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

    /**
     * 添加评价
     * @param judge
     * @return
     */
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

    /**
     * 查询需要评价的商品
     * @param orderCode
     * @param userId
     * @return
     */
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
