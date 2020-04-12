package com.demo.clientuser.dao;

import com.demo.clientuser.entity.ClientUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClientUserDao {

    /**
     * 客户列表查询
     * @param clientUser
     * @return
     */
    List<ClientUser> listClientUser(ClientUser clientUser);


}
