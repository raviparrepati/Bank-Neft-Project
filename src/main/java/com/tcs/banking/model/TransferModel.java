package com.tcs.banking.model;

public class TransferModel {

	private int custId;
	private int payeeId;
	private double transferAmount;
	private String transferType;
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getPayeeId() {
		return payeeId;
	}
	public void setPayeeId(int payeeId) {
		this.payeeId = payeeId;
	}
	public double getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}
	public String getTransferType() {
		return transferType;
	}
	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TransferModel [custId=").append(custId).append(", payeeId=").append(payeeId)
				.append(", transferAmount=").append(transferAmount).append(", transferType=").append(transferType)
				.append("]");
		return builder.toString();
	}
	
	
}
