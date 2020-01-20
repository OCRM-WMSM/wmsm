package com.boc.wms.blacklist.service;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.boc.wms.blacklist.domain.BlacklistStat;

/**
 * 黑名单服务类
 * 
 * @author st-wg-hzw14176
 *
 */
public interface BlacklistService extends IService<BlacklistStat> {

	Page<BlacklistStat> selectBlacklistStatePageList(Page<BlacklistStat> page,
			@Param("blacklistState") BlacklistStat blacklistStat);

}
