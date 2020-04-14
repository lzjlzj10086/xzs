package com.demo.goods.service;


import com.demo.goods.dao.GoodsDao;
import com.demo.goods.entity.Goods;
import com.demo.goods.entity.GoodsVo;
import com.demo.goodslevel.dao.GoodsLevelDao;
import com.demo.goodslevel.entity.GoodsLevel;
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
public class GoodsService {

    @Resource
    private GoodsDao goodsDao;
    @Resource
    private GoodsLevelDao goodsLevelDao;

    /**
     * 商品新增
     * @param goods
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveGoods(Goods goods){
        int count = goodsDao.countGoods(goods);
        if(count != 0){
            return AppResponse.bizError("商品已存在，请重新输入");
        }
        goods.setIsDelete(0);
        goods.setGoodsStatus(0);
        goods.setGoodsCode(StringUtil.getCommonCode(2));
        goods.setFirstLevelName(goodsLevelDao.findGoodsLevelById(goods.getFirstLevelCode()).getLevelName());
        goods.setSecondLevelName(goodsLevelDao.findGoodsLevelById(goods.getSecondLevelCode()).getLevelName());
        int countsave=goodsDao.saveGoods(goods);
        if(countsave == 0){
            return AppResponse.bizError("添加失败，请重新输入");
        }
        return AppResponse.success("添加成功");
    }

    /**
     * 商品列表查询
     * @param goods
     * @return
     */
    public AppResponse listGoods(Goods goods){
        List<GoodsVo> goodsList=goodsDao.listGoodsByPage(goods);
        return AppResponse.success("查询成功",getPageInfo(goodsList));
    }

    /**
     * 商品详情查询
     * @param goodsCode
     * @return
     */
    public AppResponse findGoodsById(String goodsCode){
      GoodsVo goodsVo=goodsDao.findGoodsById(goodsCode);
      return AppResponse.success("查询成功",goodsVo);
    }

    /**
     * 修改商品
     * @param goods
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoods(Goods goods){
        int count =goodsDao.updateGoods(goods);
        if(count == 0){
            return AppResponse.bizError("数据发生变化，请重新输入");
        }
        return AppResponse.success("修改成功");
    }

    /**
     * 删除商品
     * @param goodsCode
     * @param userId
     * @return AppResponse
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoods(String goodsCode,String userId){
        List<String> listCode = Arrays.asList(goodsCode.split(","));
        int count = goodsDao.deleteGoods(listCode,userId);
        if(count == 0){
            return AppResponse.bizError("删除失败");
        }
        return AppResponse.success("删除成功");
    }

    /**
     * 上架商品
     * @param goodsCode
     * @param userId
     * @return AppResponse
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse upGoods(String goodsCode,String userId){
        List<String> listCode = Arrays.asList(goodsCode.split(","));
        int count = goodsDao.upGoods(listCode,userId);
        if(count == 0){
            return AppResponse.bizError("上架失败");
        }
        return AppResponse.success("上架成功");
    }

    /**
     * 下架商品
     * @param goodsCode
     * @param userId
     * @return AppResponse
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse downGoods(String goodsCode,String userId){
        List<String> listCode = Arrays.asList(goodsCode.split(","));
        int count = goodsDao.downGoods(listCode,userId);
        if(count == 0){
            return AppResponse.bizError("下架失败");
        }
        return AppResponse.success("下架成功");
    }

    public AppResponse findFirstLevel(){
        List<GoodsLevel> listLevel = goodsDao.findFirstLevel();
        return AppResponse.success("一级查询成功",listLevel);
    }
    public AppResponse findSecondLevel(String firstLevelCode){
        List<GoodsLevel> listLevel = goodsDao.findSecondLevel(firstLevelCode);
        return AppResponse.success("二级查询成功",listLevel);
    }
}
