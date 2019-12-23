package com.boc.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.boc.common.enums.DataSourceEnum;
/**
 * 数据源接口，aop类的切入点
 * @author st-wg-hjf7526
 *
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
	DataSourceEnum value() default DataSourceEnum.DB1;
}
