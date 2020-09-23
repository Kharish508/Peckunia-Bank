package com.capg.tms.service;

 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.tms.dao.ITransactionDao;
import com.capg.tms.entity.History;
import com.capg.tms.entity.TransactionBean;

@Service
public class TransactionServiceImpl implements ITransactionService {
	
	@Autowired
	ITransactionDao dao;
	
	/* passing the bean from service layer to Dao layer */
	 @Override
	  public TransactionBean addAccount(TransactionBean bean) {
		  return dao.addAccount(bean);
	  }	
	 
	/* passing the account id and amount into Dao layer from service layer */
	@Override
	public TransactionBean creditUsingSlip(int id, double amount) {
		return dao.creditUsingSlip(id, amount);
	}
	
	/* passing the account id and amount into Dao layer from service layer */
	@Override
	public TransactionBean debitUsingSlip(int account_id, double amount) {
		return dao.debitUsingSlip(account_id, amount);
	}
	
	@Override
	public TransactionBean getBalance(int account_id) {
		return dao.getBalance(account_id);
	}

	
	/* getting all the accounts from Dao layer */
	public List<TransactionBean> getAll() {
		return dao.getAll();
	}
	
	@Override
	public List<History> printTransactions(int account_id) {
		return dao.printTransactions(account_id);
	}



	}
