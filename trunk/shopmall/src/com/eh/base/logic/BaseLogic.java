package com.eh.base.logic;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import com.eh.base.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * @author jcrm
 *
 */
public class BaseLogic implements IBaseLogic{
	protected BaseHibernateDAO baseDao;
	
	public void setBaseDao(BaseHibernateDAO baseDao) {
		this.baseDao = baseDao;
	}

	protected Connection getConnection(){
		return this.baseDao.getSessionFactory().getCurrentSession().connection();
	}
	
	/* (non-Javadoc)
	 * @see com.routdata.util.IBaseLogic#load(java.lang.Class, java.io.Serializable)
	 */
	public <T> T load(Class<T> entityClass,Serializable id){
		return baseDao.load(entityClass, id);
	}
	
	public <T> T get(Class<T> entityClass,Serializable id){
		return baseDao.get(entityClass, id);
	}
	
	/* (non-Javadoc)
	 * @see com.routdata.util.IBaseLogic#save(java.lang.Object)
	 */
	public void save(Object obj){
		this.baseDao.save(obj);
	}
	
	public void bulkUpdate(String sql,Object[] param){
		baseDao.bulkUpdate(sql, param);
	}
	
	/* (non-Javadoc)
	 * @see com.routdata.util.IBaseLogic#getBaseDao()
	 */
	public BaseHibernateDAO getBaseDao() {
		return baseDao;
	}

	/* (non-Javadoc)
	 * @see com.routdata.util.IBaseLogic#remove(java.lang.Object)
	 */
	public void remove(Object o) {
		baseDao.remove(o);
	}
	
	/* (non-Javadoc)
	 * @see com.routdata.util.IBaseLogic#removeById(java.lang.Class, java.io.Serializable)
	 */
	public <T> void removeById(Class<T> entityClass, Serializable id) {
		baseDao.removeById(entityClass,id);
	}

	/* (non-Javadoc)
	 * @see com.eh.base.logic.IBaseLogic#find(java.lang.String, java.lang.Object[])
	 */
	public List find(String hql, Object[] values) {
		return baseDao.find(hql, values);
	}	
	
	
}
