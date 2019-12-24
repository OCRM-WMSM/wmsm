package com.boc.wms.common;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boc.api.ApiError;
import com.boc.api.ApiResult;

@RestController
public class LoginController {

	/**
	 * 模仿login登陆界面，当用户未登陆时提示需要登录
	 * 
	 * @return
	 */
	@RequestMapping("/loginPage")
	public ApiResult loginPage() {
		return new ApiResult(ApiError.LOGIN_NO);
	}
    

}
