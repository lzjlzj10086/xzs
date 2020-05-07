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

    /**
     * 添加热门商品
     * @param hotGoods
     * @return
     */
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

    /**
     * 热门商品列表分页查询
     * @param hotGoods
     * @return
     */
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

    /**
     * 商品选择列表
     * @param goods
     * @return
     */
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

    /**
     * 修改热门商品
     * @param hotGoods
     * @return
     */
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

    /**
     * 删除热门商品
     * @param hotCode
     * @return
     */
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

    /**
     * 设置展现热门商品数量
     * @param number
     * @return
     */
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

    /**
     * 展现热门商品数量查询
     * @return
     */
    @PostMapping("findNum")
    public AppResponse findNum(){
        try {
            return hotService.findNum();
        }catch (Exception e) {
            logger.error("设置查询成功", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 热门商品详情
     * @param hotCode
     * @return
     */
    @PostMapping("findHotGoodsById")
    public AppResponse findHotGoodsById(String hotCode){
        try {
            return hotService.findHotGoodsById(hotCode);
        }catch (Exception e) {
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
