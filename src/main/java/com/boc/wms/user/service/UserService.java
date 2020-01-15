package com.boc.wms.user.service;

import com.boc.wms.user.domain.Employee;

/**
 * 用户管理服务接口
 * 
 * @author st-wg-hzw14176
 *
 */
public interface UserService {
	/**
	 * 根据用户编号查询用户信息
	 * 
	 * @param userId
	 * @return
	 */
	public Employee findUserById(String userId);

	/**
	 * 根据用户编号更新用户
	 * 
	 * @param employee
	 */
	public void updateUserById(Employee employee);

	/**
	 * 密码重置
	 * 
	 * @param userId
	 *            用户编号
	 * @param password
	 *            密码
	 */
	public void resetUserPwd(String userId, String password);

}
