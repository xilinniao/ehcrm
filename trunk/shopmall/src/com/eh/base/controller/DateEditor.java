package com.eh.base.controller;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.springframework.util.StringUtils;

public class DateEditor extends PropertyEditorSupport {

	private final DateFormat dateFormat;

	private final DateFormat timeFormat;

	private final boolean allowEmpty;

	private final int exactDateLength;

	/**
	 * Create a new CustomDateEditor instance, using the given DateFormat for
	 * parsing and rendering.
	 * <p>
	 * The "allowEmpty" parameter states if an empty String should be allowed
	 * for parsing, i.e. get interpreted as null value. Otherwise, an
	 * IllegalArgumentException gets thrown in that case.
	 * 
	 * @param dateFormat
	 *            DateFormat to use for parsing and rendering
	 * @param allowEmpty
	 *            if empty strings should be allowed
	 */
	public DateEditor(DateFormat dateFormat,DateFormat timeFormat, boolean allowEmpty) {
		this.dateFormat = dateFormat;
		this.timeFormat = timeFormat;
		this.allowEmpty = allowEmpty;
		this.exactDateLength = -1;
	}

	/**
	 * Create a new CustomDateEditor instance, using the given DateFormat for
	 * parsing and rendering.
	 * <p>
	 * The "allowEmpty" parameter states if an empty String should be allowed
	 * for parsing, i.e. get interpreted as null value. Otherwise, an
	 * IllegalArgumentException gets thrown in that case.
	 * <p>
	 * The "exactDateLength" parameter states that IllegalArgumentException gets
	 * thrown if the String does not exactly match the length specified. This is
	 * useful because SimpleDateFormat does not enforce strict parsing of the
	 * year part, not even with <code>setLenient(false)</code>. Without an
	 * "exactDateLength" specified, the "01/01/05" would get parsed to
	 * "01/01/0005".
	 * 
	 * @param dateFormat
	 *            DateFormat to use for parsing and rendering
	 * @param allowEmpty
	 *            if empty strings should be allowed
	 * @param exactDateLength
	 *            the exact expected length of the date String
	 */
	public DateEditor(DateFormat dateFormat,DateFormat timeFormat, boolean allowEmpty,
			int exactDateLength) {
		this.dateFormat = dateFormat;
		this.timeFormat = timeFormat;
		this.allowEmpty = allowEmpty;
		this.exactDateLength = exactDateLength;
	}

	/**
	 * Parse the Date from the given text, using the specified DateFormat.
	 */
	public void setAsText(String text) throws IllegalArgumentException {
		if (this.allowEmpty && !StringUtils.hasText(text)) {
			setValue(null);
		} else if (text != null && this.exactDateLength >= 0
				&& text.length() != this.exactDateLength) {
			throw new IllegalArgumentException(
					"Could not parse date: it is not exactly"
							+ this.exactDateLength + "characters long");
		} else {
			try {
				if (text.length() == 16) {
					setValue(this.timeFormat.parse(text));
				} else {
					setValue(this.dateFormat.parse(text));
				}
			} catch (ParseException ex) {
				IllegalArgumentException iae = new IllegalArgumentException(
						"Could not parse date: " + ex.getMessage());
				iae.initCause(ex);
				throw iae;
			}
		}
	}

	/**
	 * Format the Date as String, using the specified DateFormat.
	 */
	public String getAsText() {
		Date value = (Date) getValue();
		return (value != null ? this.dateFormat.format(value) : "");
	}

}
