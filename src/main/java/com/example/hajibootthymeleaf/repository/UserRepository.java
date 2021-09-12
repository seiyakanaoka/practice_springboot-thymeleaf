package com.example.hajibootthymeleaf.repository;

import com.example.hajibootthymeleaf.domain.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
	User findOne(String username);
}
