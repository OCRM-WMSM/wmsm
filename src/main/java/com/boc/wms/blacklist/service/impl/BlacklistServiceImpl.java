package com.boc.wms.blacklist.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boc.api.ApiResultCode;
import com.boc.common.annotation.DataSource;
import com.boc.common.enums.DataSourceEnum;
import com.boc.exception.BusException;
import com.boc.mapper.BlacklistMapper;
import com.boc.wms.blacklist.domain.BlacklistStat;
import com.boc.wms.blacklist.service.BlacklistService;

@Transactional
@Service
public class BlacklistServiceImpl extends ServiceImpl<BlacklistMapper, BlacklistStat> implements BlacklistService {
	@Autowired
	private BlacklistMapper blacklistMapper;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
    
	@DataSource(DataSourceEnum.DB1)
	@Override
	public Page<BlacklistStat> selectBlacklistStatePageList(Page<BlacklistStat> page, BlacklistStat blacklistStat) {
		try {
			return blacklistMapper.selectBlacklistStatePageList(page, blacklistStat);
		} catch (Exception e) {
			logger.error("", e);
			throw new BusException(ApiResultCode.DATABASE_ERROR);
		}
	}

}
