package com.demo.driver.controller;


import com.demo.driver.entity.Driver;
import com.demo.driver.service.DriverService;
import com.demo.goodslevel.entity.GoodsLevel;
import com.demo.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/driver")
public class DriverController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsLevel.class);

    @Resource
    private DriverService driverService;

    /**
     * 添加司机
     * @param driver
     * @return
     */
    @PostMapping("addDriver")
    public AppResponse addDriver(Driver driver){
        try{
            return  driverService.addDriver(driver);
        }catch (Exception e){
            logger.error("新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 司机列表分页查询
     * @param driver
     * @return
     */
    @PostMapping("listDriver")
    public AppResponse listDriver(Driver driver){
        try{
            return  driverService.listDriver(driver);
        }catch (Exception e){
            logger.error("分页查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 司机详情查询
     * @param driverCode
     * @return
     */
    @PostMapping("findDriverById")
    public AppResponse findDriverById(String driverCode){
        try{
            return  driverService.findDriverById(driverCode);
        }catch (Exception e){
            logger.error("详情查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改司机信息
     * @param driver
     * @return
     */
    @PostMapping("updateDriver")
    public AppResponse updateDriver(Driver driver){
        try{
            return  driverService.updateDriver(driver);
        }catch (Exception e){
            logger.error("修改失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除司机
     * @param driverCode
     * @param userId
     * @return
     */
    @PostMapping("deleteDriver")
    public AppResponse deleteDriver(String driverCode,String userId){
        try{
            return  driverService.deleteDriver(driverCode,userId);
        }catch (Exception e){
            logger.error("删除失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
