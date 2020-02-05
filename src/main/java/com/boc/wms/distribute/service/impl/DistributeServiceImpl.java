package com.boc.wms.distribute.service.impl;


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
import com.boc.wms.distribute.domain.Distribute;
import com.boc.wms.distribute.mapper.DistributeMapper;
import com.boc.wms.distribute.service.DistributeService;

@Transactional
@Service
public class DistributeServiceImpl extends ServiceImpl<DistributeMapper, Distribute> implements DistributeService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private DistributeMapper distributeMapper;


	@DataSource(DataSourceEnum.DB1)
	@Override
	public void setDistribution(Distribute distribute) {
		try {
			distributeMapper.setDistribution(distribute);
		} catch (Exception e) {
			logger.error("", e);
			throw new BusException(ApiResultCode.DATABASE_ERROR);
		}

	}

	@Override
	public Page<Distribute> queryDistribution(Page<Distribute> page, Distribute distribute) {
		try {
			return distributeMapper.queryDistribution(page, distribute);
		} catch (Exception e) {
			logger.error("", e);
			throw new BusException(ApiResultCode.DATABASE_ERROR);
		}
	}

}
