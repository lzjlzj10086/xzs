package com.demo.hotgoods.entity;

import java.util.Date;
/**
 * <p>热门商品实体类</p>
 * <p>创建日期：2020-05-05</p>
 *
 * @author 梁子杰
 */
public class HotGoods {
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
    private  int role;
    /**
     * 热门位编号
     */
    private String hotCode;

    /**
     * 展示数量
     */
    private String number;
    /**
     * 排序
     */
    private String hotSort;
    /**
     *热门商品编号
     */
    private String goodsCode;
    /**
     *商品名称
     */
    private String goodsName;
    /**
     *商品价格
     */
    private Double goodsPrice;
    /**
     *商品介绍
     */
    private String goodsNotes;
    /**
     * 商品图片
     */
    private String goodsImage;
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

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getHotCode() {
        return hotCode;
    }

    public void setHotCode(String hotCode) {
        this.hotCode = hotCode;
    }

    public String getHotSort() {
        return hotSort;
    }

    public void setHotSort(String hotSort) {
        this.hotSort = hotSort;
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

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsNotes() {
        return goodsNotes;
    }

    public void setGoodsNotes(String goodsNotes) {
        this.goodsNotes = goodsNotes;
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
