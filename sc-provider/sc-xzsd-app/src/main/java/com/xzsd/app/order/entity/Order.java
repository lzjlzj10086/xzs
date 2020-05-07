package com.xzsd.app.order.entity;

import java.util.Date;
import java.util.List;
/**
 * <p>订单实体类</p>
 * <p>创建日期：2020-05-05</p>
 *
 * @author 梁子杰
 */
public class Order {

    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 登录用户ID
     */
    private String userId;
    /**
     * 登录用户角色
     */
    private int role;
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     *订单总价格
     */
    private String orderAllPrice;
    /**
     *订单状态
     */
    private int orderStatus;
    /**
     *支付状态
     */
    private int payStatus;
    /**
     * 门店编码
     */
    private String StoresCode;
    /**
     *门店名称
     */
    private String storesName;
    /**
     *门店地址
     */
    private String storesAddress;
    /**
     *客户编码
     */
    private String clientUserCode;
    /**
     * 客户名称
     */
    private String clientUserName;
    /**
     *客户电话
     */
    private String clientUserPhone;
    /**
     * 门店店长编号
     */
    private String storesBossCode;
    /**
     * 支付时间
     */
    private String payTime;
    /**
     * 商品总数
     */
    private int goodsSum;
    private List<OrderNotes> orderNotesList;
    /**
     * 删除标志 0存在 1删除
     */
    private int isDelete;
    /**
     *创建时间
     */
    private Date createTime;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     *更新者
     */
    private String updateBy;
    /**
     * 版本号
     */
    private String version;

    public List<OrderNotes> getOrderNotesList() {
        return orderNotesList;
    }

    public void setOrderNotesList(List<OrderNotes> orderNotesList) {
        this.orderNotesList = orderNotesList;
    }

    public String getStoresName() {
        return storesName;
    }

    public void setStoresName(String storesName) {
        this.storesName = storesName;
    }

    public String getStoresAddress() {
        return storesAddress;
    }

    public void setStoresAddress(String storesAddress) {
        this.storesAddress = storesAddress;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderAllPrice() {
        return orderAllPrice;
    }

    public void setOrderAllPrice(String orderAllPrice) {
        this.orderAllPrice = orderAllPrice;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(int payStatus) {
        this.payStatus = payStatus;
    }

    public String getStoresCode() {
        return StoresCode;
    }

    public void setStoresCode(String storesCode) {
        StoresCode = storesCode;
    }

    public String getClientUserCode() {
        return clientUserCode;
    }

    public void setClientUserCode(String clientUserCode) {
        this.clientUserCode = clientUserCode;
    }

    public String getClientUserName() {
        return clientUserName;
    }

    public void setClientUserName(String clientUserName) {
        this.clientUserName = clientUserName;
    }

    public String getClientUserPhone() {
        return clientUserPhone;
    }

    public void setClientUserPhone(String clientUserPhone) {
        this.clientUserPhone = clientUserPhone;
    }

    public String getStoresBossCode() {
        return storesBossCode;
    }

    public void setStoresBossCode(String storesBossCode) {
        this.storesBossCode = storesBossCode;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public int getGoodsSum() {
        return goodsSum;
    }

    public void setGoodsSum(int goodsSum) {
        this.goodsSum = goodsSum;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
