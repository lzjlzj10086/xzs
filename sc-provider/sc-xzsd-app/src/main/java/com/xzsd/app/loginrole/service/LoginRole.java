package com.xzsd.app.loginrole.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.loginrole.dao.LoginRoleDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginRole {

    @Resource
    private LoginRoleDao loginRoleDao;
    public AppResponse getRole(String userAcct){
        int role = loginRoleDao.getRoleByAcct(userAcct);
        if(role == 0){
            return AppResponse.bizError("role获取失败");
        }
        return AppResponse.success("获得当前登录角色成功",role);
    }
}
