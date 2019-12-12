package com.boc.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.boc.api.ApiResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 对返回结果统一处理，简化controller层返回代码
 * @author st-wg-hzw14176
 *
 */
@RestControllerAdvice
public class ResponseBodyHandler implements ResponseBodyAdvice<Object>{
	
	private ThreadLocal<ObjectMapper> loacl=ThreadLocal.withInitial(ObjectMapper::new);
	
	private Logger logger=LoggerFactory.getLogger(ResponseBodyHandler.class);

	@Override
	public Object beforeBodyWrite(Object arg0, MethodParameter arg1, MediaType mediaType,
			Class<? extends HttpMessageConverter<?>> arg3, ServerHttpRequest arg4, ServerHttpResponse response) {
		String path=arg4.getURI().getPath();
		//判断是否是swagger2 ，如果是需要页面显示不做拦截 
		if(path.equals("/configuration/ui")||path.equals("/swagger-resources")||path.equals("/v2/api-docs")) {
			return arg0;
		}
		
		if(arg0 instanceof ApiResult) {
			//不做处理
		}else if(arg0 instanceof String) {
			//string 需要做特殊处理
			response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
			arg0=ApiResult.success(arg0);
			try {
				arg0=loacl.get().writeValueAsString(arg0);
			} catch (JsonProcessingException e) {
				//基本不会出现
				logger.error("ResponseBodyHandler error",e);
			}
		}else {
			arg0=ApiResult.success(arg0);
		}
		return arg0;
	}

	@Override
	public boolean supports(MethodParameter arg0, Class<? extends HttpMessageConverter<?>> arg1) {
		return true;
	}


}
