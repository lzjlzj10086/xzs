package com.xzsd.app.order.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.goods.entity.Goods;
import com.xzsd.app.order.dao.AppOrderDao;
import com.xzsd.app.order.entity.Order;
import com.xzsd.app.order.entity.OrderNotes;
import com.xzsd.app.order.entity.Stores;
import com.xzsd.app.register.entity.ClientUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class AppOrderService {

    @Resource
    private AppOrderDao appOrderDao;

    @Transactional(rollbackFor = Exception.class)
    public AppResponse addOrder(String goodsCode,String amount,String userId){
        List<String> goodsCodeList = Arrays.asList(goodsCode.split(","));
        List<String> goodsNum = Arrays.asList(amount.split(","));
        Stores stores = appOrderDao.findStoresByUserId(userId);
        ClientUser clientUser = appOrderDao.findClientUserById(userId);
        Order order = new Order();
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
        for(int i=0;i<goodsCodeList.size();i++){
            Goods goods = appOrderDao.findGoodsById(goodsCodeList.get(i));
            OrderNotes orderNotes = new OrderNotes();
            orderNotes.setOrderNotesCode(StringUtil.getCommonCode(2));
            orderNotes.setOrderCode(order.getOrderCode());
            orderNotes.setGoodsCode(goodsCodeList.get(i));
            orderNotes.setGoodsName(goods.getGoodsName());
            orderNotes.setIamgePath(goods.getGoodsImage());
            orderNotes.setPrice(goods.getPrice());
            orderNotes.setAmount(goodsNum.get(i));
            orderNotes.setAllPrice(goods.getPrice()*Integer.parseInt(goodsNum.get(i)));
            orderNotes.setGoodsNotes(goods.getGoodsNotes());
            appOrderDao.addOrderNotes(orderNotes);
            sum = sum + orderNotes.getAllPrice();
        }
        order.setOrderAllPrice(String.valueOf(sum));
        appOrderDao.addOrder(order);
        return AppResponse.success("新增订单成功");
    }
}
