package com.demo.util;



public class StoresUtils {

    /**
     * 生成随机邀请码
     * @return
     */
    public static String getStoresInviteCode(){
        String code = "YQM";
        String inviteCode = code+String.valueOf((int)((Math.random()*9+1)*100));
       return inviteCode;
    }

    /**
     * 生成门店账号
     * @return
     */
    public static String getStoresAcct(){
        String code = "MDZ";
        String storesAcct = code+String.valueOf((int)((Math.random()*9+1)*1000));
        return storesAcct;
    }
    public static String getStoresCode(){
        String code = "XZS";
        String storesCode = code+String.valueOf((int)((Math.random()*9+1)*1000));
        return storesCode;
    }

    /**
     * 得到司机编号
     * @return
     */
    public static String getDriverCode(){
        String code = "SJ";
        String driverCode = code+String.valueOf((int)((Math.random()*9+1)*10000));
        return driverCode;
    }
}
