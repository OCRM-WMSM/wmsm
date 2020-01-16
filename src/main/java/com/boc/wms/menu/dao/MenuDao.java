package com.boc.wms.menu.dao;

import com.boc.mapper.MenuMapper;
import com.boc.wms.menu.domain.db.MenuDb;
import com.boc.wms.menu.domain.entity.MenuEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

public class MenuDao {

    @Resource
    private MenuMapper menuMapper;

    public List<MenuEntity> listMenuEntityByIdList(List<Integer> menuIdList) {
        List<MenuDb> menuDbList = menuMapper.selectBatchIds(menuIdList);
        return null;

    }

}
