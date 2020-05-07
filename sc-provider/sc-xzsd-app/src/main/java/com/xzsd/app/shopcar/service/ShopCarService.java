package com.xzsd.app.shopcar.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.shopcar.dao.ShopCarDao;
import com.xzsd.app.shopcar.entity.ShopCar;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class ShopCarService {
    @Resource
    private ShopCarDao shopCarDao;

    /**
     * 加入购物车
     * @param shopCar
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addShopCar(ShopCar shopCar){
        //查看该商品是否已经存在购物车中
        int countShopCar = shopCarDao.countShopCarGoods(shopCar);
        if(countShopCar != 0){
            return AppResponse.bizError("该商品已经存在,无需再添加");
        }
        //设置购物车信息
        shopCar.setShopCarCode(StringUtil.getCommonCode(2));
        shopCar.setIsDelete(0);
        int count = shopCarDao.addShopCar(shopCar);
        if(count == 0){
            return AppResponse.bizError("加入购物车失败");
        }
        return AppResponse.success("加入购物车成功");
    }

    /**
     * 购物车列表分页查询
     * @param userId
     * @return
     */
    public AppResponse listShopCar(String userId){
        List<ShopCar> shopCarList = shopCarDao.listShopCarByPage(userId);
        if(shopCarList == null){
            return AppResponse.success("你购物车为空");
        }
        return AppResponse.success("购物车查询成功",getPageInfo(shopCarList));
    }

    /**
     * 修改购物车
     * @param shopCar
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateShopCar(ShopCar shopCar){
        int count = shopCarDao.updateShopCar(shopCar);
        if(count == 0){
            return AppResponse.bizError("修改失败数据发现变化");
        }
        return AppResponse.success("修改成功");
    }

    /**
     * 从购物车中删除
     * @param shopCarCode
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteShopCar(String shopCarCode){
        List<String> listCode = Arrays.asList(shopCarCode.split(","));
        int count = shopCarDao.deleteShopCar(listCode);
        if(count == 0){
            return AppResponse.bizError("删除失败");
        }
        return AppResponse.success("删除成功");
    }
}
