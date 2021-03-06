package com.demo.imagegroup.controller;

import com.demo.goods.entity.Goods;
import com.demo.goodslevel.entity.GoodsLevel;
import com.demo.imagegroup.entity.ImageGroup;
import com.demo.imagegroup.service.ImageGroupService;
import com.demo.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/imagegroup")
public class ImageGroupController {

    private static final Logger logger = LoggerFactory.getLogger(ImageGroup.class);

    @Resource
    private ImageGroupService imageGroupService;

    /**
     * 添加轮播图
     * @param imageGroup
     * @return
     */
    @PostMapping("addImageGroup")
    public AppResponse addImageGroup(ImageGroup imageGroup){
        try {
            return imageGroupService.addImageGroup(imageGroup);
        }catch (Exception e){
            logger.error("新增轮播图失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 选择商品列表
     * @param goods
     * @return
     */
    @PostMapping("listGoods")
    public AppResponse listGoods(Goods goods){
        try {
            return imageGroupService.listGoods(goods);
        }catch (Exception e){
            logger.error("轮播图添加商品列表查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 轮播图列表的查询
     * @param imageGroup
     * @return
     */
    @PostMapping("listImageGroup")
    public AppResponse listGoods(ImageGroup imageGroup){
        try {
            return imageGroupService.listImageGroup(imageGroup);
        }catch (Exception e){
            logger.error("轮播图列表查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除轮播图
     * @param bannerCode
     * @return
     */
    @PostMapping("deleteImageGroup")
    public AppResponse deleteImageGroup(String bannerCode){
        try {
            return imageGroupService.deleteImageGroup(bannerCode);
        }catch (Exception e){
            logger.error("轮播图删除失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 启用轮播图
     * @param bannerCode
     * @return
     */
    @PostMapping("startImageGroup")
    public AppResponse startIamgeGroup(String bannerCode){
        try {
            return imageGroupService.startIamgeGroup(bannerCode);
        }catch (Exception e){
            logger.error("启用失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 禁用轮播图
     * @param bannerCode
     * @return
     */
    @PostMapping("stopImageGroup")
    public AppResponse stopImageGroup(String bannerCode){
        try {
            return imageGroupService.stopImageGroup(bannerCode);
        }catch (Exception e){
            logger.error("禁用失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
