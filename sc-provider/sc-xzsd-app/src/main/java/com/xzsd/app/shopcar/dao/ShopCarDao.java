package com.xzsd.app.shopcar.dao;

import com.xzsd.app.shopcar.entity.ShopCar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShopCarDao {
    /**
     * 判断购物车是否存在该商品
     * @param shopCar
     * @return
     */
    int countShopCarGoods(ShopCar shopCar);
    /**
     * 商品加入购物车
     * @param shopCar
     * @return
     */
    int addShopCar(ShopCar shopCar);

    /**
     * 查询购物车列表
     * @return
     */
    List<ShopCar> listShopCarByPage();

    /**
     * 修改商品购物车数量
     * @param shopCar
     * @return
     */
    int updateShopCar(ShopCar shopCar);

    /**
     * 删除购物车的商品
     * @param shopCarCode
     * @return
     */
    int deleteShopCar(@Param("shopCarCode") List<String> shopCarCode);
}
