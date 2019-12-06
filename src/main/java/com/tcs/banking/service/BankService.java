package com.tcs.banking.service;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tcs.banking.model.AccountSummary;
import com.tcs.banking.model.Customer;
import com.tcs.banking.model.Payee;
import com.tcs.banking.repository.AccountSummaryRepository;
import com.tcs.banking.repository.CustomerRepository;
import com.tcs.banking.repository.PayeeRepository;

@Repository
public class BankService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AccountSummaryRepository accountSummaryRepository;

	@Autowired
	private PayeeRepository payeeRepository;

	public static List<Customer> customers;
	static {
//    	customers = new ArrayList<>(Arrays.asList(new Customer(1, 1, "HDFC1", "Jai"), new Customer(1, 2 , "ICIC", "Prishi")));
	}

	public  Customer getCustomer(int id) {
		
		 Optional<Customer> optionalCustomer = customerRepository.findById(id);
		 Customer customer = optionalCustomer.get();
//		 List<Payee> payees = payeeRepository.findByCustId(customer.getCustid());
//		 System.out.println("  Hello -------- "+ payees);
//		 customer.setPayees(payees);
		 return customer;
	}

	public List<AccountSummary> getAccountSummary(int id) {
		return accountSummaryRepository.findByCustid(id);
	}

	public Customer addCustomer(Customer customer) {
		System.out.println("  customer   "+ customer);
		Customer customer1 = customerRepository.save(customer);
		System.out.println("  customer.getPayees()   "+ customer.getPayees());
		Iterator<Payee> iterator = customer.getPayees().iterator();
		while (iterator.hasNext()) {
			Payee payee = iterator.next();
//			payee.setCustId(customer1.getCustid());
//			System.out.println(" Hellooooooooooo   "+ payee);
			payeeRepository.save(payee);
		}
//		AccountSummary accountSummary = new AccountSummary(customer1.getCustid(), 1, new Date(100000L), "CREDIT",
//				customer1.getBalance(), customer1.getBalance());
//		accountSummaryRepository.save(accountSummary);
//		return customer1.getCustid();
		return customer1;
	}

	public List<Customer> getAllPayees(final int accountId) {
//    	return customers.stream().filter(i -> i.getAccountId() == accountId ).collect(Collectors.toList());
		return null;
	}

	public Payee addPayee(Payee payee) {
		return payeeRepository.save(payee);
	}
}
