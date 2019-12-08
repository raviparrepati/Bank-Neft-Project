package com.tcs.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.banking.model.AccountSummary;
import com.tcs.banking.model.Customer;
import com.tcs.banking.model.Payee;
import com.tcs.banking.service.BankService;
import com.tcs.banking.utils.OTPGenerator;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private BankService bankService;

	@Autowired
	private OTPGenerator otpGenerator;
	
	@GetMapping(value = "/{customerId}")
	public Customer showDashBoard(@PathVariable int customerId) {
		return bankService.getCustomer(customerId);
	}

	@GetMapping(value = "/")
	public List<Customer> showAllCustomer() {
		return bankService.getAllCustomer();
	}

	@PostMapping(value = "/", consumes = "application/json")
	public Customer AddCustomer(@RequestBody Customer customer) {
		return bankService.addCustomer(customer);
	}

	@PostMapping(value = "/{customerId}/payee", consumes = "application/json")
	public Payee AddPayee(@RequestBody Payee payee) {
		String generatedOTP = otpGenerator.generateOTP(payee.getCustId());
		try {
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
			
		}
		System.out.println(" ravi ");
		
		return bankService.addPayee(payee, generatedOTP);
	}

	@GetMapping(value = "/{customerId}/payee")
	public List<Payee> payeesInformation(@PathVariable int customerId) {
		return bankService.getAllPayees(customerId);
	}

	@GetMapping(value = "/{customerId}/summary")
	public List<AccountSummary> showDetailedSummary(@PathVariable int customerId) {
		return bankService.getDetailedSummary(customerId);
	}

	@GetMapping(value = "/{customerId}/summary/sortByDate")
	public List<AccountSummary> showDetailedSummarySortByDate(@PathVariable int customerId) {
		return bankService.getDetailedSummarySortByDate(customerId);
	}
}
