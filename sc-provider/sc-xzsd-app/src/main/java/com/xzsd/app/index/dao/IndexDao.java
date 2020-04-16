package com.xzsd.app.index.dao;

import com.xzsd.app.index.entity.HotGoods;
import com.xzsd.app.index.entity.ImageGroup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IndexDao {

    /**
     * 首页轮播图查询
     * @return
     */
    List<ImageGroup> imageGroupList();

    /**
     * 首热门商品查询
     * @return
     */
    List<HotGoods> hotGoodsListByPage();
}
