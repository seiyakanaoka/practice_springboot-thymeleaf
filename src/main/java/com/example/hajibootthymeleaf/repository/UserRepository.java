package com.example.hajibootthymeleaf.repository;

import com.example.hajibootthymeleaf.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
