package com.xzsd.app.loginrole.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginRoleDao {

    /**
     * 根据登录账号查询角色
     * @param userAcct
     * @return
     */
    int getRoleByAcct(String userAcct);
}
