package com.boc.wms.distribute.service;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.boc.wms.distribute.domain.Distribute;

/**
 * 数据分发策略模块接口
 * 
 * @author wq3643 X04 
 *
 */
public interface DistributeService extends IService<Distribute>{

	/**
	 * 设置数据分发策略
	 * 
	 * @param distribute
	 */
	public void setDistribution(Distribute distribute);

	/**
	 * 分页查询当前机构的数据分发策略
	 * 
	 * @param page
	 * @param distribute
	 * @return
	 */
	Page<Distribute> queryDistribution(Page<Distribute> page, @Param("distribute") Distribute distribute);

}
