package com.demo.goods.entity;

import java.util.Date;

public class Goods {
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
     * 商品编号
     */
    private String goodsCode;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 书号
     */
    private String bookId;
    /**
     * 作者
     */
    private String write;
    /**
     * 一级编号
     */
    private String firstLevelCode;
    /**
     * 一级名称
     */
    private String firstLevelName;
    /**
     * 二级编号
     */
    private String secondLevelCode;
    /**
     * 二级名称
     */
    private String secondLevelName;
    /**
     * 广告词
     */
    private String advertisement;
    /**
     * 商品介绍
     */
    private String goodsNotes;
    /**
     * 商家编号
     */
    private String shopCode;
    /**
     * 商品名称
     */
    private String shopName;
    /**
     * 库存
     */
    private int stock;
    /**
     * 售价
     */
    private double price;
    /**
     * 原定价
     */
    private double costPrice;
    /**
     * 商品照片
     */
    private String goodsImage;
    /**
     * 商品状态 0上架 1下架
     */
    private int goodsStatus;
    /**
     * 上架时间
     */
    private Date upTime;
    /**
     * 下架时间
     */
    private Date donwTime;
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

    public String getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(String advertisement) {
        this.advertisement = advertisement;
    }

    public String getFirstLevelName() {
        return firstLevelName;
    }

    public void setFirstLevelName(String firstLevelName) {
        this.firstLevelName = firstLevelName;
    }

    public String getSecondLevelName() {
        return secondLevelName;
    }

    public void setSecondLevelName(String secondLevelName) {
        this.secondLevelName = secondLevelName;
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

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getWrite() {
        return write;
    }

    public void setWrite(String write) {
        this.write = write;
    }

    public String getFirstLevelCode() {
        return firstLevelCode;
    }

    public void setFirstLevelCode(String firstLevelCode) {
        this.firstLevelCode = firstLevelCode;
    }

    public String getSecondLevelCode() {
        return secondLevelCode;
    }

    public void setSecondLevelCode(String secondLevelCode) {
        this.secondLevelCode = secondLevelCode;
    }

    public String getGoodsNotes() {
        return goodsNotes;
    }

    public void setGoodsNotes(String goodsNotes) {
        this.goodsNotes = goodsNotes;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public int getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(int goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public Date getDonwTime() {
        return donwTime;
    }

    public void setDonwTime(Date donwTime) {
        this.donwTime = donwTime;
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
