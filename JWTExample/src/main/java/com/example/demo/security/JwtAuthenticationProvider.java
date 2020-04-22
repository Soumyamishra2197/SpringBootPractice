package com.example.demo.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.demo.model.JwtAuthenticationToken;
import com.example.demo.model.JwtUser;
import com.example.demo.model.JwtUserDetails;
@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider{

	@Autowired 
	JwtValidator validator;

	@Override
	public boolean supports(Class<?> authentication) {
		
		return JwtAuthenticationToken.class.isAssignableFrom(authentication);
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		JwtAuthenticationToken jwtAuthenticationtoken=(JwtAuthenticationToken)authentication;
		String token=jwtAuthenticationtoken.getToken();
		JwtUser jwtUser= validator.validate(token);
		
		if(jwtUser==null) {
			throw new RuntimeException("JWT token is incorrect");
		}
		
		List<GrantedAuthority> grantedAuthorities=AuthorityUtils.commaSeparatedStringToAuthorityList(jwtUser.getRole());
		
		return new JwtUserDetails(jwtUser.getUserName(),token,jwtUser.getId(),grantedAuthorities);
		
		
		
	}

}
