package com.dhirajb7.UnderstandNewSpringSecurity.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dhirajb7.UnderstandNewSpringSecurity.security.user.UserInfo;

public class UserInfoToUserDetails implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String pwd;
	private List<GrantedAuthority> authorities;

	public UserInfoToUserDetails(UserInfo userInfo) {
		this.name = userInfo.getUsername();
		this.pwd = userInfo.getPassword();
		this.authorities = Arrays.stream(userInfo.getRoles().split(","))
						   .map(a-> new SimpleGrantedAuthority(a))
						   .collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.pwd;
	}

	@Override
	public String getUsername() {
		return this.name;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
