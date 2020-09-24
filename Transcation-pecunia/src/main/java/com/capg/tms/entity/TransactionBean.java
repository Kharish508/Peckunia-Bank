package com.capg.tms.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="transctions")
public class TransactionBean {
 
	@Id
	
	private long account_id;
	
	
	private String customer_name;
	
	private double amount;
	
	private String contact_number;

	public long getAccount_id() {
		return account_id;
	}

	public void setAccount_id(long l) {
		
        
		this.account_id = l;
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
	

	public TransactionBean(long account_id, String customer_name, double amount, String contact_number) {
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
