package com.xzsd.app.storesBoss.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.order.entity.Order;
import com.xzsd.app.storesBoss.service.ManagerOrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/manangerOrder")
public class ManageOrderController {

    @Resource
    private ManagerOrderService managerOrderService;

    /**
     * 店长订单查询列表
     * @param orderStatus
     * @param userId
     * @return
     */
    @PostMapping("listManagerOrders")
    public AppResponse listManagerOrders(Integer orderStatus,String userId){
        try {
            AppResponse appResponse = managerOrderService.listManagerOrders(orderStatus,userId);
            return appResponse;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 店长修改订单状态
     * @param order
     * @return
     */
    @PostMapping("updateManangerOrderState")
    public AppResponse updateManangerOrderState(Order order){
        try {
            AppResponse appResponse = managerOrderService.updateManangerOrderState(order);
            return appResponse;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 订单详情
     * @param orderCode
     * @return
     */
    @PostMapping("findOrderById")
    public AppResponse findOrderById(String orderCode){
        try {
            AppResponse appResponse = managerOrderService.findOrderById(orderCode);
            return appResponse;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 店长端司机信息查询
     * @param userId
     * @return
     */
    @PostMapping("listManangerDrivers")
    public AppResponse listManangerDrivers(String userId){
        try {
            AppResponse appResponse = managerOrderService.listManangerDrivers(userId);
            return appResponse;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 店长端个人信息查询
     * @param userId
     * @return
     */
    @PostMapping("getUser")
    public AppResponse getUser(String userId){
        try {
            AppResponse appResponse = managerOrderService.getUser(userId);
            return appResponse;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        }
    }
}
