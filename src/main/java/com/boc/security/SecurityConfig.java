package com.boc.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.boc.api.ApiError;
import com.boc.api.ApiResult;
import com.boc.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 权限配置
 * 
 * @author st-wg-hzw14176
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启 security注解可以在controller上配置权限
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private JwtAuthFilter  jwtAuthFilter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		http.csrf().disable()// 跨域伪造请求限制
		         .cors().and()// 开启跨域共享
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()// 去掉session
				.httpBasic().authenticationEntryPoint(new AuthenticationEntryPoint() {

					@Override
					public void commence(HttpServletRequest arg0, HttpServletResponse arg1,
							AuthenticationException arg2) throws IOException, ServletException {
						arg1.setContentType("application/json,charset=utf-8");
						// 未登录处理
						ApiResult a = new ApiResult(ApiError.LOGIN_NO);
						arg1.getWriter().write(mapper.writeValueAsString(a));
					}
				}).and().authorizeRequests().antMatchers("/demo/*").permitAll()
				.antMatchers("/favicon.ico", "/swagger**/**", "/*/api-docs", "/webjars/**").permitAll() // swagger允许访问
				.anyRequest().authenticated()

				.and().formLogin()// 登录处理
				.successHandler(new AuthenticationSuccessHandler() {
					@Override
					public void onAuthenticationSuccess(HttpServletRequest arg0, HttpServletResponse arg1,
							Authentication arg2) throws IOException, ServletException {
						// 登录成功处理
						AuthUser user= (AuthUser) arg2.getPrincipal();
						//生成token返回
						Map<String,Object> claims=new HashMap<>();
						//暂时放用户名进去
						claims.put("username", user.getUsername());
						String token=JwtUtil.generateToken(claims);
						ApiResult a = new ApiResult("0", "登录成功");
						//返回数据
						Map<String,Object> data=new HashMap<>();
						data.put("token", token);
						a.setData(data);
						arg1.setContentType("application/json,charset=utf-8");
						arg1.getWriter().write(mapper.writeValueAsString(a));
					}
				}).failureHandler(new AuthenticationFailureHandler() {

					@Override
					public void onAuthenticationFailure(HttpServletRequest arg0, HttpServletResponse arg1,
							AuthenticationException arg2) throws IOException, ServletException {
						arg1.setContentType("application/json,charset=utf-8");
						// 登录失败处理
						ApiResult a = new ApiResult(ApiError.LOGIN_FAIL);
						arg1.getWriter().write(mapper.writeValueAsString(a));
					}
				}).loginProcessingUrl("/login").usernameParameter("username").passwordParameter("password")
				.loginPage("/loginPage").permitAll().and().logout().logoutSuccessHandler(new LogoutSuccessHandler() {

					@Override
					public void onLogoutSuccess(HttpServletRequest arg0, HttpServletResponse arg1, Authentication arg2)
							throws IOException, ServletException {
						arg1.setContentType("application/json,charset=utf-8");
						// 登出成功处理
						ApiResult a = new ApiResult("0", "登出成功");
						arg1.getWriter().write(mapper.writeValueAsString(a));
					}
				}).permitAll();

		// 无权访问设置
		http.exceptionHandling().accessDeniedHandler(new AccessDeniedHandler() {

			@Override
			public void handle(HttpServletRequest arg0, HttpServletResponse arg1, AccessDeniedException arg2)
					throws IOException, ServletException {
				// 登录失败处理
				ApiResult a = new ApiResult(ApiError.AUTH_NO);
				arg1.getWriter().write(mapper.writeValueAsString(a));

			}
		});
		//加入jwt认证
		http.addFilterAfter(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.userDetailsService(customerUserDetailService()).passwordEncoder(new BCryptPasswordEncoder());
		auth.userDetailsService(customerUserDetailService()).passwordEncoder(new BCryptPasswordEncoder());
	}
	

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public CustomerUserDetailService customerUserDetailService() {
		return new CustomerUserDetailService();
	}
	
	public static void main(String[] args) {
		BCryptPasswordEncoder b=new BCryptPasswordEncoder();
		System.out.println(b.encode("666666"));
	}

}
