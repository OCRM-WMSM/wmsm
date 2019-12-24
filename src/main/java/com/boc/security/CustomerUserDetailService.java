package com.boc.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomerUserDetailService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//TODO 这里还没有查询数据库，先写个例子
		List<GrantedAuthority> list=new ArrayList<>();
		list.add(new SimpleGrantedAuthority("admin"));
		return new AuthUser("hzw", "$2a$10$Fx38CQAk4aKUkvmD6lvske9C/K8oaGR77zntafv59z08TizqW0tlG", list);
	}

}
