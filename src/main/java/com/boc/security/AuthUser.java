package com.boc.security;

import com.boc.wms.user.domain.Employee;
import com.boc.wms.user.domain.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 权限认证用户
 * 
 * @author st-wg-hzw14176
 *
 */
public class AuthUser implements UserDetails {

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
		List<GrantedAuthority> l = new ArrayList<GrantedAuthority>();
		List<Role> roles = employee.getRoles();
		if (roles == null || roles.size() == 0) {
			l.add(new SimpleGrantedAuthority("null"));// 默认没有角色
		} else {
			l = roles.stream().map(x -> new SimpleGrantedAuthority(x.getRoleCode())).collect(Collectors.toList());
		}
		this.list = l;
		this.employee = employee;
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
