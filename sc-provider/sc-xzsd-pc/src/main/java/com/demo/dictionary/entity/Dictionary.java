package com.demo.dictionary.entity;

/**
 * <p>省市区实体类</p>
 * <p>创建日期：2020-05-05</p>
 *
 * @author 梁子杰
 */
public class Dictionary {

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
