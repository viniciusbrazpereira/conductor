package br.com.conductor.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import br.com.conductor.model.Transaction;

@Repository
public class TransactionDAO extends JdbcDaoSupport implements ITransactionDAO  {

	private final Logger LOG = LoggerFactory.getLogger(TransactionDAO.class);
	
	@Autowired 
    private DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

	@Override
	public void create(Transaction transaction){
		try {
			TransactionRowMapper rowMapper = new TransactionRowMapper();
			getJdbcTemplate().update(
					rowMapper.getInsertURL(), 
					rowMapper.getParameters(transaction));
			
		} catch (DataAccessException e) {
			LOG.error(e.getMessage(), e);
			throw e;
		}
	}
	
	@Override
	public List<Transaction> select(Transaction transaction){
		try {
			TransactionRowMapper rowMapper = new TransactionRowMapper();
			return getJdbcTemplate().query(
					rowMapper.getSelectURL(), 
					rowMapper.getSelectParameters(transaction),
					rowMapper);
			
		} catch (DataAccessException e) {
			LOG.error(e.getMessage(), e);
			throw e;
		}
	}
}
