package com.tcs.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.banking.model.Customer;
import com.tcs.banking.model.Payee;
import com.tcs.banking.service.BankService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private BankService bankService;

	@GetMapping(value="/{customerId}")
	public Customer shoeDashBoard(@PathVariable int customerId  ) {
		 return bankService.getCustomer(customerId);
	}
	
	@PostMapping(value="/")
	public Customer AddCustomer(@RequestBody Customer customer) {
		return bankService.addCustomer(customer);
	}
	
	@PostMapping(value="/{customerId}/payee")
	public Customer AddPayee(@RequestBody Payee payee) {
		return bankService.addCustomer(customer);
	}
}
