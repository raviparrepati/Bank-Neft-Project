package com.tcs.banking.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
//@TableGenerator(name="summaryGenerator", initialValue=3, allocationSize = 600)
public class AccountSummary {

	@Id
//	@GeneratedValue(strategy=GenerationType.TABLE, generator="summaryGenerator")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUMMARY_GENERATOR")
	@SequenceGenerator(name = "SUMMARY_GENERATOR", sequenceName = "SUMMARY_SEQ", initialValue = 6, allocationSize = 10000)
	private int summaryId;
	private int custId;
	private String referenceNumber;
	private Date transactionDate;
	private double debitedAmount;
	private double creaditedAmount;
	private double closingBalance;

	@ManyToOne
	@JoinColumn
	@JsonBackReference
	private Customer customer;

	public int getSummaryId() {
		return summaryId;
	}

	public void setSummaryId(int summaryId) {
		this.summaryId = summaryId;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getDebitedAmount() {
		return debitedAmount;
	}

	public void setDebitedAmount(double debitedAmount) {
		this.debitedAmount = debitedAmount;
	}

	public double getCreaditedAmount() {
		return creaditedAmount;
	}

	public void setCreaditedAmount(double creaditedAmount) {
		this.creaditedAmount = creaditedAmount;
	}

	public double getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(double closingBalance) {
		this.closingBalance = closingBalance;
	}

	public AccountSummary(int summaryId, int custId, String referenceNumber, Date transactionDate, double debitedAmount,
			double creaditedAmount, double closingBalance) {
		super();
		this.summaryId = summaryId;
		this.custId = custId;
		this.referenceNumber = referenceNumber;
		this.transactionDate = transactionDate;
		this.debitedAmount = debitedAmount;
		this.creaditedAmount = creaditedAmount;
		this.closingBalance = closingBalance;
	}

	public AccountSummary(int custId, String referenceNumber, Date transactionDate, double debitedAmount,
			double creaditedAmount, double closingBalance) {
		super();
		this.custId = custId;
		this.referenceNumber = referenceNumber;
		this.transactionDate = transactionDate;
		this.debitedAmount = debitedAmount;
		this.creaditedAmount = creaditedAmount;
		this.closingBalance = closingBalance;
	}

	public AccountSummary() {

	}

	public AccountSummary(int summaryId, int custId, String referenceNumber, Date transactionDate, double debitedAmount,
			double creaditedAmount, double closingBalance, Customer customer) {
		super();
		this.summaryId = summaryId;
		this.custId = custId;
		this.referenceNumber = referenceNumber;
		this.transactionDate = transactionDate;
		this.debitedAmount = debitedAmount;
		this.creaditedAmount = creaditedAmount;
		this.closingBalance = closingBalance;
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountSummary [summaryId=").append(summaryId).append(", custId=").append(custId)
				.append(", referenceNumber=").append(referenceNumber).append(", transactionDate=")
				.append(transactionDate).append(", debitedAmount=").append(debitedAmount).append(", creaditedAmount=")
				.append(creaditedAmount).append(", closingBalance=").append(closingBalance).append("]");
		return builder.toString();
	}

}
