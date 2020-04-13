package com.demo.driver.dao;

import com.demo.driver.entity.Driver;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DriverDao {

    /**
     * 查询是否存在该司机
     * @param driver
     * @return
     */
    int countDriver(Driver driver);

    /**
     * 添加司机
     * @param driver
     * @return
     */
    int addDriver(Driver driver);

    /**
     * 司机列表分页查询
     * @param driver
     * @return
     */
    List<Driver> listDriver(Driver driver);

    /**
     * 司机详情
     * @param driverCode
     * @return
     */
    Driver findDriverById(String driverCode);

    /**
     * 修改司机信息
     * @param driver
     * @return
     */
    int updateDriver(Driver driver);

    /**
     * 删除司机
     * @param driverCode
     * @return
     */
    int deleteDriver(@Param("driverCode")List<String> driverCode,@Param("userId") String userId);
}
