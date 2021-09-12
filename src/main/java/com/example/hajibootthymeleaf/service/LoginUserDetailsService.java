package com.example.hajibootthymeleaf.service;

import com.example.hajibootthymeleaf.domain.User;
import com.example.hajibootthymeleaf.repository.UserRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class LoginUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findOne(username);
		if(user == null) {
			throw new UsernameNotFoundException("The requested user is not found.");
		}
		return new LoginUserDetails(user);
	}
}
