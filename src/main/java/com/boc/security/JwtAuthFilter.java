package com.boc.security;

import com.boc.api.ApiResult;
import com.boc.api.ApiResultCode;
import com.boc.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 每次请求都加上security权限验证
 * 
 * @author st-wg-hzw14176
 *
 */
@Component
public class JwtAuthFilter extends OncePerRequestFilter {

	private static ObjectMapper mapper = new ObjectMapper();

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		Map<String, Object> tokenParse = null;
		try {
			tokenParse = JwtUtil.validateTokenAndGetClaims(request);
		} catch (Exception e) {
			if (e instanceof ExpiredJwtException) {
				// token 过期
				ApiResult a = new ApiResult(ApiResultCode.TOKEN_EXPIRE);
				response.setContentType("application/json,charset=utf-8");
				response.getWriter().write(mapper.writeValueAsString(a));
			} else {
				// token 验证不通过
				ApiResult a = new ApiResult(ApiResultCode.TOKEN_ERROR);
				response.setContentType("application/json,charset=utf-8");
				response.getWriter().write(mapper.writeValueAsString(a));
			}
			return;
		}

		if (tokenParse != null) {
			String username = tokenParse.get("username").toString();
			List<String> roleList = (List<String>) tokenParse.get("roles");
			List<GrantedAuthority> roles = roleList.stream().map(x -> new SimpleGrantedAuthority(x))
					.collect(Collectors.toList());
			// 如果jwt解析出账号信息，说明是合法用户，设置认证信息，认证通过
			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, null,
						roles);
				auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				// 设置认证信息
				SecurityContextHolder.getContext().setAuthentication(auth);
			}

		}
		filterChain.doFilter(request, response);

	}

}
