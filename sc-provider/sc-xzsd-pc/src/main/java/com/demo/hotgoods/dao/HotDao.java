package com.demo.hotgoods.dao;

import com.demo.hotgoods.entity.HotGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface HotDao {

    /**
     * 先看是否存在该商品在热门位序号
     * @param hotGoods
     * @return
     */
    int countHotSort(HotGoods hotGoods);
    /**
     * 先看是否存在该商品在热门位
     * @param hotGoods
     * @return
     */
    int countHotGoods(HotGoods hotGoods);

    /**
     * 添加热门商品
     * @param hotGoods
     * @return
     */
    int addHotGoods(HotGoods hotGoods);

    /**
     * 查询热门商品列表
     * @param hotGoods
     * @return
     */
    List<HotGoods> listHotGoodsByPage(HotGoods hotGoods);

    /**
     * 修改热门商品
     * @param hotGoods
     * @return
     */
    int updateHotGoods(HotGoods hotGoods);

    /**
     * 删除热门商品
     * @param hotCode
     * @return
     */
    int deleteHotGoods(@Param("hotCode") List<String> hotCode);

    /**
     * 设置展示商品数量
     * @param number
     * @return
     */
    int updateHotGoodsNumber(String number);

    /**
     * 热门商品详情
     * @param hotGoods
     * @return
     */
    HotGoods findHotGoodsById(String hotGoods);

    /**
     * 设置查询展示商品
     * @return
     */
    String findNum();

}
