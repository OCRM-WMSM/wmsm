package com.boc.wms.common.controller;


import com.boc.api.ApiResult;
import com.boc.api.ApiResultCode;
import com.boc.wms.menu.service.RoleMenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {

	@Resource
	private RoleMenuService roleMenuService;

	/**
	 * 模仿login登陆界面，当用户未登陆时提示需要登录
	 * 
	 * @return
	 */
	@RequestMapping("/loginPage")
	public ApiResult loginPage() {

//		RoleMenuAggre roleMenuAggre = roleMenuService.getRoleMenuByRoleId(11222);
		return new ApiResult(ApiResultCode.LOGIN_NO);
	}


}
