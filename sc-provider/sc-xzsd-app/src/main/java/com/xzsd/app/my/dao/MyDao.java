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
     * 查询个人信息接口
     * @return
     */
    ClientUser getUser(String userId);
}
