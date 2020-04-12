package com.demo.goods.entity;

import java.util.Date;

public class GoodsVo {

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
     * 一级名称
     */
    private String firstLevelName;
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
     * 商品状态 0上架 1下架
     */
    private int goodsStatus;
    /**
     * 上架时间
     */
    private Date upTime;


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

    public String getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(String advertisement) {
        this.advertisement = advertisement;
    }

    public String getGoodsNotes() {
        return goodsNotes;
    }

    public void setGoodsNotes(String goodsNotes) {
        this.goodsNotes = goodsNotes;
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
}
