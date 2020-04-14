package com.demo.stores.service;


import com.demo.dictionary.dao.DictionaryDao;
import com.demo.dictionary.entity.Dictionary;
import com.demo.stores.dao.StoresDao;
import com.demo.stores.entity.Stores;
import com.demo.user.dao.UserDao;
import com.demo.util.AppResponse;
import com.demo.util.StoresUtils;
import com.demo.util.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class StoresService {

    @Resource
    private StoresDao storesDao;
    @Resource
    private UserDao userDao;
    @Resource
    private DictionaryDao dictionaryDao;

    @Transactional(rollbackFor = Exception.class)
    public AppResponse addStores(Stores stores){
        stores.setStoresCode(StoresUtils.getStoresCode());
        stores.setStoresInviteCode(StoresUtils.getStoresInviteCode());
        int countSores = storesDao.countStores(stores);
        if(countSores != 0){
            AppResponse.bizError("由于新增随机门店编号或邀请码存在，请重新输入");
        }
        stores.setStoresAcct(StoresUtils.getStoresAcct());
        stores.setStoresBossName(userDao.findUserById(stores.getStoresBossCode()).getUserName());
        stores.setProvincesName(dictionaryDao.findprovincesName(stores.getProvincesNo()));
        stores.setCityName(dictionaryDao.findCityName(stores.getCityNo()));
        stores.setCountyName(dictionaryDao.findCountyName(stores.getCountyNo()));
        int count = storesDao.addStores(stores);
        if( count == 0){
            return AppResponse.bizError("添加失败");
        }
        return AppResponse.success("门店添加成功");
    }

    public AppResponse listStores(Stores stores){
        //设置店长权限只能查询自己店面的
        if(stores.getRole() == 2){
            stores.setStoresBossCode(stores.getUserId());
        }


        List<Stores> storesList = storesDao.listStoresByPage(stores);
        ;
        return AppResponse.success("列表查询成功",getPageInfo(storesList));
    }
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateStores(Stores stores){
        stores.setStoresBossName(userDao.findUserById(stores.getStoresBossCode()).getUserName());
        stores.setProvincesName(dictionaryDao.findprovincesName(stores.getProvincesNo()));
        stores.setCityName(dictionaryDao.findCityName(stores.getCityNo()));
        stores.setCountyName(dictionaryDao.findCountyName(stores.getCountyNo()));
        int count = storesDao.updateStores(stores);
        if( count == 0){
            return AppResponse.bizError("修改失败");
        }
        return AppResponse.success("门店修改成功");
    }
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deletedStores(String storesCode){
        List<String> listcode = Arrays.asList(storesCode.split(","));
        int count = storesDao.deleteStores(listcode);
        if( count == 0){
            return AppResponse.bizError("删除失败");
        }
        return AppResponse.success("门店删除成功");
    }
}
