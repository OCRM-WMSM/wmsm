package com.boc.wms.menu.domain.entity;

import java.util.List;

public class RoleMenuAggre {
    private Integer roleId;

    private List<MenuEntity> menuList;

    public RoleMenuAggre(Integer roleId, List<MenuEntity> menuList) {
        this.roleId = roleId;
        this.menuList = menuList;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<MenuEntity> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuEntity> menuList) {
        this.menuList = menuList;
    }
}
