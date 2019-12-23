package com.boc.common.multiple;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * 获取数据源
 * @author st-wg-hjf7526
 *
 */
public class MultipleDataSource extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceContextHolder.getDataSource();
	}
	
}
