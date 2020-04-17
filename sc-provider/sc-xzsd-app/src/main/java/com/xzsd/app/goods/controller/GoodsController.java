package com.xzsd.app.goods.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.goods.entity.Goods;
import com.xzsd.app.goods.entity.GoodsJudge;
import com.xzsd.app.goods.entity.GoodsLevel;
import com.xzsd.app.goods.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/appGoods")
public class GoodsController {

    private static final Logger logger = LoggerFactory.getLogger(Goods.class);
    private static final Logger logger1 = LoggerFactory.getLogger(GoodsJudge.class);
    private static final Logger logger2 = LoggerFactory.getLogger(GoodsLevel.class);
    @Resource
    private GoodsService goodsService;
    @PostMapping("findGoodsById")
    public AppResponse findGoodsById(String goodsCode,String userId){
        try {
            AppResponse appResponse = goodsService.findGoodsById(goodsCode,userId);
            return appResponse;
        } catch (Exception e) {
            logger.error("app商品详情失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("listGoodsJudge")
    public AppResponse listGoodsJudge(String goodsCode){
        try {
            AppResponse appResponse = goodsService.listGoodsJudge(goodsCode);
            return appResponse;
        } catch (Exception e) {
            logger1.error("查询商品评价列表失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("listFirstLeveL")
    public AppResponse listFirstLeveL(){
        try {
            AppResponse appResponse = goodsService.listFirstLeveL();
            return appResponse;
        } catch (Exception e) {
            logger2.error("一级列表查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("listSecondLevelAndGoodsS")
    public AppResponse listSecondLevelAndGoodsS(String firstLevel){
        try {
            AppResponse appResponse = goodsService.listSecondLevelAndGoods(firstLevel);
            return appResponse;
        } catch (Exception e) {
            logger.error("二级列表及商品失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
