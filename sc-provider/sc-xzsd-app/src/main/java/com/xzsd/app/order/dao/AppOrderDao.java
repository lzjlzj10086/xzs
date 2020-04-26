package com.xzsd.app.order.dao;

import com.xzsd.app.goods.entity.Goods;
import com.xzsd.app.goods.entity.GoodsJudge;
import com.xzsd.app.order.entity.*;
import com.xzsd.app.register.entity.ClientUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AppOrderDao {
    /**
     * 检查用户是否绑定的门店
     * @param userId
     * @return
     */
    String countInviteCode(String userId);
    /**
     * 添加订单
     * @param order
     * @return
     */
    int addOrder(Order order);

    /**
     * 添加订单详情
     * @param orderNotes
     * @return
     */
    int addOrderNotes(OrderNotes orderNotes);

    /**
     * 查询客户所绑定的门店
     * @param userId
     * @return
     */
    Stores findStoresByUserId(String userId);

    /**
     * 查询所下单客户信息
     * @param userId
     * @return
     */
    ClientUser findClientUserById(String userId);

    /**
     * 查询所下订单商品的详情
     * @param goodsCode
     * @return
     */
    Goods findGoodsById(String goodsCode);

    /**
     * 修改商品库存
     * @param goodsCode
     * @param stock
     * @return
     */
    int updateGoodsStock(@Param("goodsCode") String goodsCode,@Param("stock") int stock);

    /**
     * 删除下单的购物车商品
     * @param goodsCode
     * @return
     */
    int deleteShopCar(@Param("goodsCode") List<String> goodsCode);
    /**
     * 订单列表
     * @param orderStatus
     * @return
     */
    List<Order> listOrderByPage(@Param("orderStatus") Integer orderStatus, @Param("userId") String userId);

    /**
     * 修改订单状态
     * @param order
     * @param
     * @return
     */
    int updateOrderStatus(Order order);

    /**
     * 查询订单详情
     * @param order
     * @return
     */
    Order findOrderById(Order order);

    /**
     * 添加订单评价
     * @param judge
     * @return
     */
    int addJudge(Judge judge);

    /**
     * 添加评价图片
     * @param judgeImageList
     * @return
     */
    int addJudgeImage(@Param("judgeImageList") List<JudgeImage> judgeImageList);

    /**
     * 查询订单评价商品信息列表接口
     * @param orderCode
     * @param userId
     * @return
     */
    List<OrderNotes> listGoodsToJudge(@Param("orderCode")String orderCode,@Param("userId") String userId);
}
