package com.dhirajb7.UnderstandNewSpringSecurity.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoRepo repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public String addUser(UserInfo info) {
		info.setPassword(passwordEncoder.encode(info.getPassword()));
		repo.save(info);
		return info.getUsername()+" saved.";
	}
}
