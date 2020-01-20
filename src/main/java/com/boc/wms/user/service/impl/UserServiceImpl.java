package com.boc.wms.user.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boc.api.ApiResultCode;
import com.boc.common.annotation.DataSource;
import com.boc.common.enums.DataSourceEnum;
import com.boc.exception.BusException;
import com.boc.wms.menu.domain.entity.MenuEntity;
import com.boc.wms.user.domain.Employee;
import com.boc.wms.user.domain.Role;
import com.boc.wms.user.mapper.UserMapper;
import com.boc.wms.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, Employee> implements UserService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserMapper userMapper;

	@DataSource(DataSourceEnum.DB1)
	@Override
	public Employee findUserById(String userId) {
		try {
			return userMapper.findUserById(userId);
		} catch (Exception e) {
			logger.error("", e);
			throw new BusException(ApiResultCode.DATABASE_ERROR);
		}

	}

	@DataSource(DataSourceEnum.DB1)
	@Override
	public void updateUserById(Employee employee) {
		try {
			userMapper.updateUserById(employee);
		} catch (Exception e) {
			logger.error("", e);
			throw new BusException(ApiResultCode.DATABASE_ERROR);
		}

	}

	@DataSource(DataSourceEnum.DB1)
	@Override
	public void resetUserPwd(String userId, String password) {
		try {
			//默认重置为用户编号
			if(StringUtils.isEmpty(password)) {
				password=userId;
			}
			BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
			userMapper.resetUserPwdById(userId, bc.encode(DigestUtils.md5DigestAsHex(password.getBytes())));
		} catch (Exception e) {
			logger.error("", e);
			throw new BusException(ApiResultCode.DATABASE_ERROR);
		}

	}

	@DataSource(DataSourceEnum.DB1)
	@Override
	public List<Role> findRolesByUserId(String userId) {
		try {
			return userMapper.findRolesByUserId(userId);
		} catch (Exception e) {
			logger.error("", e);
			throw new BusException(ApiResultCode.DATABASE_ERROR);
		}
	}
    
	@DataSource(DataSourceEnum.DB1)
	@Override
	public Page<Employee> selectUserPageList(Page<Employee> page, Employee user) {
		try {
			return userMapper.selectUserPageList(page, user);
		} catch (Exception e) {
			logger.error("", e);
			throw new BusException(ApiResultCode.DATABASE_ERROR);
		}
	}
    
	@DataSource(DataSourceEnum.DB1)
	@Override
	public List<Map<String,Object>> getUserSelectRoles(String userId) {
		try {
			List<Map<String,Object>> list=new ArrayList<>();
			List<Role> userRoles=userMapper.findRolesByUserId(userId);
			List<Role> allRoles=userMapper.findAllRoles();
			for(Role rall:allRoles) {
				Map<String,Object> map=new HashMap<String, Object>();
				map.put("roleId", rall.getRoleCode());
				map.put("roleName", rall.getRoleName());
				map.put("flag", false);
				for(Role ruser:userRoles) {
					if(rall.getRoleId()==ruser.getRoleId()) {
						//代表具有该角色
						map.put("flag", true);
					}
				}
				list.add(map);
			}
			return list;
		} catch (Exception e) {
			logger.error("", e);
			throw new BusException(ApiResultCode.DATABASE_ERROR);
		}
	}
    
	@DataSource(DataSourceEnum.DB1)
	@Override
	public void updateRoles(String employeeId, List<String> list) {
		try {
			userMapper.deleteRolesByUserId(employeeId);
			if(list==null || list.size()==0) {
				return;
			}
			for(String roleId:list) {
				userMapper.addRolesByUserId(employeeId, Integer.valueOf(roleId));
			}
		} catch (Exception e) {
			logger.error("", e);
			throw new BusException(ApiResultCode.DATABASE_ERROR);
		}
		
	}

	@Override
	public List<MenuEntity> findMenusByRoleId(int roleId) {
		try {
			return userMapper.findMenusByRoleId(roleId);
		} catch (Exception e) {
			logger.error("", e);
			throw new BusException(ApiResultCode.DATABASE_ERROR);
		}
	}

}
