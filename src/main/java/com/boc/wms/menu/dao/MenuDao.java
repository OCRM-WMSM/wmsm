package com.boc.wms.menu.dao;

import com.boc.mapper.MenuMapper;
import com.boc.wms.menu.domain.db.MenuDb;
import com.boc.wms.menu.domain.entity.MenuEntity;
import com.google.common.collect.Lists;
import io.jsonwebtoken.lang.Collections;

import javax.annotation.Resource;
import java.util.List;

public class MenuDao {

    @Resource
    private MenuMapper menuMapper;

    public List<MenuEntity> listMenuEntityByIdList(List<Integer> menuIdList) {
        if(Collections.isEmpty(menuIdList)){
            return Lists.newArrayList();
        }
        List<MenuDb> menuDbList = menuMapper.selectBatchIds(menuIdList);

        return Lists.newArrayList();

    }

}
