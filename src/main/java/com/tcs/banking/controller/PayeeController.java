package com.tcs.banking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.banking.model.Customer;

@RestController
@RequestMapping("/")
public class PayeeController {

//	@GetMapping(path="/payee/{id}")
//	public Customer getCustomer(@PathVariable int id) {
//		return coustomerService.getCustomer(id);
//	}
	
//	@PostMapping(path="/saveAccount", consumes = "application/json", produces = "application/json")
//	public int addPayee(@RequestBody Customer customer) {
//		return coustomerService.addCustomer(customer);
//	}
}
