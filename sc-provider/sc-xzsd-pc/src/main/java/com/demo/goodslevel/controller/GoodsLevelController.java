package com.demo.goodslevel.controller;

import com.demo.goodslevel.entity.GoodsLevel;
import com.demo.goodslevel.service.GoodsLevelService;
import com.demo.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/goodslevel")
public class GoodsLevelController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsLevel.class);

    @Resource
    private GoodsLevelService goodsLevelService;

    /**
     * 新增分类保存
     */
    @PostMapping("saveGoodsLevel")
    public AppResponse saveGoodsLevel(GoodsLevel goodsLevel, String userId, String parentLevelCode){
        try{
            goodsLevel.setCreateBy(userId);
            return goodsLevelService.saveGoodsLevel(goodsLevel,parentLevelCode);
        }catch (Exception e){
            logger.error("新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 商品分类管理的列表查询
     * @param goodsLevel
     * @return
     */
    @PostMapping("listGoodsLevel")
    public AppResponse listGoodsLevel(GoodsLevel goodsLevel){
        try{
            return  goodsLevelService.listGoodsLevel(goodsLevel);
        }catch (Exception e){
            logger.error("列表查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 商品分类详情查询
     */
    @PostMapping("findGoodsLevelById")
    public AppResponse findGoodsLeveById(String levelCode){
        try {
            return goodsLevelService.findGoodsLevelById(levelCode);
        }catch (Exception e){
            logger.error("详情查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @PostMapping("deleteGoodsLevel")
    public AppResponse deleteGoodsLevel(String levelCode, String userId){
        try {
            return goodsLevelService.deleteGoodsLevel(levelCode,userId);
        }catch (Exception e){
            logger.error("删除失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 商品分类修改
     */
    @PostMapping("updateGoodsLevel")
    public AppResponse updateGoodsLevel(GoodsLevel goodsLevel){
        try{
            return goodsLevelService.updateGoodsLevel(goodsLevel);
        }catch (Exception e){
            logger.error("修改失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
