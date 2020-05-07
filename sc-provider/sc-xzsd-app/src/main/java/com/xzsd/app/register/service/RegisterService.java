package com.xzsd.app.register.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.register.dao.RegisterDao;
import com.xzsd.app.register.entity.ClientUser;
import com.xzsd.app.util.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class RegisterService {

    @Resource
    private RegisterDao registerDao;

    /**
     * 客户注册
     * @param clientUser
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse clientRegister(ClientUser clientUser){
        //检查账号是否存在
        int countAcct = registerDao.countAcct(clientUser);
        if(countAcct != 0){
            return AppResponse.bizError("该账号已存在");
        }
        //检查输入的邀请码是否存在
        if(clientUser.getInviteCode()!=null && clientUser.getInviteCode()!="") {
            int countInvite = registerDao.countInvite(clientUser);
            if (countInvite == 0) {
                return AppResponse.bizError("该店铺邀请码不存在，请重新输入");
            }
        }
        //检查手机号是否存在
        int countPhone = registerDao.countPhone(clientUser);
        if(countPhone != 0){
            return AppResponse.bizError("该手机号码已经被绑定，请重新输入");
        }
        clientUser.setUserCode(StringUtil.getCommonCode(2));
        clientUser.setIsDelete(0);
        clientUser.setUserPwd(PasswordUtils.generatePassword(clientUser.getUserPwd()));
        int count = registerDao.clientRegister(clientUser);
        if(count == 0){
            return AppResponse.bizError("注册失败");
        }
        return AppResponse.success("注册成功");
    }
}
