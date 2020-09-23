package com.capg.tms.dao;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import com.capg.tms.entity.History;
import com.capg.tms.entity.TransactionBean;

public interface ITransactionDao {
	
	
	public TransactionBean addAccount(TransactionBean bean);
	
	public TransactionBean creditUsingSlip(int id, double amount) ;
	
	public TransactionBean debitUsingSlip(int id, double amount);

	TransactionBean getBalance(int account_id);

	public List<TransactionBean> getAll();

	List<History> printTransactions(int account_id);


}
