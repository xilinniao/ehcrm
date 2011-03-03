package com.eh.base.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class FormateUtil {
	private static FormateUtil instance;
	public final NumberFormat MONEY_FORMATE = new DecimalFormat("##0.00");

	public static FormateUtil getInstance() {
		if (instance == null) {
			instance = new FormateUtil();
		}
		return instance;
	}

	public String formateDouble(Double value) {
		return this.formateDouble(value, "0.00");
	}

	public String formateDouble(Double value, String defaultValue) {
		if (value == null) {
			return defaultValue;
		} else {
			return MONEY_FORMATE.format(value);
		}
	}
}
