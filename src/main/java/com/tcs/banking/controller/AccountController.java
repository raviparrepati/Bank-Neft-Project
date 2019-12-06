//package com.tcs.banking.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.tcs.banking.model.AccountSummary;
//import com.tcs.banking.model.Customer;
//import com.tcs.banking.model.Payee;
//import com.tcs.banking.service.BankService;
//
//@RestController
//@RequestMapping("/")
//public class AccountController {
//	@Autowired
//	private BankService bankService;
//	
//	@GetMapping(path="/home")
//	public String toHome() {
//		return "accounts";
//	}
//	@GetMapping(path="/customer/{id}")
//	public Customer getCustomer(@PathVariable int id) {
//		System.out.println(" Hello");
//		return bankService.getCustomer(id);
//	}
//	
//	@GetMapping(path="/customer/{id}/Summary")
//	public List<AccountSummary> getCustomerSummary(@PathVariable int id) {
//		return bankService.getAccountSummary(id);
//	}
//	
//	@PostMapping(path="/saveCustomer", consumes = "application/json", produces = "application/json")
//	public int addCustomer(@RequestBody Customer customer) {
//		return bankService.addCustomer(customer);
//	}
//	
//	@PostMapping(path="/savePayee", consumes = "application/json", produces = "application/json")
//	public Payee addPayee(@RequestBody Payee payee) {
//		return bankService.addPayee(payee);
//	}
//	
//	
//	@GetMapping(path="/account/{id}/getAllPayees", produces = "application/json")
//	public List<Customer>  getPayee(@PathVariable int accountId) {
//		return bankService.getAllPayees(accountId);
//	}
//	
//}
