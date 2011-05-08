package com.eh.shop.front.cache;

import java.io.Serializable;

public class ImageUrl implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8036611014956136690L;
	
	/**
	 * 图片URL 50*50
	 */
	String imageA;
	/**
	 * 图片URL 100*100
	 */
	String imageB;
	/**
	 * 图片URL 130*130
	 */
	String imageC;
	/**
	 * 图片URL 160*160
	 */
	String imageD;
	/**
	 * 图片URL 350*350
	 */
	String imageE;
	/**
	 * 正常图片，未缩略
	 */
	String imageF;
	
	public String getImageA() {
		return imageA;
	}
	public void setImageA(String imageA) {
		this.imageA = imageA;
	}
	public String getImageB() {
		return imageB;
	}
	public void setImageB(String imageB) {
		this.imageB = imageB;
	}
	public String getImageC() {
		return imageC;
	}
	public void setImageC(String imageC) {
		this.imageC = imageC;
	}
	public String getImageD() {
		return imageD;
	}
	public void setImageD(String imageD) {
		this.imageD = imageD;
	}
	public String getImageE() {
		return imageE;
	}
	public void setImageE(String imageE) {
		this.imageE = imageE;
	}
	public String getImageF() {
		return imageF;
	}
	public void setImageF(String imageF) {
		this.imageF = imageF;
	}
}
