package br.com.conductor.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import br.com.conductor.model.Account;
import br.com.conductor.model.ApiErrorResponse;
import br.com.conductor.service.AccountService;
import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountApiController.class)
public class AccountApiControllerTest extends TestCase {
	
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private AccountService service; 
	
	private MockHttpServletRequestBuilder mockHttpServletRequestBuilder;
	
	private  static final String URL_PUT_ACCOUNT = "/account";
	private  static final String URL_POST_BLOQ = "/account/operation/bloq";
	private  static final String URL_POST_DEPOSIT = "/account/operation/deposit";
	private  static final String URL_GET_EXTRACT = "/account/operation/extract/{idAccount}";
	private  static final String URL_POST_WITHDRAWAL = "/account/operation/withdrawal";
	private  static final String URL_GET_BALANCE = "/account/operation/balance/{idAccount}";
	
	@Test
	public void testAccountOk() throws Exception {
		this.mockHttpServletRequestBuilder = put(URL_PUT_ACCOUNT);
		
		ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();
	    String requestJson = objectWriter.writeValueAsString(new Account());
		
		mockMvc.perform(this.mockHttpServletRequestBuilder
				  .content(requestJson)
			      .contentType(APPLICATION_JSON))
			      .andExpect(status().isOk());
	}
	
	@Test
	public void testAccountInternalServerError() throws Exception {
		this.mockHttpServletRequestBuilder = put(URL_PUT_ACCOUNT);
		
		ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();
	    String requestJson = objectWriter.writeValueAsString(new Account());
	    
	    when(service.insert(Mockito.any())).thenReturn(new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR));
		
