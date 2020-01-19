package com.boc.wms.menu.domain.convertor;

import com.boc.wms.menu.domain.db.MenuDb;
import com.boc.wms.menu.domain.entity.MenuEntity;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper()
@DecoratedWith(MenuDecorateConvertor.class)
public interface MenuConvertor {
    MenuConvertor INSTANCE = Mappers.getMapper(MenuConvertor.class);

    MenuEntity menuDb2Entity(MenuDb menuDb);

    List<MenuEntity> menuDbList2EntityList(List<MenuDb> menuDbList);
}
