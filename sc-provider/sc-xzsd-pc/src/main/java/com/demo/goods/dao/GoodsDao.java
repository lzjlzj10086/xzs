package com.demo.goods.dao;

import com.demo.goods.entity.Goods;
import com.demo.goods.entity.GoodsVo;
import com.demo.goodslevel.entity.GoodsLevel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsDao {
    /**
     * 查询是否存在该商品
     * @param goods
     * @return
     */
    int countGoods(Goods goods);
    /**
     * 商品添加
     * @param goods
     * @return
     */
    int saveGoods(Goods goods);

    /**
     * 商品列表分页查询
     * @param goods
     * @return
     */
    List<GoodsVo> listGoods(Goods goods);

    /**
     * 商品详情查询
     * @param goodsCode
     * @return
     */
    GoodsVo findGoodsById(String goodsCode);

    /**
     * 修改商品
     * @param goods
     * @return
     */
    int updateGoods(Goods goods);

    /**
     * 删除商品
     * @param goodsCode
     * @return
     */
    int deleteGoods(@Param("goodsCode") List<String> goodsCode, @Param("userId") String userId);

    /**
     * 上架商品
     * @param goodsCode
     * @return
     */
    int upGoods(@Param("goodsCode") List<String> goodsCode, @Param("userId") String userId);

    /**
     * 下架商品
     * @param goodsCode
     * @return
     */
    int downGoods(@Param("goodsCode") List<String> goodsCode, @Param("userId") String userId);

    /**
     * 商品分类一级下拉查询
     * @param
     * @return
     */
    List<GoodsLevel> findFirstLevel();

    /**
     * 商品分类二级下拉查询
     * @param firstLevelCode
     * @return
     */
    List<GoodsLevel> findSecondLevel(String firstLevelCode);

}
