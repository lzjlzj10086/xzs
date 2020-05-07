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

    /**
     * 门店添加
     * @param stores
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addStores(Stores stores){
        //设置门店随机编号
        stores.setStoresCode(StoresUtils.getStoresCode());
        //设置门店随机邀请码
        stores.setStoresInviteCode(StoresUtils.getStoresInviteCode());
        int countSoresAcct= storesDao.countStoresAcct(stores);
        //校验编号是否存在
        if(countSoresAcct != 0){
            AppResponse.bizError("由于新增随机门店编号存在，请重新输入");
        }
        int countSoresInvite = storesDao.countStoresInviteCode(stores);
        //校验邀请码是否存在
        if(countSoresInvite != 0){
            AppResponse.bizError("该邀请码已存在，请重新输入");
        }
        //校验是否存在该店长
        int countBoss = storesDao.countBoss(stores);
        if(countBoss != 0){
            return AppResponse.bizError("该店长已经绑定门店,请重新输入");
        }
        //设置门店信息
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

    /**
     * 门店列表查询
     * @param stores
     * @return
     */
    public AppResponse listStores(Stores stores){
        //设置店长权限只能查询自己店面的
        if(stores.getRole() == 2){
            stores.setStoresBossCode(stores.getUserId());
        }
        List<Stores> storesList = storesDao.listStoresByPage(stores);
        return AppResponse.success("列表查询成功",getPageInfo(storesList));
    }

    /**
     * 修改门店
     * @param stores
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateStores(Stores stores){
        //查询修改的门店详情
        Stores oldStores = storesDao.findStoresById(stores);
        //判断店长是否与原来的一致
        if(!(oldStores.getStoresBossCode().equals(stores.getStoresBossCode()))){
            //检查是否存在该店长
            int countBoss = storesDao.countBoss(stores);
            if(countBoss != 0){
                return AppResponse.bizError("该店长已经绑定门店,请重新输入");
            }
        }
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

    /**
     * 删除门店
     * @param storesCode
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deletedStores(String storesCode){
        List<String> listcode = Arrays.asList(storesCode.split(","));
        int count = storesDao.deleteStores(listcode);
        if( count == 0){
            return AppResponse.bizError("删除失败");
        }
        return AppResponse.success("门店删除成功");
    }

    /**
     * 门店详情查询
     * @param stores
     * @return
     */
    public AppResponse findStoresById(Stores stores){
        Stores stores1 = storesDao.findStoresById(stores);
        if(stores1 == null){
            return AppResponse.bizError("详情查询失败");
        }
        return AppResponse.success("详情查询成功",stores1);
    }
}
