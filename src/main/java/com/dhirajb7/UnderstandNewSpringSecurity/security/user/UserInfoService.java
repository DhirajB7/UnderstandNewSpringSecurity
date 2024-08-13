package com.dhirajb7.UnderstandNewSpringSecurity.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoRepo repo;
	
}
