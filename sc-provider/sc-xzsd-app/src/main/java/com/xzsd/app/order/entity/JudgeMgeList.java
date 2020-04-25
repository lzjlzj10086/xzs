package com.xzsd.app.order.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 评价信息实体类
 */
public class JudgeMgeList  {
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
    private String userCode;
    private String orderCode;
    /**
     * 评价编码
     */
    private String judgeCode;
    /**
     * 订单商品编码
     */
    private String goodsCode;
    /**
     * 评价内容
     */
    private String judgeContent;
    /**
     * 评价星级
     */
    private int judgeLevel;
    /**
     * 评价时间
     */
    private String judgeTime;
    /**
     * 商品评价标志(1差评2，3中评4,5好评)
     */
    private int judgeGoodsLevel;
    /**
     * 评价图片集合
     */
    private List<JudgeImage> judgeImages;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getJudgeCode() {
        return judgeCode;
    }

    public void setJudgeCode(String judgeCode) {
        this.judgeCode = judgeCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getJudgeContent() {
        return judgeContent;
    }

    public void setJudgeContent(String judgeContent) {
        this.judgeContent = judgeContent;
    }

    public int getJudgeLevel() {
        return judgeLevel;
    }

    public void setJudgeLevel(int judgeLevel) {
        this.judgeLevel = judgeLevel;
    }

    public int getJudgeGoodsLevel() {
        return judgeGoodsLevel;
    }

    public void setJudgeGoodsLevel(int judgeGoodsLevel) {
        this.judgeGoodsLevel = judgeGoodsLevel;
    }

    public String getJudgeTime() {
        return judgeTime;
    }

    public void setJudgeTime(String judgeTime) {
        this.judgeTime = judgeTime;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public List<JudgeImage> getJudgeImages() {
        return judgeImages;
    }

    public void setJudgeImages(List<JudgeImage> judgeImages) {
        this.judgeImages = judgeImages;
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
