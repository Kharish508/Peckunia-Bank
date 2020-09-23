package com.capg.tms.dao;

import java.util.List;

//import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.security.auth.login.AccountNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capg.tms.Exception.InSufficientException;
import com.capg.tms.entity.History;
import com.capg.tms.entity.TransactionBean;

@Repository
@Transactional
public class TransactionDaoImpl implements ITransactionDao {

	@PersistenceContext
	EntityManager em;

	@Autowired
	IRepository repo;

	@Override
	public TransactionBean addAccount(TransactionBean bean) {
		repo.saveAndFlush(bean);
		return bean;
	}

	/* crediting the amount into the account in the database */
	@Override
	public TransactionBean creditUsingSlip(int id, double amount) {

		TransactionBean bean = em.find(TransactionBean.class, id);

		try {

			bean.setAmount(amount + bean.getAmount());
		} catch (Exception e) {
			return bean;
		}
		History history = new History("Deposited", id, amount);
		em.persist(history);
		return em.merge(bean);
	}

	/* debiting the amount from the account from the database */
	@Override
	public TransactionBean debitUsingSlip(int account_id, double amount) {
		TransactionBean bean = em.find(TransactionBean.class, account_id);
		
		if(amount>bean.getAmount()) {
			throw new InSufficientException("insufficient amount"+"\n"+"Your current balance is :"+bean.getAmount());
			
		}
		try {
			bean.setAmount(bean.getAmount() - amount);
		} catch (Exception e) {
			return null;
		}
		History history = new History("Withdrawn", account_id, amount);

		em.persist(history);

		return em.merge(bean);
	}

	@Override
	public TransactionBean getBalance(int account_id) {

		return em.find(TransactionBean.class, account_id);
	}

	/* getting all the accounts in database */
	@Override
	public List<TransactionBean> getAll() {
		TypedQuery<TransactionBean> query = em.createQuery("from TransactionBean", TransactionBean.class);
		return query.getResultList();
	}

	@Override
	public List<History> printTransactions(int account_id) {
		TypedQuery<History> query = em.createQuery("select h from History h where h.acc_id=" + account_id,
				History.class);
		return query.getResultList();
	}

}
