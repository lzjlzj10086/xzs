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

@Service
public class ImageGroupService {

    @Resource
    private ImageGroupDao imageGroupDao;

    @Transactional(rollbackFor = Exception.class)
    public AppResponse addImageGroup(ImageGroup imageGroup){
        int countsort  = imageGroupDao.countSort(imageGroup);
        if(countsort != 0){
            return AppResponse.bizError("排序序号已经存在，请重新输入");
        }
        imageGroup.setBannerCode(StringUtil.getCommonCode(2));
        int count = imageGroupDao.addImageGroup(imageGroup);
        if(count == 0){
            return AppResponse.bizError("添加轮播图失败");
        }
        return AppResponse.success("添加轮播图成功");
    }

    public AppResponse listGoods(Goods goods){
        PageHelper.startPage(goods.getPageNum(),goods.getPageSize());
        List<GoodsVo> listgoods=imageGroupDao.listGoods(goods);
        PageInfo<GoodsVo> pageInfo=new PageInfo<GoodsVo>(listgoods);
        return AppResponse.success("查询成功",pageInfo);
    }

    public AppResponse listImageGroup(ImageGroup imageGroup){
        PageHelper.startPage(imageGroup.getPageNum(),imageGroup.getPageSize());
        List<ImageGroup> listImageGroup=imageGroupDao.listImageGroup(imageGroup);
        PageInfo<ImageGroup> pageInfo=new PageInfo<ImageGroup>(listImageGroup);
        return AppResponse.success("查询成功",pageInfo);
    }

    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteImageGroup(String bannerCode){
        List<String> listCode = Arrays.asList(bannerCode.split(","));
        int count = imageGroupDao.deleteImageGroup(listCode);
        if(count == 0){
            return AppResponse.bizError("删除错误");
        }
        return AppResponse.success("删除成功");
    }
    @Transactional(rollbackFor = Exception.class)
    public AppResponse startIamgeGroup(String bannerCode){
        List<String> listCode = Arrays.asList(bannerCode.split(","));
        int count = imageGroupDao.startIamgeGroup(listCode);
        if(count == 0){
            return AppResponse.bizError("启用错误");
        }
        return AppResponse.success("启用成功");
    }
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
