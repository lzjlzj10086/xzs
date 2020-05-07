package com.demo.stores.controller;

import com.demo.hotgoods.entity.HotGoods;
import com.demo.stores.entity.Stores;
import com.demo.stores.service.StoresService;
import com.demo.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/stores")
public class StoresController {

    private static final Logger logger = LoggerFactory.getLogger(HotGoods.class);

    @Resource
    private StoresService storesService;

    /**
     * 门店添加
     * @param stores
     * @return
     */
    @PostMapping("addStores")
    public AppResponse addStores(Stores stores){
        try {
            return storesService.addStores(stores);
        }catch (Exception e) {
            logger.error("新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 门店列表查询
     * @param stores
     * @return
     */
    @PostMapping("listStores")
    public AppResponse listStores(Stores stores){
        try {
            //stores.setUserId("123456");
            //stores.setRole(2);
            return storesService.listStores(stores);
        }catch (Exception e) {
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改门店信息
     * @param stores
     * @return
     */
    @PostMapping("updateStores")
    public AppResponse updateStores(Stores stores){
        try {
            //stores.setUserId("123456");
            return storesService.updateStores(stores);
        }catch (Exception e) {
            logger.error("修改失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除门店
     * @param storesCode
     * @return
     */
    @PostMapping("deleteStores")
    public AppResponse deleteStores(String storesCode){
        try {
            //stores.setUserId("123456");
            return storesService.deletedStores(storesCode);
        }catch (Exception e) {
            logger.error("删除失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 门店详情查询
     * @param stores
     * @return
     */
    @PostMapping("findStoresById")
    public AppResponse findStoresById(Stores stores){
        try {
            return storesService.findStoresById(stores);
        }catch (Exception e) {
            logger.error("详情查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
