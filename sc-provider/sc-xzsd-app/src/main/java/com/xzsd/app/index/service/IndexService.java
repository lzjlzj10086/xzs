package com.xzsd.app.index.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.index.dao.IndexDao;
import com.xzsd.app.index.entity.HotGoods;
import com.xzsd.app.index.entity.ImageGroup;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class IndexService {

    @Resource
    private IndexDao indexDao;

    /**
     * 首页轮播图查询
     * @return
     */
    public AppResponse imageGroupList(){
        List<ImageGroup> imageGroupList = indexDao.imageGroupList();
        if (imageGroupList == null){
            return AppResponse.bizError("首页轮播图异常");
        }
        return AppResponse.success("首页轮播图查询成功",imageGroupList);
    }
    /**
     * 首页热门商品查询
     * @return
     */
    public AppResponse hotGroupList(){
        int number = indexDao.getHotGoodsNumber();
        List<HotGoods> hotGoodsList = indexDao.hotGoodsListByPage(number);
        if (hotGoodsList == null){
            return AppResponse.bizError("首页热门商品异常");
        }
        return AppResponse.success("首页热门商品查询成功",hotGoodsList);
    }
}
