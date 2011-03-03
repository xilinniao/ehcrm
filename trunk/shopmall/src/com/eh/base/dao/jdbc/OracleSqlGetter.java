package com.eh.base.dao.jdbc;

import org.apache.log4j.Logger;

public class OracleSqlGetter {
	private static OracleSqlGetter instance = null;

	private final static Logger logger = Logger
			.getLogger(OracleSqlGetter.class);

	public static OracleSqlGetter getInstance() {
		if (instance == null) {
			instance = new OracleSqlGetter();
		}
		return instance;
	}

	private String removeOrderBy(String originalSql) {
		String rsql = originalSql;
		int pos = originalSql.indexOf(" ORDER BY ");

		if (pos != -1) {
			rsql = originalSql.substring(0, pos);
		}

		return rsql;
	}

	public String getCountSQL(String originalSql) {
		StringBuffer sql = new StringBuffer(" SELECT count(*) FROM ( ");
		sql.append(removeOrderBy(originalSql));
		sql.append(" ) ct");
		return sql.toString();
	}

	public String getPaginationSQL(String originalSql, int first, int pageSize) {
		/*StringBuffer sql = new StringBuffer(" SELECT * FROM ( ");
		sql.append(" SELECT temp.* ,ROWNUM num FROM ( ");
		sql.append(originalSql);
		int last = first + pageSize;
		sql.append("　) temp where ROWNUM <= ").append(last);
		sql.append(" ) WHERE　num > ").append(first);
		return sql.toString();*/
		StringBuffer sql = new StringBuffer(originalSql);
		sql.append(" limit ");
		sql.append(first);
		sql.append(",");
		sql.append(pageSize);
		return sql.toString();
	}
}