		mockMvc.perform(this.mockHttpServletRequestBuilder
				  .content(requestJson)
			      .contentType(APPLICATION_JSON))
			      .andExpect(status().isInternalServerError());
	}
	
	@Test
	public void testBloqOk() throws Exception {
		this.mockHttpServletRequestBuilder = post(URL_POST_BLOQ);
		
		ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();
	    String requestJson = objectWriter.writeValueAsString(new Account());
	    
		mockMvc.perform(this.mockHttpServletRequestBuilder
				  .content(requestJson)
			      .contentType(APPLICATION_JSON))
			      .andExpect(status().isOk());
	}
	
	@Test
	public void testBloqInternalServerError() throws Exception {
		this.mockHttpServletRequestBuilder = post(URL_POST_BLOQ);
		
		ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();
	    String requestJson = objectWriter.writeValueAsString(new Account());
	    
	    when(service.bloq(Mockito.any())).thenReturn(new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR));
		
		mockMvc.perform(this.mockHttpServletRequestBuilder
				  .content(requestJson)
			      .contentType(APPLICATION_JSON))
			      .andExpect(status().isInternalServerError());
	}
	
	@Test
	public void testDepositOk() throws Exception {
		this.mockHttpServletRequestBuilder = post(URL_POST_DEPOSIT);
		
		ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();
	    String requestJson = objectWriter.writeValueAsString(new Account());
	    
		mockMvc.perform(this.mockHttpServletRequestBuilder
			  .param("value", "100")
			  .content(requestJson)
		      .contentType(APPLICATION_JSON))
		      .andExpect(status().isOk());
	}
	
	@Test
	public void testDepositInternalServerError() throws Exception {
		this.mockHttpServletRequestBuilder = post(URL_POST_DEPOSIT);
		
		ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();
	    String requestJson = objectWriter.writeValueAsString(new Account());
	    
	    when(service.deposit(Mockito.any(), Mockito.anyDouble())).thenReturn(new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR));
		
		mockMvc.perform(this.mockHttpServletRequestBuilder
				.param("value", "100")
				.content(requestJson)
			    .contentType(APPLICATION_JSON))
			    .andExpect(status().isInternalServerError());
	}
	
	@Test
	public void testDepositBadRequest() throws Exception {
		this.mockHttpServletRequestBuilder = post(URL_POST_DEPOSIT);
		
		ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();
	    String requestJson = objectWriter.writeValueAsString(new Account());
	    
	    ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
		apiErrorResponse.setMessage("Valor Inválido.");
		apiErrorResponse.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
		
	    when(service.deposit(Mockito.any(), Mockito.anyDouble())).thenReturn(new ResponseEntity<Object>(apiErrorResponse, HttpStatus.BAD_REQUEST));
		
		mockMvc.perform(this.mockHttpServletRequestBuilder
				.param("value", "10")
				.content(requestJson)
			    .contentType(APPLICATION_JSON))
			    .andExpect(status().isBadRequest())
			    .andExpect(jsonPath("message", is("Valor Inválido.")));
	}
	
	@Test
	public void testDepositBadRequestBloqAccount() throws Exception {
		this.mockHttpServletRequestBuilder = post(URL_POST_DEPOSIT);
		
		ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();
	    String requestJson = objectWriter.writeValueAsString(new Account());
	    
	    ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
		apiErrorResponse.setMessage("Conta bloqueada.");
		apiErrorResponse.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
		
	    when(service.deposit(Mockito.any(), Mockito.anyDouble())).thenReturn(new ResponseEntity<Object>(apiErrorResponse, HttpStatus.BAD_REQUEST));
		
		mockMvc.perform(this.mockHttpServletRequestBuilder
				.param("value", "10")
				.content(requestJson)
			    .contentType(APPLICATION_JSON))
			    .andExpect(status().isBadRequest())
			    .andExpect(jsonPath("message", is("Conta bloqueada.")));
	}
	
	@Test
	public void testExtractOk() throws Exception {
		this.mockHttpServletRequestBuilder = get(URL_GET_EXTRACT, "1");

		mockMvc.perform(this.mockHttpServletRequestBuilder
		      .contentType(APPLICATION_JSON))
		      .andExpect(status().isOk());
	}
	
	@Test
	public void testExtractInternalServerError() throws Exception {
		this.mockHttpServletRequestBuilder = get(URL_GET_EXTRACT, "1");
		
	    when(service.extract(Mockito.any())).thenReturn(new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR));
		
		mockMvc.perform(this.mockHttpServletRequestBuilder
			    .contentType(APPLICATION_JSON))
			    .andExpect(status().isInternalServerError());
	}
	
	@Test
	public void testWithdrawalOk() throws Exception {
		this.mockHttpServletRequestBuilder = post(URL_POST_WITHDRAWAL);
		
		ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();
	    String requestJson = objectWriter.writeValueAsString(new Account());
	    
		mockMvc.perform(this.mockHttpServletRequestBuilder
				.param("value", "100")
				.content(requestJson)
				.contentType(APPLICATION_JSON))
		      	.andExpect(status().isOk());
	}
	
	@Test
	public void testWithdrawalInternalServerError() throws Exception {
		this.mockHttpServletRequestBuilder = post(URL_POST_WITHDRAWAL);
		
		ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();
	    String requestJson = objectWriter.writeValueAsString(new Account());
	    
	    when(service.withdrawal(Mockito.any(), Mockito.anyDouble())).thenReturn(new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR));
		
		mockMvc.perform(this.mockHttpServletRequestBuilder
				.param("value", "100")
				.content(requestJson)
			    .contentType(APPLICATION_JSON))
			    .andExpect(status().isInternalServerError());
	}
	
	@Test
	public void testWithdrawalBadRequest() throws Exception {
		this.mockHttpServletRequestBuilder = post(URL_POST_WITHDRAWAL);
		
		ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();
	    String requestJson = objectWriter.writeValueAsString(new Account());
	    
	    ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
		apiErrorResponse.setMessage("Valor Inválido.");
		apiErrorResponse.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
		
	    when(service.withdrawal(Mockito.any(), Mockito.anyDouble())).thenReturn(new ResponseEntity<Object>(apiErrorResponse, HttpStatus.BAD_REQUEST));
		
		mockMvc.perform(this.mockHttpServletRequestBuilder
				.param("value", "10")
				.content(requestJson)
			    .contentType(APPLICATION_JSON))
			    .andExpect(status().isBadRequest())
			    .andExpect(jsonPath("message", is("Valor Inválido.")));
	}
	
	@Test
	public void testWithdrawalBadRequestBloqAccount() throws Exception {
		this.mockHttpServletRequestBuilder = post(URL_POST_WITHDRAWAL);
		
		ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();
	    String requestJson = objectWriter.writeValueAsString(new Account());
	    
	    ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
		apiErrorResponse.setMessage("Conta bloqueada.");
		apiErrorResponse.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
		
	    when(service.withdrawal(Mockito.any(), Mockito.anyDouble())).thenReturn(new ResponseEntity<Object>(apiErrorResponse, HttpStatus.BAD_REQUEST));
		
		mockMvc.perform(this.mockHttpServletRequestBuilder
				.param("value", "10")
				.content(requestJson)
			    .contentType(APPLICATION_JSON))
			    .andExpect(status().isBadRequest())
			    .andExpect(jsonPath("message", is("Conta bloqueada.")));
	}
	
	@Test
	public void testBalanceOk() throws Exception {
		this.mockHttpServletRequestBuilder = get(URL_GET_BALANCE, "1");
		
		mockMvc.perform(this.mockHttpServletRequestBuilder
				.contentType(APPLICATION_JSON))
		      	.andExpect(status().isOk());
	}
	
	@Test
	public void testBalanceInternalServerError() throws Exception {
		this.mockHttpServletRequestBuilder = get(URL_GET_BALANCE, "1");
	    
	    when(service.balance(Mockito.any())).thenReturn(new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR));
		
		mockMvc.perform(this.mockHttpServletRequestBuilder
			    .contentType(APPLICATION_JSON))
			    .andExpect(status().isInternalServerError());
	}
	
	@Test
	public void testBalanceNoContent() throws Exception {
		this.mockHttpServletRequestBuilder = get(URL_GET_BALANCE, "1");
		
	    when(service.balance(Mockito.any())).thenReturn(new ResponseEntity<Object>(HttpStatus.NO_CONTENT));
		
		mockMvc.perform(this.mockHttpServletRequestBuilder
			    .contentType(APPLICATION_JSON))
			    .andExpect(status().isNoContent());
	}
}
