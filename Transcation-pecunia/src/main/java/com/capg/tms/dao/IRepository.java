package com.capg.tms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.tms.entity.TransactionBean;

@Repository
public interface IRepository  extends JpaRepository<TransactionBean, String>{
	
	
	@Query("From TransactionBean As TransactionBean where TransactionBean.account_id = :accountNum")
	List<TransactionBean> findAllSlipsByAccountNum(String accountNum);

}
