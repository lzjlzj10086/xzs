package com.xzsd.app.goods.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.goods.dao.GoodsDao;
import com.xzsd.app.goods.entity.Goods;
import com.xzsd.app.goods.entity.GoodsJudge;
import com.xzsd.app.goods.entity.GoodsLevel;
import com.xzsd.app.goods.entity.GoodsLeveltwo;
import com.xzsd.app.order.entity.JudgeMgeList;
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
        String inviteCode = goodsDao.findinviteCode(userId);
        Goods goods = new Goods();
        if(inviteCode != null && inviteCode !=""){
            goods = goodsDao.findGoodsById(goodsCode,userId);
        }
        if(inviteCode == null || inviteCode == ""){
            goods = goodsDao.findGoodsByIdTwo(goodsCode);
        }
        if(goods == null){
            return AppResponse.bizError("商品详情查询异常");
        }
        return AppResponse.success("商品查询成功",goods);
    }

    /**
     * 商品评价列表查询
     * @param judgeMgeList
     * @return
     */
    public AppResponse listGoodsJudge(JudgeMgeList judgeMgeList){
        List<JudgeMgeList> judgeMgeLists =goodsDao.listGoodsJudgeByPage(judgeMgeList);
        return AppResponse.success("商品评价列表",getPageInfo(judgeMgeLists));
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
        GoodsLeveltwo goodsLeveltwo = new GoodsLeveltwo();
        goodsLeveltwo.setParentLevelCode(firstLevelCode);
        List<GoodsLeveltwo> secondLevelAndGoodslist = goodsDao.listSecondLevelAndGoodsByPage(goodsLeveltwo);
        return AppResponse.success("查询二级名称以及以下的商品列表成功",getPageInfo(secondLevelAndGoodslist));
    }
}
