package com.boc.wms.menu.dao;

import com.boc.mapper.RoleMenuMapper;
import com.boc.wms.menu.domain.db.RoleMenuDb;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class RoleMenuDao {

    @Resource
    private RoleMenuMapper roleMenuMapper;

    public List<Integer> listMenuIdByRoleId(Integer roleId) {
        Map<String,Object> cond = Maps.newHashMapWithExpectedSize(1);
        cond.put("role_id",roleId);
        List<RoleMenuDb> roleMenuDbList= roleMenuMapper.selectByMap(cond);
        return roleMenuDbList.stream().map(RoleMenuDb::getMenuId).collect(Collectors.toList());
    }
}
