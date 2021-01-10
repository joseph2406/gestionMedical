package com.cabinet.medical.exception;

public class EntiteNotFoundException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntiteNotFoundException(String name) {

        super(String.format(name+" is not found!"));
    }
}
