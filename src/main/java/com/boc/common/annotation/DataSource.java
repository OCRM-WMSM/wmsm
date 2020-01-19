package com.boc.common.annotation;

import com.boc.common.enums.DataSourceEnum;

import java.lang.annotation.*;
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
