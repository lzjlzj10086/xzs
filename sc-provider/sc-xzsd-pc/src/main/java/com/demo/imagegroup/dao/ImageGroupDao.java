package com.demo.imagegroup.dao;

import com.demo.goods.entity.Goods;
import com.demo.goods.entity.GoodsVo;
import com.demo.imagegroup.entity.ImageGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ImageGroupDao {

    /**
     * 检查是否存在相同排序
     * @param imageGroup
     * @return
     */
    int countSort(ImageGroup imageGroup);

    /**
     * 添加轮播图
     * @param imageGroup
     * @return
     */
    int addImageGroup(ImageGroup imageGroup);

    /**
     * 添加轮播图的商品选择列表
     * @param goods
     * @return
     */
    List<GoodsVo> listGoods(Goods goods);

    /**
     * 轮播图列表查询
     * @param imageGroup
     * @return
     */
    List<ImageGroup> listImageGroup(ImageGroup imageGroup);

    /**
     * 删除轮播图
     * @param bannerCode
     * @return
     */
    int deleteImageGroup(@Param("bannerCode")List<String> bannerCode);

    /**
     * 启用轮播图
     * @param bannerCode
     * @return
     */
    int startIamgeGroup(@Param("bannerCode")List<String> bannerCode);

    /**
     * 禁用轮播图
     * @param bannerCode
     * @return
     */
    int stopImageGroup(@Param("bannerCode")List<String> bannerCode);
}
