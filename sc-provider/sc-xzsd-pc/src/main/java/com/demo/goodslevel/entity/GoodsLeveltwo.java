package com.demo.goodslevel.entity;

import java.util.Date;
import java.util.List;

public class GoodsLeveltwo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 登录用户id
     */
    private String userId;
    /**
     * 登录用户角色
     */
    private int role;
    /**
     * 分类编码
     */
    private String levelCode;
    /**
     * 分类名称
     */
    private String levelName;

    /**
     * 上级编码
     */
    private String parentLevelCode;
    /**
     * 上级名称
     */
    private String parentLeveLName;
    /**
     * 是否为一级 0是 1不是
     */
    private int isParent;
    /**
     * 备注
     */
    private String levelNotes;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
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

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getParentLevelCode() {
        return parentLevelCode;
    }

    public void setParentLevelCode(String parentLevelCode) {
        this.parentLevelCode = parentLevelCode;
    }

    public String getParentLeveLName() {
        return parentLeveLName;
    }

    public void setParentLeveLName(String parentLeveLName) {
        this.parentLeveLName = parentLeveLName;
    }

    public int getIsParent() {
        return isParent;
    }

    public void setIsParent(int isParent) {
        this.isParent = isParent;
    }

    public String getLevelNotes() {
        return levelNotes;
    }

    public void setLevelNotes(String levelNotes) {
        this.levelNotes = levelNotes;
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
