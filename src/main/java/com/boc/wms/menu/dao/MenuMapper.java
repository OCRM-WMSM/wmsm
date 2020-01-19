package com.boc.wms.menu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boc.wms.menu.domain.db.MenuDb;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper extends BaseMapper<MenuDb> {
}
