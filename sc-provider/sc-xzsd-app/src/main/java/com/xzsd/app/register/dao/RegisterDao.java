package com.xzsd.app.register.dao;

import com.xzsd.app.register.entity.ClientUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterDao {

    int countInvite(ClientUser clientUser);
    int countAcct(ClientUser clientUser);
    /**
     * 客户注册
     * @param clientUser
     * @return
     */
    int clientRegister(ClientUser clientUser);
}
