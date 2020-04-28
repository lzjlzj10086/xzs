package com.xzsd.app.loginrole.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.loginrole.service.LoginRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/role")
public class LoginRoleController {

    @Resource
    private LoginRole loginRole;

    /**
     * 获取当前登录角色
     * @param userAcct
     * @return
     */
    @PostMapping("getRole")
    public AppResponse getRoleByAcct(String userAcct){
        try {
            AppResponse appResponse = loginRole.getRole(userAcct);
            return appResponse;
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        }
    }
}
