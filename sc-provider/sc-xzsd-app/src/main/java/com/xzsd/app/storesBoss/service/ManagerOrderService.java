package com.xzsd.app.storesBoss.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.order.entity.Order;
import com.xzsd.app.storesBoss.dao.ManagerOrdersDao;
import com.xzsd.app.storesBoss.entity.Driver;
import com.xzsd.app.storesBoss.entity.Stores;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class ManagerOrderService {

    @Resource
    private ManagerOrdersDao managerOrdersDao;

    /**
     * 订单列表查询
     * @param orderStatus
     * @return
     */
    public AppResponse listManagerOrders(Integer orderStatus,String userId){
        List<Order> orderList = managerOrdersDao.listManagerOrdersByPage(orderStatus,userId);
        return AppResponse.success("店长订单列表查询成功",getPageInfo(orderList));
    }

    /**
     * 修改订单状态
     * @param order
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateManangerOrderState(Order order){
        int count = managerOrdersDao.updateManangerOrderState(order);
        if(count == 0){
            return AppResponse.bizError("修改失败");
        }
        return AppResponse.success("订单修改成功");
    }

    /**
     * 订单详情
     * @param orderCode
     * @return
     */
    public AppResponse findOrderById(String orderCode){
        Order order = managerOrdersDao.findOrderById(orderCode);
        if (order == null){
            return AppResponse.bizError("订单详细查询失败");
        }
        return AppResponse.success("查询成功",order);
    }
    /**
     * 店长的门店司机的信息查询
     * @param userId
     * @return
     */
    public AppResponse listManangerDrivers(String userId){
        List<Driver> driverList = managerOrdersDao.listManangerDrivers(userId);
        return AppResponse.success("司机信息查询成功",driverList);
    }
    public AppResponse getUser(String userId){
        Stores mananger = managerOrdersDao.getUser(userId);
        if(mananger == null){
            return AppResponse.bizError("店长端个人信息查询失败");
        }
        return AppResponse.success("店长端个人信息查询成功",mananger);
    }
}
