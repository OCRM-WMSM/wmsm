package com.boc.api;

/**
 * 错误码定义
 * 
 * @author st-wg-hzw14176
 *
 */
public enum ApiError {
	SUCCESS("0", "success"), // 成功
	/** 系统异常 */
	SYSTEM_ERROR("500", "系统异常"),
	/** 数据库操作异常 */
	DATABASE_ERROR("-98", "数据库操作异常"),
	/**统一异常*/
	COMMON_ERROR("-1", "系统异常"),
	/**参数校验异常*/
	PARAMS_ERROR("-9", "参数异常"),
	/**controller返回参数为空异常*/
	PARAMS_RETURN_NULL("-999", "返回参数异常"),
	/**未登录*/
	LOGIN_NO("-11", "未登录"),
	/**登录失败*/
	LOGIN_FAIL("-12", "登录失败"),
	/**无权限*/
	AUTH_NO("300", "没有权限"),
	/**token过期*/
	TOKEN_EXPIRE("301", "token 过期"),
	/**token解析出错*/
	TOKEN_ERROR("302", "token解析出错,非法token");

	private String message;
	private String code;

	private ApiError(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
