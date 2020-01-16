package com.boc.wms.menu.domain.convertor;

import com.boc.wms.menu.domain.db.MenuDb;
import com.boc.wms.menu.domain.entity.MenuEntity;
import com.google.common.collect.Lists;
import io.jsonwebtoken.lang.Collections;

import java.util.List;
import java.util.stream.Collectors;

public class MenuDecorateConvertor implements  MenuConvertor{

    private final MenuConvertor delegate;

    public MenuDecorateConvertor(MenuConvertor delegate) {
        this.delegate = delegate;
    }


    @Override
    public MenuEntity menuDb2Entity(MenuDb menuDb) {
        return delegate.menuDb2Entity(menuDb);
    }

    @Override
    public List<MenuEntity> menuDbList2EntityList(List<MenuDb> menuDbList) {
        if(Collections.isEmpty(menuDbList)){
            return Lists.newArrayList();
        }
        return menuDbList.stream().map(t->this.menuDb2Entity(t)).collect(Collectors.toList());
    }
}
