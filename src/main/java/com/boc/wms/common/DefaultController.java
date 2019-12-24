package com.boc.wms.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 当所有请求路径都找不到时走此路径，目前只处理404异常，后面可以添加其他异常
 * @author st-wg-hzw14176
 *
 */
@Controller
public class DefaultController {
	
	@RequestMapping
	public String error(HttpServletRequest request) throws NoHandlerFoundException {
		throw new NoHandlerFoundException(request.getMethod(),request.getRequestURI(), null);
	}

}
