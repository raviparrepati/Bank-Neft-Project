package com.tcs.banking.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.tcs.banking.model.AccountSummary;
import com.tcs.banking.model.Customer;
import com.tcs.banking.model.Payee;
import com.tcs.banking.model.TransferModel;
import com.tcs.banking.repository.AccountSummaryRepository;
import com.tcs.banking.repository.CustomerRepository;
import com.tcs.banking.repository.PayeeRepository;
import com.tcs.banking.utils.OTPGenerator;

@Repository
@EnableTransactionManagement
public class BankService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AccountSummaryRepository accountSummaryRepository;

	@Autowired
	private PayeeRepository payeeRepository;

	@Autowired
	private OTPGenerator otpGenerator;

	public Customer getCustomer(int id) {

		Optional<Customer> optionalCustomer = customerRepository.findById(id);
		Customer customer = optionalCustomer.get();
		return customer;
	}

	public List<AccountSummary> getAccountSummary(int id) {
		return accountSummaryRepository.findByCustId(id);
	}

	public Customer addCustomer(Customer customer) {
		System.out.println("  customer   " + customer);
		Customer customer1 = customerRepository.save(customer);
		System.out.println("  customer.getPayees()   " + customer.getPayees());
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

	public List<Payee> getAllPayees(final int custId) {
		return payeeRepository.findByCustId(custId);
	}

	public List<Customer> getAllCustomer() {
		List<Customer> customers = customerRepository.findAll();
		System.out.println(" customers size " + customers.size());
		return new ArrayList<Customer>(customers);
	}

	public Payee addPayee(Payee payee, String otp) {
		if (otp == otpGenerator.getOTP(payee.getCustId())) {
			Payee savedPayee = payeeRepository.save(payee);
			otpGenerator.removeOTP(payee.getCustId());
			return savedPayee;
		}else {
			System.out.println(" OTP did not matched....!");
		}
		return null;
	}

	public List<AccountSummary> getDetailedSummary(int custId) {
		return accountSummaryRepository.findByCustid(custId, Sort.by("closingBalance").ascending());
	}

	public AccountSummary transfer(TransferModel transferModel) {
		System.out.println("transfer ----------  " + transferModel);
		int custId = transferModel.getCustId();
		Customer customer = deductAmount(custId, transferModel);
		System.out.println("after sleep");
		try {
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("after sleep");
		AccountSummary summary = createAccountSummary(customer, transferModel);
		System.out.println("summary -----------  " + summary);
		return accountSummaryRepository.save(summary);
	}

	private Customer deductAmount(int custId, TransferModel transferModel) {
		Customer customer = getCustomer(custId);
		double balance = customer.getBalance();
		customer.setBalance(balance - transferModel.getTransferAmount());
		return customerRepository.save(customer);
	}

	private AccountSummary createAccountSummary(Customer customer, TransferModel transferModel) {
		return new AccountSummary(5, customer.getCustId(), "NEFT", new Date(), transferModel.getTransferAmount(), 0,
				customer.getBalance());
	}

	public List<AccountSummary> getDetailedSummarySortByDate(int customerId) {
		return accountSummaryRepository.findByCustid(customerId, Sort.by("transactionDate").ascending());
	}
}
