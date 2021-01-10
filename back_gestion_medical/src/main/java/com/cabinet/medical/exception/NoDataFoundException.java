package com.cabinet.medical.exception;

public class NoDataFoundException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoDataFoundException() {

        super("No data found");
    }
}
