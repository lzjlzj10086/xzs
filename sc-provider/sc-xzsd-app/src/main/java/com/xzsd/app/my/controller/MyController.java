package com.xzsd.app.my.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.my.service.MyService;
import com.xzsd.app.register.entity.ClientUser;
import feign.Client;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/my")
public class MyController {
    @Resource
    private MyService myService;
    @PostMapping("updateUserPassword")
    public AppResponse updateUserPassword(String userId, String userPwd, String userNewPwd){
        try {
            AppResponse appResponse = myService.updatePwd(userId,userPwd,userNewPwd);
            return appResponse;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("updateClientInvite")
    public AppResponse updateClientInvite(ClientUser clientUser){
        try {
            AppResponse appResponse = myService.updateClientInvite(clientUser);
            return appResponse;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("getUser")
    public AppResponse getUser(String userId){
        try {
            AppResponse appResponse = myService.getUser(userId);
            return appResponse;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        }
    }
}
