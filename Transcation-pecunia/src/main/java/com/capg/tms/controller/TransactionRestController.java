package com.capg.tms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.tms.Exception.AccountNotFoundException;
import com.capg.tms.Exception.InSufficientException;
import com.capg.tms.entity.History;
import com.capg.tms.entity.TransactionBean;
import com.capg.tms.service.TransactionServiceImpl;

/******************************************
- File Name      : TransactionRestController.java
- Author           : Capgemini
- Creation Date    :22-09-2020
- Description      : This Controller class act as an end point to manage the entire Transactions Service
 ******************************************/

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "transaction")
public class TransactionRestController {

	@Autowired
	TransactionServiceImpl service;

	/******************************************
    - Method Name      : createAccount
    - Input Parameters : TransactionBean
    - Return type      : ResponseEntity
    - End Point Url    : /create
    -Request Method Type: PostMapping
    - Author           : Capgemini
    - Creation Date    : 22-09-2020
    - Description      : Creating a account for customer 
     ******************************************/
	
	@PostMapping("/create") // postman :POST
	public String createAccount(@RequestBody TransactionBean bean) {
		TransactionBean transaction = service.addAccount(bean);
		return "Hello " + transaction.getCustomer_name() + "\n Your Registration is Successfull\n" + "Your Account Id is "
				+ transaction.getAccount_id();
	}

	/******************************************
    - Method Name      : creditUsingSlip
    - Input Parameters : TransactionBean
    - Return type      : ResponseEntity
    - End Point Url    : /creditUsingSlip/{id}/{amount}
    -Request Method Type: GetMapping
    - Author           : Capgemini
    - Creation Date    : 22-09-2020
    - Description      : customer crediting the amount into account
     ******************************************/
	
	@GetMapping("/creditUsingSlip/{id}/{amount}") // GET: http://localhost:8090/transaction/creditUsingSlip/10/1000
	public String creditUsingSlip(@PathVariable int id, @PathVariable double amount) throws Exception {
		
		TransactionBean transaction = service.creditUsingSlip(id, amount);

		if (transaction == null) {
			throw new AccountNotFoundException("Invalid acount number please enter valid account number");
		}
		else if(amount<100 || amount>100000) {
			throw new InSufficientException("Please enter amount between 100-100000");
		}
		
		return "Hello " + transaction.getCustomer_name() + "\n Your Amount is Deposited Succesfully\n"
				+ "Your Current Account Balance is " + transaction.getAmount();

	}
	
	/******************************************
    - Method Name      : debitUsingSlip
    - Input Parameters : TransactionBean
    - Return type      : ResponseEntity
    - End Point Url    : /debitUsingSlip/{account_id}/{amount}
    -Request Method Type: GetMapping
    - Author           : Capgemini
    - Creation Date    : 22-09-2020
    - Description      : customer debiting the amount into account
     ******************************************/

	@GetMapping("/debitUsingSlip/{account_id}/{amount}") // http://localhost:8090/transaction/debitUsingSlip/10/2000
	public String debitUsingSlip(@PathVariable int account_id, @PathVariable double amount) throws Exception {
		TransactionBean transaction = service.debitUsingSlip(account_id, amount);

		if (transaction == null) {
			throw new AccountNotFoundException("Invalid account number please enter valid account number");
		}
		else if(amount<100  || amount>100000) {
			throw new InSufficientException("Please enter amount between 100-100000");
		}
		return "Hello Your Amount is Withdrawn Succesfully\n" + "Your Current Account Balance is " + transaction.getAmount();

	}

	/******************************************
    - Method Name      : getall
    - Input Parameters : TransactionBean
    - Return type      : ResponseEntity
    - End Point Url    : /findall
    -Request Method Type: GetMapping
    - Author           : Capgemini
    - Creation Date    : 22-09-2020
    - Description      : To get all accountants details
     ******************************************/
	
	@GetMapping("/findall") // GET: http://localhost:8090/transaction/findall
	public ResponseEntity<List<TransactionBean>> getall() {

		List<TransactionBean> bean = service.getAll();
		return new ResponseEntity<List<TransactionBean>>(bean, new HttpHeaders(), HttpStatus.OK);

	}
	
	/******************************************
    - Method Name      : printTransaction
    - Input Parameters : History Bean
    - Return type      : ResponseEntity
    - End Point Url    : //Print/{account_id}
    -Request Method Type: GetMapping
    - Author           : Capgemini
    - Creation Date    : 22-09-2020
    - Description      : To get transcions details of a perticular customer
     ******************************************/

	@GetMapping("/Print/{account_id}") // http://localhost:8090/transaction/Print/10
	public ResponseEntity<List<History>> printTransaction(@PathVariable int account_id) throws Exception {

		List<History> history =service.printTransactions(account_id);
		if (history == null) {
			throw new AccountNotFoundException("Invalid id please enter valid account number");
		}

		List<History> historytransctions = service.printTransactions(account_id);
		return new ResponseEntity<List<History>>(historytransctions, new HttpHeaders(), HttpStatus.OK);
	}

	@ExceptionHandler(Exception.class)
	public String inValid(Exception e) {
		return e.getMessage();
	}

}
