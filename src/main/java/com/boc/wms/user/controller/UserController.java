package com.boc.wms.user.controller;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boc.api.ApiResult;
import com.boc.exception.BusException;
import com.boc.wms.user.service.UserService;
import com.boc.wms.user.vo.Employee;

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
@Validated
public class UserController {
	@Autowired
	private UserService userService;

	@ApiOperation("用户修改自己密码")
	@ApiImplicitParams({ @ApiImplicitParam(name = "employeeId", value = "用户编号", required = true),
			@ApiImplicitParam(name = "oldPassword", value = "旧密码", required = true),
			@ApiImplicitParam(name = "newPassword", value = "新密码", required = true),
			@ApiImplicitParam(name = "checkPassword", value = "确认密码", required = true) })
	@PostMapping("/updatePwd")
	public ApiResult updatePwd(@NotEmpty String employeeId, @NotEmpty String oldPassword, @NotEmpty String newPassword,
			@NotEmpty String checkPassword) {
		if(oldPassword.equals(newPassword)) {
			throw new BusException("-1", "新密码不能和旧密码相同！");
		}
		if(!newPassword.equals(checkPassword)) {
			throw new BusException("-2", "新密码和确认密码不相同！");
		}
		Employee e=userService.findUserById(employeeId);
		if(e==null) {
			throw new BusException("-3", "当前用户不存在！");
		}
		if(!oldPassword.equals(e.getEmpPwd())) {
			throw new BusException("-4", "旧密码不正确！");
		}
		e=new Employee();
		e.setEmployeeId(employeeId);
		e.setEmpPwd(DigestUtils.md5DigestAsHex(newPassword.toString().getBytes()));
		userService.updateUserById(e);
		return ApiResult.success();
	}

}
