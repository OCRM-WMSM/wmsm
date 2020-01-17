package com.boc.wms.user.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boc.api.ApiResult;
import com.boc.exception.BusException;
import com.boc.wms.menu.domain.entity.MenuEntity;
import com.boc.wms.menu.domain.entity.RoleMenuAggre;
import com.boc.wms.menu.service.RoleMenuService;
import com.boc.wms.user.domain.Employee;
import com.boc.wms.user.domain.Role;
import com.boc.wms.user.service.UserService;

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
	@Autowired
	private RoleMenuService roleMenuService;

	@ApiOperation("用户修改自己密码")
	@ApiImplicitParams({ @ApiImplicitParam(name = "employeeId", value = "用户编号", required = true),
			@ApiImplicitParam(name = "oldPassword", value = "旧密码", required = true),
			@ApiImplicitParam(name = "newPassword", value = "新密码", required = true),
			@ApiImplicitParam(name = "checkPassword", value = "确认密码", required = true) })
	@PostMapping("/updatePwd")
	public ApiResult updatePwd(@NotEmpty String employeeId, @NotEmpty String oldPassword, @NotEmpty String newPassword,
			@NotEmpty String checkPassword) {
		if (oldPassword.equals(newPassword)) {
			throw new BusException("-1", "新密码不能和旧密码相同！");
		}
		if (!newPassword.equals(checkPassword)) {
			throw new BusException("-2", "新密码和确认密码不相同！");
		}
		Employee e = userService.findUserById(employeeId);
		if (e == null) {
			throw new BusException("-3", "当前用户不存在！");
		}
		// 验证密码是否正确，数据库存得密码是对用户密码md5后在进行BCrypt加密的
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		if (!BCrypt.checkpw(DigestUtils.md5DigestAsHex(oldPassword.getBytes()), e.getEmpPwd())) {
			throw new BusException("-4", "旧密码不正确！");
		}
		e = new Employee();
		e.setEmployeeId(employeeId);
		e.setEmpPwd(bc.encode(DigestUtils.md5DigestAsHex(newPassword.getBytes())));
		userService.updateUserById(e);
		return ApiResult.success();
	}

	@ApiOperation("重置用户密码")
	@ApiImplicitParams({ @ApiImplicitParam(name = "employeeId", value = "用户编号", required = true),
			@ApiImplicitParam(name = "password", value = "密码", required = true) })
	@PostMapping("/resetPwd")
	public ApiResult resetPwd(@NotEmpty String employeeId, @NotEmpty String password) {
		userService.resetUserPwd(employeeId, password);
		return ApiResult.success();
	}

	@ApiOperation("查询用户所有菜单")
	@ApiImplicitParams({ @ApiImplicitParam(name = "employeeId", value = "用户编号", required = true) })
	@PostMapping("/getAllMenus")
	public ApiResult getAllMenus(@NotEmpty String employeeId) {
		List<Role> roles = userService.findRolesByUserId(employeeId);
		List<MenuEntity> menus = new ArrayList<>();
		for (Role role : roles) {
			RoleMenuAggre r = roleMenuService.getRoleMenuByRoleId(role.getRoleId());
			List<MenuEntity> ms = r.getMenuList();
			menus.addAll(ms);
		}
		// 去重
		menus = menus.stream()
				.collect(Collectors.collectingAndThen(
						Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(MenuEntity::getMenuId))),
						ArrayList::new));
		return ApiResult.success(menus);
	}

	@RequestMapping("/getUserList")
	@ApiOperation(value = "查询用户list")
	public Object getUserList(@RequestParam("user") String jsonUser,
			@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
			@RequestParam(value = "currentPage", defaultValue = "10") int pageSize) {
		Employee e=JSONObject.parseObject(jsonUser, Employee.class);
		Page<Employee> page = new Page<>(currentPage, pageSize);
		page = userService.selectUserPageList(page, e);
		List<Employee> list=page.getRecords();
		for(Employee emp:list) {
			List<Role> roles = userService.findRolesByUserId(emp.getEmployeeId());
			emp.setRoles(roles);
		}
		return page;
	}
	

}
