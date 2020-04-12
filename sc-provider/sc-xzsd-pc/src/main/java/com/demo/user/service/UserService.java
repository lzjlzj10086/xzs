package com.demo.user.service;

import com.demo.user.dao.UserDao;
import com.demo.user.entity.User;
import com.demo.util.AppResponse;
import com.demo.util.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    /**
     * 用户添加
     * @param user
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addUser(User user){
        // 校验账号是否存在
        int countUserAcct = userDao.usercount(user);
        if(0 != countUserAcct) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        user.setUserCode(StringUtil.getCommonCode(2));
        user.setIsDelete(0);
        // 新增用户
        int count = userDao.addUser(user);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 用户列表查询
     * @param user
     * @return
     */
    public AppResponse listUser(User user){

        PageHelper.startPage(user.getPageNum(), user.getPageSize());
        List<User> userInfoList = userDao.listUser(user);
        // 包装Page对象
        PageInfo<User> pageData = new PageInfo<User>(userInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * 用户详情查询
     * @param userCode
     * @return
     */
    public AppResponse findUserById(String userCode){
        User user = userDao.findUserById(userCode);
        return AppResponse.success("查询成功",user);
    }

    /**
     * 用户修改
     * @param user
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUser(User user){
        int count = userDao.updateUser(user);
        if(count == 0){
            return AppResponse.bizError("数据发生变化");
        }
        return AppResponse.success("修改成功");
    }

    /**
     * 用户删除
     * @param userCode
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteUser(String userCode,String userId){
        List<String> listCode = Arrays.asList(userCode.split(","));
        int count = userDao.deleteUser(listCode,userId);
        if(count == 0){
            return AppResponse.bizError("删除失败");
        }
        return AppResponse.success("删除成功");
    }
}
