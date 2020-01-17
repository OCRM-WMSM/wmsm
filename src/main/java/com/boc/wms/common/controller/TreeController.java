package com.boc.wms.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boc.wms.common.domain.OrgTreeEntity;
import com.boc.wms.common.service.CommonService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 各种树controller
 * 
 * @author st-wg-hzw14176
 *
 */
@RestController
@RequestMapping("/tree")
public class TreeController {

	@Autowired
	private CommonService commonService;

	@ApiOperation("查询机构树")
	@ApiImplicitParams({ @ApiImplicitParam(name = "orgNo", value = "用户编号", required = false) })
	@PostMapping("/orgTree")
	public Object queryOrgTree(String orgNo) {
		List<OrgTreeEntity> list = commonService.findOrgTree(orgNo);
		return list;
	}

}
