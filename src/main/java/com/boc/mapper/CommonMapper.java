package com.boc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.boc.wms.common.domain.DwBocBchLvlEntity;

@Mapper
public interface CommonMapper {

	/**
	 * 查询所有的机构
	 * 
	 * @param orgNo
	 * @return
	 */
	List<DwBocBchLvlEntity> selectAllDwBocBchLvlList();

}
