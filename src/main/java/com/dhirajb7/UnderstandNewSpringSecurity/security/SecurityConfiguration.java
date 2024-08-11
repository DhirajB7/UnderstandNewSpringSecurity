package com.dhirajb7.UnderstandNewSpringSecurity.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	
//	In Memory way to do stuffs better is JDBC[user,authorites] written on top
//	@Bean
//	InMemoryUserDetailsManager userDetailsManager() {
//
//		UserDetails john = User.builder().username("john").password("{noop}test123").roles("EMPLOYEE").build();
//		UserDetails mary = User.builder().username("mary").password("{noop}test123").roles("EMPLOYEE", "MANAGER")
//				.build();
//		UserDetails susan = User.builder().username("susan").password("{noop}test123")
//				.roles("EMPLOYEE", "MANAGER", "ADMIN").build();
//
//		return new InMemoryUserDetailsManager(john, mary, susan);
//
//	}

//	thats it, things happen from DB
	@Bean
	UserDetailsManager userDetailsManager(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(config -> config.requestMatchers(HttpMethod.GET, "/emp/").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.GET, "/emp/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "/emp/").hasRole("MANAGER").requestMatchers(HttpMethod.PUT, "/emp/")
				.hasRole("MANAGER").requestMatchers(HttpMethod.DELETE, "/emp/**").hasRole("ADMIN"));

		http.httpBasic(Customizer.withDefaults());

		http.csrf(a -> a.disable());

		return http.build();

	}



}
