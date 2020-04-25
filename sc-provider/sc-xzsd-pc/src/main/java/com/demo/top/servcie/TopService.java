package com.demo.top.servcie;

import com.demo.top.dao.TopDao;
import com.demo.user.entity.User;
import com.demo.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TopService {

    @Resource
    private TopDao topDao;

    public AppResponse getTop(String userId){
        User user = topDao.getTop(userId);
        if(user == null){
            return AppResponse.bizError("顶部栏查询失败");
        }
        return AppResponse.success("顶部栏查询成功",user);
    }
}
