package com.demo.hotgoods.controller;


import com.demo.goods.entity.Goods;
import com.demo.hotgoods.entity.HotGoods;
import com.demo.hotgoods.service.HotService;
import com.demo.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/hotPlace")
public class HotController {

    @Resource
    private HotService hotService;

    private static final Logger logger = LoggerFactory.getLogger(HotGoods.class);

    @PostMapping("addHotGoods")
    public AppResponse addHotGoods(HotGoods hotGoods) {
        try {
            //hotGoods.setUserId("123456");
            return hotService.addHotGoods(hotGoods);
        }catch (Exception e) {
            logger.error("新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @PostMapping("listHotGoods")
    public AppResponse listHotHotGoods(HotGoods hotGoods){
        try {
            //hotGoods.setUserId("123456");
            //hotGoods.setRole(2);
            return hotService.listHotGoods(hotGoods);
        }catch (Exception e) {
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @PostMapping("listGoods")
    public AppResponse getHotService(Goods goods) {
        try {
            //hotGoods.setUserId("123456");
            return hotService.listGoods(goods);
        }catch (Exception e) {
            logger.error("选择商品列表失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @PostMapping("updateHotGoods")
    public AppResponse updateHotGoods(HotGoods hotGoods){
        try {
            //hotGoods.setUserId("123456");
            return hotService.updateHotGoods(hotGoods);
        }catch (Exception e) {
            logger.error("修改失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @PostMapping("deleteHotGoods")
    public AppResponse deleteHotGoods(String hotCode){
        try {
            //hotGoods.setUserId("123456");
            return hotService.deleteHotGoods(hotCode);
        }catch (Exception e) {
            logger.error("删除失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("updateHotGoodsNumber")
    public AppResponse updateHotGoodsNumber(String number){
        try {
            //hotGoods.setUserId("123456");
            return hotService.updateHotGoodsNumber(number);
        }catch (Exception e) {
            logger.error("设置失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("findNum")
    public AppResponse findNum(){
        try {
            //hotGoods.setUserId("123456");
            return hotService.findNum();
        }catch (Exception e) {
            logger.error("设置查询成功", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("findHotGoodsById")
    public AppResponse findHotGoodsById(String hotCode){
        try {
            //hotGoods.setUserId("123456");
            //hotGoods.setRole(2);
            return hotService.findHotGoodsById(hotCode);
        }catch (Exception e) {
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
