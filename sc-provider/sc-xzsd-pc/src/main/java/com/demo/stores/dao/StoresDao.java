package com.demo.stores.dao;

import com.demo.stores.entity.Stores;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StoresDao {

    /**
     * 根据门店编码是否存在门店
     * @param stores
     * @return
     */
    int countStores(Stores stores);

    /**
     * 添加门店
     * @param stores
     * @return
     */
    int addStores(Stores stores);

    /**
     * 门店列表查询
     * @param stores
     * @return
     */
    List<Stores> listStoresByPage(Stores stores);

    /**
     * 门店修改
     * @param stores
     * @return
     */
    int updateStores(Stores stores);

    /**
     * 删除门店
     * @param storesCode
     * @return
     */
    int deleteStores(@Param("storesCode") List<String> storesCode);
}
