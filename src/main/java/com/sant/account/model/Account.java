package com.sant.account.model;

public class Account {

	String accountId;
	String custId;
	double balance;
	
	public Account(String accountId, String custId, int balance) {
		this.accountId = accountId;
		this.custId = custId;
		this.balance = balance;
	}
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}	
	
}
