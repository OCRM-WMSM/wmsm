package com.boc.wms.common.service;
/**
 * 公用的service方法
 * @author st-wg-hzw14176
 *
 */

import java.util.List;

import com.boc.wms.common.domain.OrgTreeEntity;

public interface CommonService {

	/**
	 * 查询机构树
	 * 
	 * @param orgNo
	 *            如果为空则查询所有，不为空查询该机构
	 * @return
	 */
	List<OrgTreeEntity> findOrgTree(String orgNo);

}
