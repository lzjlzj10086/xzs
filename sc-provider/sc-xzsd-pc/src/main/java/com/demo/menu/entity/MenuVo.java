package com.demo.menu.entity;
/**
 * <p>菜单实体类返回类</p>
 * <p>创建日期：2020-05-05</p>
 *
 * @author 梁子杰
 */
public class MenuVo {

    private String menuCode;

    private String menuName;

    private String menuUrl;

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
