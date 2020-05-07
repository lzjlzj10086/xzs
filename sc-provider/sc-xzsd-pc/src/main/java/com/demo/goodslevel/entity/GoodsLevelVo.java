package com.demo.goodslevel.entity;

/**
 * <p>商品实体类返回类</p>
 * <p>创建日期：2020-05-05</p>
 *
 * @author 梁子杰
 */
public class GoodsLevelVo {

    /**
     * 分类编号
     */
    private String levelCode;
    /**
     * 分类名称
     */
    private String levelName;
    /**
     * 备注
     */
    private String levelNotes;
    /**
     * 是否为一级 0是 1不是
     */
    private int isParent;

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

    public String getLevelNotes() {
        return levelNotes;
    }

    public void setLevelNotes(String levelNotes) {
        this.levelNotes = levelNotes;
    }

    public int getIsParent() {
        return isParent;
    }

    public void setIsParent(int isParent) {
        this.isParent = isParent;
    }
}
