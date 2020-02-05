package com.boc.wms.menu.service.impl;

import com.boc.wms.menu.dao.MenuDao;
import com.boc.wms.menu.dao.RoleMenuDao;
import com.boc.wms.menu.domain.entity.MenuEntity;
import com.boc.wms.menu.domain.entity.RoleMenuAggre;
import com.boc.wms.menu.service.RoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    @Resource
    private MenuDao menuDao;

    @Resource
    private RoleMenuDao roleMenuDao;

    @Override
    public RoleMenuAggre getRoleMenuByRoleId(Integer roleId) {
        if(null == roleId){
            return null;
        }
        List<Integer> menuIdList = roleMenuDao.listMenuIdByRoleId(roleId);
        if(CollectionUtils.isEmpty(menuIdList)){
            return null;
        }
        List<MenuEntity> menuEntityList = menuDao.listMenuEntityByIdList(menuIdList);
        if(CollectionUtils.isEmpty(menuEntityList)){
            return null;
        }
        RoleMenuAggre roleMenuAggre = new RoleMenuAggre(roleId,menuEntityList);
        return roleMenuAggre;
    }
}
