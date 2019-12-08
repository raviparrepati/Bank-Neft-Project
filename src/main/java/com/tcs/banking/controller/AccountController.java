package com.tcs.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.banking.model.AccountSummary;
import com.tcs.banking.model.TransferModel;
import com.tcs.banking.service.BankService;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private BankService bankService;
	
	
	@PostMapping(path="/transfer/", consumes = "application/json", produces = "application/json")
	public AccountSummary addCustomer(@RequestBody TransferModel transferModel) {
		System.out.println(" Hello  ============ "+ transferModel);
		AccountSummary summary = bankService.transfer(transferModel);
		System.out.println(" Summary  ============ "+ summary);
		return summary;
	}
	
	
}
