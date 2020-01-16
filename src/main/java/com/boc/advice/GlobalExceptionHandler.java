package com.boc.advice;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.boc.api.ApiResultCode;
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
			if(ex.getCode().equals(ApiResultCode.PARAMS_RETURN_NULL.getCode())) {
				//controller返回参数为空返回正常
				return ApiResult.fail(ApiResultCode.SUCCESS);
			}
			return ApiResult.fail(ex.getCode(), ex.getMessage());
		} else {
			return ApiResult.fail(ApiResultCode.COMMON_ERROR.getCode(), ex.getMessage());
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
		return ApiResult.fail(ApiResultCode.PARAMS_ERROR.getCode(), "参数检验异常:"+ex.getMessage());
	}
	
	/**
	 * 404异常
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = NoHandlerFoundException.class)
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public ApiResult noHandlerFoundException( NoHandlerFoundException ex) {
		logger.error("", ex);
		return ApiResult.fail("404", "请求资源路径"+ex.getRequestURL()+"不存在!");
	}
	
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ApiResult missingServletRequestParameter( MissingServletRequestParameterException ex) {
		logger.error("", ex);
		return ApiResult.fail(ApiResultCode.PARAMS_ERROR.getCode(), "参数检验异常:"+ex.getMessage());
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
		return ApiResult.fail(ApiResultCode.SYSTEM_ERROR);
	}

}
