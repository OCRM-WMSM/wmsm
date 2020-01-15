package com.boc.wms.menu.domain.db;

import io.swagger.models.auth.In;

import java.util.Date;

public class RoleMenuDb {
    //角色ID
    private Integer roleId;

    //菜单ID
    private Integer menuId;

    //有效性，1-有效，0-无效
    private Integer valid;

    //更新人的employeeId
    private String  updateEmp;

    //更新时间
    private Date updateDate;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public String getUpdateEmp() {
        return updateEmp;
    }

    public void setUpdateEmp(String updateEmp) {
        this.updateEmp = updateEmp;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
