package com.boc.wms.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boc.wms.menu.domain.entity.MenuEntity;
import com.boc.wms.user.domain.Employee;
import com.boc.wms.user.domain.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


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
	/**
	 * 查询所有角色
	 * @return
	 */
	public List<Role> findAllRoles();
	/**
	 * 删除用户角色
	 * @return
	 */
	public void deleteRolesByUserId(String employeeId);
	/**
	 * 增加用户角色
	 * @param employeeId
	 * @param roleId
	 */
	public void addRolesByUserId(@Param("employeeId")String employeeId,@Param("roleId")int roleId);
	/**
	 * 根据角色查询菜单
	 * @param roleId
	 * @return
	 */
	public List<MenuEntity> findMenusByRoleId(int roleId);

}
