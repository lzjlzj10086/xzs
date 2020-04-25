package com.xzsd.app.driver.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.driver.service.AppDriverService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/driverHome")
public class AppDriverController {

    @Resource
    private AppDriverService appDriverService;

    @PostMapping("getUser")
    public AppResponse getUser(String userId){
        try {
            AppResponse appResponse = appDriverService.getUser(userId);
            return appResponse;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("listDriverStores")
    public AppResponse listDriverStores(String userId){
        try {
            AppResponse appResponse = appDriverService.listDriverStores(userId);
            return appResponse;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        }
    }
}
