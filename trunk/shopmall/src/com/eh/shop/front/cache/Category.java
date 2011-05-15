package com.eh.shop.front.cache;

import java.io.Serializable;

public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2829235634907675535L;
	
	String leftNav;
	/**
	 * 导航HTML
	 */
	String navHtml;
	
	public String getNavHtml() {
		return navHtml;
	}
	public void setNavHtml(String navHtml) {
		this.navHtml = navHtml;
	}
	
}
