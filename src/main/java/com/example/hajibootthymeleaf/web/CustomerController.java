package com.example.hajibootthymeleaf.web;

import com.example.hajibootthymeleaf.domain.Customer;
import com.example.hajibootthymeleaf.service.CustomerService;
import com.example.hajibootthymeleaf.service.LoginUserDetails;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("customers")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@ModelAttribute
	CustomerForm setUpform() {
		return new CustomerForm();
	}
	
	@GetMapping
	String list(Model model) {
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers", customers);
		return "customers/list";
	}
	
	@PostMapping(path = "create")
	String create(@Validated CustomerForm form, BindingResult result, Model model, @AuthenticationPrincipal LoginUserDetails userDetails) {
		if (result.hasErrors()) {
			return list(model);
		}
		Customer customer = new Customer();
		BeanUtils.copyProperties(form, customer);
		customerService.create(customer, userDetails.getUser());
		return "redirect:/customers";
	}
	
	@GetMapping(path = "edit", params = "form")
	String editForm(@RequestParam Integer id, CustomerForm form, Model model) {
		Optional<Customer> customer = customerService.findOne(id);
		BeanUtils.copyProperties(customer, form);
		model.addAttribute("customer", customer);
		return "customers/edit";
	}
	
	@PostMapping(path = "edit")
	String edit(@RequestParam Integer id, @Validated CustomerForm form, BindingResult result, @AuthenticationPrincipal LoginUserDetails userDetails) {
		if (result.hasErrors()) {
			return editForm(id, form, null);
		}
		Customer customer = new Customer();
		BeanUtils.copyProperties(form, customer);
		customer.setId(id);
		customerService.update(customer, userDetails.getUser());
		return "redirect:/customers";
	}
	
	@PostMapping(path = "edit", params = "goToTop")
	String goToTop() {
		return "redirect:/customers";
	}
	
	@PostMapping(path = "delete")
	String delete(@RequestParam Integer id) {
		customerService.delete(id);
		return "redirect:/customers";
	}
}
