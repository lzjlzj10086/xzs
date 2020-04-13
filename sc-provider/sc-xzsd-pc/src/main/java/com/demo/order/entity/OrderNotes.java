package com.demo.order.entity;

import java.util.Date;

public class OrderNotes {
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
     * 订单详情编号
     */
    private String orderNotesCode;
    /**
     *订单编号
     */
    private String orderCode;
    /**
     *商品编号
     */
    private String goodsCode;
    /**
     *商品名称
     */
    private String goodsName;
    /**
     *商品图片路径
     */
    private String IamgePath;
    /**
     *商品总数
     */
    private String amount;
    /**
     *客户编号
     */
    private String clientUserCode;
    /**
     *门店编号
     */
    private String storesCode;
    /**
     *门店名称
     */
    private String storesName;
    /**
     *门店地址
     */
    private String storesAddress;
    /**
     *支付状态
     */
    private int payStatus;
    /**
     *商品价格
     */
    private double price;
    /**
     *商品总价格
     */
    private double allPrice;
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

    public String getOrderNotesCode() {
        return orderNotesCode;
    }

    public void setOrderNotesCode(String orderNotesCode) {
        this.orderNotesCode = orderNotesCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getIamgePath() {
        return IamgePath;
    }

    public void setIamgePath(String iamgePath) {
        IamgePath = iamgePath;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getClientUserCode() {
        return clientUserCode;
    }

    public void setClientUserCode(String clientUserCode) {
        this.clientUserCode = clientUserCode;
    }

    public String getStoresCode() {
        return storesCode;
    }

    public void setStoresCode(String storesCode) {
        this.storesCode = storesCode;
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

    public int getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(int payStatus) {
        this.payStatus = payStatus;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(double allPrice) {
        this.allPrice = allPrice;
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
