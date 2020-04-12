package com.demo.dictionary.dao;

import com.demo.dictionary.entity.Dictionary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DictionaryDao {
    /**
     * 省份查询
     * @return
     */
    List<Dictionary> findprovinces();

    /**
     * 城市查询
     * @param provincesNo
     * @return
     */
    List<Dictionary> findCity(String provincesNo);

    /**
     * 所在区查询
     * @param cityNo
     * @return
     */
    List<Dictionary> findCounty(String cityNo);

    String findprovincesName(String provincesNo);

    String findCityName(String cityNo);

    String findCountyName(String countyNo);
}
