package com.demo.stores.entity;

import java.util.Date;

public class Stores {

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
     * 门店编号
     */
    private String storesCode;
    /**
     * 门店名称
     */
    private String storesName;
    /**
     *门店详情地址
     */
    private String storesAddress;
    /**
     *店长编号
     */
    private String storesBossCode;
    /**
     *店长名称
     */
    private String storesBossName;
    /**
     *营业编码
     */
    private String openCode;
    /**
     *门店电话
     */
    private String storesPhone;
    private String phone;
    /**
     *门店邀请码
     */
    private String storesInviteCode;
    /**
     *门店账号
     */
    private String storesAcct;
    private String storesProvincesName;
    private String storesCityName;
    private String storesCountyName;
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
    /**
     * 所在省编码
     */
    private String provincesNo;
    /**
     * 所在省名称
     */
    private String provincesName;
    /**
     *所在城市编码
     */
    private String cityNo;
    /**
     *所在城市名称
     */
    private String cityName;
    /**
     *所在区编号
     */
    private String countyNo;
    /**
     *所在区名称
     */
    private String countyName;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public String getStoresProvincesName() {
        return storesProvincesName;
    }

    public void setStoresProvincesName(String storesProvincesName) {
        this.storesProvincesName = storesProvincesName;
    }

    public String getStoresCityName() {
        return storesCityName;
    }

    public void setStoresCityName(String storesCityName) {
        this.storesCityName = storesCityName;
    }

    public String getStoresCountyName() {
        return storesCountyName;
    }

    public void setStoresCountyName(String storesCountyName) {
        this.storesCountyName = storesCountyName;
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

    public String getStoresBossCode() {
        return storesBossCode;
    }

    public void setStoresBossCode(String storesBossCode) {
        this.storesBossCode = storesBossCode;
    }

    public String getStoresBossName() {
        return storesBossName;
    }

    public void setStoresBossName(String storesBossName) {
        this.storesBossName = storesBossName;
    }

    public String getOpenCode() {
        return openCode;
    }

    public void setOpenCode(String openCode) {
        this.openCode = openCode;
    }

    public String getStoresPhone() {
        return storesPhone;
    }

    public void setStoresPhone(String storesPhone) {
        this.storesPhone = storesPhone;
    }

    public String getStoresInviteCode() {
        return storesInviteCode;
    }

    public void setStoresInviteCode(String storesInviteCode) {
        this.storesInviteCode = storesInviteCode;
    }

    public String getStoresAcct() {
        return storesAcct;
    }

    public void setStoresAcct(String storesAcct) {
        this.storesAcct = storesAcct;
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

    public String getProvincesNo() {
        return provincesNo;
    }

    public void setProvincesNo(String provincesNo) {
        this.provincesNo = provincesNo;
    }

    public String getProvincesName() {
        return provincesName;
    }

    public void setProvincesName(String provincesName) {
        this.provincesName = provincesName;
    }

    public String getCityNo() {
        return cityNo;
    }

    public void setCityNo(String cityNo) {
        this.cityNo = cityNo;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountyNo() {
        return countyNo;
    }

    public void setCountyNo(String countyNo) {
        this.countyNo = countyNo;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }
}
