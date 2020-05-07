package com.xzsd.app.index.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.index.service.IndexService;
import net.sf.jsqlparser.statement.create.table.Index;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/index")
public class IndexCotroller {

    private static final Logger logger = LoggerFactory.getLogger(Index.class);
    @Resource
    private IndexService indexService;

    /**
     * 首页轮播图查询
     * @return
     */
    @PostMapping("listImageGroup")
    public AppResponse listImageGroup(){
        try {
            AppResponse appResponse = indexService.imageGroupList();
            return appResponse;
        } catch (Exception e) {
            logger.error("首页轮播图失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 首页热门商品查询
     * @return
     */
    @PostMapping("listHotGoods")
    public AppResponse listHotGoods(){
        try {
            AppResponse appResponse = indexService.hotGroupList();
            return appResponse;
        } catch (Exception e) {
            logger.error("首页热门商品失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
