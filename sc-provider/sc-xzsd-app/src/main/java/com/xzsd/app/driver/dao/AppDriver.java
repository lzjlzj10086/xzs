package com.xzsd.app.driver.dao;

import com.xzsd.app.driver.entity.Driver;
import com.xzsd.app.storesBoss.entity.Stores;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppDriver {

    /**
     * 司机个人信息查询
     * @param userId
     * @return
     */
    Driver getUser(String userId);

    /**
     * 司机门店与店长信息
     * @param userId
     * @return
     */
    List<Stores> listDriverStores(String userId);
}
