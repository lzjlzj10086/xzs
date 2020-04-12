package com.demo.dictionary.service;

import com.demo.dictionary.dao.DictionaryDao;
import com.demo.dictionary.entity.Dictionary;
import com.demo.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DictionaryService {

    @Resource
    private DictionaryDao dictionaryDao;


    public AppResponse findprovinces(){
        List<Dictionary> listProvinces = dictionaryDao.findprovinces();
        return AppResponse.success("省份查询成功",listProvinces);
    }

    public AppResponse findCity(String provincesNo){
        List<Dictionary> listCity = dictionaryDao.findCity(provincesNo);
        return AppResponse.success("城市查询成功",listCity);
    }

    public AppResponse findCounty(String cityNo){
        List<Dictionary> listCounty = dictionaryDao.findCounty(cityNo);
        return AppResponse.success("区查询成功",listCounty);
    }
}
