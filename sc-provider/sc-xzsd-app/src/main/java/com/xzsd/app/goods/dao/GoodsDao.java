package com.xzsd.app.goods.dao;

import com.xzsd.app.goods.entity.Goods;
import com.xzsd.app.goods.entity.GoodsJudge;
import com.xzsd.app.goods.entity.GoodsLevel;
import com.xzsd.app.goods.entity.GoodsLeveltwo;
import com.xzsd.app.order.entity.Judge;
import com.xzsd.app.order.entity.JudgeMgeList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsDao {
    /**
     * 查询商品信息详情接口
     * @param goodsCode
     * @return
     */
    Goods findGoodsById(@Param("goodsCode") String goodsCode,@Param("userId") String userId);

    /**
     * 查询一级商品分类
     * @return
     */
    List<GoodsLevel> listFirstLeveL();

    /**
     * 查询二级及以下的商品列表
     * @param goodsLeveltwo
     * @return
     */
    List<GoodsLeveltwo> listSecondLevelAndGoodsByPage(GoodsLeveltwo goodsLeveltwo);

    /**
     * 商品评价列表查询
     * @param judgeMgeList
     * @return
     */
    List<JudgeMgeList> listGoodsJudgeByPage(JudgeMgeList judgeMgeList);
}
