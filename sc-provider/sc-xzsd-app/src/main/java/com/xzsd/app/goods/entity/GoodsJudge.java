package com.xzsd.app.goods.entity;

import java.util.Date;
import java.util.List;

/**
 * 商品评价实体类
 */
public class GoodsJudge {
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
     * 每一条评价的编号
     */
    private String judgeCode;
    /**
     * 评价客户编号
     */
    private String userCode;
    /**
     * 评级客户账号
     */
    private String userAcct;
    /**
     *所评价商品的编号
     */
    private String goodsCode;
    /**
     * 评价的图片
     */
    private String imageUrl;
    /**
     *评价星级（1-5,1差评2-3中评4-5好评）
     */
    private int starLevel;
    /**
     *评价内容
     */
    private String content;
    /**
     *评价时间
     */
    private String judgeTime;
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

    public String getJudgeCode() {
        return judgeCode;
    }

    public void setJudgeCode(String judgeCode) {
        this.judgeCode = judgeCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(int starLevel) {
        this.starLevel = starLevel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getJudgeTime() {
        return judgeTime;
    }

    public void setJudgeTime(String judgeTime) {
        this.judgeTime = judgeTime;
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
