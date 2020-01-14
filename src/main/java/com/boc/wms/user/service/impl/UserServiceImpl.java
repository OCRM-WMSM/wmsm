package com.boc.wms.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boc.api.ApiError;
import com.boc.exception.BusException;
import com.boc.wms.user.mapper.UserMapper;
import com.boc.wms.user.service.UserService;
import com.boc.wms.user.vo.Employee;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public Employee findUserById(String userId) {
		try {
			return userMapper.findUserById(userId);
		} catch (Exception e) {
			throw new BusException(ApiError.DATABASE_ERROR);
		}

	}

	@Override
	public void updateUserById(Employee employee) {
		try {
			userMapper.updateUserById(employee);
		} catch (Exception e) {
			throw new BusException(ApiError.DATABASE_ERROR);
		}

	}

}
