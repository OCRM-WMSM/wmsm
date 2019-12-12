package com.boc.advice;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boc.api.ApiError;
import com.boc.api.ApiResult;
import com.boc.exception.BusException;

/**
 * 全局异常统一处理，restcontroller 和 controller的异常都在此统一处理
 * 
 * @author st-wg-hzw14176
 *
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(ResponseBodyHandler.class);

	@ExceptionHandler(value = BusException.class)
	public ApiResult busExceptionHandler(BusException ex) {
		logger.error("", ex);
		if (ex.getCode() != null && !"".equals(ex.getCode())) {
			return ApiResult.fail(ex.getCode(), ex.getMessage());
		} else {
			return ApiResult.fail(ApiError.COMMON_ERROR.getCode(), ex.getMessage());
		}
	}

	/**
	 * 参数校验异常 
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ApiResult constraintViolationExceptionHandler(ConstraintViolationException ex) {
		logger.error("", ex);
		return ApiResult.fail(ApiError.PARAMS_ERROR.getCode(), "参数检验异常:"+ex.getMessage());
	}
	
	/**
	 * 参数校验异常-为空检验
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ApiResult missingServletRequestParameter( MissingServletRequestParameterException ex) {
		logger.error("", ex);
		return ApiResult.fail(ApiError.PARAMS_ERROR.getCode(), "参数检验异常:"+ex.getMessage());
	}

	/**
	 * Exception异常处理
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)
	public ApiResult exceptionHandler(Exception ex) {
		logger.error("", ex);
		return ApiResult.fail(ApiError.SYSTEM_ERROR);
	}

}
