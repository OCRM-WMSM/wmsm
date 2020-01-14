package com.boc.wms.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boc.api.ApiResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 用户管理模块controller
 * 
 * @author st-wg-hzw14176
 *
 */
@RestController
@Api(tags = "用户管理模块接口")
@RequestMapping("/user")
public class UserController {

	@ApiOperation("用户修改自己密码")
	@ApiImplicitParams({ @ApiImplicitParam(name = "employeeId", value = "用户编号", required = true),
			@ApiImplicitParam(name = "oldPassword", value = "旧密码", required = true),
			@ApiImplicitParam(name = "newPassword", value = "新密码", required = true),
			@ApiImplicitParam(name = "checkPassword", value = "确认密码", required = true) })
	@PostMapping("/resetPwd")
	public ApiResult test3(String oldPassword, String newPassword, String checkPassword) {
		System.out.println(
				"oldPassword:" + oldPassword + "  newPassword:" + newPassword + " checkPassword" + checkPassword);
		return ApiResult.success();
	}

}
