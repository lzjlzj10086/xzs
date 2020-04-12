package com.demo.user.controller;


import com.demo.user.entity.User;
import com.demo.user.service.UserService;
import com.demo.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {


    private static final Logger logger = LoggerFactory.getLogger(User.class);

    @Resource
    private UserService userService;

    @PostMapping("addUser")
    public AppResponse addUser(User user){
        try {
            AppResponse appResponse = userService.addUser(user);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("listUser")
    public AppResponse listUser(User user){
        try{
            return userService.listUser(user);
        }catch (Exception e){
            logger.error("查询用户列表失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @PostMapping("findUserById")
    public AppResponse findUserById(String userCode){
        try{
            return userService.findUserById(userCode);
        }catch (Exception e){
            logger.error("详情查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @PostMapping("updateUser")
    public AppResponse updateUser(User user){
        try {
            return userService.updateUser(user);
        }catch (Exception e){
            logger.error("修改失败失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @PostMapping("deleteUser")
    public AppResponse deleteUser(String userCode,String userId){
        try {
            return userService.deleteUser(userCode,userId);
        }catch (Exception e){
            logger.error("删除·失败失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
