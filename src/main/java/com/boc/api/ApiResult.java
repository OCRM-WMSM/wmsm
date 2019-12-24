package com.boc.api;

/**
 * 对返回数据统一封装
 * 
 * @author st-wg-hzw14176
 *
 */
public class ApiResult {

	private String code;

	private String msg;

	private Object data;

	public ApiResult() {

	}

	public ApiResult(ApiError apiError) {
		this.code = apiError.getCode();
		this.msg = apiError.getMessage();
	}
	
	public ApiResult(ApiError apiError,Object data) {
		this.code = apiError.getCode();
		this.msg = apiError.getMessage();
		this.data=data;
	}

	public ApiResult(String code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public ApiResult(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static ApiResult success(Object data) {
		ApiResult apiResult = new ApiResult(ApiError.SUCCESS);
		if(data!=null) {
			apiResult.setData(data);
		}
		return apiResult;
	}
	
	public static ApiResult success() {
		ApiResult apiResult = new ApiResult(ApiError.SUCCESS);
		return apiResult;
	}

	public static ApiResult fail(String code, String msg) {
		ApiResult apiResult = new ApiResult(code, msg);
		return apiResult;
	}
	
	public static ApiResult fail(ApiError apiError) {
		ApiResult apiResult = new ApiResult(apiError);
		return apiResult;
	}

}
