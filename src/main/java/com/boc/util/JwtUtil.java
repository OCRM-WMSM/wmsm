package com.boc.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
/**
 * jwt 加解密工具
 * @author st-wg-hzw14176
 *
 */
@Component
public class JwtUtil {
	/**token 时长 （单位秒）*/
	private static final Long expiration=1800l; 
    
	/**密钥*/
	private static String secret="12345678*&^%$#@!";

	private final static String TOKEN_PREFIX = "Bearer";

	private final static String HEADER_STRING = "Authorization";

	/**
	 * 生成token
	 * 
	 * @param claims
	 * @return
	 */
	public static String generateToken(Map<String, Object> claims) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.SECOND, expiration.intValue());
		Date d = c.getTime();
		String token = Jwts.builder().setClaims(claims).setExpiration(d).signWith(SignatureAlgorithm.HS512, secret)
				.compact();
		return token;
	}

	/**
	 * 验证token并且获取被加密信息
	 * 
	 * @param request
	 * @return
	 */
	public static Map<String, Object> validateTokenAndGetClaims(HttpServletRequest request) {
		String token = request.getHeader(HEADER_STRING);
		if (token == null) {
			return null;
		}
		Map<String, Object> body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
				.getBody();
		return body;

	}

}
