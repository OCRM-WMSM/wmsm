package com.boc.wms.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.boc.wms.user.vo.Employee;

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
	public Employee updateUserById(Employee employee);

}
