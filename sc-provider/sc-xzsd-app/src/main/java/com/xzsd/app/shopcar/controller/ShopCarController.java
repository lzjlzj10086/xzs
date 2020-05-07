package com.xzsd.app.shopcar.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.goods.entity.Goods;
import com.xzsd.app.shopcar.entity.ShopCar;
import com.xzsd.app.shopcar.service.ShopCarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/appShopCar")
public class ShopCarController {

    private static final Logger logger = LoggerFactory.getLogger(ShopCar.class);
    @Resource
    private ShopCarService shopCarService;

    /**
     * 加入购物车
     * @param shopCar
     * @return
     */
    @PostMapping("addShopCar")
    public AppResponse addShopCar(ShopCar shopCar){
        try {
            AppResponse appResponse = shopCarService.addShopCar(shopCar);
            return appResponse;
        } catch (Exception e) {
            logger.error("加入购物车失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 购物车查询
     * @return
     */
    @PostMapping("listShopCar")
    public AppResponse listShopCar(String userId){
        try {
            AppResponse appResponse = shopCarService.listShopCar(userId);
            return appResponse;
        } catch (Exception e) {
            logger.error("购物车列表失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改购物车数量
     * @param shopCar
     * @return
     */
    @PostMapping("updateShopCar")
    public AppResponse updateShopCar(ShopCar shopCar){
        try {
            AppResponse appResponse = shopCarService.updateShopCar(shopCar);
            return appResponse;
        } catch (Exception e) {
            logger.error("修改购物车失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除购物车
     * @param shopCarCode
     * @return
     */
    @PostMapping("deleteShopCar")
    public AppResponse deleteShopCar(String shopCarCode){
        try {
            AppResponse appResponse = shopCarService.deleteShopCar(shopCarCode);
            return appResponse;
        } catch (Exception e) {
            logger.error("删除购物商品失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
