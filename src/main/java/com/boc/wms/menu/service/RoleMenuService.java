package com.boc.wms.menu.service;

import com.boc.wms.menu.domain.entity.RoleMenuAggre;

import java.util.List;

public interface RoleMenuService {

    /**
     * 根据角色ID获取该角色能操作的所有菜单功能
     * @param roleId
     * @return
     */
    RoleMenuAggre getRoleMenuByRoleId(Integer roleId);
}
