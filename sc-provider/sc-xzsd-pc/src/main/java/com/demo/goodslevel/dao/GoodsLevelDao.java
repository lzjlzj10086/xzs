package com.demo.goodslevel.dao;

import com.demo.goodslevel.entity.GoodsLevel;
import com.demo.goodslevel.entity.GoodsLevelVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsLevelDao {
    /**
     * 查询是否存在同名
     * @param goodsLevel
     * @return
     */
    int countLevelName(GoodsLevel goodsLevel);

    /**
     * 检查商品是否有二级
     * @param levelCode
     * @return
     */
    int countSecondLevel(@Param("levelCode") String levelCode);
    /**
     * 商品分类新增
     */
    int saveGoodsLevel(GoodsLevel goodsLevel);
    /**
     * 商品分类列表查询
     */
    List<GoodsLevel> listGoodsLevel(GoodsLevel goodsLevel);
    /**
     * 商品分类查询
     */
    GoodsLevelVo findGoodsLevelById(String levelCode);
    /**
     * 商品分类删除
     */
    int deleteGoodsLevel(@Param("levelCode") String levelCode, @Param("userId") String userId);
    /**
     * 商品修改
     */
    int updateGoodsLevel(GoodsLevel goodsLevel);

    /**
     * 查询二级分类是否存在商品
     * @param levelCode
     * @return
     */
    int countSecondGoods(String levelCode);
}
