package com.boc.exception;

import com.boc.api.ApiResultCode;

public class BusException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;

	public BusException(String code, String message) {
		super("【code:" + code + "】" + message);
		this.code = code;
	}

	public BusException(ApiResultCode apiError) {
		super("【code:" + apiError.getCode() + "】" + apiError.getMessage());
		this.code = apiError.getCode();
	}

	public BusException(String message) {
		super(message);
	}

	public BusException(Throwable e) {
		super(e);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return super.toString();
	}


}
