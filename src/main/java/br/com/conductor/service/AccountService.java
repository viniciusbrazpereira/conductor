package br.com.conductor.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.conductor.dao.IAccountDAO;
import br.com.conductor.dao.ITransactionDAO;
import br.com.conductor.model.Account;
import br.com.conductor.model.ApiErrorResponse;
import br.com.conductor.model.Transaction;

@Service
public class AccountService {
	
	private static final Logger LOG = LoggerFactory.getLogger(AccountService.class);
	
	@Autowired
	private IAccountDAO accountDAO;
	
	@Autowired
	private ITransactionDAO transactionDAO;
	
	@Autowired
	public void setIAccountDAO(IAccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	@Autowired
	public void setITransactionDAO(ITransactionDAO transactionDAO) {
		this.transactionDAO = transactionDAO;
	}
	
	public ResponseEntity<Object> insert(Account account){
		try {
			this.accountDAO.insert(account);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
			
		} catch (Exception e) {
			LOG.error("Couldn't serialize response for content type application/json", e);
			
			ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
			apiErrorResponse.setMessage(e.getMessage());
			apiErrorResponse.setCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
			return new ResponseEntity<Object>(apiErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<Object> deposit(Account account, Double value){
		try {
			
			if(value <= Double.valueOf(0)) {
				ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
				apiErrorResponse.setMessage("Valor Inválido.");
				apiErrorResponse.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
				return new ResponseEntity<Object>(apiErrorResponse, HttpStatus.BAD_REQUEST);
			}
			
			Account accountCurrent = this.accountDAO.select(account);
			
			if(accountCurrent.isActiveFlag()) {
			
				Transaction transaction = new Transaction();
				transaction.setAccount(account);
				transaction.setTransactionDate(LocalDate.now());
				transaction.setValue(value);
				
				accountCurrent.setBalance(Double.sum(accountCurrent.getBalance(), value));
				this.accountDAO.deposit(accountCurrent);
				this.transactionDAO.create(transaction);
			} else {
				ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
				apiErrorResponse.setMessage("Conta bloqueada.");
				apiErrorResponse.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
				return new ResponseEntity<Object>(apiErrorResponse, HttpStatus.BAD_REQUEST);
			}
			
			return new ResponseEntity<Object>(HttpStatus.OK);
			
		} catch (Exception e) {
			LOG.error("Couldn't serialize response for content type application/json", e);
			
			ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
			apiErrorResponse.setMessage(e.getMessage());
			apiErrorResponse.setCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
			return new ResponseEntity<Object>(apiErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<Object> withdrawal(Account account, Double value){
		try {
			
			if(value <= Double.valueOf(0)) {
				ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
				apiErrorResponse.setMessage("Valor Inválido.");
				apiErrorResponse.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
				return new ResponseEntity<Object>(apiErrorResponse, HttpStatus.BAD_REQUEST);
			}
			
			Account accountCurrent = this.accountDAO.select(account);
			
			if(accountCurrent.isActiveFlag()) {
				Transaction transaction = new Transaction();
				transaction.setAccount(account);
				transaction.setTransactionDate(LocalDate.now());
				transaction.setValue(-value);
				
				
				accountCurrent.setBalance(Double.sum(accountCurrent.getBalance(), -value));
				this.accountDAO.deposit(accountCurrent);
				this.transactionDAO.create(transaction);
			} else {
				ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
				apiErrorResponse.setMessage("Conta bloqueada.");
				apiErrorResponse.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
				return new ResponseEntity<Object>(apiErrorResponse, HttpStatus.BAD_REQUEST);
			}
			
			return new ResponseEntity<Object>(HttpStatus.OK);
			
		} catch (Exception e) {
			LOG.error("Couldn't serialize response for content type application/json", e);
			
			ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
			apiErrorResponse.setMessage(e.getMessage());
			apiErrorResponse.setCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
			return new ResponseEntity<Object>(apiErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<Object> bloq(Account account){
		try {
			Account accountCurrent = this.accountDAO.select(account);
			accountCurrent.activeFlag(false);
			this.accountDAO.bloq(accountCurrent);
			
			return new ResponseEntity<Object>(HttpStatus.OK);
			
		} catch (Exception e) {
			LOG.error("Couldn't serialize response for content type application/json", e);
			
			ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
			apiErrorResponse.setMessage(e.getMessage());
			apiErrorResponse.setCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
			return new ResponseEntity<Object>(apiErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<Object> balance(Account account){
		try {
			Account accountCurrent = this.accountDAO.balance(account);
			
			if(accountCurrent == null) {
				return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
			}
			
			Map<Object, Object> balance = new HashMap<>();
			balance.put("saldo", accountCurrent.getBalance());
			
			return new ResponseEntity<Object>(balance, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error("Couldn't serialize response for content type application/json", e);
			
			ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
			apiErrorResponse.setMessage(e.getMessage());
			apiErrorResponse.setCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
			return new ResponseEntity<Object>(apiErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<Object> extract(Account account){
		try {
			Account accountCurrent = this.accountDAO.balance(account);
			
			if(accountCurrent == null) {
				return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
			}
			
			Transaction transaction = new Transaction();
			transaction.setAccount(accountCurrent);
			List<Transaction> transactions = this.transactionDAO.select(transaction);
			
			Map<Object, Object> extractBalance = new HashMap<>();
			
			/*
			List<Transaction> transactionBefore = 
					transactions.stream().filter(
							transactionStream -> transactionStream.getTransactionDate().isBefore(beforeDate)
					).collect(Collectors.toList());
			
			List<Transaction> transactionAfter = 
					transactionBefore.stream().filter(
							transactionStream -> transactionStream.getTransactionDate().isAfter(afterDate)
					).collect(Collectors.toList());
			*/
			
			for(Transaction transactionTemp : transactions) {
				Map<Object, Object> extract = new HashMap<>();
				extract.put("Valor", transactionTemp.getValue());
				extract.put("Data", transactionTemp.getTransactionDate());
				extractBalance.put(transactionTemp.getIdTransaction(), extract);
			}
			
			extractBalance.put("saldo", accountCurrent.getBalance());
			
			return new ResponseEntity<Object>(extractBalance, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error("Couldn't serialize response for content type application/json", e);
			
			ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
			apiErrorResponse.setMessage(e.getMessage());
			apiErrorResponse.setCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
			return new ResponseEntity<Object>(apiErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
