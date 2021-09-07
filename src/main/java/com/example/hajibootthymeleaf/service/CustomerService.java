package com.example.hajibootthymeleaf.service;

import com.example.hajibootthymeleaf.domain.Customer;
import com.example.hajibootthymeleaf.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> findAll() {
		return customerRepository.findAllOrderByName();
	}
	
	public Optional<Customer> findOne(Integer id) {
		return customerRepository.findById(id);
	}
	
	public Customer create(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Customer update(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public void delete(Integer id) {
		customerRepository.deleteById(id);
	}
}
