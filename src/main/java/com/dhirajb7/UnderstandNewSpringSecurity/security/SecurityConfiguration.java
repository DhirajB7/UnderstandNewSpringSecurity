
package com.dhirajb7.UnderstandNewSpringSecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	
	//password encoder
	@Bean
	 PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//Authentication related - saved in DB
    @Bean
    UserDetailsManager userDetailsManager(PasswordEncoder encoder) {
    	return new UserInfoDetailsService();
	}


	//Authorization  related
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(config -> config
				.requestMatchers(HttpMethod.GET,"/emp/welcome").permitAll()
				.requestMatchers(HttpMethod.GET, "/emp/").hasAnyRole("ADMIN","MANAGER","EMPLOYEE")
				.requestMatchers(HttpMethod.GET, "/emp/**").hasAnyRole("ADMIN","MANAGER","EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "/emp/").hasRole("ADMIN")
				.requestMatchers(HttpMethod.PUT, "/emp/").hasAnyRole("ADMIN","MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/emp/**").hasRole("ADMIN"));

		http.httpBasic(Customizer.withDefaults());

		http.csrf(a -> a.disable());

		return http.build();

	}



}

