package com.boc.security;


import com.boc.common.annotation.DataSource;
import com.boc.common.enums.DataSourceEnum;
import com.boc.wms.user.domain.Employee;
import com.boc.wms.user.domain.Role;
import com.boc.wms.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户登陆后security调用此接口查询用户进行密码验证
 * 
 * @author st-wg-hzw14176
 *
 */
@Service
public class CustomerUserDetailService implements UserDetailsService {
	
	
	@Autowired
	private UserService userService;

	@Override
	@DataSource(DataSourceEnum.DB1)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee user=userService.findUserById(username);
		if(user==null) {
			throw new UsernameNotFoundException("该用户不存在");
		}
		//查询角色
		List<Role> roles=userService.findRolesByUserId(username);
		user.setRoles(roles);
		//目前角色暂时选择一个 TODO
		Role role=new Role();
		if(roles.size()>=1) {
			role=roles.get(0);
		}
		user.setCurrentRole(role);
		return new AuthUser(user);
	}

}
