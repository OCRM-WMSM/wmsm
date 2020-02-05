package com.boc.wms.menu.dao;

import com.boc.wms.menu.domain.convertor.MenuConvertor;
import com.boc.wms.menu.domain.db.MenuDb;
import com.boc.wms.menu.domain.entity.MenuEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Repository
public class MenuDao {

    @Resource
    private MenuMapper menuMapper;

    public List<MenuEntity> listMenuEntityByIdList(List<Integer> menuIdList) {
        if(CollectionUtils.isEmpty(menuIdList)){
            return Collections.EMPTY_LIST;
        }
        List<MenuDb> menuDbList = menuMapper.selectBatchIds(menuIdList);
        return MenuConvertor.INSTANCE.menuDbList2EntityList(menuDbList);
    }

}
