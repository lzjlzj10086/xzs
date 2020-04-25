package com.xzsd.app.driver.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.driver.dao.AppDriver;
import com.xzsd.app.driver.entity.Driver;
import com.xzsd.app.storesBoss.entity.Stores;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppDriverService {

    @Resource
    private AppDriver appDriver;

    /**
     * 司机信息查询
     * @param userId
     * @return
     */
    public AppResponse getUser(String userId){
        Driver driver = appDriver.getUser(userId);
        if(driver == null){
            return AppResponse.bizError("司机信息查询失败");
        }
        return AppResponse.success("司机信息查询成功",driver);
    }
    public AppResponse listDriverStores(String userId){
        List<Stores> driverStoreslist = appDriver.listDriverStores(userId);
        return AppResponse.success("门店与店长信息查询成功",driverStoreslist);
    }
}
