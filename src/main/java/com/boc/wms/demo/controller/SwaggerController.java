package com.boc.wms.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author st-wg-hzw14176
 *
 */
@RestController
@Api(tags = "这是一个测试接口")
public class SwaggerController {

	@ApiOperation(value="这是一个测试接口-1",httpMethod="GET") // 接口描述
	@ApiImplicitParam(name = "id", value = "用户id", defaultValue = "1", required = true)
	@GetMapping("/swa1")
	public String test1(String id) {
		return id;
	}

	@ApiOperation("这是一个测试接口-2") // 接口描述
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "1", required = true),
			@ApiImplicitParam(name = "name", value = "用户 名字", defaultValue = "1") })
	@GetMapping("/swa2")
	public String test2(String id, String name) {
		return name;
	}
	
	@ApiOperation("这是一个测试接口-3") // 接口描述
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "1", required = true),
			@ApiImplicitParam(name = "name", value = "用户 名字", defaultValue = "1") })
	@PostMapping("/swa3")
	public String test3(String id, String name) {
		return id+name;
	}

}
