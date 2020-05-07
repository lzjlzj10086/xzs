package com.demo.top.controller;

import com.demo.hotgoods.entity.HotGoods;
import com.demo.top.servcie.TopService;
import com.demo.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/top")
public class TopController {

    private static final Logger logger = LoggerFactory.getLogger(HotGoods.class);

    @Resource
    private TopService topService;

    /**
     * 顶部栏信息查询
     * @param userAccount
     * @return
     */
    @PostMapping("getTop")
    public AppResponse getTop(String userAccount){
        try{
            return topService.getTop(userAccount);
        }catch (Exception e) {
            logger.error("顶部栏失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
