package com.tcs.banking.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@TableGenerator(name="idGenerator", initialValue=7, allocationSize=50)
public class Customer {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="idGenerator")
	private int custId;
	private String name;
	private int age;
	private String address;
	private String type;
	private int accountNumber;
	private double balance;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
	@JsonManagedReference
	private List<Payee> payees = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
	@JsonManagedReference
	private List<AccountSummary> accountSummaries = new ArrayList<>();

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getName() {
		return name;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public List<AccountSummary> getAccountSummaries() {
		return accountSummaries;
	}

	public void setAccountSummaries(List<AccountSummary> accountSummaries) {
		this.accountSummaries = accountSummaries;
	}

	public Customer(int custId, String name, int age, String address, String type, int accountNumber, double balance,
			List<Payee> payees, List<AccountSummary> accountSummaries) {
		super();
		this.custId = custId;
		this.name = name;
		this.age = age;
		this.address = address;
		this.type = type;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.payees = payees;
		this.accountSummaries = accountSummaries;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAccountId() {
		return accountNumber;
	}

	public void setAccountId(int accountId) {
		this.accountNumber = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Payee> getPayees() {
		return payees;
	}

	public void setPayees(List<Payee> payees) {
		this.payees = payees;
	}

	public Customer(int custId, String name, int age, String address, String type, int accountNumber, double balance,
			List<Payee> payees) {
		super();
		this.custId = custId;
		this.name = name;
		this.age = age;
		this.address = address;
		this.type = type;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.payees = payees;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [custId=").append(custId).append(", name=").append(name).append(", age=").append(age)
				.append(", address=").append(address).append(", type=").append(type).append(", accountNumber=")
				.append(accountNumber).append(", balance=").append(balance).append(", payees=").append(payees)
				.append(", accountSummaries=").append(accountSummaries).append("]");
		return builder.toString();
	}


}
