package com.example.hajibootthymeleaf.repository;

import com.example.hajibootthymeleaf.domain.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	@Query("SELECT x FROM Customer x ORDER BY x.firstName, x.lastName")
	List<Customer> findAllOrderByName();
	@Query("SELECT DISTINCT x FROM Customer x JOIN FETCH x.user ORDER BY x.firstName, x.lastName")
	List<Customer> findAllWithUserOrderByName();
}