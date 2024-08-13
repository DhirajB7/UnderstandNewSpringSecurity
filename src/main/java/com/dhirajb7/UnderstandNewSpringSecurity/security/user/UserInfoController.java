package com.dhirajb7.UnderstandNewSpringSecurity.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user" )
public class UserInfoController {
	
	@Autowired
	private UserInfoService service;

	
	
}
