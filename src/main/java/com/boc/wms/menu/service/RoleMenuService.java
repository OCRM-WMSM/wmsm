package com.boc.wms.menu.service;

import com.boc.wms.menu.domain.entity.RoleMenuAggre;

import java.util.List;

public interface RoleMenuService {

    /**
     *
     * @param roleId
     * @return
     */
    List<RoleMenuAggre> listRoleMenuByRoleId(Integer roleId);
}
