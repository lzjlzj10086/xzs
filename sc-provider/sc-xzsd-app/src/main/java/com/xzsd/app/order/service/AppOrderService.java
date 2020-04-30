package com.xzsd.app.order.service;

import com.github.pagehelper.PageHelper;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.goods.entity.Goods;
import com.xzsd.app.order.dao.AppOrderDao;
import com.xzsd.app.order.entity.*;
import com.xzsd.app.register.entity.ClientUser;
import com.xzsd.app.shopcar.dao.ShopCarDao;
import com.xzsd.app.shopcar.entity.ShopCar;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class AppOrderService {

    @Resource
    private AppOrderDao appOrderDao;
    @Resource
    private ShopCarDao shopCarDao;
    /**
     * 订单添加和订单详情添加
     * @param goodsCode
     * @param amount
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addOrder(String goodsCode,String amount,String userId){
        String inviteCode = appOrderDao.countInviteCode(userId);
        if (inviteCode.length() == 0) {
            return AppResponse.success("请先去根据邀请码绑定门店");
        }
        List<String> goodsCodeList = Arrays.asList(goodsCode.split(","));
        List<String> goodsNum = Arrays.asList(amount.split(","));
        Stores stores = appOrderDao.findStoresByUserId(userId);
        ClientUser clientUser = appOrderDao.findClientUserById(userId);
        Order order = new Order();
        //设置订单门店和用户信息
        order.setOrderCode(StringUtil.getCommonCode(2));
        order.setStoresCode(stores.getStoresCode());
        order.setStoresAddress(stores.getProvincesName()+stores.getCityName()+stores.getCountyName()+stores.getStoresAddress());
        order.setStoresName(stores.getStoresName());
        order.setStoresBossCode(stores.getStoresBossCode());
        order.setClientUserPhone(clientUser.getPhone());
        order.setClientUserName(clientUser.getUserName());
        order.setClientUserCode(userId);
        order.setPayStatus(1);
        double sum = 0;
        int goodssum=0;
        //设置商品到订单详细
        for(int i=0;i<goodsCodeList.size();i++){
            Goods goods = appOrderDao.findGoodsById(goodsCodeList.get(i));
            //判断是否有库存
            if(goods.getStock()<Integer.parseInt(goodsNum.get(i))){
                return AppResponse.bizError(goods.getGoodsName()+"库存不足");
            }
            OrderNotes orderNotes = new OrderNotes();
            orderNotes.setOrderNotesCode(StringUtil.getCommonCode(2));
            orderNotes.setOrderCode(order.getOrderCode());
            orderNotes.setGoodsCode(goodsCodeList.get(i));
            orderNotes.setGoodsName(goods.getGoodsName());
            orderNotes.setImagePath(goods.getGoodsImage());
            orderNotes.setPrice(goods.getPrice());
            orderNotes.setAmount(goodsNum.get(i));
            orderNotes.setAllPrice(goods.getPrice()*Integer.parseInt(goodsNum.get(i)));
            orderNotes.setGoodsNotes(goods.getGoodsNotes());
            //添加订单详情
            int countordernotes = appOrderDao.addOrderNotes(orderNotes);
            if(countordernotes == 0){
                return AppResponse.bizError("订单详情失败,购买失败");
            }
            //修改商品库存
            int updateStock = appOrderDao.updateGoodsStock(goodsCodeList.get(i),Integer.parseInt(goodsNum.get(i)));
            if(updateStock == 0){
                return AppResponse.bizError("修改库存失败，购买失败");
            }
            sum = sum + orderNotes.getAllPrice();
            goodssum =goodssum + Integer.parseInt(goodsNum.get(i));
        }
        //设置订单总价
        order.setOrderAllPrice(String.valueOf(sum));
        //订单商品总数量
        order.setGoodsSum(goodssum);
        int count = appOrderDao.addOrder(order);
        if(count == 0){
            return AppResponse.bizError("订单添加失败，购买失败");
        }
        //删除购物车的已完成下单
        appOrderDao.deleteShopCar(goodsCodeList);
        return AppResponse.success("购买成功");
    }

    /**
     * app订单列表查询
     * @param orderStatus
     * @return
     */
    public AppResponse listOrder(Integer orderStatus,String userId){
        List<Order> orderList = appOrderDao.listOrderByPage(orderStatus,userId);
        return AppResponse.success("订单列表查询成功",getPageInfo(orderList));
    }
    /**
     * 修改订单状态
     * @param order
     * @param
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderStatus(Order order){
        int count = appOrderDao.updateOrderStatus(order);
        if(count == 0){
            return AppResponse.bizError("修改失败");
        }
        return AppResponse.success("修改成功");
    }

    /**
     * 查看订单详情
     * @param ordercode
     * @return
     */
    public AppResponse findOrderById(Order ordercode){
        Order order = appOrderDao.findOrderById(ordercode);
        if (order == null){
            return AppResponse.bizError("订单详细查询失败");
        }
        return AppResponse.success("查询成功",order);
    }

    /**
     * 添加评价
     * @param judge
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addJudge(Judge judge){
        //设置照片集合
        List<JudgeImage> judgeImageList = new ArrayList<>();
        for(int i = 0;i<judge.getJudgeMgeLists().size();i++){
            judge.getJudgeMgeLists().get(i).setJudgeCode(StringUtil.getCommonCode(2));
            JudgeMgeList judgeMge =judge.getJudgeMgeLists().get(i);
            for(int j = 0;j<judgeMge.getJudgeImages().size();j++){
                JudgeImage judgeImage = judgeMge.getJudgeImages().get(j);
                judgeImage.setImageCode(StringUtil.getCommonCode(2));
                judgeImage.setJudgeCode(judgeMge.getJudgeCode());
                judgeImageList.add(judgeImage);
            }
            //设置差中好评标志
            if(judge.getJudgeMgeLists().get(i).getJudgeLevel() == 1){
                judge.getJudgeMgeLists().get(i).setJudgeGoodsLevel(1);
            }else if(judge.getJudgeMgeLists().get(i).getJudgeLevel() == 2 || judge.getJudgeMgeLists().get(i).getJudgeLevel() == 3){
                judge.getJudgeMgeLists().get(i).setJudgeGoodsLevel(3);
            }else if(judge.getJudgeMgeLists().get(i).getJudgeLevel() == 4 || judge.getJudgeMgeLists().get(i).getJudgeLevel() == 5){
                judge.getJudgeMgeLists().get(i).setJudgeGoodsLevel(5);
            }
            //获取商品评价的总个数和总星级
            List<JudgeMgeList> allGoodsJudge = appOrderDao.countAllGoodsJudge(judge.getJudgeMgeLists().get(i).getGoodsCode());
            double sum = 0;
            //计算总分（总星级)
            for(int m = 0;m<allGoodsJudge.size();m++){
                sum = sum+allGoodsJudge.get(m).getJudgeLevel();
            }
            //计算平均（评价平均分）星级
            double goodsJudgeSum = sum/allGoodsJudge.size();
            //更新商品星级
            int countGoodsJudge = appOrderDao.updateGoodsLevel(judge.getJudgeMgeLists().get(i).getGoodsCode(),goodsJudgeSum);
            if(countGoodsJudge == 0){
                return AppResponse.bizError("更新评价星级失败");
            }
        }
        //添加商品信息
        int addJudgeCount = appOrderDao.addJudge(judge);
        if(addJudgeCount != judge.getJudgeMgeLists().size()){
            return AppResponse.bizError("评价失败1");
        }
        //添加图片
        int addImageCount = appOrderDao.addJudgeImage(judgeImageList);
        if(addImageCount != judgeImageList.size()){
            return AppResponse.bizError("评价失败2");
        }
        //修改评价后商品状态
        Order order = new Order();
        order.setOrderCode(judge.getOrderCode());
        order.setUserId(judge.getUserId());
        order.setOrderStatus(4);
        int countStatus = appOrderDao.updateOrderStatus(order);
        if(countStatus == 0){
            return AppResponse.bizError("评价失败3");
        }
        return AppResponse.success("评价成功");
    }

    /**
     * 查询订单评价商品信息列表
     * @param orderCode
     * @param userId
     * @return
     */
    public AppResponse listGoodsToJudge(String orderCode,String userId){
        List<OrderNotes> orderNotesList = appOrderDao.listGoodsToJudge(orderCode,userId);
        return AppResponse.success("查询订单评价商品信息列表成功",orderNotesList);
    }
}
