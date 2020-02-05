package com.boc.wms.distribute.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boc.wms.distribute.domain.Distribute;


@Mapper
public interface DistributeMapper extends BaseMapper<Distribute> {

	/**
	 * 设置数据分发策略
	 * 
	 * @param distribute
	 * @return
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
