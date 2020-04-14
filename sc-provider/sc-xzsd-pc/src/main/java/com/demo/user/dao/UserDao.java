package com.demo.user.dao;

import com.demo.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {

    /**
     * 查看是否存在该账号
     * @param user
     * @return
     */
    int usercount(User user);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 用户列表查询
     * @param user
     * @return
     */
    List<User> listUserByPage(User user);

    /**
     * 用户详情查询
     * @param userCode
     * @return
     */
    User findUserById(String userCode);

    /**
     * 删除用户
     * @param userCode
     * @param userId
     * @return
     */
    int deleteUser(@Param("userCode") List<String> userCode, @Param("userId") String userId);

}
