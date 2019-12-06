package com.tcs.banking.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccountSummary {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "summaryId")
	private int summaryId;
	
	@Column(name = "custId")
	private int custId;
	
	private String referenceNumber;
	private Date transactionDate;
	private double depositedAmount;
	private double creaditedAmount;
	private double closingBalance;

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

	public double getDepositedAmount() {
		return depositedAmount;
	}

	public void setDepositedAmount(double depositedAmount) {
		this.depositedAmount = depositedAmount;
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

	public AccountSummary(int summaryId, int custId, String referenceNumber, Date transactionDate,
			double depositedAmount, double creaditedAmount, double closingBalance) {
		super();
		this.summaryId = summaryId;
		this.custId = custId;
		this.referenceNumber = referenceNumber;
		this.transactionDate = transactionDate;
		this.depositedAmount = depositedAmount;
		this.creaditedAmount = creaditedAmount;
		this.closingBalance = closingBalance;
	}

	public AccountSummary() {
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountSummary [summaryId=").append(summaryId).append(", custId=").append(custId)
				.append(", referenceNumber=").append(referenceNumber).append(", transactionDate=")
				.append(transactionDate).append(", depositedAmount=").append(depositedAmount)
				.append(", creaditedAmount=").append(creaditedAmount).append(", closingBalance=").append(closingBalance)
				.append("]");
		return builder.toString();
	}

}
