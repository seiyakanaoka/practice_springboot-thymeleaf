package com.example.hajibootthymeleaf.service;

import com.example.hajibootthymeleaf.domain.User;
import lombok.Data;

import java.util.Optional;

import org.springframework.security.core.authority.AuthorityUtils;

@Data
public class LoginUserDetails extends org.springframework.security.core.userdetails.User {
	private final Optional<User> user;
	
	public LoginUserDetails(Optional<User> user) {
		super(user.getUsername(), user.getEncodedPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
		this.user = user;
	}
}
