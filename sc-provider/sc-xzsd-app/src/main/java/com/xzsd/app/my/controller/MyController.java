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

    /**
     * 客户修改密码
     * @param userId
     * @param userPwd
     * @param userNewPwd
     * @return
     */
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

    /**
     * 客户修改邀请码
     * @param clientUser
     * @return
     */
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

    /**
     * 查询统一角色信息
     * @param userAcct
     * @return
     */
    @PostMapping("getUser")
    public AppResponse getUser(String userAcct){
        try {
            AppResponse appResponse = myService.getUserOrDriver(userAcct);
            return appResponse;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 客户个人信息查询
     * @param userId
     * @return
     */
    @PostMapping("getClientUser")
    public AppResponse getClientUser(String userId){
        try {
            AppResponse appResponse = myService.getClientUser(userId);
            return appResponse;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        }
    }
}
