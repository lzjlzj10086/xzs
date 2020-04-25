package com.demo.top.dao;

import com.demo.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TopDao {
    /**
     * 顶部栏查询
     * @param userId
     * @return
     */
    User getTop(String userId);
}
