package com.dhirajb7.UnderstandNewSpringSecurity.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user" )
public class UserInfoController {
	
	@Autowired
	private UserInfoService service;
	
	@PostMapping(path = "/")
	public String addUser(@RequestBody UserInfo userInfo) {
		return service.addUser(userInfo);
	}

	
	
}
