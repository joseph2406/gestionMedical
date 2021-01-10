package com.cabinet.medical.exception;

public class EntiteTransactionException  extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EntiteTransactionException(String Message) {
		super(Message+" est dupliqué!");
	}
}
