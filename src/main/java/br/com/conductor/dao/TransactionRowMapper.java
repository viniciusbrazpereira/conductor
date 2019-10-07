package br.com.conductor.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import br.com.conductor.model.Account;
import br.com.conductor.model.Transaction;

public class TransactionRowMapper implements RowMapper<Transaction> {
	
	public String getInsertURL() {
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO conductor.transaction ");
		sql.append(" (id_account, value, transaction_date) ");
		sql.append(" VALUES(?, ?, ?); ");
		
		return sql.toString();
	}
	
	public String getSelectURL() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM conductor.transaction ");
		sql.append(" WHERE id_account = ? ");
		return sql.toString();
	}
	
	public Object[] getSelectParameters(Transaction transaction) {
		return new Object[] {
				transaction.getAccount().getIdAccount()};
	}
	
	public Object[] getParameters(Transaction transaction) {
		return new Object[] {
				transaction.getAccount().getIdAccount(), 
				transaction.getValue(),
				transaction.getTransactionDate()};
	}

	@Override
	public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
		Transaction transaction = new Transaction();
		
		Account account = new Account();
		account.setIdAccount(rs.getInt("ID_ACCOUNT"));
		
		transaction.setIdTransaction(rs.getInt("ID_TRANSACTION"));
		
		transaction.setAccount(account);
		transaction.setValue(rs.getDouble("VALUE"));
		
		LocalDate localDate = rs.getDate("TRANSACTION_DATE").toLocalDate();
		transaction.setTransactionDate(localDate);
		return transaction;
	}

}