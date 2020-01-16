package com.boc.wms.common;


import com.boc.wms.menu.domain.entity.RoleMenuAggre;
import com.boc.wms.menu.service.RoleMenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boc.api.ApiError;
import com.boc.api.ApiResult;

import javax.annotation.Resource;
import java.util.List;

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

//		List<RoleMenuAggre> roleMenuAggreList = roleMenuService.listRoleMenuByRoleId(11222);
		return new ApiResult(ApiError.LOGIN_NO);
	}
    

}
