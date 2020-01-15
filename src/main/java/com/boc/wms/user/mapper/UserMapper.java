package com.boc.wms.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.boc.wms.user.domain.Employee;

@Mapper
public interface UserMapper {
	/**
	 * 根据用户编号查询用户信息
	 * 
	 * @param userId
	 * @return
	 */
	public Employee findUserById(String userId);

	/**
	 * 根据用户id修改用户信息
	 * 
	 * @param employee
	 * @return
	 */
	public void updateUserById(Employee employee);

	/**
	 * 重置用户密码
	 * 
	 * @param userId
	 * @param password
	 */
	public void resetUserPwdById(@Param("employeeId") String userId, @Param("password") String password);

}
