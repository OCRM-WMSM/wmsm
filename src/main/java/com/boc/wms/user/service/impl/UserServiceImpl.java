package com.boc.wms.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.boc.api.ApiError;
import com.boc.common.annotation.DataSource;
import com.boc.common.enums.DataSourceEnum;
import com.boc.exception.BusException;
import com.boc.wms.user.mapper.UserMapper;
import com.boc.wms.user.service.UserService;
import com.boc.wms.user.vo.Employee;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private UserMapper userMapper;
    
	@DataSource(DataSourceEnum.DB1)
	@Override
	public Employee findUserById(String userId) {
		try {
			return userMapper.findUserById(userId);
		} catch (Exception e) {
			logger.error("",e);
			throw new BusException(ApiError.DATABASE_ERROR);
		}

	}
    
	@DataSource(DataSourceEnum.DB1)
	@Override
	public void updateUserById(Employee employee) {
		try {
			userMapper.updateUserById(employee);
		} catch (Exception e) {
			logger.error("",e);
			throw new BusException(ApiError.DATABASE_ERROR);
		}

	}
    
	@DataSource(DataSourceEnum.DB1)
	@Override
	public void resetUserPwd(String userId, String password) {
		try {
			BCryptPasswordEncoder bc= new BCryptPasswordEncoder();
			userMapper.resetUserPwdById(userId, bc.encode(DigestUtils.md5DigestAsHex(password.getBytes())));
		} catch (Exception e) {
			logger.error("",e);
			throw new BusException(ApiError.DATABASE_ERROR);
		}
		
	}

}
