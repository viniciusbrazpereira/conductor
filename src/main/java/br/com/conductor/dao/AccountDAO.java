package br.com.conductor.dao;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import br.com.conductor.model.Account;

@Repository
public class AccountDAO extends JdbcDaoSupport implements IAccountDAO  {

	private final Logger LOG = LoggerFactory.getLogger(AccountDAO.class);
	
	@Autowired 
    private DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

	@Override
	public void insert(Account account){
		try {
			account.setActiveFlag(true);
			AccountRowMapper rowMapper = new AccountRowMapper();
			getJdbcTemplate().update(
					rowMapper.getInsertURL(), 
					rowMapper.getParameters(account));
			
		} catch (DataAccessException e) {
			LOG.error(e.getMessage(), e);
			throw e;
		}
	}

	@Override
	public Account select(Account account) {
		try {
			AccountRowMapper rowMapper = new AccountRowMapper();
			return getJdbcTemplate().queryForObject(
					rowMapper.getSelectURL(), 
					rowMapper.getSelectParameters(account),
					rowMapper);
			
		} catch (DataAccessException e) {
			LOG.error(e.getMessage(), e);
			throw e;
		}
	}
	
	@Override
	public void deposit(Account account) {
		try {
			AccountRowMapper rowMapper = new AccountRowMapper();
			getJdbcTemplate().update(
					rowMapper.getDepositURL(), 
					rowMapper.getDepositParameters(account));
			
		} catch (DataAccessException e) {
			LOG.error(e.getMessage(), e);
			throw e;
		}
	}
	
	@Override
	public void bloq(Account account) {
		try {
			AccountRowMapper rowMapper = new AccountRowMapper();
			getJdbcTemplate().update(
					rowMapper.getUpdateFlagURL(), 
					rowMapper.getUpdateFlagParameters(account));
			
		} catch (DataAccessException e) {
			LOG.error(e.getMessage(), e);
			throw e;
		}
	}
	
	@Override
	public Account balance(Account account) {
		try {
			AccountRowMapper rowMapper = new AccountRowMapper();
			return getJdbcTemplate().queryForObject(
					rowMapper.getSelectByAccoutIdURL(), 
					rowMapper.getSelectByAccoutIdParameters(account),
					rowMapper);
			
		} catch (EmptyResultDataAccessException e) {
			LOG.error(e.getMessage(), e);
			return null;
			
		} catch (DataAccessException e) {
			LOG.error(e.getMessage(), e);
			throw e;
		}
	}
}
