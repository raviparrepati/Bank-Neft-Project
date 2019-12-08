package com.tcs.banking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Payee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUMMARY_GENERATOR")
	@SequenceGenerator(name = "SUMMARY_GENERATOR", sequenceName = "SUMMARY_SEQ", initialValue = 6, allocationSize = 10000)
	private int payeeId;
	@Column(name = "custId")
	private int custId;
	private String name;
	private String NickName;
	private long accountNumber;
	private String IFSCCode;

	@ManyToOne
	@JoinColumn
	@JsonBackReference
	private Customer customer;

	public int getPayeeId() {
		return payeeId;
	}

	public void setPayeeId(int payeeId) {
		this.payeeId = payeeId;
	}

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

	public String getNickName() {
		return NickName;
	}

	public void setNickName(String nickName) {
		NickName = nickName;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIFSCCode() {
		return IFSCCode;
	}

	public void setIFSCCode(String iFSCCode) {
		IFSCCode = iFSCCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	public Payee() {
	}

	public Payee(int payeeId, int custId, String name, String nickName, long accountNumber, String iFSCCode,
			Customer customer) {
		super();
		this.payeeId = payeeId;
		this.custId = custId;
		this.name = name;
		NickName = nickName;
		this.accountNumber = accountNumber;
		IFSCCode = iFSCCode;
		this.customer = customer;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Payee [payeeId=").append(payeeId).append(", custId=").append(custId).append(", name=")
				.append(name).append(", NickName=").append(NickName).append(", accountNumber=").append(accountNumber)
				.append(", IFSCCode=").append(IFSCCode).append(", customer=").append(customer).append("]");
		return builder.toString();
	}

}
