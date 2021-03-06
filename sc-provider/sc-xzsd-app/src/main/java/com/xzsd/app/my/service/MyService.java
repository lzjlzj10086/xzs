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
        //判断输入原密码是否和新密码是否一致
        if(userPwd != null && !"".equals(userNewPwd)){
            //获取客户原密码
            ClientUser clientUser = myDao.findUserById(userId);
            //判断输入原密码和数据库原密码是否一致
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
        //判断输入邀请码是否存在
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
     * 获取role统一信息
     * @param userAcct
     * @return
     */
    public AppResponse getUserOrDriver(String userAcct){
        ClientUser clientUser = myDao.getUserOrDriver(userAcct);
        return AppResponse.success("查询成功",clientUser);
    }
    /**
     * 获取当前用户详细信息
     * @param userId
     * @return
     */
    public AppResponse getClientUser(String userId){
        ClientUser clientUser = myDao.getClientUser(userId);
        return AppResponse.success("个人信息查询成功",clientUser);
    }
}
