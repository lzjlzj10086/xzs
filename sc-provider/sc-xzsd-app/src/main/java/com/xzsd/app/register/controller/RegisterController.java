package com.xzsd.app.register.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.register.entity.ClientUser;
import com.xzsd.app.register.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private static final Logger logger = LoggerFactory.getLogger(ClientUser.class);
    @Resource
    private RegisterService registerService;

    /**
     * 客户注册
     * @param clientUser
     * @return
     */
    @PostMapping("clientRegister")
    public AppResponse clientRegister(ClientUser clientUser){
        try {
            AppResponse appResponse = registerService.clientRegister(clientUser);
            return appResponse;
        } catch (Exception e) {
            logger.error("注册失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
