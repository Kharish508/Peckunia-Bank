package com.capg.tms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capg.tms.entity.TransactionBean;


public interface IRepositoy extends JpaRepository<TransactionBean, Long> {

}
