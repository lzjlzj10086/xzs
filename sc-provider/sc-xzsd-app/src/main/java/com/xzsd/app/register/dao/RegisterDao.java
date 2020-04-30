package com.xzsd.app.register.dao;

import com.xzsd.app.register.entity.ClientUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterDao {
    /**
     * 查询输入邀请码是否争取
     * @param clientUser
     * @return
     */
    int countInvite(ClientUser clientUser);

    /**
     * 统计账号个数
     * @param clientUser
     * @return
     */
    int countAcct(ClientUser clientUser);

    /**
     * 统计手机号个数
     * @param clientUser
     * @return
     */
    int countPhone(ClientUser clientUser);
    /**
     * 客户注册
     * @param clientUser
     * @return
     */
    int clientRegister(ClientUser clientUser);
}
