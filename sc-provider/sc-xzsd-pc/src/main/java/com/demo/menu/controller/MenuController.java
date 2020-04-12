package com.demo.menu.controller;

import com.demo.goodslevel.entity.GoodsLevel;
import com.demo.menu.entity.Menu;
import com.demo.menu.service.MenuService;
import com.demo.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsLevel.class);

    @Resource
    private MenuService menuService;

    /**
     * 添加菜单
     * @param menu
     * @return
     */
    @PostMapping("addMenu")
    public AppResponse addMenu(Menu menu){
        try {
            return menuService.addMenu(menu);
        }catch (Exception e){
            logger.error("删除失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 菜单列表查询
     * @param menu
     * @return
     */
    @PostMapping("listMenu")
    public AppResponse listMenu(Menu menu){
        try {
            return menuService.listMenu(menu);
        }catch (Exception e){
            logger.error("列表查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 菜单详情查询
     * @param menuCode
     * @return
     */
    @PostMapping("findMenuById")
    public AppResponse findMenuById(String menuCode){
        try {
            return menuService.findMenuById(menuCode);
        }catch (Exception e){
            logger.error("菜单详情查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 菜单修改
     * @param menu
     * @return
     */
    @PostMapping("updateMenu")
    public AppResponse updateMenu(Menu menu){
        try {
            return menuService.updateMenu(menu);
        }catch (Exception e){
            logger.error("修改失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @PostMapping("deleteMenu")
    public AppResponse deleteMenu(String menuCode,String userId){
        try {
            return menuService.deleteMenu(menuCode,userId);
        }catch (Exception e){
            logger.error("删除失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
