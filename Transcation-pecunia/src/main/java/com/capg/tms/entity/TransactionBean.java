package com.capg.tms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transctions")
public class TransactionBean {
 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int account_id;
	
	private String customer_name;
	
	private double amount;
	
	private String contact_number;

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	

	public TransactionBean(int account_id, String customer_name, double amount, String contact_number) {
		super();
		this.account_id = account_id;
		this.customer_name = customer_name;
		this.amount = amount;
		this.contact_number = contact_number;
	}
	

	public TransactionBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BankBean [account_id=" + account_id + ", customer_name=" + customer_name + ", amount=" + amount
				+ ", contact_number=" + contact_number + "]";
	}
	
	
}
