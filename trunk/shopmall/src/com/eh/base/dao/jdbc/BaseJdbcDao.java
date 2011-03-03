package com.eh.base.dao.jdbc;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import com.eh.base.dao.hibernate.Page;

public class BaseJdbcDao extends NamedParameterJdbcDaoSupport  {
	private final static Logger logger = Logger.getLogger(BaseJdbcDao.class);
	
	/**
	 * 
	 * @param sql
	 * @return
	 */
	public List queryForList(String sql){
		logger.debug(sql);
		return getJdbcTemplate().queryForList(sql);
	}
	/**
	 * 
	 * @param sql
	 * @param rowMapper
	 * @return
	 */
	public List queryForList(String sql,RowMapper rowMapper){
		logger.debug(sql);
		return this.getJdbcTemplate().query(sql, rowMapper);
	}
	/**
	 * 
	 * @param sql
	 * @param args
	 * @return
	 */
	public List queryForList(String sql,Object[] args){
		logger.debug(sql);
		return this.getJdbcTemplate().queryForList(sql, args);
	}
	
	/**
	 * 参数hashMap
	 * @param sql
	 * @param paramMap
	 * @return
	 */
	public List queryForList(String sql,Map paramMap){
		logger.debug(sql);
		return this.getNamedParameterJdbcTemplate().queryForList(sql, paramMap);
	}
	
	/**
	 * 
	 * @param sql
	 * @param args
	 * @param rowMapper
	 * @return
	 */
	public List queryForList(String sql,Object[] args,RowMapper rowMapper){
		logger.debug(sql);
		return this.getJdbcTemplate().query(sql, args, rowMapper);
	}
	
	/**
	 * 
	 * @param sql
	 * @param paramMap
	 * @param rowMapper
	 * @return
	 */
	public List queryForList(String sql,Map paramMap,RowMapper rowMapper){
		logger.debug(sql);
		return this.getNamedParameterJdbcTemplate().query(sql, paramMap, rowMapper);
	}
	
	/**
	 * 查询分页数据
	 * @param sql
	 * @param paramMap
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page queryForPage(String sql,Map paramMap,int pageNo, int pageSize){
		String countSql = OracleSqlGetter.getInstance().getCountSQL(sql);
		int totalCount = this.getNamedParameterJdbcTemplate().queryForInt(countSql, paramMap);
		
		if (totalCount < 1)
			return new Page();
		
		int startIndex = Page.getStartOfPage(pageNo, pageSize);		
		
		String pageSql = OracleSqlGetter.getInstance().getPaginationSQL(sql, startIndex, pageSize);
		logger.debug(pageSql);
		
		List list = this.getNamedParameterJdbcTemplate().queryForList(pageSql, paramMap);
		
		return new Page(startIndex, totalCount, pageNo,pageSize, list);
	}
	
	/**
	 * 查询分页数据
	 * @param sql
	 * @param paramMap
	 * @param rowMapper
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page queryForPage(String sql,Map paramMap,RowMapper rowMapper,int pageNo, int pageSize){
		String countSql = OracleSqlGetter.getInstance().getCountSQL(sql);
		int totalCount = this.getNamedParameterJdbcTemplate().queryForInt(countSql, paramMap);		
		if (totalCount < 1)
			return new Page();
		
		int startIndex = Page.getStartOfPage(pageNo, pageSize);		
		
		String pageSql = OracleSqlGetter.getInstance().getPaginationSQL(sql, startIndex, pageSize);
		logger.debug(pageSql);
		
		List list = this.getNamedParameterJdbcTemplate().query(pageSql, paramMap, rowMapper);
		return new Page(startIndex, totalCount, pageNo,pageSize, list);
	}
}
