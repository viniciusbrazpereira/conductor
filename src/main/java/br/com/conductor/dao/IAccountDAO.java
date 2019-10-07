package br.com.conductor.dao;

import br.com.conductor.model.Account;

public interface IAccountDAO {
	public void insert(Account account);
	public void deposit(Account account);
	public Account select(Account account);
	public void bloq(Account account);
	public Account balance(Account account);
}
