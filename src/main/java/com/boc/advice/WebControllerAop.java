package com.boc.advice;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 主要用于controller打印日志
 * 
 * @author st-wg-hzw14176
 *
 */
@Aspect
@Component
public class WebControllerAop {
	private Logger logger = LoggerFactory.getLogger(getClass());

	// 记录花费时间
	private ThreadLocal<Long> startTime = new ThreadLocal<Long>();
    
	/**
	 * 切入点，需要在此配置
	 */
	@Pointcut("execution(* com.boc.wms.*.controller.*.*(..))")
	public void webLog() {

	}
   
	/**
	 * 前置
	 * @param point
	 */
	@Before("webLog()")
	public void doBefore(JoinPoint point) {
		logger.info("===============start==================");
		startTime.set(System.currentTimeMillis());
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		Signature signature = point.getSignature();
		logger.info("IP : " + request.getRemoteAddr());
		logger.info("URL : " + request.getRequestURL().toString());
		logger.info("HTTP_METHOD : " + request.getMethod());
		logger.info("CLASS_NAME : " + signature.getDeclaringTypeName() + "." + signature.getName());
		MethodSignature ms=(MethodSignature)signature;
		String[] ps=ms.getParameterNames();//参数名字
		Object[] args=point.getArgs();//参数值
		//参数名字：参数值 加一起输出
		String[] params=new String[ps.length];
		if(ps!=null||ps.length>0) {
			for(int i=0;i<ps.length;i++) {
				params[i]=ps[i]+":"+args[i];
			}
		}
		logger.info("ARGS : " + Arrays.toString(params));
	}
    
	/**
	 * 后置
	 * @param ret
	 */
	@AfterReturning(pointcut = "webLog()", returning = "ret")
	public void doAfterReturning(Object ret) {
		logger.info("RESPONSE : " + ret);
		logger.info("Spend Time : " + (System.currentTimeMillis() - startTime.get()));
		logger.info("===============end==================");
		logger.info("");
	}

}
