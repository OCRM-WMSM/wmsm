package com.boc.wms.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boc.wms.user.domain.Employee;
import com.boc.wms.user.domain.Role;

@Mapper
public interface UserMapper extends BaseMapper<Employee> {
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

	/**
	 * 通过用户id查询角色
	 * 
	 * @param userId
	 * @return
	 */
	public List<Role> findRolesByUserId(String userId);

	/**
	 * 分页查询用户数据
	 * 
	 * @param page
	 * @param user
	 * @return
	 */
	Page<Employee> selectUserPageList(Page<Employee> page, @Param("employee") Employee user);

}
