package com.xzsd.app.my.dao;

import com.xzsd.app.register.entity.ClientUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MyDao {

    ClientUser findUserById(String userId);
    /**
     * 修改密码
     * @param userNewPwd
     * @param userNewPwd
     * @return
     */
    int updatePwd(@Param("userNewPwd") String userNewPwd,@Param("userId") String userId);

    /**
     * 修改邀请码
     * @param inviteCode
     * @return
     */
    int updateClientInvite(@Param("inviteCode") String inviteCode, @Param("userId") String userId);

    /**
     * 获取角色统一信息
     * @return
     */
    ClientUser getUserOrDriver(String userAcct);

    /**
     * 获取客户信息
     * @param userId
     * @return
     */
    ClientUser getClientUser(String userId);
}
