package com.xzsd.app.goods.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.goods.dao.GoodsDao;
import com.xzsd.app.goods.entity.Goods;
import com.xzsd.app.goods.entity.GoodsJudge;
import com.xzsd.app.goods.entity.GoodsLevel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class GoodsService {

    @Resource
    private GoodsDao goodsDao;

    /**
     * 查询商品信息详情接口
     * @param goodsCode
     * @return
     */
    public AppResponse findGoodsById(String goodsCode,String userId){
        Goods goods = goodsDao.findGoodsById(goodsCode,userId);
        if(goods == null){
            return AppResponse.bizError("商品详情查询异常");
        }
        return AppResponse.success("商品查询成功",goods);
    }

    /**
     * 查询商品评价列表
     * @param goodsCode,starLevel
     * @return
     */
    public AppResponse listGoodsJudge(GoodsJudge goodsJudge){
        List<GoodsJudge> goodsJudgeList = goodsDao.listGoodsJudgeByPage(goodsJudge);
        return AppResponse.success("该商品评价列表查询成功",getPageInfo(goodsJudgeList));
    }

    /**
     * 查询一级商品分类列表
     * @return
     */
    public AppResponse listFirstLeveL(){
        List<GoodsLevel> goodsLevelList = goodsDao.listFirstLeveL();
        return AppResponse.success("一级分类查询成功",goodsLevelList);
    }

    /**
     * 查询二级及以下的商品列表
     * @param firstLevelCode
     * @return
     */
    public AppResponse listSecondLevelAndGoods(String firstLevelCode){
        List<Goods> goodsList = goodsDao.listSecondLevelAndGoodsByPage(firstLevelCode);
        return AppResponse.success("查询二级以下的商品列表成功",goodsList);
    }
}
