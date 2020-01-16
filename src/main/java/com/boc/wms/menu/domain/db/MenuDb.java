package com.boc.wms.menu.domain.db;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("ocrm_menu")
public class MenuDb {
    //菜单Id
    @TableId(value = "menu_id")
    private Integer menuId;
    //菜单名称
    private String menuName;
    //菜单对应的URL
    private String menuUrl;
    //菜单的有效性，1-有效，0-无效
    @TableLogic(value = "1")
    private Integer valid;
    //创建人employeeId
    private Integer createEmp;
    //创建时间
    private Date createDate;
    //更新人的employeeId
    private Integer updateEmp;
    //更新时间
    private Date updateDate;

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

    public Integer getCreateEmp() {
        return createEmp;
    }

    public void setCreateEmp(Integer createEmp) {
        this.createEmp = createEmp;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getUpdateEmp() {
        return updateEmp;
    }

    public void setUpdateEmp(Integer updateEmp) {
        this.updateEmp = updateEmp;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
