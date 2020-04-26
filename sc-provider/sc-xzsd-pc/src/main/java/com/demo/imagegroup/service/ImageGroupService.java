package com.demo.imagegroup.service;

import com.demo.goods.entity.Goods;
import com.demo.goods.entity.GoodsVo;
import com.demo.imagegroup.dao.ImageGroupDao;
import com.demo.imagegroup.entity.ImageGroup;
import com.demo.util.AppResponse;
import com.demo.util.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class ImageGroupService {

    @Resource
    private ImageGroupDao imageGroupDao;

    /**
     * 添加轮播图
     * @param imageGroup
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addImageGroup(ImageGroup imageGroup){
        int countsort  = imageGroupDao.countSort(imageGroup);
        //校验轮播序号
        if(countsort != 0){
            return AppResponse.bizError("排序序号已经存在，请重新输入");
        }
        int countGoods = imageGroupDao.countGoods(imageGroup);
        //校验轮播图商品
        if(countGoods != 0){
            return AppResponse.bizError("该商品已经存在，请重新输入");
        }
        //设置轮播图信息
        imageGroup.setBannerCode(StringUtil.getCommonCode(2));
        int count = imageGroupDao.addImageGroup(imageGroup);
        if(count == 0){
            return AppResponse.bizError("添加轮播图失败");
        }
        return AppResponse.success("添加轮播图成功");
    }

    /**
     * 轮播图选择商品列表查询
     * @param goods
     * @return
     */
    public AppResponse listGoods(Goods goods){
        List<GoodsVo> goodsList=imageGroupDao.listGoodsByPage(goods);
        return AppResponse.success("查询成功",getPageInfo(goodsList));
    }

    /**
     * 轮播图列表分页查询
     * @param imageGroup
     * @return
     */
    public AppResponse listImageGroup(ImageGroup imageGroup){
        List<ImageGroup> imageGroupList=imageGroupDao.listImageGroupByPage(imageGroup);
        return AppResponse.success("查询成功",getPageInfo(imageGroupList));
    }

    /**
     * 删除轮播图
     * @param bannerCode
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteImageGroup(String bannerCode){
        List<String> listCode = Arrays.asList(bannerCode.split(","));
        int count = imageGroupDao.deleteImageGroup(listCode);
        if(count == 0){
            return AppResponse.bizError("删除错误");
        }
        return AppResponse.success("删除成功");
    }

    /**
     * 轮播图启用
     * @param bannerCode
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse startIamgeGroup(String bannerCode){
        List<String> listCode = Arrays.asList(bannerCode.split(","));
        int count = imageGroupDao.startIamgeGroup(listCode);
        if(count == 0){
            return AppResponse.bizError("启用错误");
        }
        return AppResponse.success("启用成功");
    }

    /**
     * 轮播图的禁用
     * @param bannerCode
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse stopImageGroup(String bannerCode){
        List<String> listCode = Arrays.asList(bannerCode.split(","));
        int count = imageGroupDao.stopImageGroup(listCode);
        if(count == 0){
            return AppResponse.bizError("禁用错误");
        }
        return AppResponse.success("禁用成功");
    }

}
