package com.boc.wms.demo.entity;

import org.springframework.util.StringUtils;

/**
 * 分页数据封装基类
 * @author st-wg-hjf7526
 *
 */
public class BaseVo {
	// 排序条件
	private String orderBy;
	// 排序方式
	private String sortPatten;
	
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getSortPatten() {
		return sortPatten;
	}
	public void setSortPatten(String sortPatten) {
		this.sortPatten = sortPatten;
	}
	/**
	 * 排序
	 * @param vo
	 * @param sort
	 * @param order
	 */
	public void setOrderCondition(BaseVo vo,String sort,String order){
		if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
			StringBuffer orderBy = new StringBuffer();
			String[] sorts = sort.split(",");
			String[] orders = order.split(",");
			for (int i = 0; i < sorts.length; i++) {
				orderBy.append(sorts[i]).append(" ").append(orders[i]).append(",");
			}
			vo.setOrderBy(orderBy.substring(0, orderBy.length() - 1));
		}
	}
}
