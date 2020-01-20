package com.boc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boc.wms.blacklist.domain.BlacklistStat;

@Mapper
public interface BlacklistMapper extends BaseMapper<BlacklistStat> {
	/**
	 * 分页查询用户上传黑名单状态
	 * 
	 * @param page
	 * @param blacklistStat
	 * @return
	 */
	Page<BlacklistStat> selectBlacklistStatePageList(Page<BlacklistStat> page,
			@Param("blacklistState") BlacklistStat blacklistStat);

}
