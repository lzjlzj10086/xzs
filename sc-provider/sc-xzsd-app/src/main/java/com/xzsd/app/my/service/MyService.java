package com.xzsd.app.my.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.my.dao.MyDao;
import com.xzsd.app.register.dao.RegisterDao;
import com.xzsd.app.register.entity.ClientUser;
import com.xzsd.app.util.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class MyService {
    @Resource
    private MyDao myDao;
    @Resource
    private RegisterDao registerDao;
    /**
     * 修改密码
     * @param userId
     * @param userPwd
     * @param userNewPwd
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updatePwd(String userId,String userPwd,String userNewPwd){
        if(userPwd != null && !"".equals(userNewPwd)){
            ClientUser clientUser = myDao.findUserById(userId);
            boolean pwd = PasswordUtils.Password(userPwd,clientUser.getUserPwd());
            if(!pwd){
                return AppResponse.bizError("原密码不匹配，请重新输入");
            }
        }
        userNewPwd = PasswordUtils.generatePassword(userNewPwd);
        int count = myDao.updatePwd(userNewPwd,userId);
        if(count == 0){
            return AppResponse.bizError("修改失败");
        }
        return AppResponse.success("修改成功");
    }

    /**
     * 修改店铺邀请码
     * @param clientUser
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateClientInvite(ClientUser clientUser){
        int countInvite = registerDao.countInvite(clientUser);
        if(countInvite == 0){
            return AppResponse.bizError("该店铺邀请码不存在，请重新输入");
        }
        int count = myDao.updateClientInvite(clientUser.getInviteCode(),clientUser.getUserId());
        if(count == 0){
            return AppResponse.bizError("修改失败");
        }
        return AppResponse.success("修改成功");
    }

    /**
     * 获取当前用户详细信息
     * @param userId
     * @return
     */
    public AppResponse getUserOrDriver(String userId){
        ClientUser clientUser = myDao.getUserOrDriver(userId);
        return AppResponse.success("查询成功",clientUser);
    }
}
