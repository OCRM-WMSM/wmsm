package com.boc.wms.user.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boc.api.ApiResultCode;
import com.boc.common.annotation.DataSource;
import com.boc.common.enums.DataSourceEnum;
import com.boc.exception.BusException;
import com.boc.wms.user.domain.Employee;
import com.boc.wms.user.domain.Role;
import com.boc.wms.user.mapper.UserMapper;
import com.boc.wms.user.service.UserService;

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

	@Override
	public Page<Employee> selectUserPageList(Page<Employee> page, Employee user) {
		try {
			return userMapper.selectUserPageList(page, user);
		} catch (Exception e) {
			logger.error("", e);
			throw new BusException(ApiResultCode.DATABASE_ERROR);
		}
	}

}
