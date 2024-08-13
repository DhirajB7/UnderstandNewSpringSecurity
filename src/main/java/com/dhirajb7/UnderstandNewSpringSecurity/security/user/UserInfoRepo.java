package com.dhirajb7.UnderstandNewSpringSecurity.security.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepo extends JpaRepository<UserInfo, Integer> {

	Optional<UserInfo> findByUsername(String username);

}
