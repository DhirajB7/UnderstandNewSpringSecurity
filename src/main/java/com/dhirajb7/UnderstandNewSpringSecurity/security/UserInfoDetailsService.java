package com.dhirajb7.UnderstandNewSpringSecurity.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.dhirajb7.UnderstandNewSpringSecurity.security.user.UserInfo;
import com.dhirajb7.UnderstandNewSpringSecurity.security.user.UserInfoRepo;

@Service
public class UserInfoDetailsService implements UserDetailsManager {
	
	@Autowired
	private UserInfoRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<UserInfo> userInfo = repo.findByUsername(username);
		
		if(userInfo.isPresent()) {
			return new UserInfoToUserDetails(userInfo.get());
		}else {
			return (UserDetails) new UsernameNotFoundException(username);
		}

	}

	@Override
	public void createUser(UserDetails user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
