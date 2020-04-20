package com.xzsd.app.order.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.order.service.AppOrderService;
import com.xzsd.app.register.entity.ClientUser;
import org.springframework.web.bind.annotation.PostMapping;
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
}
