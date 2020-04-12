package com.demo.goods.controller;

import com.demo.goods.entity.Goods;
import com.demo.goods.service.GoodsService;
import com.demo.goodslevel.entity.GoodsLevel;
import com.demo.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsLevel.class);

    @Resource
    private GoodsService goodsService;

    @PostMapping("saveGoods")
    public AppResponse saveGoods(Goods goods){
        try{
            return  goodsService.saveGoods(goods);
        }catch (Exception e){
            logger.error("新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("listGoods")
    public AppResponse listGoods(Goods goods){
        try {
            return goodsService.listGoods(goods);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @PostMapping("findGoodsById")
    public AppResponse findGoodsById(String goodsCode){
        try{
            return goodsService.findGoodsById(goodsCode);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("updateGoods")
    public AppResponse updateGoods(Goods goods){
        try {
            return goodsService.updateGoods(goods);
        }catch (Exception e){
            logger.error("修改失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("deleteGoods")
    public AppResponse deleteGoods(String goodsCode,String userId){
        try{
            return goodsService.deleteGoods(goodsCode,userId);
        }catch (Exception e){
            logger.error("删除失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("upGoods")
    public AppResponse upGoods(String goodsCode,String userId){
        try{
            return goodsService.upGoods(goodsCode,userId);
        }catch (Exception e){
            logger.error("上架失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("downGoods")
    public AppResponse downGoods(String goodsCode,String userId){
        try{
            return goodsService.downGoods(goodsCode,userId);
        }catch (Exception e){
            logger.error("下架失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("findFirstLevel")
    public AppResponse findFirstLevel(){
        try {
            return goodsService.findFirstLevel();
        }catch (Exception e){
            logger.error("一级查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("findSecondLevel")
    public AppResponse findSecondLevel(String firstLevelCode){
        try {
            return goodsService.findSecondLevel(firstLevelCode);
        }catch (Exception e){
            logger.error("二级查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
