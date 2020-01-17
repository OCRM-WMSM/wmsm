package com.boc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.boc.wms.common.domain.DwBocBchLvlEntity;

@Mapper
public interface CommonMapper {

	/**
	 * 查询所有的机构
	 * 
	 * @param orgNo
	 * @return
	 */
	List<DwBocBchLvlEntity> selectAllChildrenList(@Param("parentId") String parentId, @Param("orglvl") int orglvl);

	/**
	 * 根据机构id查询机构
	 * 
	 * @return
	 */
	DwBocBchLvlEntity selectAllDwBocBchLvlByOrgId(String orgId);

}
