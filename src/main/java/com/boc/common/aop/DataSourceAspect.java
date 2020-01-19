package com.boc.common.aop;

import com.boc.common.annotation.DataSource;
import com.boc.common.multiple.DataSourceContextHolder;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/**
 * 数据源aop
 * @author st-wg-hjf7526
 * Order设置足够小是为了让它先执行
 */
@Component
@Aspect
@Order(-100)
public class DataSourceAspect {
	@Pointcut("@within(com.boc.common.annotation.DataSource) || @annotation(com.boc.common.annotation.DataSource)")
	public void pointCut() {
		
	}
	@Before("pointCut() && @annotation(dataSource)")
	public void preHandle(DataSource dataSource) {
		System.out.println("当前数据源为==================="+dataSource.value().getValue());
		DataSourceContextHolder.setDataSource(dataSource.value().getValue());
	}
	@After("pointCut()")
	public void afterHandle() {
		DataSourceContextHolder.clear();
	}
}
