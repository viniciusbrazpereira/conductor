package br.com.conductor.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import br.com.conductor.model.Account;
import br.com.conductor.model.Person;

public class AccountRowMapper implements RowMapper<Account> {
	
	public String getInsertURL() {
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO conductor.account ");
		sql.append(" (id_person, balance, limit_withdrawal_daily, account_type, create_date, active_flag) ");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?); ");
		
		return sql.toString();
	}
	
	public String getDepositURL() {
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE conductor.account ");
		sql.append(" SET balance=?");
		sql.append(" WHERE id_account=?; ");
		
		return sql.toString();
	}
	
	public String getUpdateFlagURL() {
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE conductor.account ");
		sql.append(" SET ACTIVE_FLAG=?");
		sql.append(" WHERE ID_PERSON = ? AND ID_ACCOUNT = ?");
		
		return sql.toString();
	}
	
	public Object[] getUpdateFlagParameters(Account account) {
		return new Object[] {
				account.isActiveFlag(),
				account.getPerson().getIdPerson(),
				account.getIdAccount()};
	}
	
	public String getSelectURL() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM conductor.account ");
		sql.append(" WHERE ID_PERSON = ? AND ID_ACCOUNT = ?");
		return sql.toString();
	}
	
	public String getSelectByAccoutIdURL() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM conductor.account ");
		sql.append(" WHERE ID_ACCOUNT = ?");
		return sql.toString();
	}
	
	public Object[] getSelectByAccoutIdParameters(Account account) {
		return new Object[] {
				account.getIdAccount()};
	}
	
	public Object[] getDepositParameters(Account account) {
		return new Object[] {
				account.getBalance(),
				account.getIdAccount()};
	}
	
	public Object[] getSelectParameters(Account account) {
		return new Object[] {
				account.getPerson().getIdPerson(),
				account.getIdAccount()};
	}
	
	public Object[] getParameters(Account account) {
		return new Object[] {
				account.getPerson().getIdPerson(), 
				account.getBalance(),
				account.getLimiteWithdrawalDaily(),
				account.getAccountType(),
				account.getCreateDate(),
				account.isActiveFlag()};
	}

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account = new Account();
		account.setIdAccount(rs.getInt("ID_ACCOUNT"));
		
		Person person = new Person();
		person.setIdPerson(rs.getInt("ID_PERSON"));
		account.setPerson(person);
		
		account.setBalance(rs.getDouble("BALANCE"));
		account.setLimiteWithdrawalDaily(rs.getDouble("LIMIT_WITHDRAWAL_DAILY"));
		account.setAccountType(rs.getInt("ACCOUNT_TYPE"));
		
		account.setActiveFlag(rs.getBoolean("ACTIVE_FLAG"));
		
		LocalDate localDate = rs.getDate("CREATE_DATE").toLocalDate();
		account.setCreateDate(localDate);
		return account;
	}

}