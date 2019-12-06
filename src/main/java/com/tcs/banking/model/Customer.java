package com.tcs.banking.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int custId;
	private String name;
	private int age;
	private String address;
	private String type;
	private int accountNumber;
	private double balance;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
	private List<Payee> payees = new ArrayList<>();

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getName() {
		return name;
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
		return "Customer [custId=" + custId + ", name=" + name + ", age=" + age + ", address=" + address + ", type="
				+ type + ", accountNumber=" + accountNumber + ", balance=" + balance + ", payees=" + payees + "]";
	}

}
