package com.demo.driver.service;

import com.demo.dictionary.dao.DictionaryDao;
import com.demo.driver.dao.DriverDao;
import com.demo.driver.entity.Driver;
import com.demo.util.AppResponse;
import com.demo.util.PasswordUtils;
import com.demo.util.StoresUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class DriverService {

    @Resource
    private DriverDao driverDao;
    @Resource
    private DictionaryDao dictionaryDao;

    @Transactional(rollbackFor = Exception.class)
    public AppResponse addDriver(Driver driver){
        driver.setDriverCode(StoresUtils.getDriverCode());
        int countDriver = driverDao.countDriver(driver);
        if(countDriver != 0){
            return AppResponse.bizError("已存在该账号");
        }
        int countPhone = driverDao.countPhone(driver);
        if(countPhone != 0){
            return AppResponse.bizError("已有司机绑定该手机号，请重新输入");
        }
        driver.setDriverPwd(PasswordUtils.generatePassword(driver.getDriverPwd()));
        driver.setProvincesName(dictionaryDao.findprovincesName(driver.getProvincesNo()));
        driver.setCityName(dictionaryDao.findCityName(driver.getCityNo()));
        driver.setCountyName(dictionaryDao.findCountyName(driver.getCountyNo()));
        int count = driverDao.addDriver(driver);
        if(count == 0){
            AppResponse.bizError("添加司机失败");
        }
        return AppResponse.success("添加成功");
    }

    public AppResponse listDriver(Driver driver){
        //判断是否为店长
        if(driver.getRole() == 2){
            driver.setStoresBossCode(driver.getUserId());
        }
        List<Driver> driverList = driverDao.listDriverByPage(driver);
        return AppResponse.success("分页查询成功",getPageInfo(driverList));
    }
    public AppResponse findDriverById(String driverCode){
        Driver driver = driverDao.findDriverById(driverCode);
        return AppResponse.success("详情查询成功",driver);
    }
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateDriver(Driver driver){
        driver.setProvincesName(dictionaryDao.findprovincesName(driver.getProvincesNo()));
        driver.setCityName(dictionaryDao.findCityName(driver.getCityNo()));
        driver.setCountyName(dictionaryDao.findCountyName(driver.getCountyNo()));
        int count = driverDao.updateDriver(driver);
        if(count == 0){
            return AppResponse.bizError("修改失败");
        }
        return AppResponse.success("修改成功");
    }
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteDriver(String driverCode,String userId){
        List<String> listCode = Arrays.asList(driverCode.split(","));
        int count = driverDao.deleteDriver(listCode,userId);
        if(count == 0){
            return AppResponse.bizError("删除失败");
        }
        return AppResponse.success("删除成功");
    }
}
