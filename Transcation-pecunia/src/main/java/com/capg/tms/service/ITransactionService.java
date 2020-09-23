package com.capg.tms.service;

 import java.util.List;

import com.capg.tms.entity.History;
import com.capg.tms.entity.TransactionBean;

public interface ITransactionService {

	
	public TransactionBean addAccount(TransactionBean bean);
	
	public TransactionBean creditUsingSlip(int id, double amount);
	
	public TransactionBean debitUsingSlip(int id, double amount);

	public TransactionBean getBalance(int account_id);

	List<History> printTransactions(int account_id);

		
	
}
