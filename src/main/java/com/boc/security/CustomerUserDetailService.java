package com.boc.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.boc.common.annotation.DataSource;
import com.boc.common.enums.DataSourceEnum;
import com.boc.wms.user.mapper.UserMapper;
import com.boc.wms.user.vo.Employee;

/**
 * 用户登陆后security调用此接口查询用户进行密码验证
 * 
 * @author st-wg-hzw14176
 *
 */
@Service
public class CustomerUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	@DataSource(DataSourceEnum.DB1)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee user=userMapper.findUserById(username);
		if(user==null) {
			throw new UsernameNotFoundException("该用户不存在");
		}
		return new AuthUser(user);
	}

}
