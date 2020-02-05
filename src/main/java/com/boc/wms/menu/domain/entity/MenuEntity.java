package com.boc.wms.menu.domain.entity;

public class MenuEntity {
    //菜单Id
    private Integer menuId;
    //菜单名称
    private String menuName;
    //菜单对应的URL
    private String menuUrl;
    //菜单的有效性，1-有效，0-无效
    private Integer valid;


    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}
