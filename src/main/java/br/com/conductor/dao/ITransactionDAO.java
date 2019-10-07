package br.com.conductor.dao;

import java.util.List;

import br.com.conductor.model.Transaction;

public interface ITransactionDAO {
	
	public void create(Transaction transaction);
	public List<Transaction> select(Transaction transaction);

}
