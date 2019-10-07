package br.com.conductor.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.conductor.model.Account;
import br.com.conductor.service.AccountService;
import io.swagger.annotations.ApiParam;

@Controller
public class AccountApiController implements AccountApi {

    @Autowired
    private AccountService service;

    public ResponseEntity<Object> accountOperationBalanceGet(
    		@ApiParam(value = "",required=true) @PathVariable("idAccount") Integer idAccount) {
    	Account account = new Account();
    	account.setIdAccount(idAccount);
    	return service.balance(account);
    }

    public ResponseEntity<Object> accountOperationBloqPost(
    		@ApiParam(value = "Account Enitity" ,required=true )  @Valid @RequestBody Account account) {
    	return service.bloq(account);
    }

    public ResponseEntity<Object> accountOperationDepositPut(
    		@ApiParam(value = "Account Enitity" ,required=true )  @Valid @RequestBody Account account,
    		@ApiParam(value = "Value Deposit",required=true) @RequestParam(value = "value") Double value) {
        return service.deposit(account, value);
    }

    public ResponseEntity<Object> accountOperationExtractGet(
    		@ApiParam(value = "",required=true) @PathVariable("idAccount") Integer idAccount) {
    	Account account = new Account();
    	account.setIdAccount(idAccount);
    	return service.extract(account);
    }

    public ResponseEntity<Object> accountOperationWithdrawalPost(
    		@ApiParam(value = "Value Withdrawal",required=true) @RequestParam("value") Double value,
    		@ApiParam(value = "Account Enitity" ,required=true )  @Valid @RequestBody Account account) {
    	return service.withdrawal(account, value);
    }

    public ResponseEntity<Object> accountPut(
    		@ApiParam(value = "Account Enitity" ,required=true )  @Valid @RequestBody Account account) {
        return service.insert(account);
    }

}
