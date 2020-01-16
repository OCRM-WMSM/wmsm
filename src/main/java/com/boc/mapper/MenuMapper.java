package com.boc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boc.wms.menu.domain.db.MenuDb;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface MenuMapper extends BaseMapper<MenuDb> {
}
