package com.demo.dictionary.controller;

import com.demo.dictionary.service.DictionaryService;
import com.demo.hotgoods.entity.HotGoods;
import com.demo.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("dictionary")
public class DictionaryController {

    private static final Logger logger = LoggerFactory.getLogger(HotGoods.class);

    @Resource
    private DictionaryService dictionaryService;

    @PostMapping("findProvinces")
    public AppResponse findProvinces(){
        try {
            return dictionaryService.findprovinces();
        }catch (Exception e) {
            logger.error("省份查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @PostMapping("findCity")
    public AppResponse findCity(String provincesNo){
        try {
            return dictionaryService.findCity(provincesNo);
        }catch (Exception e) {
            logger.error("城市查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @PostMapping("findCounty")
    public AppResponse findCounty(String cityNo){
        try {
            return dictionaryService.findCounty(cityNo);
        }catch (Exception e) {
            logger.error("区查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
