package com.demo.clientuser.service;

import com.demo.clientuser.dao.ClientUserDao;
import com.demo.clientuser.entity.ClientUser;
import com.demo.user.dao.UserDao;
import com.demo.user.entity.User;
import com.demo.util.AppResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClientUserService {

    @Resource
    private ClientUserDao clientUserDao;

    @Resource
    private UserDao userDao;


    /**
     * 客户列表查询
     * @param clientUser
     * @return
     */
    public AppResponse listClientUser(ClientUser clientUser){
        //根据判断是否为店长
        if(clientUser.getRole() == 2){
            clientUser.setStoresBossCode(clientUser.getUserId());
        }
        PageHelper.startPage(clientUser.getPageNum(),clientUser.getPageSize());
        List<ClientUser> listClient = clientUserDao.listClientUser(clientUser);
        PageInfo<ClientUser> pageInfo = new PageInfo<ClientUser>(listClient);
        return AppResponse.success("查询成功",pageInfo);
    }
}
