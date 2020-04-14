package com.demo.clientuser.service;

import com.demo.clientuser.dao.ClientUserDao;
import com.demo.clientuser.entity.ClientUser;
import com.demo.user.dao.UserDao;;
import com.demo.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

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
        List<ClientUser> clientList = clientUserDao.listClientUserByPage(clientUser);
        return AppResponse.success("查询成功",getPageInfo(clientList));
    }
}
