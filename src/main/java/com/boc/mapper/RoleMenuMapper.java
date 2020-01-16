package com.boc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boc.wms.menu.domain.db.RoleMenuDb;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMenuMapper extends BaseMapper<RoleMenuDb> {
}
