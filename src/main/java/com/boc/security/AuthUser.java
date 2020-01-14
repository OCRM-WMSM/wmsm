package com.boc.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.boc.wms.user.vo.Employee;

public class AuthUser implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	
	private String password;
	
	private List<GrantedAuthority> list;
	
	private Employee employee;
    
	
	
	public AuthUser(String username, String password, List<GrantedAuthority> list) {
		super();
		this.username = username;
		this.password = password;
		this.list = list;
	}
	
	public AuthUser(Employee employee) {
		super();
		this.username = employee.getName();
		this.password = employee.getEmpPwd();
		//目前一个用户只有一个角色
		List<GrantedAuthority> l=new ArrayList<GrantedAuthority>();
		l.add(new SimpleGrantedAuthority(employee.getEmpRole()));//需要这样加前缀
		this.list = l;
		this.employee=employee;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.list;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	

}
