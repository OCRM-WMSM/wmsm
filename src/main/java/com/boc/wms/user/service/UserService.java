package com.boc.wms.user.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.boc.wms.user.domain.Employee;
import com.boc.wms.user.domain.Role;

/**
 * 用户管理服务接口
 * 
 * @author st-wg-hzw14176
 *
 */
public interface UserService extends IService<Employee>{
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
