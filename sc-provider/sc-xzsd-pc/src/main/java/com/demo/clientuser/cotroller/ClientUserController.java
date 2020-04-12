package com.demo.clientuser.cotroller;


import com.demo.clientuser.entity.ClientUser;
import com.demo.clientuser.service.ClientUserService;
import com.demo.top.dao.TopDao;
import com.demo.top.servcie.TopService;
import com.demo.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/client")
public class ClientUserController {

    private static final Logger logger = LoggerFactory.getLogger(ClientUser.class);

    @Resource
    private ClientUserService clientUserService;

    @Resource
    private TopDao topDao;

    @PostMapping("listClient")
    public AppResponse listClient(ClientUser clientUser){
        try {
            //获取登录用户Id和role
           //clientUser.getUserId();
            return clientUserService.listClientUser(clientUser);
        }catch (Exception e){
            logger.error("列表查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
