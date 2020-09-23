package com.capg.tms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.tms.dao.TransactionDaoImpl;
import com.capg.tms.entity.History;
import com.capg.tms.entity.TransactionBean;

@SpringBootTest
class TranscationPecuniaApplicationTests {

	@Autowired
	TransactionDaoImpl dao;
	TransactionBean bean;
	History history;
	
	@BeforeEach
	void setUp() {
		bean = new TransactionBean(200,"helly",150000.0,"8334155692");
	}
	
	
	@Test
	void contextLoads() {
		TransactionBean transaction=dao.debitUsingSlip(200, 150000.0);
	}

}
