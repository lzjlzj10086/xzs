package com.demo.hotgoods.service;

import com.demo.goods.dao.GoodsDao;

import com.demo.goods.entity.Goods;
import com.demo.goods.entity.GoodsVo;
import com.demo.hotgoods.dao.HotDao;
import com.demo.hotgoods.entity.HotGoods;

import com.demo.imagegroup.service.ImageGroupService;
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
public class HotService {

    @Resource
    private HotDao hotDao;
    @Resource
    private GoodsDao goodsDao;
    @Resource
    private ImageGroupService imageGroupService;

    /**
     * 热门商品添加
     * @param hotGoods
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addHotGoods(HotGoods hotGoods){
        int countSort = hotDao.countHot(hotGoods);
        if(countSort != 0){
            return AppResponse.bizError("该排序重复或者该商品存在");
        }
        hotGoods.setHotCode(StringUtil.getCommonCode(2));
        GoodsVo goodsvo = goodsDao.findGoodsById(hotGoods.getGoodsCode());
        hotGoods.setGoodsName(goodsvo.getGoodsName());
        hotGoods.setGoodsPrice(goodsvo.getPrice());
        hotGoods.setGoodsNotes(goodsvo.getGoodsNotes());
        int count = hotDao.addHotGoods(hotGoods);
        if( count == 0){
            return AppResponse.bizError("添加失败");
        }
        return AppResponse.success("添加成功");
    }

    /**
     * 热门商品列表查询
     * @param hotGoods
     * @return
     */
    public AppResponse listHotGoods(HotGoods hotGoods){

        List<HotGoods> hotGoodsList = hotDao.listHotGoodsByPage(hotGoods);
        ;
        return AppResponse.success("热门商品列表查询成功",getPageInfo(hotGoodsList));
    }

    /**
     * 热门商品添加商品选择列表
     * @param goods
     * @return
     */
    public AppResponse listGoods(Goods goods){

        return imageGroupService.listGoods(goods);
    }

    /**
     * 修改热门商品
     * @param hotGoods
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateHotGoods(HotGoods hotGoods){
        int countSort = hotDao.countHot(hotGoods);
        GoodsVo goodsvo = goodsDao.findGoodsById(hotGoods.getGoodsCode());
        hotGoods.setGoodsName(goodsvo.getGoodsName());
        hotGoods.setGoodsPrice(goodsvo.getPrice());
        hotGoods.setGoodsNotes(goodsvo.getGoodsNotes());
        int count = hotDao.updateHotGoods(hotGoods);
        if( count == 0){
            return AppResponse.bizError("修改失败");
        }
        return AppResponse.success("修改成功");
    }

    /**
     * 删除热门商品
     * @param hotCode
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteHotGoods(String hotCode){
        List<String> listCode = Arrays.asList(hotCode.split(","));
        int count = hotDao.deleteHotGoods(listCode);
        if(count == 0){
            return AppResponse.bizError("删除失败");
        }
        return AppResponse.success("删除成功");
    }

    /**
     * 热门位商品展示数量设置
     * @param number
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateHotGoodsNumber(String number){
        int count = hotDao.updateHotGoodsNumber(number);
        if(count == 0){
            return AppResponse.bizError("设置热门商品数量失败");
        }
        return AppResponse.success("设置成功");
    }
}
