package com.eh.base.logic;

import java.io.Serializable;

/**
 * 
 * @author jcrm
 *
 */
public interface IBaseLogic {

	public <T> T load(Class<T> entityClass, Serializable id);
	
	public <T> T get(Class<T> entityClass,Serializable id);

	public void save(Object obj);
	/**
	 * 删除对象.
	 */
	public void remove(Object o);
	/**
	 * 根据ID删除对象.
	 */
	public <T> void removeById(Class<T> entityClass, Serializable id);

}