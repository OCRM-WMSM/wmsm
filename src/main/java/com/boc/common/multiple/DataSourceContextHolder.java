package com.boc.common.multiple;
/**
 * 数据源上下文
 * @author st-wg-hjf7526
 *
 */
public class DataSourceContextHolder {
	private static final ThreadLocal<String> contextHolder=new InheritableThreadLocal<>();
	/**
	 * 设置数据源
	 * @param db
	 */
	public static void setDataSource(String db) {
		contextHolder.set(db);
	}
	/**
	 * 获取数据源
	 * @return
	 */
	public static String getDataSource() {
		return contextHolder.get();
	}
	/**
	 * 清除上下文数据
	 */
	public static void clear() {
		contextHolder.remove();
	}
}
