package br.com.conductor.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.conductor.model.Account;
import br.com.conductor.model.ApiErrorResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "account", description = "the account API")
public interface AccountApi {

    @ApiOperation(value = "Balance Inquiry", nickname = "accountOperationBalanceGet", notes = "Balance Inquiry", tags={ "getBalanceInquiry", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful Request"),
        @ApiResponse(code = 400, message = "Bad Request", response = ApiErrorResponse.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = ApiErrorResponse.class),
        @ApiResponse(code = 403, message = "Forbidden", response = ApiErrorResponse.class),
        @ApiResponse(code = 404, message = "Data not found", response = ApiErrorResponse.class),
        @ApiResponse(code = 405, message = "Data input not supplied or invalid", response = ApiErrorResponse.class),
        @ApiResponse(code = 500, message = "Internal Error", response = ApiErrorResponse.class) })
    @RequestMapping(value = "/account/operation/balance/{idAccount}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Object> accountOperationBalanceGet(@ApiParam(value = "",required=true) @PathVariable("idAccount") Integer idAccount);


    @ApiOperation(value = "Bloq Account", nickname = "accountOperationBloqPost", notes = "Bloq Account", tags={ "bloqAccount", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful Request"),
        @ApiResponse(code = 400, message = "Bad Request", response = ApiErrorResponse.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = ApiErrorResponse.class),
        @ApiResponse(code = 403, message = "Forbidden", response = ApiErrorResponse.class),
        @ApiResponse(code = 404, message = "Data not found", response = ApiErrorResponse.class),
        @ApiResponse(code = 405, message = "Data input not supplied or invalid", response = ApiErrorResponse.class),
        @ApiResponse(code = 500, message = "Internal Error", response = ApiErrorResponse.class) })
    @RequestMapping(value = "/account/operation/bloq",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Object> accountOperationBloqPost(@ApiParam(value = "Account Enitity" ,required=true )  @Valid @RequestBody Account account);


    @ApiOperation(value = "Create New Deposit", nickname = "accountOperationDepositPut", notes = "Create New Deposit", tags={ "createDeposit", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Successful Request"),
        @ApiResponse(code = 400, message = "Bad Request", response = ApiErrorResponse.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = ApiErrorResponse.class),
        @ApiResponse(code = 403, message = "Forbidden", response = ApiErrorResponse.class),
        @ApiResponse(code = 404, message = "Data not found", response = ApiErrorResponse.class),
        @ApiResponse(code = 405, message = "Data input not supplied or invalid", response = ApiErrorResponse.class),
        @ApiResponse(code = 500, message = "Internal Error", response = ApiErrorResponse.class) })
    @RequestMapping(value = "/account/operation/deposit",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Object> accountOperationDepositPut(
    		@ApiParam(value = "Account Enitity" ,required=true )  @Valid @RequestBody Account account,
    		@ApiParam(value = "Value Deposit",required=true) @RequestParam(value = "value") Double value);


    @ApiOperation(value = "Extract Account", nickname = "accountOperationExtractGet", notes = "Extract Account", tags={ "getExtract", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful Request"),
        @ApiResponse(code = 400, message = "Bad Request", response = ApiErrorResponse.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = ApiErrorResponse.class),
        @ApiResponse(code = 403, message = "Forbidden", response = ApiErrorResponse.class),
        @ApiResponse(code = 404, message = "Data not found", response = ApiErrorResponse.class),
        @ApiResponse(code = 405, message = "Data input not supplied or invalid", response = ApiErrorResponse.class),
        @ApiResponse(code = 500, message = "Internal Error", response = ApiErrorResponse.class) })
    @RequestMapping(value = "/account/operation/extract/{idAccount}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Object> accountOperationExtractGet(@ApiParam(value = "",required=true) @PathVariable("idAccount") Integer idAccount);


    @ApiOperation(value = "Withdrawal", nickname = "accountOperationWithdrawalPost", notes = "Withdrawal", tags={ "withdrawal", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful Request"),
        @ApiResponse(code = 400, message = "Bad Request", response = ApiErrorResponse.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = ApiErrorResponse.class),
        @ApiResponse(code = 403, message = "Forbidden", response = ApiErrorResponse.class),
        @ApiResponse(code = 404, message = "Data not found", response = ApiErrorResponse.class),
        @ApiResponse(code = 405, message = "Data input not supplied or invalid", response = ApiErrorResponse.class),
        @ApiResponse(code = 500, message = "Internal Error", response = ApiErrorResponse.class) })
    @RequestMapping(value = "/account/operation/withdrawal",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Object> accountOperationWithdrawalPost(
    		@ApiParam(value = "Value Withdrawal",required=true) @PathVariable("value") Double value,
    		@ApiParam(value = "Account Enitity" ,required=true )  @Valid @RequestBody Account account);


    @ApiOperation(value = "Create New Account", nickname = "accountPut", notes = "Create New Account", tags={ "createAccount", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Successful Request"),
        @ApiResponse(code = 400, message = "Bad Request", response = ApiErrorResponse.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = ApiErrorResponse.class),
        @ApiResponse(code = 403, message = "Forbidden", response = ApiErrorResponse.class),
        @ApiResponse(code = 404, message = "Data not found", response = ApiErrorResponse.class),
        @ApiResponse(code = 405, message = "Data input not supplied or invalid", response = ApiErrorResponse.class),
        @ApiResponse(code = 500, message = "Internal Error", response = ApiErrorResponse.class) })
    @RequestMapping(value = "/account",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Object> accountPut(@ApiParam(value = "Account Enitity" ,required=true )  @Valid @RequestBody Account account);

}
