package com.demo.goodslevel.service;

import com.demo.goodslevel.dao.GoodsLevelDao;
import com.demo.goodslevel.entity.GoodsLevel;
import com.demo.goodslevel.entity.GoodsLevelVo;
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
public class GoodsLevelService {

    @Resource
    private GoodsLevelDao goodsLevelDao;

    /**
     * 新增保存分类信息
     * @param goodsLevel
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveGoodsLevel(GoodsLevel goodsLevel, String parentLevelCode){
        int countName=goodsLevelDao.countLevelName(goodsLevel);
        if(countName!=0){
            return AppResponse.bizError("分类名称已存在，请重新输入！");
        }
        if(parentLevelCode != null){
            goodsLevel.setIsParent(1);
            goodsLevel.setParentLeveLName(goodsLevelDao.findGoodsLevelById(parentLevelCode).getLevelName());
        }else{
            goodsLevel.setIsParent(0);
        }
        goodsLevel.setLevelCode(StringUtil.getCommonCode(2));
        goodsLevel.setIsDelete(0);

        int count=goodsLevelDao.saveGoodsLevel(goodsLevel);
        if(count == 0){
            return AppResponse.bizError("新增失败，请重试！");
        }
        return  AppResponse.success("新增成功");
    }

    /**
     * 商品分类管理的列表查询
     * @param goodsLevel
     * @return
     */
    public AppResponse listGoodsLevel(GoodsLevel goodsLevel){
        PageHelper.startPage(goodsLevel.getPageNum(),goodsLevel.getPageSize());
        List<GoodsLevel> listGoodsLevel=goodsLevelDao.listGoodsLevel(goodsLevel);
        PageInfo<GoodsLevel> pagedate= new PageInfo<GoodsLevel>(listGoodsLevel);
        return AppResponse.success("查询成功",pagedate);
    }
    /**
     * 商品分类详情查询
     */
    public AppResponse findGoodsLevelById(String levelCode){
        GoodsLevelVo goodsLevelVo=goodsLevelDao.findGoodsLevelById(levelCode);
        return AppResponse.success("查询成功",goodsLevelVo);
    }
    /**
     * 商品分类删除
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoodsLevel(String levelCode, String userId){
        List<String> listLevelCode= Arrays.asList(levelCode.split(","));
        int count=goodsLevelDao.deleteGoodsLevel(listLevelCode,userId);
        if(count == 0){
            return AppResponse.bizError("删除异常");
        }
        return AppResponse.success("删除成功");
    }
    /**
     * 商品分类修改
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsLevel(GoodsLevel goodsLevel){
        int countupdate=goodsLevelDao.updateGoodsLevel(goodsLevel);
        if (countupdate == 0){
            return AppResponse.bizError("数据发生变化，请重新输入");
        }
        return AppResponse.success("修改成功");
    }
}
