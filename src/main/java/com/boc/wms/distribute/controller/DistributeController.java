package com.boc.wms.distribute.controller;


import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boc.api.ApiResult;
import com.boc.wms.distribute.domain.Distribute;
import com.boc.wms.distribute.service.DistributeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 数据分发策略模块controller
 * 
 * @author wq3643 X04
 *
 */
@RestController
@Api(tags = "数据分发策略模块接口")
@RequestMapping("/distribute")
@Validated
public class DistributeController {
	@Autowired
	private DistributeService distributeService;

	
	@RequestMapping("/queryDistribution")
	@ApiOperation(value = "查询数据分发策略")
	@ApiImplicitParams({ @ApiImplicitParam(name = "orgCode", value = "机构号"),
		@ApiImplicitParam(name = "provCode", value = "省行号") })
	
	public Object getUserList(@RequestParam(value = "orgCode") String orgCode,
			@RequestParam(value = "provCode") String provCode,
			@RequestParam(value = "orgLvl") String orgLvl,
			@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		Page<Distribute> page = new Page<>(currentPage, pageSize);
		Distribute d = new Distribute();
		d.setProvCode(provCode);
		d.setOrgLvl(orgLvl);
		page = distributeService.queryDistribution(page, d);
		return page;
	}
	
	@RequestMapping("/setDistribution")
	@ApiOperation(value = "设置数据分发策略")
	public ApiResult setDistribution(@RequestParam("user") String jsonDistribute,
			@RequestParam(value = "provCode") String provCode) {
		Distribute d = JSONObject.parseObject(jsonDistribute, Distribute.class);
		distributeService.setDistribution(d);
		return ApiResult.success();
	}
	
}
